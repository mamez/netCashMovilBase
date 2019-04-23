package com.bbva.pibee.cbd.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.ClientBd;
import com.bbva.pibee.cbd.dao.DocumentTypeDao;
import com.bbva.pibee.cbd.mappers.DocumentTypeMapper;
import com.bbva.pibee.dto.cbd.DocumentTypeDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;

@ClientBd
public class DocumentTypeDaoImpl implements DocumentTypeDao 
{
	
	static final String QUERYLISTGETTTLCLTDL = "SELECT * FROM TTLCLTDL WHERE COD_BANCOGBL = '82'";
	
	@Autowired
	@Qualifier("BTLNECO1namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<DocumentTypeDto> getTypeDocument() throws BbvaClientCbdException {
		
		List<DocumentTypeDto> getListTypeDocument = new ArrayList<DocumentTypeDto>();
		try{
			getListTypeDocument = (List<DocumentTypeDto>) jdbcTemplate.query(QUERYLISTGETTTLCLTDL, new DocumentTypeMapper());
			LogNetCashMovil.logDebugPibee("listado ok "+getListTypeDocument.size());
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYLISTGETTTLCLTDL);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYLISTGETTTLCLTDL);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
		return getListTypeDocument;
	}
}
