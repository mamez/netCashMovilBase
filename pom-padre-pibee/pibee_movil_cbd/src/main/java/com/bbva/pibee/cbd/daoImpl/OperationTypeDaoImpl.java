package com.bbva.pibee.cbd.daoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.ClientBd;
import com.bbva.pibee.cbd.dao.OperationTypeDao;
import com.bbva.pibee.cbd.mappers.OperationTypeMapper;
import com.bbva.pibee.dto.response.OperationType;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;

@ClientBd
public class OperationTypeDaoImpl implements OperationTypeDao {	
	
	static final String LISTQUERY = "SELECT CLO.COD_CLASEORD, LDM.DES_LITECOR "
			+ "FROM TLNE.TTLBHCLO CLO JOIN BDBD.TBDBDLDM LDM ON CLO.COD_CLASEORD = LDM.COD_CLAVELIT AND LDM.COD_CATALOG = 'CLASEORD' AND LDM.COD_IDIOMA = :languageCode "
			+ "WHERE CLO.COD_SERCRUBD IN (:services)";	
	
	
	@Autowired  
	@Qualifier("BTLNECO1namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate JdbcTemplate;
	 
	private Map<String, Object> parameters;
	
	@Override
	public List<OperationType> listOperationType(List<Integer> serviceCodeList, Integer languageCode)throws BbvaClientCbdException {
		List<OperationType> resultList = new ArrayList<OperationType>();
		parameters = new HashMap<String, Object>();
		parameters.put("services", serviceCodeList);
		parameters.put("languageCode", languageCode);			
		
		try{
			resultList = (List<OperationType>) JdbcTemplate.query(LISTQUERY,parameters, new OperationTypeMapper());
			LogNetCashMovil.logDebugPibee("Consulta realizada OK-> "+resultList.size());
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+LISTQUERY);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+LISTQUERY);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
		
		
		return resultList;
	}

}
