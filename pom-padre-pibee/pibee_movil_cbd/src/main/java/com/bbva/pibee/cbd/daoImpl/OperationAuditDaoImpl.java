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
import com.bbva.pibee.cbd.dao.OperationAuditDao;
import com.bbva.pibee.cbd.mappers.OperationAuditMapper;
import com.bbva.pibee.dto.cbd.OperationAuditDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;

@ClientBd
public class OperationAuditDaoImpl implements OperationAuditDao 
{
	
	static final String QUERYINSERT = "INSERT INTO TLCL.TTLBHFUA(COD_CLIECASH, COD_CLASEORD, COD_IDORDEN,"
			+" COD_ACCION, COD_IDACCION, COD_USUARIO, FEC_ACCIO, COD_USUFIRMA, COD_USUPODER, COD_ESTADFIC,"
			+" FEC_ACCION, AUD_FMODIFIC, AUD_USUARIO, COD_IPCLIENT, COD_APPORIG)"
			+ " VALUES (:COD_CLIECASH, :COD_CLASEORD, :COD_IDORDEN, :COD_ACCION, :COD_IDACCION, :COD_USUARIO, TO_CHAR(CURRENT_DATE, 'YYYYMMDD'), :COD_USUFIRMA,"
			+ ":COD_USUPODER,:COD_ESTADFIC, TO_CHAR(CURRENT_DATE, 'YYYYMMDD'), CURRENT_DATE ,:AUD_USUARIO, :COD_IPCLIENT, 'APP')";
	
	static final String QUERY_SELECT = "SELECT COD_CLIECASH, COD_CLASEORD, COD_IDORDEN, COD_ACCION, COD_IDACCION, COD_USUARIO, "
			+ "FEC_ACCIO, COD_USUFIRMA, COD_USUPODER, COD_ESTADFIC, FEC_ACCION, AUD_FMODIFIC, AUD_USUARIO, COD_IPCLIENT, COD_APPORIG "
			+ "FROM TLCL.TTLBHFUA ";
	
	static final String SIGNER_USER_FILTER = "WHERE COD_CLIECASH = :COD_CLIECASH AND COD_CLASEORD = :COD_CLASEORD AND COD_IDORDEN = :COD_IDORDEN "
			+ "AND COD_USUFIRMA = :COD_USUFIRMA";

	
	@Autowired
	@Qualifier("BTLCLCO1namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;
	 
	 private Map<String, Object> parameters; 	

	/**
	 * Metodo para insertar 
	 */
	 @Override
	 public void insert(String codClieCash, String codClaseOrd, String codIdOrden, int codAccion, int codIdAccion, String codUsuario, String codUsuFirma, String codUsuPoder, String codEstaFic, String  audUsuario, String codIpClient) throws BbvaClientCbdException {
		 try{
			 parameters = new HashMap<String, Object>();		 
			 parameters.put("COD_CLIECASH", codClieCash);
			 parameters.put("COD_CLASEORD", codClaseOrd);
			 parameters.put("COD_IDORDEN", codIdOrden);
			 parameters.put("COD_ACCION", codAccion);
			 parameters.put("COD_IDACCION", codIdAccion);
			 parameters.put("COD_USUARIO", codUsuario);
			 parameters.put("COD_USUFIRMA", codUsuFirma);
			 parameters.put("COD_USUPODER", codUsuPoder);
			 parameters.put("COD_ESTADFIC", codEstaFic);
			 parameters.put("AUD_USUARIO", audUsuario);
			 parameters.put("COD_IPCLIENT", codIpClient);
		 
		 
			int registros= jdbcTemplate.update(QUERYINSERT, parameters);
			LogNetCashMovil.logDebugPibee("Registros actualizados : "+registros);
		 }catch (DataAccessException e2) {
				LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYINSERT.toString());
				LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
				throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
			}catch (Exception e3) {
				LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYINSERT.toString());
				LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
				throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
			}			  
	 }

	@Override
	public OperationAuditDto getOperationAuditBySignerUser(String codClieCash, String codClaseOrd, String codIdOrden, String codUsuFirma) throws BbvaClientCbdException {

		OperationAuditDto operationAuditDto = null;	
		StringBuilder query=null;
		try{
			 query = new StringBuilder(QUERY_SELECT);
			query.append(SIGNER_USER_FILTER);
			
			parameters = new HashMap<String, Object>();
			parameters.put("COD_CLIECASH", codClieCash);
			parameters.put("COD_CLASEORD", codClaseOrd);
			parameters.put("COD_IDORDEN", codIdOrden);
			parameters.put("COD_USUFIRMA", codUsuFirma);
			List<OperationAuditDto> listOperationAuditDto    = jdbcTemplate.query(query.toString(), parameters, new OperationAuditMapper());
			if(listOperationAuditDto != null && (!listOperationAuditDto.isEmpty())) {
				operationAuditDto=listOperationAuditDto.get(0);
				LogNetCashMovil.logDebugPibee("Consulta realizada ok");
				LogNetCashMovil.logDebugPibee("AUD_USUARIO: "+operationAuditDto.getAUD_USUARIO());
				LogNetCashMovil.logDebugPibee("COD_ACCION: "+operationAuditDto.getCOD_ACCION());
				LogNetCashMovil.logDebugPibee("COD_APPORIG: "+operationAuditDto.getCOD_APPORIG());
				LogNetCashMovil.logDebugPibee("COD_IDORDEN: "+operationAuditDto.getCOD_IDORDEN());
				LogNetCashMovil.logDebugPibee("COD_USUFIRMA: "+operationAuditDto.getCOD_USUFIRMA());
			}else {
				LogNetCashMovil.logDebugPibee("La consulta no arroja ningun resultado");
			}
			
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+ query.toString());
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+query.toString());
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}	 
		return operationAuditDto;		
	} 
	 
}
