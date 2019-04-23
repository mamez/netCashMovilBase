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
import com.bbva.pibee.cbd.dao.TtlbhoriDao;
import com.bbva.pibee.cbd.mappers.TtlbhoriMapper;
import com.bbva.pibee.dto.cbd.TtlbhoriDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;

@ClientBd
public class TtlbhoriDaoImpl implements TtlbhoriDao
{
	
	static final String QUERYLISTGETTTLBHORI = "SELECT * FROM TLCL.TTLBHORI";
	
	static final String QUERYLISTACCOUNTSBYISSUING = "SELECT DISTINCT TLCL.TTLBHORI.COD_IDORIGEN, TLCL.TTLBHORI.COD_CLIECASH, TLCL.TTLBHORI.COD_CLASEORD, TLCL.TTLBHORI.COD_CDNITR, TLCL.TTLBHORI.COD_SUFPRESE, TLCL.TTLBHORI.XTI_DOCIDENT, TLCL.TTLBHORI.DES_DOCIDENT, TLCL.TTLBHORI.DES_PRSCONT, TLCL.TTLBHORI.DES_TFNOCONT, TLCL.TTLBHORI.COD_PROVINCI, TLCL.TTLBHORI.DES_ORIGEN, TLCL.TTLBHORI.DES_DOMIORI1, TLCL.TTLBHORI.DES_DOMIORI2, TLCL.TTLBHORI.DES_DOMIORI3, TLCL.TTLBHORI.DES_LOCALI, TLCL.TTLBHORI.COD_CDIPOS, TLCL.TTLBHORI.QNU_REFEREN, TLCL.TTLBHORI.XSN_REFEREN, TLCL.TTLBHORI.DES_REFEROPE, TLCL.TTLBHORI.XSN_CONCEPTO, TLCL.TTLBHORI.COD_ALFANUM, TLCL.TTLBHORI.COD_REFEREXT, TLCL.TTLBHORI.COD_SWIFT, TLCL.TTLBHCUO.COD_BANCSB, TLCL.TTLBHORI.XTI_EMISOR, TLCL.TTLBHORI.DES_ONOMBRE, TLCL.TTLBHORI.DES_ODIRECC, TLCL.TTLBHORI.COD_OCP2, TLCL.TTLBHORI.COD_SOCIEDAD "
			+ "FROM TLCL.TTLBHORI, TLCL.TTLBHCUO ";			
	
	static final String COMPANY_WHERE = "WHERE TLCL.TTLBHORI.COD_CLIECASH = :COD_CLIECASH AND TLCL.TTLBHORI.COD_CLASEORD =:COD_CLASEORD AND TLCL.TTLBHORI.COD_CLIECASH = TLCL.TTLBHCUO.COD_CLIECASH AND TLCL.TTLBHORI.COD_CLASEORD = TLCL.TTLBHCUO.COD_CLASEORD AND TLCL.TTLBHORI.COD_CDNITR = TLCL.TTLBHCUO.COD_CDNITR AND TLCL.TTLBHORI.COD_SUFPRESE = TLCL.TTLBHCUO.COD_SUFPRESE AND TLCL.TTLBHORI.COD_IDORIGEN = TLCL.TTLBHCUO.COD_IDORIGEN ";
	
	static final String ESPECIFIC_WHERE = "WHERE TLCL.TTLBHORI.COD_CLIECASH = :COD_CLIECASH AND TLCL.TTLBHORI.COD_CLASEORD =:COD_CLASEORD AND TLCL.TTLBHORI.COD_IDORIGEN = :COD_IDORIGEN "
			+ "AND TLCL.TTLBHORI.COD_CLIECASH = TLCL.TTLBHCUO.COD_CLIECASH AND TLCL.TTLBHORI.COD_CLASEORD = TLCL.TTLBHCUO.COD_CLASEORD "
			+ "AND TLCL.TTLBHORI.COD_CDNITR = TLCL.TTLBHCUO.COD_CDNITR AND TLCL.TTLBHORI.COD_SUFPRESE = TLCL.TTLBHCUO.COD_SUFPRESE "
			+ "AND TLCL.TTLBHORI.COD_IDORIGEN = TLCL.TTLBHCUO.COD_IDORIGEN ";
	
	static final String GROUP_BY = "ORDER BY TLCL.TTLBHORI.COD_IDORIGEN ASC";
	
	@Autowired
	@Qualifier("BTLCLCO1namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	private Map<String, Object> parameters;
	
	@Override
	public List<TtlbhoriDto> getTtlbhori() throws BbvaClientCbdException {
		List<TtlbhoriDto> getListTtlbhori = new ArrayList<TtlbhoriDto>();
		
		try{
			getListTtlbhori = (List<TtlbhoriDto>) jdbcTemplate.query(QUERYLISTGETTTLBHORI, new TtlbhoriMapper());
			LogNetCashMovil.logDebugPibee("consulta realizada ok-> "+getListTtlbhori.size());
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYLISTGETTTLBHORI);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYLISTGETTTLBHORI);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
		
		return getListTtlbhori;
	}
	
	@Override
	public List<TtlbhoriDto> getIssuings(String codCliecash, String codClaseord) throws BbvaClientCbdException {
		
		parameters = new HashMap<String, Object>();
		List<TtlbhoriDto> getListTtlbhori = new ArrayList<TtlbhoriDto>();
		
		try{
			parameters.put("COD_CLIECASH", codCliecash);
			parameters.put("COD_CLASEORD", codClaseord);
			
			StringBuilder query = new StringBuilder(QUERYLISTACCOUNTSBYISSUING).append(COMPANY_WHERE).append(GROUP_BY);
			
			getListTtlbhori = (List<TtlbhoriDto>) jdbcTemplate.query(query.toString(), parameters, new TtlbhoriMapper());
			LogNetCashMovil.logDebugPibee("consulta realizada ok-> "+getListTtlbhori.size());
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYLISTGETTTLBHORI);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYLISTGETTTLBHORI);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
		
		return getListTtlbhori;
	}

	@Override
	public TtlbhoriDto getTtlbhori(String codCliecash, String codClaseord, String codIdOrigen)
			throws BbvaClientCbdException {
		parameters = new HashMap<String, Object>();
		List<TtlbhoriDto> getListTtlbhori = new ArrayList<TtlbhoriDto>();
		TtlbhoriDto ttlbhoriDto = null;
		try{
			parameters.put("COD_CLIECASH", codCliecash);
			parameters.put("COD_CLASEORD", codClaseord);
			parameters.put("COD_IDORIGEN", codIdOrigen);
			
			StringBuilder query = new StringBuilder(QUERYLISTACCOUNTSBYISSUING).append(ESPECIFIC_WHERE).append(GROUP_BY);
			
			getListTtlbhori = (List<TtlbhoriDto>) jdbcTemplate.query(query.toString(), parameters, new TtlbhoriMapper());
			LogNetCashMovil.logDebugPibee("consulta realizada ok-> "+getListTtlbhori.size());
			if(getListTtlbhori != null && !getListTtlbhori.isEmpty()){
				ttlbhoriDto = getListTtlbhori.get(0);
			}
			
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYLISTGETTTLBHORI);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYLISTGETTTLBHORI);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
		
		return ttlbhoriDto;
	}

	
	
}
