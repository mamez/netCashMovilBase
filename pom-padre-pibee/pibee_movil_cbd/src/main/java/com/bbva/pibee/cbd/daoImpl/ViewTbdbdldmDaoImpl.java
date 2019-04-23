package com.bbva.pibee.cbd.daoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.ClientBd;
import com.bbva.pibee.cbd.mappers.ViewTbdbdldmMapper;
import com.bbva.pibee.dto.cbd.ViewTbdbdldmDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;
import com.bbva.pibee.util.CatalogType;
import com.bbva.pibee.util.CodeLanguage;

@ClientBd
public class ViewTbdbdldmDaoImpl implements com.bbva.pibee.cbd.dao.ViewTbdbdldmDao 
{
	
	static final String QUERY_LIST_CATALOG  = "SELECT * FROM BDBD.TBDBDLDM WHERE COD_IDIOMA = :COD_IDIOMA AND COD_CATALOG = :COD_CATALOG";	
			
	@Autowired
	@Qualifier("BTLNECO1namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;

	private HashMap<String, Object> parameters;

	
	@Override
	public List<ViewTbdbdldmDto> getViewInformation(CatalogType catalogo,CodeLanguage idioma) throws BbvaClientCbdException {
		List<ViewTbdbdldmDto> getListDesState = new ArrayList<ViewTbdbdldmDto>();
		try {
			parameters = new HashMap<String, Object>();
			parameters.put("COD_IDIOMA", idioma.getCodeLanguage());
			parameters.put("COD_CATALOG", catalogo.getCatalogCode());
			getListDesState = (List<ViewTbdbdldmDto>) jdbcTemplate.query(QUERY_LIST_CATALOG, parameters, new  ViewTbdbdldmMapper());
			LogNetCashMovil.logDebugPibee("Consulta relizada OK-> "+getListDesState.size());
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERY_LIST_CATALOG);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
		return getListDesState;
	}
}
