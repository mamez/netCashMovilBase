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
import com.bbva.pibee.cbd.dao.TtlbhcuoDao;
import com.bbva.pibee.cbd.mappers.TtlbhcuoMapper;
import com.bbva.pibee.dto.cbd.TtlbhcuoDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;

@ClientBd
public class TtlbhcuoDaoImpl implements TtlbhcuoDao{

	private final String QUERY_GET_TTLBHCUO = "SELECT * FROM TLCL.TTLBHCUO ";
	private final String QUERY_GET_ACCOUNTSCUO = "SELECT * FROM TLCL.TTLBHCUO CUO WHERE CUO.COD_CLIECASH = :COD_CLIECASH AND CUO.COD_CLASEORD = :COD_CLASEORD AND CUO.COD_IDORIGEN = :COD_IDORIGEN ";
	private final String INSERT_CUO = "INSERT INTO TLCL.TTLBHCUO (COD_CLIECASH, COD_CLASEORD, COD_CDNITR, COD_SUFPRESE, COD_IDORIGEN, DES_CUENORIG, COD_BANCINTE, COD_BANCASH, COD_BANCSB, COD_SWIFT, COD_BANABA, COD_DIISOALF, COD_FORMASUN, XTI_CLASEASU, AUD_FMODIFIC, AUD_USUARIO) VALUES(:COD_CLIECASH, :COD_CLASEORD, :COD_CDNITR, :COD_SUFPRESE, :COD_IDORIGEN, :DES_CUENORIG, :COD_BANCINTE, :COD_BANCASH, :COD_BANCSB, :COD_SWIFT, :COD_BANABA, :COD_DIISOALF, :COD_FORMASUN, :XTI_CLASEASU, :AUD_FMODIFIC, :AUD_USUARIO ";
	
	@Autowired
	@Qualifier("BTLCLCO1namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	private Map<String, Object> parameters;

	@Override
	public List<TtlbhcuoDto> getTtlbhcuo() throws BbvaClientCbdException 
	{
		List<TtlbhcuoDto> getTtlbhcuo = new ArrayList<TtlbhcuoDto>();
		
		try{
			getTtlbhcuo = (List<TtlbhcuoDto>) jdbcTemplate.query(QUERY_GET_TTLBHCUO, new TtlbhcuoMapper());
			LogNetCashMovil.logDebugPibee("Consulta realizada ok-> "+getTtlbhcuo.size());
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERY_GET_TTLBHCUO);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERY_GET_TTLBHCUO);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
		return getTtlbhcuo;
	}
	
	@Override
	public List<TtlbhcuoDto> getAccounts(String codCliecash, String codClaseord, String codIdorigen) throws BbvaClientCbdException {
		
		List<TtlbhcuoDto> getAccountsCuo = new ArrayList<TtlbhcuoDto>();
		parameters = new HashMap<String, Object>();
		
		try {
			parameters.put("COD_CLIECASH", codCliecash);
			parameters.put("COD_CLASEORD", codClaseord);
			parameters.put("COD_IDORIGEN", codIdorigen);
			
			getAccountsCuo = (List<TtlbhcuoDto>)jdbcTemplate.query(QUERY_GET_ACCOUNTSCUO, parameters, new TtlbhcuoMapper());
			LogNetCashMovil.logDebugPibee("Consulta realizada ok-> "+getAccountsCuo.size());
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERY_GET_ACCOUNTSCUO);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERY_GET_ACCOUNTSCUO);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
		return getAccountsCuo;
	}
	
	@Override
	public void insertCUO(String codCliecash, String codClaseord, String codCdnitr, String codSufprese, String codIdorigen, String desCuenorig, String codBancinte, String codBancash, int codBancsb, String codSwift, String codBanaba, String codDiisoalf, int codFormasun, String xtiClaseasu, String audFmodific, String audUsuario) throws BbvaClientCbdException {
						
		parameters = new HashMap<String, Object>();
		
		try {
			parameters.put("COD_CLIECASH", codCliecash);
			parameters.put("COD_CLASEORD", codClaseord);
			parameters.put("COD_CDNITR", codCdnitr);
			parameters.put("COD_SUFPRESE", codSufprese);
			parameters.put("COD_IDORIGEN", codIdorigen);
			parameters.put("DES_CUENORIG", desCuenorig);
			parameters.put("COD_BANCINTE", codBancinte);
			parameters.put("COD_BANCASH", codBancash);
			parameters.put("COD_BANCSB", codBancsb);
			parameters.put("COD_SWIFT", codSwift);
			parameters.put("COD_BANABA", codBanaba);
			parameters.put("COD_DIISOALF", codDiisoalf);
			parameters.put("COD_FORMASUN", codFormasun);
			parameters.put("XTI_CLASEASU", xtiClaseasu);
			parameters.put("AUD_FMODIFIC", audFmodific);
			parameters.put("AUD_USUARIO", audUsuario);
			
			jdbcTemplate.update(INSERT_CUO, parameters);
			LogNetCashMovil.logDebugPibee("Registro creado OK");
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+INSERT_CUO);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+INSERT_CUO);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
	}
}
