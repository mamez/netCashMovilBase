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
import com.bbva.pibee.cbd.dao.OperationSignerDao;
import com.bbva.pibee.cbd.mappers.OperationSignerMapper;
import com.bbva.pibee.dto.cbd.OperationSignerDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;
@ClientBd
public class OperationSignerDaoImpl implements OperationSignerDao
{
	
	static final String QUERYLISTORDERID = "SELECT * FROM TLCL.TTLCLFFU"
			+" WHERE COD_IDORDEN = (:COD_IDORDEN)";
	
	static final String USER_FILER = " AND COD_USUARIO = :COD_USUARIO ";
	
	static final String UPDATE_SIGNER = "UPDATE TLCL.TTLCLFFU SET XSN_FIRMADO = :XSN_FIRMADO "
			+ "WHERE COD_CLIECASH = :COD_CLIECASH AND COD_CLASEORD = :COD_CLASEORD AND "
			+ "COD_IDORDEN = :COD_IDORDEN AND COD_USUARIO = :COD_USUARIO ";
	
	 @Autowired
	 @Qualifier("BTLCLCO1namedParameterJdbcTemplate")
	 private NamedParameterJdbcTemplate jdbcTemplate;
	
	 private Map<String, Object> parameters;
	 
	 @Override
	 /**
	  *Metodo para consultar por IDORDEN la tabla  Ttlclffu
	  * 
	  */
	 public List<OperationSignerDto> listOrderId(String codIdOrden) throws BbvaClientCbdException
	 {
		List<OperationSignerDto> listOrderId = new ArrayList<OperationSignerDto>();
		parameters = new HashMap<String, Object>();
		parameters.put("COD_IDORDEN", codIdOrden);
		
		try
		{
			listOrderId = (List<OperationSignerDto>)jdbcTemplate.query(QUERYLISTORDERID, parameters, new OperationSignerMapper());	
			LogNetCashMovil.logDebugPibee("Consulta realizada OK-> "+listOrderId.size());
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYLISTORDERID);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYLISTORDERID);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
		return listOrderId; 
	 }

	@Override
	public void udateOperationSigner(OperationSignerDto operationSignerDto) throws BbvaClientCbdException {		
		
		parameters = new HashMap<String, Object>();
		parameters.put("XSN_FIRMADO", operationSignerDto.getXSN_FIRMADO());
		parameters.put("COD_CLIECASH", operationSignerDto.getCOD_CLIECASH());
		parameters.put("COD_IDORDEN", operationSignerDto.getCOD_IDORDEN());
		parameters.put("COD_CLASEORD", operationSignerDto.getCOD_CLASEORD());
		parameters.put("COD_USUARIO", operationSignerDto.getCOD_USUARIO());
		try{
			int resp=jdbcTemplate.update(UPDATE_SIGNER, parameters);
			LogNetCashMovil.logDebugPibee("Actualizacion realizada-> "+resp);
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+UPDATE_SIGNER);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+UPDATE_SIGNER);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
	}

	@Override
	public OperationSignerDto getOperationSigner(String codIdOrden, String userId) throws BbvaClientCbdException {
		OperationSignerDto operationSignerDto = null;
		
		StringBuilder query = new StringBuilder(QUERYLISTORDERID);
		query.append(USER_FILER);
		
		parameters = new HashMap<String, Object>();
		parameters.put("COD_IDORDEN", codIdOrden);
		parameters.put("COD_USUARIO", userId);
		
		try
		{
			List<OperationSignerDto> operationSignerDtoList = (List<OperationSignerDto>)jdbcTemplate.query(query.toString(), parameters, new OperationSignerMapper()); 
			if(operationSignerDtoList != null && !operationSignerDtoList.isEmpty()){
				operationSignerDto = operationSignerDtoList.get(0);
				LogNetCashMovil.logDebugPibee("Consulta realizda COD_NUMALEAT-> "+operationSignerDto.getCOD_NUMALEAT());
				LogNetCashMovil.logDebugPibee("Consulta realizda COD_IDORDEN-> "+operationSignerDto.getCOD_IDORDEN());
				LogNetCashMovil.logDebugPibee("Consulta realizda XSN_FIRMADO-> "+operationSignerDto.getXSN_FIRMADO());
			}
			 			
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+query.toString());
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+query.toString());
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
		
		return operationSignerDto;
	}
}
