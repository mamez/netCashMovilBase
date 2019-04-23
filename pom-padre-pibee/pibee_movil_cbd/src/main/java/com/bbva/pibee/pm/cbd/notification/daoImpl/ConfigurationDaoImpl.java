package com.bbva.pibee.pm.cbd.notification.daoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.bbva.pibee.arq.annotations.ClientBd;
import com.bbva.pibee.dto.notification.ConfigurationDto;
import com.bbva.pibee.pm.cbd.notification.dao.ConfigurationDao;
import com.bbva.pibee.pm.cbd.notification.mappers.ConfigurationMapper;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;

@ClientBd
public class ConfigurationDaoImpl implements ConfigurationDao
{
	public static Logger logger = Logger.getLogger("pibee");
	
	static final String QUERYEXISTCONFIG = "SELECT count(*) FROM TNCMCONF WHERE FK_OPERATION= :FK_OPERATION AND REFERENCE_USU= :REFERENCE_USU AND ID_USU=:ID_USU";
	
	static final String QUERYINSERTCONFIGURATION = "INSERT INTO TNCMCONF(STATE_CONF,REFERENCE_USU,ID_USU,DATE_AUDI,FK_OPERATION)"
			+ " VALUES (:STATE_CONF,:REFERENCE_USU,:ID_USU,TO_CHAR(CURRENT_DATE, 'YYYY-MM-DD'),:FK_OPERATION)";
	
	static final String QUERY_UPDATE_CONFIGURATION = "UPDATE TNCMCONF SET STATE_CONF= :STATE_CONF  WHERE FK_OPERATION= :FK_OPERATION AND REFERENCE_USU=:REFERENCE_USU AND  ID_USU=:ID_USU";
	
	static final String QUERYEXISTCONFIGBYUSER ="SELECT count(*) FROM NOTIFICATION.TNCMCONF WHERE ID_CONF=:ID_CONF AND REFERENCE_USU= :REFERENCE_USU AND ID_USU=:ID_USU";
	
	@Autowired
	@Qualifier("BNCMCOnamedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	private Map<String, Object> parameters;
	
	/*petodo para verificar una configuracion 
	 * (non-Javadoc)
	 * @see com.bbva.pibee.pm.cbd.notification.dao.ConfigurationDao#existConfigByOperation(int, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean existConfigByOperation(int fkOPeration, String reference, String idUser) throws BbvaClientCbdException
	{
		parameters = new HashMap<String, Object>();
		boolean existe= false;
		try
		{
			parameters.put("FK_OPERATION", fkOPeration);
			parameters.put("REFERENCE_USU", reference);
			parameters.put("ID_USU", idUser);
			int total = (Integer)this.jdbcTemplate.queryForObject(QUERYEXISTCONFIG,parameters, Integer.class);
			if(total > 0 ) {
				existe = true;
			}
		}
		catch(Exception e)
		{
			logger.error("ERROR AL EJECUTAR SQL: "+QUERYEXISTCONFIG);
			logger.error(e.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e);
		}
		
		return existe;
	}
	
	/*Metodo para verificar una configuracion de usuario
	 * (non-Javadoc)
	 * @see com.bbva.pibee.pm.cbd.notification.dao.ConfigurationDao#getExistConfigByUser(int, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean existConfigByUser(int idConfig, String reference, String idUser) throws BbvaClientCbdException {
		parameters = new HashMap<String, Object>();
		boolean existe= false;
		
		try{
			parameters.put("ID_CONF", idConfig);
			parameters.put("REFERENCE_USU", reference);
			parameters.put("ID_USU", idUser);
			
			int total = (Integer)this.jdbcTemplate.queryForObject(QUERYEXISTCONFIGBYUSER, parameters,Integer.class);
			if(total > 0 ) {
				existe = true;
			}
		}
		catch(Exception e){
			logger.error("ERROR AL EJECUTAR SQL: "+QUERYEXISTCONFIGBYUSER);
			logger.error(e.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e);
		}
		return existe;
	}


	@Override
	public int updateConfiguration(String state,int fkOperacion, String user, String reference) throws BbvaClientCbdException{
		 int resultado=0;
		parameters = new HashMap<String, Object>();
		
		try{	
			parameters.put("STATE_CONF", state);
			parameters.put("FK_OPERATION", fkOperacion);
			parameters.put("ID_USU", user);
			parameters.put("REFERENCE_USU", reference);
			jdbcTemplate.update(QUERY_UPDATE_CONFIGURATION, parameters);
			resultado = 1;
		}
		catch(Exception e){
			logger.error("ERROR AL EJECUTAR SQL: "+QUERY_UPDATE_CONFIGURATION);
			logger.error(e.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e);
		}
		return resultado;
	}
	
	
	/*Merodo para insertar una configuracion
	 * (non-Javadoc)
	 * @see com.bbva.pibee.pm.cbd.notification.dao.ConfigurationDao#insertConfiguration(java.lang.String, java.lang.String, java.lang.String, int)
	 */
	@Override
	public int insertConfiguration(String stateConf,String refeUser, String userId, int fkOpera) throws BbvaClientCbdException{	
		 int resultado=0;
		parameters = new HashMap<String, Object>();
		
		try{			
			parameters.put("STATE_CONF", stateConf);
			parameters.put("REFERENCE_USU", refeUser);
			parameters.put("ID_USU", userId);
			parameters.put("FK_OPERATION", fkOpera);
			
			jdbcTemplate.update(QUERYINSERTCONFIGURATION, parameters);
			resultado = 1;
		}
		catch(Exception e){
			logger.error("ERROR AL EJECUTAR SQL: "+QUERYINSERTCONFIGURATION);
			logger.error(e.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e);			
		}
		return resultado;
	}
}
