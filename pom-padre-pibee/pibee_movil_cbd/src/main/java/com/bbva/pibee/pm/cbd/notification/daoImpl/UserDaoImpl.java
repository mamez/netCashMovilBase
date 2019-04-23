package com.bbva.pibee.pm.cbd.notification.daoImpl;


import java.util.ArrayList;
import java.util.Date;
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
import com.bbva.pibee.dto.notification.UserDto;
import com.bbva.pibee.pm.cbd.notification.dao.UserDao;
import com.bbva.pibee.pm.cbd.notification.mappers.UserMapper;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;


@ClientBd
public class UserDaoImpl implements UserDao
{
	public static Logger logger = Logger.getLogger("pibee");
	
	static final String GET_USERS="SELECT * FROM TNCMUSER";
	static final String GETUSER=" SELECT * FROM TNCMUSER WHERE REFERENCE_USU = :REFERENCE_USU AND ID_USU=:ID_USU ";
	static final String CREATEUSER="INSERT INTO TNCMUSER(REFERENCE_USU,ID_USU,DEVICE_USU,TOKEN_USU,PLATFORM_USU, " + 
			"		VERSION_USU,CREATIONDATE_USU,MODIFIDATE_USU,STATE_USU,ENROLLMENT) VALUES " + 
			"			(:REFERENCE_USU,:ID_USU,:DEVICE_USU,:TOKEN_USU,:PLATFORM_USU,:VERSION_USU,:CREATIONDATE_USU,:MODIFIDATE_USU,:STATE_USU,:ENROLLMENT)";		
	static final String MODIFY="UPDATE TNCMUSER SET ";
	static final String MODIFYDEVICE = "DEVICE_USU=:DEVICE_USU ,";
	static final String MODIFYTOKEN = "TOKEN_USU=:TOKEN_USU ,";
	static final String MODIFYPLATFORM = " PLATFORM_USU=:PLATFORM_USU ,";
	static final String MODIFYVERSION = " VERSION_USU=:VERSION_USU ,";
	static final String MODIFYSTATE = " STATE_USU=:STATE_USU ,";
	static final String MODIFYDATEM = " MODIFIDATE_USU=TO_CHAR(CURRENT_DATE, 'YYYY-MM-DD')";
	static final String MODIFYWHERE = " WHERE REFERENCE_USU=:REFERENCE_USU AND ID_USU=:ID_USU ";
	
	@Autowired
	@Qualifier("BNCMCOnamedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	private Map<String, Object> parameters;	
	
	/*Metodo para listar todos los usuarios
	 * (non-Javadoc)
	 * @see com.bbva.pibee.pm.cbd.notification.dao.UserDao#getUsers(java.lang.String, java.lang.String)
	 */
	@Override
	public List<UserDto> getUsers(String reference, String user, String device, String token, String platform, String version, String creationDate, String modifiDate, String state, String enrollment)throws BbvaClientCbdException{
		parameters = new HashMap<String, Object>();
		List<UserDto> users = new ArrayList<UserDto>();
		try
		{
			parameters.put("REFERENCE_USU", reference);
			parameters.put("ID_USU", user);
			parameters.put("DEVICE_USU", device);
			parameters.put("TOKEN_USU", token);
			parameters.put("PLATAFORM_USU", platform);
			parameters.put("VERSION_USU", version);
			parameters.put("CREATIONDATE_USU", creationDate);
			parameters.put("MODIFIDATE_USU", modifiDate);
			parameters.put("STATE_USU", state);
			parameters.put("ENROLLMENT",enrollment);
			users = jdbcTemplate.query(GET_USERS, parameters, new UserMapper());
		}
		catch (EmptyResultDataAccessException e) {
			logger.debug("El usuario  "+ user+" no existe");
			users = null;
		}catch(DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+GETUSER.toString());
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch(Exception e){
			logger.error("ERROR AL EJECUTAR SQL: "+GETUSER);
			logger.error(e.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e);
		}
		return users;
	}

	
	/*Metodo para crear un usuario
	 * (non-Javadoc)
	 * @see com.bbva.pibee.pm.cbd.notification.dao.UserDao#createUser(com.bbva.pibee.dto.notification.UserDto)
	 */
	@Override
	public void createUser(UserDto userDto) throws BbvaClientCbdException 
	{
		parameters = new HashMap<String, Object>();
		
		try
		{
			parameters.put("REFERENCE_USU", userDto.getREFERENCE_USU());
			parameters.put("ID_USU", userDto.getID_USU());
			parameters.put("DEVICE_USU", userDto.getDEVICE_USU());
			parameters.put("TOKEN_USU", userDto.getTOKEN_USU());
			parameters.put("PLATFORM_USU", userDto.getPLATFORM_USU());
			parameters.put("VERSION_USU", userDto.getVERSION_USU());
			parameters.put("MODIFIDATE_USU",new Date());
			parameters.put("CREATIONDATE_USU",new Date());
			parameters.put("STATE_USU", "true");
			parameters.put("ENROLLMENT",userDto.getENROLLMENT());
			
		  this.jdbcTemplate.update(CREATEUSER, parameters);
						
		}
		catch(Exception e)
		{
			logger.error("ERROR AL EJECUTAR SQL: "+CREATEUSER);
			logger.error(e.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e);
		}		
	}
	
	/*Metodo para modifivar un suario registrado en notificaciones
	 * (non-Javadoc)
	 * @see com.bbva.pibee.pm.cbd.notification.dao.UserDao#modifyUser(com.bbva.pibee.dto.notification.UserDto)
	 */
	@Override
	public void modifyUser(UserDto userDto) throws BbvaClientCbdException {
		parameters = new HashMap<String, Object>();
		
		try{
			StringBuilder query = new StringBuilder(MODIFY);
			
			if(!userDto.getDEVICE_USU().isEmpty()){
				query.append(MODIFYDEVICE);
				parameters.put("DEVICE_USU", userDto.getDEVICE_USU());
			}
			
			if(!userDto.getTOKEN_USU().isEmpty()){
				query.append(MODIFYTOKEN);
				parameters.put("TOKEN_USU", userDto.getTOKEN_USU());
			}
				
			if(!userDto.getPLATFORM_USU().isEmpty()){
				query.append(MODIFYPLATFORM);
				parameters.put("PLATFORM_USU", userDto.getPLATFORM_USU());
			}
			
			if(!userDto.getVERSION_USU().isEmpty()){
				query.append(MODIFYVERSION);
				parameters.put("VERSION_USU", userDto.getVERSION_USU());
			}
				
			if(!userDto.getSTATE_USU().isEmpty()){
				query.append(MODIFYSTATE);
				parameters.put("STATE_USU", userDto.getSTATE_USU());
			}
				
			if(!userDto.getREFERENCE_USU().isEmpty() && !userDto.getID_USU().isEmpty()){
				query.append(MODIFYDATEM);
				query.append(MODIFYWHERE);
				parameters.put("REFERENCE_USU", userDto.getREFERENCE_USU());
				parameters.put("ID_USU", userDto.getID_USU());
			}								
			
		
			jdbcTemplate.update(query.toString(), parameters);	
		}
		catch(Exception e)
		{
			logger.error("ERROR AL EJECUTAR SQL: "+MODIFYDEVICE);
			logger.error(e.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e);
		}		
	}

	/*Metodo para obtener un usuario registrado en notificaciones
	 * (non-Javadoc)
	 * @see com.bbva.pibee.pm.cbd.notification.dao.UserDao#getUser(java.lang.String, java.lang.String)
	 */
	@Override
	public UserDto getUser(String reference, String user) throws BbvaClientCbdException {
		
		parameters = new HashMap<String, Object>();
		UserDto userDto =null;
		try
		{
			parameters.put("REFERENCE_USU", reference);
			parameters.put("ID_USU", user);
			userDto =(UserDto)this.jdbcTemplate.queryForObject(GETUSER, parameters, new UserMapper());
		}catch (EmptyResultDataAccessException e) {
			logger.debug("El usuario  "+ user+" no existe");
			userDto = null;
		}catch(DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+GETUSER.toString());
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch(Exception e){
			logger.error("ERROR AL EJECUTAR SQL: "+GETUSER);
			logger.error(e.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e);
		}
		return userDto;
		
	}

}
