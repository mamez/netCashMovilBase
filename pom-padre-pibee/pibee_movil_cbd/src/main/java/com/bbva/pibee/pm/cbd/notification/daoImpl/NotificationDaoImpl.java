package com.bbva.pibee.pm.cbd.notification.daoImpl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.ClientBd;
import com.bbva.pibee.dto.notification.NotificationDto;
import com.bbva.pibee.pm.cbd.notification.dao.NotificationDao;
import com.bbva.pibee.pm.cbd.notification.mappers.NotificationMapper;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;

@ClientBd
public class NotificationDaoImpl implements NotificationDao 
{	public static Logger logger = Logger.getLogger("pibee");
	static final String QUERYLISTNOTI= "SELECT ID_NOTI,DATE_NOTI,STATE_NOTI,TITLE_NOTI,DESCRIPTION_NOTI,FK_CONFIGURATION,CODE_TRAN,ORIGIN_NOTI "
			+ "FROM TNCMNOTI N INNER JOIN TNCMCONF C ON C.ID_CONF = N.FK_CONFIGURATION WHERE C.REFERENCE_USU= :REFERENCE_USU AND C.ID_USU= :ID_USU";
	
	static final String QUERYINSERTNOTI= "INSERT INTO TNCMNOTI (ID_NOTI,STATE_NOTI,DATE_NOTI,TITLE_NOTI,DESCRIPTION_NOTI,CODE_TRAN,FK_CONFIGURATION,ORIGIN_NOTI)" + 
			"VALUES ( :ID_NOTI, 'unread',TO_CHAR(CURRENT_DATE, 'YYYY-MM-DD'), :TITLE_NOTI, :DESCRIPTION_NOTI, :CODE_TRAN, :FK_CONFIGURATION, :ORIGIN_NOTI)";
	
	static final String QUERYDELETEALLNOTIBYUSER ="DELETE FROM TNCMNOTI N where N.FK_CONFIGURATION in "
			+ " (select C.ID_CONF FROM NOTIFICATION.TNCMCONF C WHERE C.REFERENCE_USU=:REFERENCE_USU AND C.ID_USU=:ID_USU)";
	
	static final String QUERYDELETENOTI = "DELETE FROM TNCMNOTI WHERE ID_NOTI = :ID_NOTI";
	
	static final String QUERYUPDATENOTIFICATION = "UPDATE TNCMNOTI SET STATE_NOTI='read' WHERE ID_NOTI =:ID_NOTI";
	
	static final String QUERYONENOTIFICATION="SELECT ID_NOTI,DATE_NOTI,STATE_NOTI,TITLE_NOTI,DESCRIPTION_NOTI,FK_CONFIGURATION,CODE_TRAN,ORIGIN_NOTI " + 
			" FROM TNCMNOTI N INNER JOIN TNCMCONF C ON C.ID_CONF = N.FK_CONFIGURATION WHERE C.REFERENCE_USU= :REFERENCE_USU AND C.ID_USU= :ID_USU  AND N.ID_NOTI = :ID_NOTI";
	
	
	@Autowired
	@Qualifier("BNCMCOnamedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	private Map<String, Object> parameters;
	int resultado = 0;
	
	@Override
	public List<NotificationDto> getNotification(String usuRefe, String usuId) throws BbvaClientCbdException 
	{
		List<NotificationDto> listGetNotification = new ArrayList<NotificationDto>();
		parameters = new HashMap<String, Object>();		
		try
		{
			parameters.put("REFERENCE_USU", usuRefe);
			parameters.put("ID_USU", usuId);
			listGetNotification = (List<NotificationDto>) jdbcTemplate.query(QUERYLISTNOTI, parameters, new NotificationMapper());
		}
		catch (EmptyResultDataAccessException e) {
			logger.debug("La lista  "+ listGetNotification+" no existe");
			listGetNotification = null;
		}
		catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYLISTNOTI);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYLISTNOTI);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}		
		return listGetNotification;		
	}
	
	@Override
	public List<NotificationDto> getOneNotification(String usuRefe, String usuId, int idNoti) throws BbvaClientCbdException
	{
		List<NotificationDto> listOneNotification = new ArrayList<NotificationDto>();
		parameters = new HashMap<String, Object>();
		
		try
		{
			parameters.put("REFERENCE_USU", usuRefe);
			parameters.put("ID_USU", usuId);
			parameters.put("ID_NOTI", idNoti);
			listOneNotification = (List<NotificationDto>) jdbcTemplate.query(QUERYONENOTIFICATION, parameters, new NotificationMapper());
		}catch (EmptyResultDataAccessException e) {
			logger.debug("La lista  "+ listOneNotification+" no existe");
			listOneNotification = null;
		}
		catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYLISTNOTI);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYLISTNOTI);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
		
		return listOneNotification; 
	}
	
   @Override
	public void insertNotification(NotificationDto noti) throws BbvaClientCbdException 
	{  
		SimpleDateFormat formatoId = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Timestamp id = new Timestamp(System.currentTimeMillis());
		String  idNoti = formatoId.format(id);
		
		parameters = new HashMap<String, Object>();	
		try
		{
			parameters.put("ID_NOTI", idNoti);
			parameters.put("TITLE_NOTI", noti.getTITLE_NOTI());
			parameters.put("DESCRIPTION_NOTI",noti.getDESCRIPTION_NOTI());
			parameters.put("CODE_TRAN", noti.getCODE_TRAN());
			parameters.put("FK_CONFIGURATION",noti.getFK_CONFIGURATION());
			parameters.put("ORIGIN_NOTI", noti.getORIGIN_NOTI());
			
			jdbcTemplate.update(QUERYINSERTNOTI, parameters);
		}catch (DataIntegrityViolationException e) {
			throw new BbvaClientCbdException(CodClientException.INVALID_PARAMETERS);
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYINSERTNOTI);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYINSERTNOTI);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}				
	}

	@Override
	public void deleteAllNotificationByUser(String userRef, String userId) throws BbvaClientCbdException
	{
		parameters = new HashMap<String, Object>();
		try
		{
			parameters.put("REFERENCE_USU", userRef);
			parameters.put("ID_USU", userId);
			jdbcTemplate.update(QUERYDELETEALLNOTIBYUSER, parameters);			
		}
		catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYDELETEALLNOTIBYUSER);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYDELETEALLNOTIBYUSER);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
	}

	@Override
	public int deleteNotification(String idNoti) throws BbvaClientCbdException
	{
		parameters = new HashMap<String, Object>();
		int resp=0;
		try
		{
			parameters.put("ID_NOTI", idNoti);
			resp=jdbcTemplate.update(QUERYDELETENOTI, parameters);
		}
		catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYDELETENOTI);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			resp=-1;
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYDELETENOTI);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			resp=-1;
		}
		return resp;
	}

	@Override
	public int updateNotification(String idNoti) throws BbvaClientCbdException
	{		
		parameters = new HashMap<String, Object>();		
		 try
		 {
			 parameters.put("ID_NOTI", idNoti);			 
			 resultado =jdbcTemplate.update(QUERYUPDATENOTIFICATION, parameters);			 
		 }
		catch (DataAccessException e2) {			
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYUPDATENOTIFICATION);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYUPDATENOTIFICATION);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
		 return resultado;
	}
	
}