package com.bbva.pibee.cbd.daoImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.ClientBd;
import com.bbva.pibee.cbd.dao.OperationStateDao;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;

@ClientBd
public class OperationStateDaoImpl implements OperationStateDao{

	static final String LISTQUERY = "SELECT DES_LITECOR "
			+ "FROM BDBD.TBDBDLDM WHERE COD_CATALOG = 'ESTADOFR' "
			+ "AND COD_IDIOMA = :languageCode AND COD_CLAVELIT = :operationStateId";

	
	@Autowired  
	@Qualifier("BTLNECO1namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate JdbcTemplate;
	
	private Map<String, Object> parameters;
	
	@Override
	public String getOperationStateDescription(String operationStateId,Integer languageCode) throws BbvaClientCbdException{
		String operationStateDescription = null;
		
		parameters = new HashMap<String, Object>();
		parameters.put("operationStateId", operationStateId);
		parameters.put("languageCode", languageCode);
		
		try{
			operationStateDescription = (String) JdbcTemplate.queryForObject(LISTQUERY,parameters, String.class);
			LogNetCashMovil.logDebugPibee("Descripcion encontrada "+operationStateDescription);
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+LISTQUERY);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+LISTQUERY);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
		return operationStateDescription;
	}

}
