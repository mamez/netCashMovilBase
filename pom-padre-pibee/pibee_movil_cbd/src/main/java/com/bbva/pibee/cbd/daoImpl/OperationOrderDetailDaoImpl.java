package com.bbva.pibee.cbd.daoImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.ClientBd;
import com.bbva.pibee.cbd.dao.OperationOrderDetailDao;
import com.bbva.pibee.dto.cbd.TtlbhdorDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;

@ClientBd
public class OperationOrderDetailDaoImpl implements OperationOrderDetailDao{

	static final String INSERT_QUERY = "INSERT INTO TLCL.TTLBHDOR VALUES (:COD_CLIECASH, :COD_CLASEORD, :COD_IDORDEN, :COD_CABECORI, :COD_DETALL, :COD_ORIGE, :IMP_IMPORIVA, "
			+ ":QTY_DETALLE, :COD_DIISOALF, :FEC_VALOCASH, :QNU_TIPCAMBI, :COD_REFDETAL, :COD_REFDOCUM, :XSN_GASTOS, "
			+ ":XSN_FORMPAGO, :FEC_EXPEDICI, :QNU_NUMPAGOS, :FEC_VENCCASH, :COD_DEVOLORD, :DES_MOTIVDEV, :DES_MOTIVDEL, "
			+ ":XSN_CONCEPTO, :FEC_ORIGENOR, :COD_REFSEGUR, :XTI_INSTRUCC, :COD_MOTPAGOD, :COD_REFINTER, :XTI_PROVEDOR, "
			+ ":DES_FACTURA, :COD_FACTURA, :FEC_FACTURA, :DES_FICHEROH, :AUD_FMODIFIC, :AUD_USUARIO, :IMP_CUOTTA, "
			+ ":QTY_CUOTA, :QTY_PRIMCUOT, :XTI_INACELER, :COD_OFICPLAZ, :QTY_CONCEPTO, :COD_LNUMERO, :DES_CPTO144)";
	
	@Autowired
	@Qualifier("BTLCLCO1namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;

	private Map<String, Object> parameters;
	
	@Override
	public void createOperationOrderDetail(TtlbhdorDto ttlbhdorDto) throws BbvaClientCbdException {
		try {
			
			parameters = new HashMap<String, Object>();
			parameters.put("COD_CLIECASH", ttlbhdorDto.getCOD_CLIECASH());
			parameters.put("COD_CLASEORD", ttlbhdorDto.getCOD_CLASEORD());
			parameters.put("COD_IDORDEN", ttlbhdorDto.getCOD_IDORDEN());
			parameters.put("COD_CABECORI", ttlbhdorDto.getCOD_CABECORI());
			parameters.put("COD_DETALL", ttlbhdorDto.getCOD_DETALL());
			parameters.put("COD_ORIGE", ttlbhdorDto.getCOD_ORIGE());
			parameters.put("IMP_IMPORIVA", ttlbhdorDto.getIMP_IMPORIVA());
			parameters.put("QTY_DETALLE", ttlbhdorDto.getQTY_DETALLE());
			parameters.put("COD_DIISOALF", ttlbhdorDto.getCOD_DIISOALF());
			parameters.put("FEC_VALOCASH", ttlbhdorDto.getFEC_VALOCASH());
			parameters.put("QNU_TIPCAMBI", ttlbhdorDto.getQNU_TIPCAMBI());
			parameters.put("COD_REFDETAL", ttlbhdorDto.getCOD_REFDETAL());
			parameters.put("COD_REFDOCUM", ttlbhdorDto.getCOD_REFDOCUM());
			parameters.put("XSN_GASTOS", ttlbhdorDto.getXSN_GASTOS());
			parameters.put("XSN_FORMPAGO", ttlbhdorDto.getXSN_FORMPAGO());
			parameters.put("FEC_EXPEDICI", ttlbhdorDto.getFEC_EXPEDICI());
			parameters.put("QNU_NUMPAGOS", ttlbhdorDto.getQNU_NUMPAGOS());
			parameters.put("FEC_VENCCASH", ttlbhdorDto.getFEC_VENCCASH());
			parameters.put("COD_DEVOLORD", ttlbhdorDto.getCOD_DEVOLORD());
			parameters.put("DES_MOTIVDEV", ttlbhdorDto.getDES_MOTIVDEV());
			parameters.put("DES_MOTIVDEL", ttlbhdorDto.getDES_MOTIVDEL());
			parameters.put("XSN_CONCEPTO", ttlbhdorDto.getXSN_CONCEPTO());
			parameters.put("FEC_ORIGENOR", ttlbhdorDto.getFEC_ORIGENOR());
			parameters.put("COD_REFSEGUR", ttlbhdorDto.getCOD_REFSEGUR());
			parameters.put("XTI_INSTRUCC", ttlbhdorDto.getXTI_INSTRUCC());
			parameters.put("COD_MOTPAGOD", ttlbhdorDto.getCOD_MOTPAGOD());
			parameters.put("COD_REFINTER", ttlbhdorDto.getCOD_REFINTER());
			parameters.put("XTI_PROVEDOR", ttlbhdorDto.getXTI_PROVEDOR());
			parameters.put("DES_FACTURA", ttlbhdorDto.getDES_FACTURA());
			parameters.put("COD_FACTURA", ttlbhdorDto.getCOD_FACTURA());
			parameters.put("FEC_FACTURA", ttlbhdorDto.getFEC_FACTURA());
			parameters.put("DES_FICHEROH", ttlbhdorDto.getDES_FICHEROH());
			parameters.put("AUD_FMODIFIC", ttlbhdorDto.getAUD_FMODIFIC());
			parameters.put("AUD_USUARIO", ttlbhdorDto.getAUD_USUARIO());
			parameters.put("IMP_CUOTTA", ttlbhdorDto.getIMP_CUOTTA());
			parameters.put("QTY_CUOTA", ttlbhdorDto.getQTY_CUOTA());
			parameters.put("QTY_PRIMCUOT", ttlbhdorDto.getQTY_PRIMCUOT());
			parameters.put("XTI_INACELER", ttlbhdorDto.getXTI_INACELER());
			parameters.put("COD_OFICPLAZ", ttlbhdorDto.getCOD_OFICPLAZ());
			parameters.put("QTY_CONCEPTO", ttlbhdorDto.getQTY_CONCEPTO());
			parameters.put("COD_LNUMERO", ttlbhdorDto.getCOD_LNUMERO());
			parameters.put("DES_CPTO144", ttlbhdorDto.getDES_CPTO144());
			
			int res=jdbcTemplate.update(INSERT_QUERY, parameters);
			LogNetCashMovil.logDebugPibee("Elementos actualizados "+res);
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
