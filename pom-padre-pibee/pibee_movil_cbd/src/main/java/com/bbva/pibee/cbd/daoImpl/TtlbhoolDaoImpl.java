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
import com.bbva.pibee.cbd.dao.TtlbhoolDao;
import com.bbva.pibee.cbd.mappers.TtlbhoolMapper;
import com.bbva.pibee.dto.cbd.TtlbhoolDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;

@ClientBd
public class TtlbhoolDaoImpl implements TtlbhoolDao {
	

	private final String QUERY_GET_TTLBHOOL = "SELECT * FROM TLCL.TTLBHOOL WHERE QNU_NUMITEM = :QNU_NUMITEM ";
	private final String WHERE_GET_TTLBHOOL_TPO="AND COD_TIPORD = 'TPO'";
	private final String INSERT_OOL = "INSERT INTO TLCL.TTLBHOOL (QNU_NUMITEM, TIM_ORDEN, QNU_ORDEN, DES_ORDENOL, COD_TIPORD, COD_BANCOGBL, AUD_FMODIFIC, AUD_USUARIO) VALUES(:QNU_NUMITEM, :TIM_ORDEN, :QNU_ORDEN, :DES_ORDENOL, :COD_TIPORD, :COD_BANCOGBL, :AUD_FMODIFIC, :AUD_USUARIO)";
	
	@Autowired
	@Qualifier("BTLCLCO1namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	private Map<String, Object> parameters;

	@Override
	public List<TtlbhoolDto> getOrderTpo(long qnuNumItem, String typeOrder) throws BbvaClientCbdException {
		List<TtlbhoolDto> getOrderDetail = new ArrayList<TtlbhoolDto>();
		StringBuilder query = new StringBuilder(QUERY_GET_TTLBHOOL);
		parameters = new HashMap<String, Object>();
		
		if(typeOrder.equalsIgnoreCase("TPO")) {
			parameters.put("QNU_NUMITEM", qnuNumItem);
			parameters.put("COD_TIPORD", typeOrder);
			
			query.append(WHERE_GET_TTLBHOOL_TPO);
		}
		
		try{
			getOrderDetail = (List<TtlbhoolDto>) jdbcTemplate.query(query.toString(), parameters, new TtlbhoolMapper());
			LogNetCashMovil.logDebugPibee("Consulta realizada OK ->"+getOrderDetail.size());
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERY_GET_TTLBHOOL);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERY_GET_TTLBHOOL);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
		return getOrderDetail;
	}
	
	@Override
	public void insertOOL(TtlbhoolDto orderOnLine) throws BbvaClientCbdException {
						
		parameters = new HashMap<String, Object>();
		
		try {
			parameters.put("QNU_NUMITEM", orderOnLine.getQNU_NUMITEM());
			parameters.put("TIM_ORDEN", orderOnLine.getTIM_ORDEN());
			parameters.put("QNU_ORDEN", orderOnLine.getQNU_ORDEN());
			parameters.put("DES_ORDENOL", orderOnLine.getDES_ORDENOL());
			parameters.put("COD_TIPORD", orderOnLine.getCOD_TIPORD());
			parameters.put("COD_BANCOGBL", orderOnLine.getCOD_BANCOGBL());
			parameters.put("AUD_FMODIFIC", orderOnLine.getAUD_FMODIFIC());
			parameters.put("AUD_USUARIO", orderOnLine.getAUD_USUARIO());
			
			jdbcTemplate.update(INSERT_OOL, parameters);
			LogNetCashMovil.logDebugPibee("Registro ingresado con exito");
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERY_GET_TTLBHOOL);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERY_GET_TTLBHOOL);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
	}
}
