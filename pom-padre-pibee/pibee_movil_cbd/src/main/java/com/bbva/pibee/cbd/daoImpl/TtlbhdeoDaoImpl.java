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
import com.bbva.pibee.cbd.dao.TtlbhdeoDao;
import com.bbva.pibee.cbd.mappers.TtlbhdeoMapper;
import com.bbva.pibee.dto.cbd.TtlbhdeoDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;

@ClientBd
public class TtlbhdeoDaoImpl implements TtlbhdeoDao {
	
	
	static final String QUERYLISTGETTTLBHDEO = "SELECT A.COD_CLIECASH, A.COD_CLASEORD, A.COD_IDORDEN, A.COD_DETALL, A.COD_CABECORI, A.COD_IDORIGEN, A.COD_IDESTINO, A.DES_DESTINO, A.DES_DOMIDES1, "
			+ "A.DES_DOMIDES2, A.DES_DOMIDES3, A.DES_CPLAZA, A.COD_FORMASUN, A.XTI_CLASEASU, A.DES_CUENDEST, "
			+ "A.COD_PROVINCI, A.COD_CDIPOS, A.XSN_DOMICILI, A.COD_BANCASH, A.COD_BANCSB, A.COD_OFICPLAZ, "
			+ "A.DES_OFICIDES, A.XTI_DOCIDENT, A.COD_NIFDESTI, A.COD_INSTRUC, A.COD_CDNITR, A.COD_SUFPRESE, "
			+ "A.DES_TITULCTA, A.DES_BANCO, A.DES_PRSCONT, A.DES_LIBRADO, A.COD_SWFIT, A.COD_BANABA, "
			+ "A.COD_ESTADIS, A.COD_PAISESTA, A.COD_PAISOALF, A.DES_INSTRUCC, A.COD_TIPTAB, A.XSN_PAGO, "
			+ "A.DES_BANCINTE, A.DES_DIRBANIN, A.DES_PLABANIN, A.COD_TELFPROV, A.COD_FAXPORT, A.XSN_IDENTFIS, "
			+ "A.COD_CLAFPROV, A.DES_FICHEROH, A.AUD_FMODIFIC, A.AUD_USUARIO, A.COD_COMUNA, A.COD_ENTREGA, "
			+ "A.COD_SUCURENT, A.DES_EMAIL, A.COD_PRSCONT, A.DES_DNOMBER, A.XTI_DIDEBCOT, A.XTI_DIDEBCOI, "
			+ "A.COD_BANCINTE, A.DES_DDIRECC, A.DES_DDIRBCOT, A.COD_DPAIBCOI, A.DES_DNOMCO, A.DES_DDIRBCOI, "
			+ "A.DES_DCUEBCOI, A.COD_GASTODES, A.COD_CDIPOS2, A.FEC_NACIMTIT, A.XSN_FORMPAGO ";
	
	static final String QUERY_FROM = "FROM TLCL.TTLBHDEO A ";
	
	static final String WHERE = "WHERE A.COD_CLIECASH = :codCliente AND A.COD_CLASEORD = :claseOrden "
			+ "AND A.COD_IDORDEN = :idOrden AND A.COD_DETALL = :idDetalle AND A.COD_CABECORI = :idCodCabOrigen";
	
	static final String INSERT_QUERY = "INSERT INTO TLCL.TTLBHDEO VALUES (:COD_CLIECASH, :COD_CLASEORD, :COD_IDORDEN, :COD_DETALL, :COD_CABECORI, :COD_IDORIGEN, :COD_IDESTINO, :DES_DESTINO, "
			+ ":DES_DOMIDES1, :DES_DOMIDES2, :DES_DOMIDES3, :DES_CPLAZA, :COD_FORMASUN, :XTI_CLASEASU, :DES_CUENDEST, :COD_PROVINCI, "
			+ ":COD_CDIPOS, :XSN_DOMICILI, :COD_BANCASH, :COD_BANCSB, :COD_OFICPLAZ, :DES_OFICIDES, :XTI_DOCIDENT, :COD_NIFDESTI, "
			+ ":COD_INSTRUC, :COD_CDNITR, :COD_SUFPRESE, :DES_TITULCTA, :DES_BANCO, :DES_PRSCONT, :DES_LIBRADO, :COD_SWFIT, "
			+ ":COD_BANABA, :COD_ESTADIS, :COD_PAISESTA, :COD_PAISOALF, :DES_INSTRUCC, :COD_TIPTAB, :XSN_PAGO, :DES_BANCINTE, "
			+ ":DES_DIRBANIN, :DES_PLABANIN, :COD_TELFPROV, :COD_FAXPORT, :XSN_IDENTFIS, :COD_CLAFPROV, :DES_FICHEROH, :AUD_FMODIFIC, "
			+ ":AUD_USUARIO, :COD_COMUNA, :COD_ENTREGA, :COD_SUCURENT, :DES_EMAIL, :COD_PRSCONT, :DES_DNOMBER, :XTI_DIDEBCOT, "
			+ ":XTI_DIDEBCOI, :COD_BANCINTE, :DES_DDIRECC, :DES_DDIRBCOT, :COD_DPAIBCOI, :DES_DNOMCO, :DES_DDIRBCOI, :DES_DCUEBCOI, "
			+ ":COD_GASTODES, :COD_CDIPOS2, :FEC_NACIMTIT, :XSN_FORMPAGO) ";
	
	private final String QUERY_INSERT_PAYEE_DEO = "INSERT INTO TLCL.TTLBHDEO (COD_CLIECASH, COD_CLASEORD, COD_IDORDEN, COD_DETALL, COD_CABECORI, COD_IDORIGEN, COD_IDESTINO, DES_DESTINO, DES_DOMIDES1, DES_DOMIDES2, "
			+ "DES_DOMIDES3, DES_CPLAZA, COD_FORMASUN, XTI_CLASEASU, DES_CUENDEST, COD_PROVINCI, COD_CDIPOS, XSN_DOMICILI, COD_BANCASH, COD_BANCSB, "
			+ "COD_OFICPLAZ, DES_OFICIDES, XTI_DOCIDENT, COD_NIFDESTI, COD_INSTRUC, COD_CDNITR, COD_SUFPRESE, DES_TITULCTA, DES_BANCO, DES_PRSCONT, "
			+ "DES_LIBRADO, COD_SWFIT, COD_BANABA, COD_ESTADIS, COD_PAISESTA, COD_PAISOALF, DES_INSTRUCC, COD_TIPTAB, XSN_PAGO, DES_BANCINTE, DES_DIRBANIN, "
			+ "DES_PLABANIN, COD_TELFPROV, COD_FAXPORT, XSN_IDENTFIS, COD_CLAFPROV, DES_FICHEROH, AUD_FMODIFIC, AUD_USUARIO, COD_COMUNA, COD_ENTREGA, "
			+ "COD_SUCURENT, DES_EMAIL, COD_PRSCONT, DES_DNOMBER, XTI_DIDEBCOT, XTI_DIDEBCOI, COD_BANCINTE, DES_DDIRECC, DES_DDIRBCOT, COD_DPAIBCOI, "
			+ "DES_DNOMCO, DES_DDIRBCOI, DES_DCUEBCOI, COD_GASTODES, COD_CDIPOS2, FEC_NACIMTIT, XSN_FORMPAGO) "
			+ "VALUES "
			+ "(:COD_CLIECASH, :COD_CLASEORD, :COD_IDORDEN, :COD_DETALL, :COD_CABECORI, :COD_IDORIGEN, :COD_IDESTINO, :DES_DESTINO, :DES_DOMIDES1, "
			+ ":DES_DOMIDES2, :DES_DOMIDES3, :DES_CPLAZA, :COD_FORMASUN, :XTI_CLASEASU, :DES_CUENDEST, :COD_PROVINCI, :COD_CDIPOS, :XSN_DOMICILI, "
			+ ":COD_BANCASH, :COD_BANCSB, :COD_OFICPLAZ, :DES_OFICIDES, :XTI_DOCIDENT, :COD_NIFDESTI, :COD_INSTRUC, :COD_CDNITR, :COD_SUFPRESE, "
			+ ":DES_TITULCTA, :DES_BANCO, :DES_PRSCONT, :DES_LIBRADO, :COD_SWFIT, :COD_BANABA, :COD_ESTADIS, :COD_PAISESTA, :COD_PAISOALF, :DES_INSTRUCC, "
			+ ":COD_TIPTAB, :XSN_PAGO, :DES_BANCINTE, :DES_DIRBANIN, :DES_PLABANIN, :COD_TELFPROV, :COD_FAXPORT, :XSN_IDENTFIS, :COD_CLAFPROV, "
			+ ":DES_FICHEROH, :AUD_FMODIFIC, :AUD_USUARIO, :COD_COMUNA, :COD_ENTREGA, :COD_SUCURENT, :DES_EMAIL, :COD_PRSCONT, :DES_DNOMBER, :XTI_DIDEBCOT, "
			+ ":XTI_DIDEBCOI, :COD_BANCINTE, :DES_DDIRECC, :DES_DDIRBCOT, :COD_DPAIBCOI, :DES_DNOMCO, :DES_DDIRBCOI, :DES_DCUEBCOI, :COD_GASTODES, "
			+ ":COD_CDIPOS2, :FEC_NACIMTIT, :XSN_FORMPAGO)";
	
	private Map<String, Object> parameters;
	
	@Autowired
	@Qualifier("BTLCLCO1namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<TtlbhdeoDto> getTtlbhdeo(String codCliente, String claseOrden, String idOrden, String idDetalle, String idCodCabOrigen) throws BbvaClientCbdException {
		StringBuilder query = new StringBuilder();
		List<TtlbhdeoDto> lTtlbhdeo = new ArrayList<TtlbhdeoDto>();
		try {
			if (!codCliente.isEmpty() || !claseOrden.isEmpty() || !idOrden.isEmpty() || !idCodCabOrigen.isEmpty()) {
				parameters = new HashMap<String, Object>();
				parameters.put("codCliente", codCliente);
				parameters.put("claseOrden", claseOrden);
				parameters.put("idOrden", idOrden);
				parameters.put("idDetalle", idDetalle);
				parameters.put("idCodCabOrigen", idCodCabOrigen);
				
				query.append(QUERYLISTGETTTLBHDEO).append(QUERY_FROM).append(WHERE);
				
				lTtlbhdeo = (List<TtlbhdeoDto>) jdbcTemplate.query(query.toString(), parameters, new TtlbhdeoMapper());
				LogNetCashMovil.logDebugPibee("Consulta realizada ok->"+lTtlbhdeo.size());
			} else {
				String campos = "";
				campos += codCliente.isEmpty()?"COD_CLIECASH, ":"";
				campos += claseOrden.isEmpty()?"COD_CLASEORD, ":"";
				campos += idOrden.isEmpty()?"COD_IDORDEN, ":"";
				campos += idDetalle.isEmpty()?"COD_DETAIL, ":"";
				campos += idCodCabOrigen.isEmpty()?"COD_CABECORI, ":"";
				LogNetCashMovil.logDebugPibee("Campo(s) "+campos+"vacio(s)");
			}
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+lTtlbhdeo);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+lTtlbhdeo);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
		return lTtlbhdeo;
	}
	
	@Override
	public void insertDeo(TtlbhdeoDto deoDto) throws BbvaClientCbdException
	{
		parameters = new HashMap<String, Object>();
		
		//INSERT DE LA TABLA TTLBHDEO
		try
		{
			parameters = new HashMap<String, Object>();
			
			parameters.put("COD_CLIECASH", deoDto.getCOD_CLIECASH());
			parameters.put("COD_CLASEORD", deoDto.getCOD_CLASEORD());
			parameters.put("COD_IDORDEN", deoDto.getCOD_IDORDEN());  
			parameters.put("COD_DETALL", deoDto.getCOD_DETALL());    
			parameters.put("COD_CABECORI", deoDto.getCOD_CABECORI());
			parameters.put("COD_IDORIGEN", deoDto.getCOD_IDORIGEN());
			parameters.put("COD_IDESTINO", deoDto.getCOD_IDESTINO());
			parameters.put("DES_DESTINO", deoDto.getDES_DESTINO());  
			parameters.put("DES_DOMIDES1", deoDto.getDES_DOMIDES1());
			parameters.put("DES_DOMIDES2", deoDto.getDES_DOMIDES2());
			parameters.put("DES_DOMIDES3", deoDto.getDES_DOMIDES3());
			parameters.put("DES_CPLAZA", deoDto.getDES_CPLAZA());    
			parameters.put("COD_FORMASUN", deoDto.getCOD_FORMASUN());
			parameters.put("XTI_CLASEASU", deoDto.getXTI_CLASEASU());
			parameters.put("DES_CUENDEST", deoDto.getDES_CUENDEST());
			parameters.put("COD_PROVINCI", deoDto.getCOD_PROVINCI());
			parameters.put("COD_CDIPOS", deoDto.getCOD_CDIPOS());    
			parameters.put("XSN_DOMICILI", deoDto.getXSN_DOMICILI());
			parameters.put("COD_BANCASH", deoDto.getCOD_BANCASH());  
			parameters.put("COD_BANCSB", deoDto.getCOD_BANCSB());    
			parameters.put("COD_OFICPLAZ", deoDto.getCOD_OFICPLAZ());
			parameters.put("DES_OFICIDES", deoDto.getDES_OFICIDES());
			parameters.put("XTI_DOCIDENT", deoDto.getXTI_DOCIDENT());
			parameters.put("COD_NIFDESTI", deoDto.getCOD_NIFDESTI());
			parameters.put("COD_INSTRUC", deoDto.getCOD_INSTRUC());  
			parameters.put("COD_CDNITR", deoDto.getCOD_CDNITR());    
			parameters.put("COD_SUFPRESE", deoDto.getCOD_SUFPRESE());
			parameters.put("DES_TITULCTA", deoDto.getDES_TITULCTA());
			parameters.put("DES_BANCO", deoDto.getDES_BANCO());      
			parameters.put("DES_PRSCONT", deoDto.getDES_PRSCONT());  
			parameters.put("DES_LIBRADO", deoDto.getDES_LIBRADO());  
			parameters.put("COD_SWFIT", deoDto.getCOD_SWFIT());      
			parameters.put("COD_BANABA", deoDto.getCOD_BANABA());    
			parameters.put("COD_ESTADIS", deoDto.getCOD_ESTADIS());  
			parameters.put("COD_PAISESTA", deoDto.getCOD_PAISESTA());
			parameters.put("COD_PAISOALF", deoDto.getCOD_PAISOALF());
			parameters.put("DES_INSTRUCC", deoDto.getDES_INSTRUCC());
			parameters.put("COD_TIPTAB", deoDto.getCOD_TIPTAB());    
			parameters.put("XSN_PAGO", deoDto.getXSN_PAGO());        
			parameters.put("DES_BANCINTE", deoDto.getDES_BANCINTE());
			parameters.put("DES_DIRBANIN", deoDto.getDES_DIRBANIN());
			parameters.put("DES_PLABANIN", deoDto.getDES_PLABANIN());
			parameters.put("COD_TELFPROV", deoDto.getCOD_TELFPROV());
			parameters.put("COD_FAXPORT", deoDto.getCOD_FAXPORT());  
			parameters.put("XSN_IDENTFIS", deoDto.getXSN_IDENTFIS());
			parameters.put("COD_CLAFPROV", deoDto.getCOD_CLAFPROV());
			parameters.put("DES_FICHEROH", deoDto.getDES_FICHEROH());
			parameters.put("AUD_FMODIFIC", deoDto.getAUD_FMODIFIC());
			parameters.put("AUD_USUARIO", deoDto.getAUD_USUARIO());  
			parameters.put("COD_COMUNA", deoDto.getCOD_COMUNA());    
			parameters.put("COD_ENTREGA", deoDto.getCOD_ENTREGA());  
			parameters.put("COD_SUCURENT", deoDto.getCOD_SUCURENT());
			parameters.put("DES_EMAIL", deoDto.getDES_EMAIL());      
			parameters.put("COD_PRSCONT", deoDto.getCOD_PRSCONT());  
			parameters.put("DES_DNOMBER", deoDto.getDES_DNOMBER());  
			parameters.put("XTI_DIDEBCOT", deoDto.getXTI_DIDEBCOT());
			parameters.put("XTI_DIDEBCOI", deoDto.getXTI_DIDEBCOI());
			parameters.put("COD_BANCINTE", deoDto.getCOD_BANCINTE());
			parameters.put("DES_DDIRECC", deoDto.getDES_DDIRECC());  
			parameters.put("DES_DDIRBCOT", deoDto.getDES_DDIRBCOT());
			parameters.put("COD_DPAIBCOI", deoDto.getCOD_DPAIBCOI());
			parameters.put("DES_DNOMCO", deoDto.getDES_DNOMCO());    
			parameters.put("DES_DDIRBCOI", deoDto.getDES_DDIRBCOI());
			parameters.put("DES_DCUEBCOI", deoDto.getDES_DCUEBCOI());
			parameters.put("COD_GASTODES", deoDto.getCOD_GASTODES());
			parameters.put("COD_CDIPOS2", deoDto.getCOD_CDIPOS2());  
			parameters.put("FEC_NACIMTIT", deoDto.getFEC_NACIMTIT());
			parameters.put("XSN_FORMPAGO", deoDto.getXSN_FORMPAGO());
			
			int resp=jdbcTemplate.update(QUERY_INSERT_PAYEE_DEO, parameters);
			LogNetCashMovil.logDebugPibee("Elemento creado OK-> "+resp);
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERY_INSERT_PAYEE_DEO);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERY_INSERT_PAYEE_DEO);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
	}

	@Override
	public void createOperationOrderDestination(TtlbhdeoDto operationOrderDestination) throws BbvaClientCbdException {
		try{
			parameters = new HashMap<String, Object>();
			parameters.put("COD_CLIECASH", operationOrderDestination.getCOD_CLIECASH());
			parameters.put("COD_CLASEORD", operationOrderDestination.getCOD_CLASEORD());
			parameters.put("COD_IDORDEN", operationOrderDestination.getCOD_IDORDEN());
			parameters.put("COD_DETALL", operationOrderDestination.getCOD_DETALL());
			parameters.put("COD_CABECORI", operationOrderDestination.getCOD_CABECORI());
			parameters.put("COD_IDORIGEN", operationOrderDestination.getCOD_IDORIGEN());
			parameters.put("COD_IDESTINO", operationOrderDestination.getCOD_IDESTINO());
			parameters.put("DES_DESTINO", operationOrderDestination.getDES_DESTINO());
			parameters.put("DES_DOMIDES1", operationOrderDestination.getDES_DOMIDES1());
			parameters.put("DES_DOMIDES2", operationOrderDestination.getDES_DOMIDES2());
			parameters.put("DES_DOMIDES3", operationOrderDestination.getDES_DOMIDES3());
			parameters.put("DES_CPLAZA", operationOrderDestination.getDES_CPLAZA());
			parameters.put("COD_FORMASUN", operationOrderDestination.getCOD_FORMASUN());
			parameters.put("XTI_CLASEASU", operationOrderDestination.getXTI_CLASEASU());
			parameters.put("DES_CUENDEST", operationOrderDestination.getDES_CUENDEST());
			parameters.put("COD_PROVINCI", operationOrderDestination.getCOD_PROVINCI());
			parameters.put("COD_CDIPOS", operationOrderDestination.getCOD_CDIPOS());
			parameters.put("XSN_DOMICILI", operationOrderDestination.getXSN_DOMICILI());
			parameters.put("COD_BANCASH", operationOrderDestination.getCOD_BANCASH());
			parameters.put("COD_BANCSB", operationOrderDestination.getCOD_BANCSB());
			parameters.put("COD_OFICPLAZ", operationOrderDestination.getCOD_OFICPLAZ());
			parameters.put("DES_OFICIDES", operationOrderDestination.getDES_OFICIDES());
			parameters.put("XTI_DOCIDENT", operationOrderDestination.getXTI_DOCIDENT());
			parameters.put("COD_NIFDESTI", operationOrderDestination.getCOD_NIFDESTI());
			parameters.put("COD_INSTRUC", operationOrderDestination.getCOD_INSTRUC());
			parameters.put("COD_CDNITR", operationOrderDestination.getCOD_CDNITR());
			parameters.put("COD_SUFPRESE", operationOrderDestination.getCOD_SUFPRESE());
			parameters.put("DES_TITULCTA", operationOrderDestination.getDES_TITULCTA());
			parameters.put("DES_BANCO", operationOrderDestination.getDES_BANCO());
			parameters.put("DES_PRSCONT", operationOrderDestination.getDES_PRSCONT());
			parameters.put("DES_LIBRADO", operationOrderDestination.getDES_LIBRADO());
			parameters.put("COD_SWFIT", operationOrderDestination.getCOD_SWFIT());
			parameters.put("COD_BANABA", operationOrderDestination.getCOD_BANABA());
			parameters.put("COD_ESTADIS", operationOrderDestination.getCOD_ESTADIS());
			parameters.put("COD_PAISESTA", operationOrderDestination.getCOD_PAISESTA());
			parameters.put("COD_PAISOALF", operationOrderDestination.getCOD_PAISOALF());
			parameters.put("DES_INSTRUCC", operationOrderDestination.getDES_INSTRUCC());
			parameters.put("COD_TIPTAB", operationOrderDestination.getCOD_TIPTAB());
			parameters.put("XSN_PAGO", operationOrderDestination.getXSN_PAGO());
			parameters.put("DES_BANCINTE", operationOrderDestination.getDES_BANCINTE());
			parameters.put("DES_DIRBANIN", operationOrderDestination.getDES_DIRBANIN());
			parameters.put("DES_PLABANIN", operationOrderDestination.getDES_PLABANIN());
			parameters.put("COD_TELFPROV", operationOrderDestination.getCOD_TELFPROV());
			parameters.put("COD_FAXPORT", operationOrderDestination.getCOD_FAXPORT());
			parameters.put("XSN_IDENTFIS", operationOrderDestination.getXSN_IDENTFIS());
			parameters.put("COD_CLAFPROV", operationOrderDestination.getCOD_CLAFPROV());
			parameters.put("DES_FICHEROH", operationOrderDestination.getDES_FICHEROH());
			parameters.put("AUD_FMODIFIC", operationOrderDestination.getAUD_FMODIFIC());
			parameters.put("AUD_USUARIO", operationOrderDestination.getAUD_USUARIO());
			parameters.put("COD_COMUNA", operationOrderDestination.getCOD_COMUNA());
			parameters.put("COD_ENTREGA", operationOrderDestination.getCOD_ENTREGA());
			parameters.put("COD_SUCURENT", operationOrderDestination.getCOD_SUCURENT());
			parameters.put("DES_EMAIL", operationOrderDestination.getDES_EMAIL());
			parameters.put("COD_PRSCONT", operationOrderDestination.getCOD_PRSCONT());
			parameters.put("DES_DNOMBER", operationOrderDestination.getDES_DNOMBER());
			parameters.put("XTI_DIDEBCOT", operationOrderDestination.getXTI_DIDEBCOT());
			parameters.put("XTI_DIDEBCOI", operationOrderDestination.getXTI_DIDEBCOI());
			parameters.put("COD_BANCINTE", operationOrderDestination.getCOD_BANCINTE());
			parameters.put("DES_DDIRECC", operationOrderDestination.getDES_DDIRECC());
			parameters.put("DES_DDIRBCOT", operationOrderDestination.getDES_DDIRBCOT());
			parameters.put("COD_DPAIBCOI", operationOrderDestination.getCOD_DPAIBCOI());
			parameters.put("DES_DNOMCO", operationOrderDestination.getDES_DNOMCO());
			parameters.put("DES_DDIRBCOI", operationOrderDestination.getDES_DDIRBCOI());
			parameters.put("DES_DCUEBCOI", operationOrderDestination.getDES_DCUEBCOI());
			parameters.put("COD_GASTODES", operationOrderDestination.getCOD_GASTODES());
			parameters.put("COD_CDIPOS2", operationOrderDestination.getCOD_CDIPOS2());
			parameters.put("FEC_NACIMTIT", operationOrderDestination.getFEC_NACIMTIT());
			parameters.put("XSN_FORMPAGO", operationOrderDestination.getXSN_FORMPAGO());
			
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
