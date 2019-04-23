package com.bbva.pibee.pm.cbd.notification.daoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.ClientBd;
import com.bbva.pibee.dto.notification.GenericServicesDto;
import com.bbva.pibee.dto.notification.ServicesDto;
import com.bbva.pibee.pm.cbd.notification.dao.ServiceDao;
import com.bbva.pibee.pm.cbd.notification.mappers.GenericServicesMapper;
import com.bbva.pibee.pm.cbd.notification.mappers.ServicesMapper;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;

@ClientBd
public class ServiceDaoImpl implements ServiceDao {	
	private static String QUERYGETSERVICES = "SELECT * FROM NOTIFICATION.TNCMSERV";
	public static Logger logger = Logger.getLogger("pibee");
	private   static String QUERY_GET_GENERIC_SERVICES= "SELECT ser.*, oper.ID_OPE, oper.COD_OPE, oper.NAME_OPE, oper.ACTION_OPE,  (SELECT conf.STATE_CONF FROM NOTIFICATION.TNCMCONF conf WHERE  conf.ID_USU =  USUARIO.ID_USU AND conf.REFERENCE_USU =USUARIO.REFERENCE_USU  AND oper.ID_OPE= FK_OPERATION  ) AS STATE_CONFIGURATION, " + 
			" (SELECT conf.ID_CONF FROM NOTIFICATION.TNCMCONF conf WHERE  conf.ID_USU = USUARIO.ID_USU  AND conf.REFERENCE_USU =USUARIO.REFERENCE_USU  AND oper.ID_OPE= FK_OPERATION  ) AS ID_CONFIGURATION " + 
			" FROM NOTIFICATION.TNCMSERV ser, NOTIFICATION.TNCMOPER oper , NOTIFICATION.TNCMUSER USUARIO " + 
			" WHERE ser.ID_SER = oper.FK_SERVICES AND oper.STATE_OPE='ACTIVO' " + 
			" AND  USUARIO.ID_USU = :USUARIO " + 
			" AND USUARIO.REFERENCE_USU = :REFERENCIA "
			+ "ORDER BY ser.ID_SER ";
	private static String 	QUERY_GET_ALL_SERVICES ="SELECT ser.*, oper.ID_OPE, oper.COD_OPE, oper.NAME_OPE, oper.ACTION_OPE" + 
			" FROM NOTIFICATION.TNCMSERV ser, NOTIFICATION.TNCMOPER oper" + 
			" WHERE ser.ID_SER = oper.FK_SERVICES AND oper.STATE_OPE='ACTIVO' ";
	
	private Map<String, Object> parameters;

	
	@Autowired
	@Qualifier("BNCMCOnamedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;		
	
	@Override
	public List<ServicesDto> getServices() throws BbvaClientCbdException 
	{
		List<ServicesDto> getListServices = new ArrayList<ServicesDto>();
		
		try
		{
			getListServices = (List<ServicesDto>) jdbcTemplate.query(QUERYGETSERVICES, new ServicesMapper());
		}catch (EmptyResultDataAccessException e) {
			logger.debug("La lista  "+ getListServices+" no existe");
			getListServices = null;
		}
		catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYGETSERVICES);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYGETSERVICES);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
		return getListServices;
	}
	

	@Override
	public List<GenericServicesDto> getGenericServices(String reference, String user) throws BbvaClientCbdException {
		List<GenericServicesDto> resp= new ArrayList<GenericServicesDto>();
		try {
			parameters = new HashMap<String, Object>();
			parameters.put("USUARIO", user);
			parameters.put("REFERENCIA",reference);
			
			resp= (List<GenericServicesDto>)jdbcTemplate.query(QUERY_GET_GENERIC_SERVICES, parameters, new GenericServicesMapper());
			
		}catch (EmptyResultDataAccessException e) {
			logger.debug("La lista  "+ resp+" no existe");
			resp = null;
		}
		catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERY_GET_GENERIC_SERVICES);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERY_GET_GENERIC_SERVICES);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
		return resp;
	}
	
	@Override
	public List<GenericServicesDto> getAllServices() throws BbvaClientCbdException{
		List<GenericServicesDto> resp= new ArrayList<GenericServicesDto>();
		try {
			resp=(List<GenericServicesDto>)jdbcTemplate.query(QUERY_GET_ALL_SERVICES, new GenericServicesMapper());
			
		}catch (EmptyResultDataAccessException e) {
				logger.debug("La lista  "+ resp+" no existe");
				resp = null;
			}
		catch(DataAccessException e2){
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERY_GET_GENERIC_SERVICES);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERY_GET_GENERIC_SERVICES);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);	
		}
		return resp;
	}
	
}