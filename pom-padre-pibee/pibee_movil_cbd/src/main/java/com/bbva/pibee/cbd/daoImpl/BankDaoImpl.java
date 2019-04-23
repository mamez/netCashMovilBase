package com.bbva.pibee.cbd.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.ClientBd;
import com.bbva.pibee.cbd.dao.BankDao;
import com.bbva.pibee.cbd.mappers.BankMapper;
import com.bbva.pibee.dto.cbd.BankDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;

@ClientBd
public class BankDaoImpl implements BankDao {
	
	
	
	static final String QUERYLISTBANKS = "SELECT * FROM TLNE.TTLCLBSP WHERE COD_BANCOGBL= '82'";
	
	@Autowired
	@Qualifier("BTLNECO1namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;	
	
	@Override
	public List<BankDto> getBanks() throws BbvaClientCbdException {	
		
		List<BankDto> listGetBanks = new ArrayList<BankDto>();
		
		try {
			listGetBanks = (List<BankDto>) jdbcTemplate.query(QUERYLISTBANKS, new BankMapper());
			LogNetCashMovil.logDebugPibee("resultado de consulta "+listGetBanks.size());
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYLISTBANKS);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYLISTBANKS);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
		return listGetBanks;
	}
}