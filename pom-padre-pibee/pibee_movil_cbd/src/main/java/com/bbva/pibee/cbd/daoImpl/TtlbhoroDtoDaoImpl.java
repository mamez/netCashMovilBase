package com.bbva.pibee.cbd.daoImpl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.ClientBd;
import com.bbva.pibee.cbd.dao.TtlbhoroDtoDao;
import com.bbva.pibee.dto.cbd.OperationOrderSourceDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;

@ClientBd
public class TtlbhoroDtoDaoImpl implements TtlbhoroDtoDao{

	static final String INSERT_QUERY = "INSERT INTO TLCL.TTLBHORO VALUES (:COD_IDORDEN, :COD_CLIECASH, :COD_CLASEORD, :COD_CABECORI, :COD_CDNITR, :COD_SUFPRESE, :COD_IDORIGEN, :XTI_DOCIDENT, "
			+ ":DES_DOCIDENT, :DES_PRSCONT, :DES_TFNOCONT, :DES_ORIGEN, :DES_DOMIORI1, :DES_DOMIORI2, :DES_DOMIORI3, :DES_LOCALI, "
			+ ":COD_PROVINCI, :COD_CDIPOS, :QNU_REFEREN, :XSN_REFEREN, :DES_REFEROPE, :XSN_MODELCON, :COD_ALFANUM, :COD_REFEREXT, "
			+ ":COD_SWIFT, :COD_NIFORIGN, :XTI_PROVEDOR, :COD_CTASIGN, :COD_OFITOMAD, :COD_FICHERO, :COD_SOCIEDAD, :DES_FICHEROH, "
			+ ":AUD_FMODIFIC, :AUD_USUARIO, :XTI_EMISOR, :DES_ONOMBRE, :DES_ODIRECC, :COD_OCP2)";
	
	@Autowired
	@Qualifier("BTLCLCO1namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	private HashMap<String, Object> parameters;
	
	@Override
	public void createTtlbhoroDto(OperationOrderSourceDto ttlbhoroDto) throws BbvaClientCbdException {		
	try{
		parameters = new HashMap<String, Object>();
		
		parameters.put("COD_IDORDEN", ttlbhoroDto.getCOD_IDORDEN());
		parameters.put("COD_CLIECASH", ttlbhoroDto.getCOD_CLIECASH());
		parameters.put("COD_CLASEORD", ttlbhoroDto.getCOD_CLASEORD());
		parameters.put("COD_CABECORI", ttlbhoroDto.getCOD_CABECORI());
		parameters.put("COD_CDNITR", ttlbhoroDto.getCOD_CDNITR());
		parameters.put("COD_SUFPRESE", ttlbhoroDto.getCOD_SUFPRESE());
		parameters.put("COD_IDORIGEN", ttlbhoroDto.getCOD_IDORIGEN());
		parameters.put("XTI_DOCIDENT", ttlbhoroDto.getXTI_DOCIDENT());
		parameters.put("DES_DOCIDENT", ttlbhoroDto.getDES_DOCIDENT());
		parameters.put("DES_PRSCONT", ttlbhoroDto.getDES_PRSCONT());
		parameters.put("DES_TFNOCONT", ttlbhoroDto.getDES_TFNOCONT());
		parameters.put("DES_ORIGEN", ttlbhoroDto.getDES_ORIGEN());
		parameters.put("DES_DOMIORI1", ttlbhoroDto.getDES_DOMIORI1());
		parameters.put("DES_DOMIORI2", ttlbhoroDto.getDES_DOMIORI2());
		parameters.put("DES_DOMIORI3", ttlbhoroDto.getDES_DOMIORI3());
		parameters.put("DES_LOCALI", ttlbhoroDto.getDES_LOCALI());
		parameters.put("COD_PROVINCI", ttlbhoroDto.getCOD_PROVINCI());
		parameters.put("COD_CDIPOS", ttlbhoroDto.getCOD_CDIPOS());
		parameters.put("QNU_REFEREN", ttlbhoroDto.getQNU_REFEREN());
		parameters.put("XSN_REFEREN", ttlbhoroDto.getXSN_REFEREN());
		parameters.put("DES_REFEROPE", ttlbhoroDto.getDES_REFEROPE());
		parameters.put("XSN_MODELCON", ttlbhoroDto.getXSN_MODELCON());
		parameters.put("COD_ALFANUM", ttlbhoroDto.getCOD_ALFANUM());
		parameters.put("COD_REFEREXT", ttlbhoroDto.getCOD_REFEREXT());
		parameters.put("COD_SWIFT", ttlbhoroDto.getCOD_SWIFT());
		parameters.put("COD_NIFORIGN", ttlbhoroDto.getCOD_NIFORIGN());
		parameters.put("XTI_PROVEDOR", ttlbhoroDto.getXTI_PROVEDOR());
		parameters.put("COD_CTASIGN", ttlbhoroDto.getCOD_CTASIGN());
		parameters.put("COD_OFITOMAD", ttlbhoroDto.getCOD_OFITOMAD());
		parameters.put("COD_FICHERO", ttlbhoroDto.getCOD_FICHERO());
		parameters.put("COD_SOCIEDAD", ttlbhoroDto.getCOD_SOCIEDAD());
		parameters.put("DES_FICHEROH", ttlbhoroDto.getDES_FICHEROH());
		parameters.put("AUD_FMODIFIC", ttlbhoroDto.getAUD_FMODIFIC());
		parameters.put("AUD_USUARIO", ttlbhoroDto.getAUD_USUARIO());
		parameters.put("XTI_EMISOR", ttlbhoroDto.getXTI_EMISOR());
		parameters.put("DES_ONOMBRE", ttlbhoroDto.getDES_ONOMBRE());
		parameters.put("DES_ODIRECC", ttlbhoroDto.getDES_ODIRECC());
		parameters.put("COD_OCP2", ttlbhoroDto.getCOD_OCP2());
		
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
