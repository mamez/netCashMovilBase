 
package com.bbva.pibee.notification.back.businessImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.bbva.pibee.arq.annotations.ResourceClientAso;
import com.bbva.pibee.arq.annotations.ResourceClientBd;
import com.bbva.pibee.aso.noti.dto.Enrollment;
import com.bbva.pibee.aso.noti.dto.Platform;
import com.bbva.pibee.aso.noti.inter.EnrollmentService;
import com.bbva.pibee.context.RequestInterceptor;
import com.bbva.pibee.dto.notification.ConfigurationDto;
import com.bbva.pibee.dto.notification.GenericServicesDto;
import com.bbva.pibee.dto.notification.UserDto;
import com.bbva.pibee.notification.back.business.ConfigurationBusiness;
import com.bbva.pibee.pm.cbd.notification.dao.ConfigurationDao;
import com.bbva.pibee.pm.cbd.notification.dao.OperationDao;
import com.bbva.pibee.pm.cbd.notification.dao.ServiceDao;
import com.bbva.pibee.pm.cbd.notification.dao.UserDao;
import com.bbva.pibee.rest.exception.BbvaClientAsoException;
import com.bbva.pibee.rest.exception.BbvaClientBackException;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;
import com.bbva.pibee.web.dto.notifi.entity.OperationModel;
import com.bbva.pibee.web.dto.notifi.entity.ServiceModel;
import com.bbva.pibee.web.dto.notifi.request.ConfigurationEntityRequest;
import com.bbva.pibee.web.dto.notifi.request.State;
import com.bbva.pibee.web.dto.notifi.request.UserEntityRequest;
import com.bbva.pibee.web.dto.notifi.response.ServicesResponse;

@Service
public class ConfigurationBusinessImpl implements ConfigurationBusiness {

	@ResourceClientBd
	ConfigurationDao configurationDao;

	@ResourceClientBd
	ServiceDao serviceDao;

	@ResourceClientBd
	OperationDao operationDao;
	
	@ResourceClientBd
	private UserDao userDao;
	
	@ResourceClientAso
	EnrollmentService userService;

	@Autowired
	RequestInterceptor requestInterceptor;
	
	@Autowired
	Environment env;

	public int resultado= 0;

	@Override
	public ServicesResponse getConfigurations() throws BbvaClientBackException {
		ServicesResponse response = null;
		 
		try {
			String usuario = requestInterceptor.getUserId();
			String referencia = "00260082"+requestInterceptor.getReference();
		   List<GenericServicesDto> list=serviceDao.getGenericServices(referencia, usuario);
		   if(list.isEmpty()) {
			    list=serviceDao.getAllServices();
			  }
		   response= new ServicesResponse();
		   List<ServiceModel> listServiceModel = new ArrayList<ServiceModel>();
		   ServiceModel model= null;
		   for(GenericServicesDto in:list) {
			   boolean existe= false;
			  for(ServiceModel in2 : listServiceModel) {
				  if(in2.getId() == in.getID_SER()) {
					  existe = true;
					  break;
				  }
			  }
			  if(!existe) {
				  model= new ServiceModel();
				  model.setId(in.getID_SER());
				  model.setName(in.getNAME_SER());
				  List<OperationModel> listOperationModel = new ArrayList<OperationModel>();
				  OperationModel operationModel = new OperationModel();
				  operationModel.setId(in.getID_OPE());
				  operationModel.setCode(in.getCOD_OPE());
				  operationModel.setName(in.getNAME_OPE());
				  operationModel.setAction(in.getACTION_OPE());
				  operationModel.setStateConfiguration(in.getSTATE_CONFIGURATION());
				  if(in.getSTATE_CONFIGURATION() == null) {
					  operationModel.setStateConfiguration(State.uncheck.toString());
				  }	
				  if(in.getID_CONFIGURATION() != 0) {
					  operationModel.setIdConfiguration(Integer.toString(in.getID_CONFIGURATION()));
				  }
				  listOperationModel.add(operationModel);
				  model.setListOperationModel(listOperationModel);
				  listServiceModel.add(model);
			  }else {
				  for(ServiceModel in2 : listServiceModel) {
					  if(in2.getId() == in.getID_SER()) {
						  OperationModel operationModel = new OperationModel();
						  operationModel.setId(in.getID_OPE());
						  operationModel.setCode(in.getCOD_OPE());
						  operationModel.setName(in.getNAME_OPE());
						  operationModel.setAction(in.getACTION_OPE());
						  operationModel.setStateConfiguration(in.getSTATE_CONFIGURATION());
						  if(in.getSTATE_CONFIGURATION() == null) {
							  operationModel.setStateConfiguration(State.uncheck.toString());
						  }		
						  if(in.getID_CONFIGURATION() != 0) {
							  operationModel.setIdConfiguration(Integer.toString(in.getID_CONFIGURATION()));
						  }
						 
						 in2.getListOperationModel().add(operationModel);
						  break;
					  }
			  }
		   }
		 } 

		   response.setServiceModel(listServiceModel);
		}catch (BbvaClientCbdException e) {
			throw new BbvaClientBackException(e.getError());
		} catch (Exception e) {
			throw new BbvaClientBackException(CodClientException.CLIENT_ERROR, e);
		}
		return response;
	}

	
	@Override
	public void configuration(ConfigurationEntityRequest configurationEntityRequest) throws BbvaClientBackException {
		String reference = "00260082"+requestInterceptor.getReference();
		String user = requestInterceptor.getUserId();
		try {
			UserDto userDto = userDao.getUser(reference, user);
			if( userDto != null) {
				userDto= UpdateUser(userDto,configurationEntityRequest.getUserEntityRequest());
			}else {
				UserDto usu= new UserDto();
				usu.setREFERENCE_USU(reference);
				usu.setID_USU(user);
				usu.setDEVICE_USU(configurationEntityRequest.getUserEntityRequest().getDevice());
				usu.setPLATFORM_USU(configurationEntityRequest.getUserEntityRequest().getPlatform());
				usu.setVERSION_USU(configurationEntityRequest.getUserEntityRequest().getVersion());
				usu.setTOKEN_USU(configurationEntityRequest.getUserEntityRequest().getToken());
				usu.setCREATIONDATE_USU(configurationEntityRequest.getUserEntityRequest().getCreationDate());
				usu.setMODIFIDATE_USU(configurationEntityRequest.getUserEntityRequest().getModificationDate());
				usu.setSTATE_USU(configurationEntityRequest.getUserEntityRequest().getState().name());
				usu.setENROLLMENT(enrollment(configurationEntityRequest.getUserEntityRequest()));
				userDto=CreateUser(usu);
			}
			createConfiguration(configurationEntityRequest.getState(), configurationEntityRequest.getIdOperation());
		} catch (BbvaClientCbdException e) {
			throw new BbvaClientBackException(e.getError());
		}catch (BbvaClientBackException  e) {
			throw new BbvaClientBackException(e.getError());
		}catch (Exception e) {
			throw new BbvaClientBackException(CodClientException.CLIENT_ERROR, e);
		}
		
	}
	
	
	private UserDto UpdateUser(UserDto userDto, UserEntityRequest userEntityRequest ) throws BbvaClientBackException {
		boolean isDiferente= false;
		
		String divice= userEntityRequest.getDevice();
		if(!userDto.getDEVICE_USU().equals(divice)) {
			userDto.setDEVICE_USU(divice);
			isDiferente= true;
		}
		
		String token=userEntityRequest.getToken();
		if(!userDto.getTOKEN_USU().equals(token)) {
			userDto.setDEVICE_USU(token);
			isDiferente= true;
		}
		
		String platform=userEntityRequest.getPlatform();
		if(!userDto.getPLATFORM_USU().equals(platform)) {
			userDto.setDEVICE_USU(platform);
			isDiferente= true;
		}
		
		String version=userEntityRequest.getVersion();
		if(!userDto.getVERSION_USU().equals(version)) {
			userDto.setVERSION_USU(version);
			isDiferente= true;
		}
		
		String state=userEntityRequest.getState().name();
		if(!userDto.getSTATE_USU().equals(state)) {
			userDto.setSTATE_USU(state);
			isDiferente= true;
		}
		
		if(isDiferente) {
			try {
				 updateEnrollment(userDto.getENROLLMENT(), userEntityRequest );
				this.userDao.modifyUser(userDto);
			}catch (BbvaClientCbdException e) {
				throw new BbvaClientBackException(e.getError());
			}
			
		}
		return userDto;
	}
	
	
	private UserDto CreateUser(UserDto userDto) throws BbvaClientBackException {
		try {
			this.userDao.createUser(userDto);
		}catch(BbvaClientCbdException e) {
			throw new BbvaClientBackException(e.getError());
		}
		return userDto;
		
	}
	
	
	private void createConfiguration(State state, int idOperation) throws BbvaClientBackException {
		String referenceUser = "00260082"+requestInterceptor.getReference();
		String userId = requestInterceptor.getUserId();
		try {
			boolean existe=  this.configurationDao.existConfigByOperation(idOperation,referenceUser, userId);
			if(existe) {
				this.configurationDao.updateConfiguration(state.name(), idOperation, userId, referenceUser);
			}else {
				this.configurationDao.insertConfiguration(State.check.name(), referenceUser, userId, idOperation);
			}
		} catch (BbvaClientCbdException e) {
			throw new BbvaClientBackException(e.getError());
		}catch (Exception e) {
			throw new BbvaClientBackException(CodClientException.CLIENT_ERROR,e);
		}
	}
	
	
	private String enrollment(UserEntityRequest userEntityRequest) throws BbvaClientBackException {
		String respuesta = null;
		 try {			 
				String reference = "00260082"+requestInterceptor.getReference();
				String user = requestInterceptor.getUserId();
				String idUser = reference+user;
				String appId = env.getProperty("pibee.aso.jboss.app.id");
				String appKey=env.getProperty("pibee.aso.jboss.app.key");
				Enrollment enrollment = new Enrollment();		
				Platform plataforma= new Platform();
				plataforma.setId(userEntityRequest.getPlatform());
				enrollment.setPlatform(plataforma);
				enrollment.setDeviceId(userEntityRequest.getDevice());
				enrollment.setVersion(userEntityRequest.getVersion());
				enrollment.setToken(userEntityRequest.getToken());
				respuesta=userService.createEnrollment(idUser, appId, appKey, enrollment);
			
		} catch (BbvaClientAsoException e) {
			throw new BbvaClientBackException(e.getError());
		}catch (Exception e) {
			throw new BbvaClientBackException(CodClientException.CLIENT_ERROR,e);
		}
		return respuesta;
	}
	
	private void updateEnrollment(String enrollmentId, UserEntityRequest userEntityRequest ) throws BbvaClientBackException {
	
		 try {		
				String appId = env.getProperty("pibee.aso.jboss.app.id");
				String appKey=env.getProperty("pibee.aso.jboss.app.key");
				Enrollment enrollment = new Enrollment();		
				Platform plataforma= new Platform();
				plataforma.setId(userEntityRequest.getPlatform());
				enrollment.setPlatform(plataforma);
				enrollment.setDeviceId(userEntityRequest.getDevice());
				enrollment.setVersion(userEntityRequest.getVersion());
				enrollment.setToken(userEntityRequest.getToken());
				userService.modifyEnrollment(enrollmentId, appId, appKey, enrollment);
		} catch (BbvaClientAsoException e) {
			throw new BbvaClientBackException(e.getError());
		}catch (Exception e) {
			throw new BbvaClientBackException(CodClientException.CLIENT_ERROR,e);
		}
	}

	
}
