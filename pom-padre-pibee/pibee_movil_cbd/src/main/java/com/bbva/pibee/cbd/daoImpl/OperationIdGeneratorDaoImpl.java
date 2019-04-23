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
import com.bbva.pibee.cbd.dao.OperationIdGeneratorDao;
import com.bbva.pibee.cbd.mappers.OperationIdGeneratorMapper;
import com.bbva.pibee.dto.cbd.OperationIdGeneratorDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;

@ClientBd
public class OperationIdGeneratorDaoImpl implements OperationIdGeneratorDao{

	private static final String SELECT_QUERY = "SELECT A.COD_IDENTIFI, A.COD_LOCALIZA, A.COD_CCONTROL, A.QNU_IDORDEN, A.QNU_IDORDEN2, A.AUD_FMODIFIC, A.AUD_USUARIO "
			+ "FROM TLCL.TTLCLGID A "
			+ "WHERE A.COD_LOCALIZA = :sLocal AND A.COD_CCONTROL = :sCodControl ";
	
	private static final String INSERT_QUERY = "INSERT INTO TTLCLGID (QNU_IDORDEN2, AUD_FMODIFIC, AUD_USUARIO, COD_LOCALIZA, COD_CCONTROL, COD_IDENTIFI) "
			+ "VALUES ( :qnuIdOrden2 , :fModific , :aUser , :sLocal , :sCodControl ,'idorden')";
	
	private static final String UPDATE_QUERY = "UPDATE TTLCLGID SET QNU_IDORDEN2 = :qnuIdOrden2 , AUD_FMODIFIC = :fModific , AUD_USUARIO = :aUser "
			+ "WHERE COD_LOCALIZA = :sLocal AND COD_CCONTROL = :sCodControl ";	
	
	@Autowired
	@Qualifier("BTLCLCO1namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;

	private Map<String, Object> parameters;
	
	@Override
	public OperationIdGeneratorDto getOperationIdGenerator(String sLocal, String sCodControl) throws BbvaClientCbdException {
		OperationIdGeneratorDto result = null;
		StringBuilder query = new StringBuilder(SELECT_QUERY);
		try{
			if(sLocal != null && !sLocal.isEmpty() && sCodControl != null && !sCodControl.isEmpty()){
				parameters = new HashMap<String, Object>();
				parameters.put("sLocal", sLocal);
				parameters.put("sCodControl", sCodControl);
				
				List<OperationIdGeneratorDto> resultList = (List<OperationIdGeneratorDto>)jdbcTemplate.query(query.toString(), parameters, new OperationIdGeneratorMapper());
				if(resultList != null && !resultList.isEmpty()){
					result = resultList.get(0);
				}
			}else{
				String campos = "";
				campos += sLocal.isEmpty()?"COD_LOCALIZA, ":"";
				campos += sLocal.isEmpty()?"COD_CCONTROL, ":"";				
				LogNetCashMovil.logDebugPibee("Campo(s) "+campos+"vacio(s)");
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
		
		return result;
	}

	@Override
	public void createOperationIdGenerator(OperationIdGeneratorDto operationIdGeneratorDto)
			throws BbvaClientCbdException {
		try{
			parameters = new HashMap<String, Object>();
			parameters.put("qnuIdOrden2", operationIdGeneratorDto.getQNU_IDORDEN2());
			parameters.put("fModific", operationIdGeneratorDto.getAUD_FMODIFIC());
			parameters.put("aUser", operationIdGeneratorDto.getAUD_USUARIO());
			parameters.put("sLocal", operationIdGeneratorDto.getCOD_LOCALIZA());
			parameters.put("sCodControl", operationIdGeneratorDto.getCOD_CCONTROL());			
			
			int resp=jdbcTemplate.update(INSERT_QUERY, parameters);
			LogNetCashMovil.logDebugPibee("Elemento creado OK operationIdGeneratorDto -> "+ resp);
			
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

	@Override
	public void updateOperationIdGenerator(OperationIdGeneratorDto operationIdGeneratorDto)
			throws BbvaClientCbdException {
		try{
			parameters = new HashMap<String, Object>();
			parameters.put("qnuIdOrden2", operationIdGeneratorDto.getQNU_IDORDEN2());
			parameters.put("fModific", operationIdGeneratorDto.getAUD_FMODIFIC());
			parameters.put("aUser", operationIdGeneratorDto.getAUD_USUARIO());
			parameters.put("sLocal", operationIdGeneratorDto.getCOD_LOCALIZA());
			parameters.put("sCodControl", operationIdGeneratorDto.getCOD_CCONTROL());			
			
			int resp=jdbcTemplate.update(UPDATE_QUERY, parameters);
			LogNetCashMovil.logDebugPibee("Elemento actualizado OK operationIdGeneratorDto -> "+ resp);
			
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
