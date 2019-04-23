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
import com.bbva.pibee.cbd.dao.DetailConceptDao;
import com.bbva.pibee.cbd.mappers.DetailConceptMapper;
import com.bbva.pibee.dto.cbd.DetailConceptDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;

@ClientBd
public class DetailConceptDaoImpl implements DetailConceptDao{
	
	private static final String SELECT_QUERY  = " SELECT A.COD_CLIECASH, A.COD_CLASEORD, A.COD_IDORDEN, A.COD_DETALL, A.COD_IDCONCEP, A.COD_CABECORI, A.DES_CONCCASH, "
			+ "A.IMP_CONCEPTO, A.XTI_CONCEP, A.FEC_DOCUMENT, A.COD_NUMDOCU, A.DES_MONBRU, "
			+ "A.DES_MONAJU, A.DES_MONNET, A.COD_CIBENE, A.DES_APELLID, A.COD_CTABE, A.POR_TPCPAGO, "
			+ "A.AUD_FMODIFIC, A.AUD_USUARIO ";
	
	private static final String FROM_QUERY = " FROM TLCL.TTLBHCOD A";
	
	private static final String WHERE_QUERY = " WHERE A.COD_CLIECASH = :sCodCliente AND A.COD_CLASEORD = :sClaseOrden AND A.COD_IDORDEN = :sIdOrden "
			+ "AND A.COD_DETALL = :iIdDetalle AND A.COD_CABECORI = :iCodCabOri ";
	
	private static final String INSERT_QUERY = "INSERT INTO TLCL.TTLBHCOD VALUES (:COD_CLIECASH, :COD_CLASEORD, :COD_IDORDEN, :COD_CABECORI, :COD_DETALL, :COD_IDCONCEP, "
			+ ":DES_CONCCASH, :IMP_CONCEPTO, :XTI_CONCEP, :AUD_FMODIFIC, :AUD_USUARIO, :FEC_DOCUMENT, "
			+ ":COD_NUMDOCU, :DES_MONBRU, :DES_MONAJU, :DES_MONNET, :COD_CIBENE, :DES_APELLID, "
			+ ":COD_CTABE, :POR_TPCPAGO) ";
	
	@Autowired
	@Qualifier("BTLCLCO1namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	private Map<String, Object> parameters;
	
	@Override
	public List<DetailConceptDto> getDetailConceptList(String sCodCliente, String sClaseOrden, String sIdOrden,
			int iCodCabOri, int iIdDetalle) throws BbvaClientCbdException {
		
		List<DetailConceptDto> detailConceptList = null;
		
		StringBuilder query = new StringBuilder(SELECT_QUERY).append(FROM_QUERY).append(WHERE_QUERY);
		parameters = new HashMap<String, Object>();
		
		parameters.put("sCodCliente", sCodCliente);
		parameters.put("sClaseOrden", sClaseOrden);
		parameters.put("sIdOrden", sIdOrden);
		parameters.put("iCodCabOri", new Integer(iCodCabOri));
		parameters.put("iIdDetalle", new Integer(iIdDetalle));
		
		try{
			detailConceptList = (List<DetailConceptDto>) jdbcTemplate.query(query.toString(), parameters, new DetailConceptMapper());
			LogNetCashMovil.logDebugPibee("Consulta realizada ["+detailConceptList.size()+"]");
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+query.toString());
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+query.toString());
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
		
		return detailConceptList;
	}

	@Override
	public void createDetailConcept(DetailConceptDto detailConceptDto) throws BbvaClientCbdException {
		
		try{
			parameters = new HashMap<String, Object>();
			parameters.put("COD_CLIECASH", detailConceptDto.getCOD_CLIECASH());
			parameters.put("COD_CLASEORD", detailConceptDto.getCOD_CLASEORD());
			parameters.put("COD_IDORDEN", detailConceptDto.getCOD_IDORDEN());
			parameters.put("COD_CABECORI", detailConceptDto.getCOD_CABECORI());
			parameters.put("COD_DETALL", detailConceptDto.getCOD_DETALL());
			parameters.put("COD_IDCONCEP", detailConceptDto.getCOD_IDCONCEP());
			parameters.put("DES_CONCCASH", detailConceptDto.getDES_CONCCASH());
			parameters.put("IMP_CONCEPTO", detailConceptDto.getIMP_CONCEPTO());
			parameters.put("XTI_CONCEP", detailConceptDto.getXTI_CONCEP());
			parameters.put("AUD_FMODIFIC", detailConceptDto.getAUD_FMODIFIC());
			parameters.put("AUD_USUARIO", detailConceptDto.getAUD_USUARIO());
			parameters.put("FEC_DOCUMENT", detailConceptDto.getFEC_DOCUMENT());
			parameters.put("COD_NUMDOCU", detailConceptDto.getCOD_NUMDOCU());
			parameters.put("DES_MONBRU", detailConceptDto.getDES_MONBRU());
			parameters.put("DES_MONAJU", detailConceptDto.getDES_MONAJU());
			parameters.put("DES_MONNET", detailConceptDto.getDES_MONNET());
			parameters.put("COD_CIBENE", detailConceptDto.getCOD_CIBENE());
			parameters.put("DES_APELLID", detailConceptDto.getDES_APELLID());
			parameters.put("COD_CTABE", detailConceptDto.getCOD_CTABE());
			parameters.put("POR_TPCPAGO", detailConceptDto.getPOR_TPCPAGO());

			int res=jdbcTemplate.update(INSERT_QUERY, parameters);
			LogNetCashMovil.logDebugPibee("Elementos creados "+res);
			
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: " + INSERT_QUERY);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: " + INSERT_QUERY);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
		
	}

}
