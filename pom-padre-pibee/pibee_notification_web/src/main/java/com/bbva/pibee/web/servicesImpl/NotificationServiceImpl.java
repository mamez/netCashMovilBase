package com.bbva.pibee.web.servicesImpl;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.bbva.pibee.arq.annotations.ResourceBusiness;
import com.bbva.pibee.arq.container.StatusBBVA;
import com.bbva.pibee.notification.back.business.NotificationBusiness;
import com.bbva.pibee.rest.exception.BbvaClientBackException;
import com.bbva.pibee.rest.exception.BbvaFilterListException;
import com.bbva.pibee.rest.exception.CodClientException;
import com.bbva.pibee.rest.util.Filters;
import com.bbva.pibee.web.dto.notifi.entity.NotificationModel;
import com.bbva.pibee.web.dto.notifi.request.NotificationEntityRequest;
import com.bbva.pibee.web.dto.notifi.request.NotificationsDeleteRequest;
import com.bbva.pibee.web.dto.notifi.response.NotificationServiceResponse;
import com.bbva.pibee.web.dto.response.NotificationsDeleteResponse;
import com.bbva.pibee.web.services.NotificationService;

public class NotificationServiceImpl implements NotificationService
{
	public static Logger logger = Logger.getLogger("pibee");
	
	@ResourceBusiness
	NotificationBusiness notificationBusiness;
	
	@Override
	public Response getNotification(String paginationKey, String pageSize) throws BbvaClientBackException , BbvaFilterListException
	{
		NotificationServiceResponse notiResp;
		try
		{
			notiResp = notificationBusiness.getNotifications(0);
			if((notiResp !=null) && (notiResp.getListNotification().isEmpty()))
			{
				return StatusBBVA.NoContent.Status();
			}
			else
			{
				try
				{
					Filters<NotificationModel> filtro = new Filters<NotificationModel>();
					filtro.FiltersList(notiResp.getListNotification(), Integer.parseInt(paginationKey), Integer.parseInt(pageSize));
					notiResp = new NotificationServiceResponse();
					if(filtro.getListResponse().isEmpty())
					{
						return StatusBBVA.NoContent.Status();
					}
					else
					{
						notiResp.setListNotification(filtro.getListResponse());
						notiResp.setPaginationKey(filtro.getPaginationKey());
						notiResp.setPageSize(filtro.getPageSize());
						return StatusBBVA.Ok.entity(notiResp);
					}
				}
				catch (BbvaFilterListException fl) 
				{
					throw new BbvaClientBackException(CodClientException.CLIENT_ERROR,fl);
				}
			}
		}
		catch(BbvaClientBackException e)
		{
			throw new BbvaClientBackException(CodClientException.CLIENT_ERROR,e);		
		}
		catch(Exception e)
		{
			throw new BbvaClientBackException(CodClientException.CLIENT_ERROR,e);
		}		
	}

	@Override
	public Response saveNotifications(NotificationEntityRequest notiReq) throws BbvaClientBackException
	{		
		try
		{
			notificationBusiness.createNotification(notiReq);
			return StatusBBVA.Create.Status();
		}
		catch (BbvaClientBackException ex)
		{
			if(ex.getError().getCod() == CodClientException.INVALID_PARAMETERS){
				throw new BbvaClientBackException(CodClientException.INVALID_PARAMETERS,ex);
			}
			else{
				throw new BbvaClientBackException(CodClientException.CLIENT_ERROR,ex);
			}
		}
		catch(Exception e)
		{
			throw new BbvaClientBackException(CodClientException.CLIENT_ERROR,e);		
		}		
	}	

	@Override
	public Response deleteNotifications(NotificationsDeleteRequest notificaciones) throws BbvaClientBackException{
		try{
			NotificationsDeleteResponse resp=(NotificationsDeleteResponse)notificationBusiness.deleteNotification(notificaciones);
			return StatusBBVA.Ok.entity(resp);
		}
		catch (BbvaClientBackException ex){
			if(ex.getError().getCod() == CodClientException.INVALID_PARAMETERS){
				throw new BbvaClientBackException(CodClientException.INVALID_PARAMETERS,ex);
			}
			else{
				throw new BbvaClientBackException(CodClientException.CLIENT_ERROR,ex);
			}
		}
		catch(Exception e){
			throw new BbvaClientBackException(CodClientException.CLIENT_ERROR,e);		
		}			
	}
		
	
	@Override
	public Response changeStateNotifications(String id) throws BbvaClientBackException {		
		try
		{		
			NotificationEntityRequest notiReq= new NotificationEntityRequest();
			notiReq.setId(id);
			if(notificationBusiness.updateNotifications(notiReq) == 1)
			{
				return StatusBBVA.Ok.Status();
			}else {
				return StatusBBVA.Forbidden.Status();
			}			
		}
		catch (BbvaClientBackException ex)
		{
			if(ex.getError().getCod() == CodClientException.INVALID_PARAMETERS){
				throw new BbvaClientBackException(CodClientException.INVALID_PARAMETERS,ex);
			}
			else{
				throw new BbvaClientBackException(CodClientException.CLIENT_ERROR,ex);
			}
		}
		catch(Exception e)
		{
			throw new BbvaClientBackException(CodClientException.CLIENT_ERROR,e);		
		}	
	}

	@Override
	public Response deleteNotifications() throws BbvaClientBackException {
		try
		{
			notificationBusiness.deleteAllNotification(null);
			return StatusBBVA.Ok.Status();
		}
		catch (BbvaClientBackException ex)
		{
			if(ex.getError().getCod() == CodClientException.INVALID_PARAMETERS){
				throw new BbvaClientBackException(CodClientException.INVALID_PARAMETERS,ex);
			}
			else{
				throw new BbvaClientBackException(CodClientException.CLIENT_ERROR,ex);
			}
		}
		catch(Exception e)
		{
			throw new BbvaClientBackException(CodClientException.CLIENT_ERROR,e);		
		}	
	}
}
