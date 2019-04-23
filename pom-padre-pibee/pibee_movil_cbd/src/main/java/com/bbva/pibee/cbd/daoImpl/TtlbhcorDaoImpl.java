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
import com.bbva.pibee.cbd.dao.TtlbhcorDao;
import com.bbva.pibee.cbd.mappers.TtlbhcorMapper;
import com.bbva.pibee.dto.cbd.TtlbhcorDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;

@ClientBd
public class TtlbhcorDaoImpl implements TtlbhcorDao {
	

	private final String QUERY_GET_TTLBHCOR = "SELECT * FROM TLCL.TTLBHCOR";
	
	private final String INSERT_QUERY = "INSERT INTO TLCL.TTLBHCOR VALUES (:COD_IDORDEN, :COD_CLIECASH, :COD_CLASEORD, :COD_CABECORI, :COD_CDNITR, :COD_SUFPRESE, "
			+ ":COD_IDORIGEN, :DES_CUENORIG, :COD_BANCINTE, :COD_BANCSB, :COD_DIISOALF, :COD_FORMASUN, "
			+ ":XTI_CLASEASU, :COD_SWIFT, :COD_BANABA, :DES_FICHEROH, :AUD_FMODIFIC, :AUD_USUARIO, "
			+ ":XTI_EMISOR, :DES_ORDPAGO, :XTI_INDMODAL)";
	
	@Autowired
	@Qualifier("BTLCLCO1namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	private Map<String, Object> parameters;

	@Override
	public List<TtlbhcorDto> getTtlbhcor() throws BbvaClientCbdException 
	{
		List<TtlbhcorDto> getTtlbhcor = new ArrayList<TtlbhcorDto>();
		
		try{
			getTtlbhcor = (List<TtlbhcorDto>) jdbcTemplate.query(QUERY_GET_TTLBHCOR, new TtlbhcorMapper());
			LogNetCashMovil.logDebugPibee("Consulta realizada ok->"+getTtlbhcor.size());
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERY_GET_TTLBHCOR);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERY_GET_TTLBHCOR);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
		return getTtlbhcor;
	}
	

	@Override
	public void createOperationSourceHeader(TtlbhcorDto operationSourceHeader) throws BbvaClientCbdException {
		parameters = new HashMap<String, Object>();
		
		try {
			parameters.put("COD_IDORDEN", operationSourceHeader.getCOD_IDORDEN());
			parameters.put("COD_CLIECASH", operationSourceHeader.getCOD_CLIECASH());
			parameters.put("COD_CLASEORD", operationSourceHeader.getCOD_CLASEORD());
			parameters.put("COD_CABECORI", operationSourceHeader.getCOD_CABECORI());
			parameters.put("COD_CDNITR", operationSourceHeader.getCOD_CDNITR());
			parameters.put("COD_SUFPRESE", operationSourceHeader.getCOD_SUFPRESE());
			parameters.put("COD_IDORIGEN", operationSourceHeader.getCOD_IDORIGEN());
			parameters.put("DES_CUENORIG", operationSourceHeader.getDES_CUENORIG());			
			parameters.put("COD_BANCINTE", operationSourceHeader.getCOD_BANCINTE());
			parameters.put("COD_BANCSB", operationSourceHeader.getCOD_BANCSB());
			parameters.put("COD_DIISOALF", operationSourceHeader.getCOD_DIISOALF());
			parameters.put("COD_FORMASUN", operationSourceHeader.getCOD_FORMASUN());
			parameters.put("XTI_CLASEASU", operationSourceHeader.getXTI_CLASEASU());
			parameters.put("COD_SWIFT", operationSourceHeader.getCOD_SWIFT());
			parameters.put("COD_BANABA", operationSourceHeader.getCOD_BANABA());
			parameters.put("DES_FICHEROH", operationSourceHeader.getDES_FICHEROH());
			parameters.put("AUD_FMODIFIC", operationSourceHeader.getAUD_FMODIFIC());
			parameters.put("AUD_USUARIO", operationSourceHeader.getAUD_USUARIO());
			parameters.put("XTI_EMISOR", operationSourceHeader.getXTI_EMISOR());
			parameters.put("DES_ORDPAGO", operationSourceHeader.getDES_ORDPAGO());
			parameters.put("XTI_INDMODAL", operationSourceHeader.getXTI_INDMODAL());			
			
			jdbcTemplate.update(INSERT_QUERY, parameters);
			LogNetCashMovil.logDebugPibee("Registro creado OK");
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
