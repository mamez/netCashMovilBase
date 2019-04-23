package com.bbva.pibee.cbd.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.ClientBd;
import com.bbva.pibee.cbd.dao.OperationFileItemDao;
import com.bbva.pibee.cbd.mappers.OperationFileItemMapper;
import com.bbva.pibee.dto.cbd.OperationFileItemDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;

@ClientBd
public class OperationFileItemImpl implements OperationFileItemDao 
{	
	
	static final String QUERYUPDATE = "UPDATE BDBZ.TBDBZBIT SET COD_LOGONAPL = (:COD_LOGONAPL), XTI_BUZON = (:XTI_BUZON),"
			+"AUD_USUARIO = CURRENT USER, AUD_FMODIFIC = CURRENT DATE WHERE COD_CANALDI = (:COD_CANALDI)"
			+"AND COD_BANCOINT = (:COD_BANCOINT)  AND QNU_NUMITEM = (:QNU_NUMITEM)";
	
	static final String SELECT_QUERY = "SELECT COD_CANALDI, COD_BANCOINT, COD_LOGONAPL, XTI_BUZON, QNU_NUMITEM, "
			+ "FEC_RECEPCIO, HMS_RECEPCIO, AUD_USUARIO, AUD_FMODIFIC, COD_PID "
			+ "FROM BDBZ.TBDBZBIT "
			+ "WHERE QNU_NUMITEM = :QNU_NUMITEM";	
	
	static final String INSERT_QUERY = "INSERT INTO BDBZ.TBDBZBIT VALUES (:COD_CANALDI, :COD_BANCOINT, :COD_LOGONAPL, :XTI_BUZON, :QNU_NUMITEM, "
			+ ":FEC_RECEPCIO, :HMS_RECEPCIO, :AUD_USUARIO, :AUD_FMODIFIC, :COD_PID)";
	
	@Autowired
	@Qualifier("BTLNECO1namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	private Map<String, Object> parameters;
	
	@Override
	public void update(String codLogonapl , String xtiBuzon , int codCanalDi , int codBancoInt ,String  codLogonaplId, Long qnuNUmItem) throws BbvaClientCbdException 
	{
		parameters = new HashMap<String, Object>();
		
		parameters.put("COD_LOGONAPL", codLogonapl);
		parameters.put("XTI_BUZON", xtiBuzon);
		parameters.put("COD_CANALDI", codCanalDi);
		parameters.put("COD_BANCOINT", codBancoInt);
		//parameters.put("COD_LOGONAPLID", codLogonaplId);
		parameters.put("QNU_NUMITEM", qnuNUmItem);		
		
		try{
			int resp=jdbcTemplate.update(QUERYUPDATE, parameters);
			LogNetCashMovil.logDebugPibee("Registros acrualizados "+resp);
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYUPDATE.toString());
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYUPDATE.toString());
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
	}

	@Override
	public OperationFileItemDto getOperationFileItem(Long qnuItem) throws BbvaClientCbdException {
		OperationFileItemDto fileItem = null;
		try{
		parameters = new HashMap<String, Object>();
		parameters.put("QNU_NUMITEM", qnuItem);
		
		
			List<OperationFileItemDto> operationFileItemDtoList = jdbcTemplate.query(SELECT_QUERY, parameters, new OperationFileItemMapper());
			if(operationFileItemDtoList != null && !operationFileItemDtoList.isEmpty()){
				fileItem = operationFileItemDtoList.get(0);
				LogNetCashMovil.logDebugPibee("Consulta realizada ok");
				LogNetCashMovil.logDebugPibee("AUD_USUARIO "+fileItem.getAUD_USUARIO());
				LogNetCashMovil.logDebugPibee("COD_BANCOINT "+fileItem.getCOD_BANCOINT());
				LogNetCashMovil.logDebugPibee("COD_CANALDI "+fileItem.getCOD_CANALDI());
				LogNetCashMovil.logDebugPibee("COD_LOGONAPL "+fileItem.getCOD_LOGONAPL());
				LogNetCashMovil.logDebugPibee("QNU_NUMITEM "+fileItem.getQNU_NUMITEM());
				LogNetCashMovil.logDebugPibee("XTI_BUZON "+fileItem.getXTI_BUZON());
			}	
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+SELECT_QUERY.toString());
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+SELECT_QUERY.toString());
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}		
		return fileItem;
		
	}

	@Override
	public void createOperationFileItem(OperationFileItemDto operationFileItemDto) throws BbvaClientCbdException {
		try{
			parameters = new HashMap<String, Object>();
			
			parameters.put("COD_CANALDI", operationFileItemDto.getCOD_CANALDI());
			parameters.put("COD_BANCOINT", operationFileItemDto.getCOD_BANCOINT());
			parameters.put("COD_LOGONAPL", operationFileItemDto.getCOD_LOGONAPL());
			parameters.put("XTI_BUZON", operationFileItemDto.getXTI_BUZON());
			parameters.put("QNU_NUMITEM", operationFileItemDto.getQNU_NUMITEM());
			parameters.put("FEC_RECEPCIO", operationFileItemDto.getFEC_RECEPCIO());
			parameters.put("HMS_RECEPCIO", operationFileItemDto.getHMS_RECEPCIO());
			parameters.put("AUD_USUARIO", operationFileItemDto.getAUD_USUARIO());
			parameters.put("AUD_FMODIFIC", operationFileItemDto.getAUD_FMODIFIC());
			parameters.put("COD_PID", operationFileItemDto.getCOD_PID());
	
			
			int resp=jdbcTemplate.update(INSERT_QUERY, parameters);
			LogNetCashMovil.logDebugPibee("Registros acrualizados "+resp);
			
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+ INSERT_QUERY);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+ INSERT_QUERY);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
		
	}	
	
}
