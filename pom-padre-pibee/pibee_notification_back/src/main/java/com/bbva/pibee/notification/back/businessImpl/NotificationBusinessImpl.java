package com.bbva.pibee.notification.back.businessImpl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.Business;
import com.bbva.pibee.arq.annotations.ResourceClientAso;
import com.bbva.pibee.arq.annotations.ResourceClientBd;
import com.bbva.pibee.aso.noti.dto.Notification;
import com.bbva.pibee.aso.noti.dto.NotificationPush;
import com.bbva.pibee.aso.noti.inter.NotificationService;
import com.bbva.pibee.context.RequestInterceptor;
import com.bbva.pibee.dto.notification.ConfigurationDto;
import com.bbva.pibee.dto.notification.NotificationDto;
import com.bbva.pibee.dto.notification.UserDto;
import com.bbva.pibee.notification.back.business.NotificationBusiness;
import com.bbva.pibee.pm.cbd.notification.dao.ConfigurationDao;
import com.bbva.pibee.pm.cbd.notification.dao.NotificationDao;
import com.bbva.pibee.pm.cbd.notification.dao.UserDao;
import com.bbva.pibee.rest.exception.BbvaClientAsoException;
import com.bbva.pibee.rest.exception.BbvaClientBackException;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;
import com.bbva.pibee.rest.util.EncryptAes;
import com.bbva.pibee.web.dto.notifi.entity.NotificationModel;
import com.bbva.pibee.web.dto.notifi.entity.NotificationsDeleteModel;
import com.bbva.pibee.web.dto.notifi.entity.NotificationsStatus;
import com.bbva.pibee.web.dto.notifi.request.NotificationEntityRequest;
import com.bbva.pibee.web.dto.notifi.request.NotificationsDeleteRequest;
import com.bbva.pibee.web.dto.notifi.request.State;
import com.bbva.pibee.web.dto.notifi.request.StateUsuario;
import com.bbva.pibee.web.dto.notifi.response.NotificationServiceResponse;
import com.bbva.pibee.web.dto.response.NotificationsDeleteResponse;

@Business
public class NotificationBusinessImpl implements NotificationBusiness
{	

	@ResourceClientBd
	NotificationDao notificationDao;
	
	@ResourceClientBd
	UserDao userDao;
	
	@ResourceClientBd
	ConfigurationDao configurationDao;

	@ResourceClientBd
	ConfigurationBusinessImpl configurationImpl;
	
	@ResourceClientAso
	NotificationService notificationService; 
	
	@Autowired
	public RequestInterceptor requestInterceptor;
	
	@Autowired
	Environment env;
	
	@Autowired 
	public EncryptAes encryptAes;
	
	int resultado=0;
	public NotificationServiceResponse getNotifications(int idNoti) throws BbvaClientBackException{
		NotificationServiceResponse response = null;
		List<NotificationDto> getListNotification = new ArrayList<NotificationDto>();
		List<NotificationModel> getListNotificationMod;		
		try
		{
			if(idNoti == 0)
			{
				getListNotification = notificationDao.getNotification("00260082"+requestInterceptor.getReference(), requestInterceptor.getUserId());
			}
			else			
			{
				getListNotification = notificationDao.getOneNotification("00260082"+requestInterceptor.getReference(), requestInterceptor.getUserId(), idNoti);
			}
		
			
			getListNotificationMod = new ArrayList<NotificationModel>();
			response = new NotificationServiceResponse();
			
			for(NotificationDto noti : getListNotification)
			{
				NotificationModel objNoti = new NotificationModel();
				
				objNoti.setId(noti.getID_NOTI());
				objNoti.setDate(noti.getDATE_NOTI());
				objNoti.setState(noti.getSTATE_NOTI());
				objNoti.setTitle(noti.getTITLE_NOTI());
				objNoti.setDescription(noti.getDESCRIPTION_NOTI());
				objNoti.setFkConfig(noti.getFK_CONFIGURATION());
				objNoti.setCodeTransaction(noti.getCODE_TRAN());
				
				getListNotificationMod.add(objNoti);
			}			
			response.setListNotification(getListNotificationMod);
		}
		catch(BbvaClientCbdException e)
		{
			throw new BbvaClientBackException(CodClientException.CLIENT_ERROR,e);
		}
 		catch(Exception e)
 		{
 			throw new BbvaClientBackException(CodClientException.CLIENT_ERROR,e);
 		}
		return response;
	}



	public NotificationServiceResponse deleteAllNotificationByUser() throws BbvaClientBackException{
		NotificationServiceResponse response = null;
		String userRef;
		String userId;
		
		if(requestInterceptor.getReference() != null && requestInterceptor.getUserId() != null)
		{
			userRef = requestInterceptor.getReference();
			userId = requestInterceptor.getUserId();
			try{
				notificationDao.deleteAllNotificationByUser(userRef, userId);
			}
			catch(BbvaClientCbdException e){
				if(e.getError().getCod() == CodClientException.INVALID_PARAMETERS) {
					throw new BbvaClientBackException(CodClientException.INVALID_PARAMETERS,e);	
				}else {
					throw new BbvaClientBackException(CodClientException.CLIENT_ERROR,e);	
				}						
			}
	 		catch(Exception e){
	 			throw new BbvaClientBackException(CodClientException.CLIENT_ERROR,e);	 			
	 		}	
		}
		return response;
	}
	
   
	@Override
	public NotificationsDeleteResponse deleteNotification(NotificationsDeleteRequest notificaciones) throws BbvaClientBackException {
		 NotificationsDeleteResponse resp= new NotificationsDeleteResponse();
		
		 NotificationsStatus status=null;
		if (notificaciones != null) {
			List<NotificationsDeleteModel> lista=new ArrayList<NotificationsDeleteModel>();
			for (NotificationsDeleteModel noti : notificaciones.getNotifications()) {
				 NotificationsDeleteModel notiFicacion= new NotificationsDeleteModel();
				try {
					notiFicacion.setId(noti.getId());
					int respDao=notificationDao.deleteNotification(noti.getId());
					status= new NotificationsStatus();
					if(respDao > 0) {
						status.setStatus("OK");
					}else {
						status.setStatus("ERROR");
						status.setDescription("Notificación no existe");
					}
					notiFicacion.setStatus(status);
				} catch (BbvaClientCbdException e) {
					status= new NotificationsStatus();
					status.setDescription("Error al eliminar la notificación");
					notiFicacion.setStatus(status);
				} catch (Exception e) {
					status= new NotificationsStatus();
					status.setDescription("Error al eliminar la notificación");
					notiFicacion.setStatus(status);
				}
				lista.add(notiFicacion);
			}
			resp.setNotifications(lista);
		} else {
			throw new BbvaClientBackException(CodClientException.INVALID_PARAMETERS);
		}
		return resp;
	}


	@Override
	public int updateNotifications(NotificationEntityRequest notiReq) throws BbvaClientBackException
	{		
		String idNoti;
		if(notiReq !=null)
		{
			try
			{
				idNoti = notiReq.getId();				
				resultado = notificationDao.updateNotification(idNoti);				
			}
			catch(BbvaClientCbdException e)
			{
				if(e.getError().getCod() == CodClientException.INVALID_PARAMETERS) {
					throw new BbvaClientBackException(CodClientException.INVALID_PARAMETERS,e);	
				}else {
					throw new BbvaClientBackException(CodClientException.CLIENT_ERROR,e);	
				}						
			}
	 		catch(Exception e)
	 		{
	 			throw new BbvaClientBackException(CodClientException.CLIENT_ERROR,e);	 			
	 		}
		}
		return resultado;
	}
	
	@Override
	public void createNotification(NotificationEntityRequest notiReq) throws BbvaClientBackException{		
		String idNoti = requestInterceptor.getIdNotification();
		String referenceUser = "00260082"+requestInterceptor.getReference();
		String userId = requestInterceptor.getUserId();
			try{
				NotificationDto noti = new NotificationDto();
				
				noti.setID_NOTI(idNoti);
				noti.setSTATE_NOTI(notiReq.getState());
				noti.setDATE_NOTI(notiReq.getDate());
				noti.setDESCRIPTION_NOTI(notiReq.getDescription());
				noti.setTITLE_NOTI(notiReq.getTitle());
				noti.setCODE_TRAN(notiReq.getCodeTransaction());
				noti.setFK_CONFIGURATION(notiReq.getFkConfig());
				noti.setORIGIN_NOTI(notiReq.getOriginNoti());
				
				boolean existConfiguration=this.configurationDao.existConfigByUser(noti.getFK_CONFIGURATION(), referenceUser, userId);
				if(existConfiguration) {
					UserDto user=this.userDao.getUser(referenceUser, userId);
					Notification notification= new Notification();
					
					NotificationPush notiP = new NotificationPush();
					notiP.setOs(user.getPLATFORM_USU());				
					notiP.setApplicationId(env.getProperty("com.bbva.pibee.noti.applicationId"));
					notiP.setCollapseKey(env.getProperty("com.bbva.pibee.noti.collapse"));
					notiP.setPriority(env.getProperty("com.bbva.pibee.noti.priority"));
					notiP.setRecipient(env.getProperty("com.bbva.pibee.noti.recipient"));
					notiP.setTimeToLive((Integer.valueOf(env.getProperty("com.bbva.pibee.noti.timeToLive"))));
					
					notiP.setNotification(notification);
					notification.setTitle(notiReq.getTitle());
					notification.setBody(notiReq.getDescription());
					notification.setAction(env.getProperty("com.bbva.pibee.noti.title"));
					notification.setBadge(env.getProperty("com.bbva.pibee.noti.badge"));
					notification.setIconName(env.getProperty("com.bbva.pibee.noti.iconName")); 
					notification.setColor(env.getProperty("com.bbva.pibee.noti.color"));
					notification.setSound(env.getProperty("com.bbva.pibee.noti.sound"));
					notification.setTag(env.getProperty("com.bbva.pibee.noti.action"));
					notification.setContentAvailable(Boolean.valueOf(env.getProperty("com.bbva.pibee.noti.contentAvailable","false")));

					this.notificationDao.insertNotification(noti);
					this.notificationService.sendNotification(notiP);
					
					
				}else {
					throw new BbvaClientCbdException(CodClientException.INVALID_PARAMETERS);
				}								
			}catch (BbvaClientCbdException e) {
				throw new BbvaClientBackException(e.getError());
			}catch (Exception e) {
				throw new BbvaClientBackException(CodClientException.CLIENT_ERROR, e);
			}
	}
	
	
	@Override
	public void deleteAllNotification(NotificationsDeleteRequest notificaciones) throws BbvaClientBackException {
		try {
			notificationDao.deleteAllNotificationByUser("00260082" + requestInterceptor.getReference(),requestInterceptor.getUserId());
		} catch (BbvaClientCbdException e) {
			if (e.getError().getCod() == CodClientException.INVALID_PARAMETERS) {
				throw new BbvaClientBackException(CodClientException.INVALID_PARAMETERS, e);
			} else {
				throw new BbvaClientBackException(CodClientException.CLIENT_ERROR, e);
			}
		}
		
	}
}
