package com.bbva.pibee.pm.cbd.notification.daoImpl;

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
import com.bbva.pibee.dto.notification.OperationDto;
import com.bbva.pibee.dto.notification.UserDto;
import com.bbva.pibee.pm.cbd.notification.dao.OperationDao;
import com.bbva.pibee.pm.cbd.notification.mappers.OperationMapper;
import com.bbva.pibee.pm.cbd.notification.mappers.UserMapper;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;

@ClientBd
public class OperationDaoImpl implements OperationDao 
{
	public static Logger logger = Logger.getLogger("pibee");
	
	static String QUERY_GET_OPERATION = "SELECT O.COD_OPE,O.NAME_OPE,O.ACTION_OPE ,C.STATE_CONF, C.ID_CONF, O.ID_OPE, O.STATE_OPE, O.FK_SERVICES FROM TNCMCONF C " + 
			       "INNER JOIN TNCMOPER O ON O.ID_OPE=C.FK_OPERATION " + 
			       "WHERE O.STATE_OPE='ACTIVO' AND C.REFERENCE_USU=:REFERENCE_USU AND C.ID_USU=:ID_USU  AND C.FK_OPERATION= :FK_OPERATION";
	
	@Autowired
	@Qualifier("BNCMCOnamedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	private Map<String, Object> parameters;
	
	@Override
	public OperationDto getOperation(String referenceUser, String userId,int idOperacion) throws BbvaClientCbdException 
	{
		parameters = new HashMap<String, Object>();
		OperationDto operationDto = null;
		try
		{
			parameters.put("REFERENCE_USU", referenceUser);
			parameters.put("ID_USU", userId);
			parameters.put("FK_OPERATION", idOperacion);
			operationDto =(OperationDto)this.jdbcTemplate.queryForObject(QUERY_GET_OPERATION, parameters, new OperationMapper());
		}catch (EmptyResultDataAccessException e) {
			logger.debug("la operacion"+ userId+"");
			operationDto = null;
		}catch (Exception e) {
			logger.error("ERROR AL EJECUTAR SQL: "+QUERY_GET_OPERATION);
			logger.error(e.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e);
		}
		return operationDto;
	}
	
  }


