package com.bbva.pibee.cbd.daoImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.cbd.dao.TtlbhdorDao;
import com.bbva.pibee.dto.cbd.TtlbhdorDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;

public class TtlbhdorDaoImpl implements TtlbhdorDao
{
	private final String QUERY_INSERT_PAYEE_DOR = " INSERT INTO TLCL.TTLBHDOR (COD_CLIECASH, COD_CLASEORD, COD_IDORDEN, COD_DETALL,COD_CABECORI,COD_ORIGE, IMP_IMPORIVA, QTY_DETALLE, COD_DIISOALF, FEC_VALOCASH," 
						+ "QNU_TIPCAMBI, COD_REFDETAL, COD_REFDOCUM, XSN_GASTOS, XSN_FORMPAGO, FEC_EXPEDICI, QNU_NUMPAGOS, FEC_VENCCASH, COD_DEVOLORD, DES_MOTIVDEV, " 
						+ "DES_MOTIVDEL, XSN_CONCEPTO, FEC_ORIGENOR, COD_REFSEGUR, XTI_INSTRUCC, COD_MOTPAGOD, COD_REFINTER, XTI_PROVEDOR, DES_FACTURA, COD_FACTURA, " 
						+ "FEC_FACTURA, IMP_CUOTTA, QTY_CUOTA, QTY_PRIMCUOT, XTI_INACELER, COD_OFICPLAZ, QTY_CONCEPTO, "
						+ "COD_LNUMERO, DES_CPTO144,AUD_FMODIFIC, AUD_USUARIO)"
						+ "VALUES "
						+ "(:COD_CLIECASH, :COD_CLASEORD, :COD_IDORDEN, :COD_DETALL, :COD_CABECORI, :COD_ORIGE, :IMP_IMPORIVA, :QTY_DETALLE,"
						+ " :COD_DIISOALF, :FEC_VALOCASH, :QNU_TIPCAMBI, :COD_REFDETAL, :COD_REFDOCUM, :XSN_GASTOS, :XSN_FORMPAGO, :FEC_EXPEDICI,"
						+ " :QNU_NUMPAGOS, :FEC_VENCCASH, :COD_DEVOLORD, :DES_MOTIVDEV, :DES_MOTIVDEL, :XSN_CONCEPTO, :FEC_ORIGENOR, :COD_REFSEGUR,"
						+ " :XTI_INSTRUCC, :COD_MOTPAGOD, :COD_REFINTER, :XTI_PROVEDOR, :DES_FACTURA, :COD_FACTURA, :FEC_FACTURA, :IMP_CUOTTA,"
						+ " :QTY_CUOTA, :QTY_PRIMCUOT, :XTI_INACELER, :COD_OFICPLAZ, :QTY_CONCEPTO, :COD_LNUMERO, :DES_CPTO144, TO_CHAR(CURRENT_DATE, 'YYYY-MM-DD'), :AUD_USUARIO)";
	
	@Autowired
	@Qualifier("BTLCLCO1namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	private Map<String, Object> parameters;
	
	public void insertDor(TtlbhdorDto dorDto) throws BbvaClientCbdException
	{
		parameters = new HashMap<String, Object>();
		//INSERT DE LA TABLA TTLBHDOR
		try {
			parameters = new HashMap<String, Object>();
			
			parameters.put("COD_CLIECASH", dorDto.getCOD_CLIECASH());
			parameters.put("COD_CLASEORD", dorDto.getCOD_CLASEORD());
			parameters.put("COD_IDORDEN ", dorDto.getCOD_IDORDEN ());
			parameters.put("COD_DETALL", dorDto.getCOD_DETALL  ());
			parameters.put("COD_CABECORI", dorDto.getCOD_CABECORI());
			parameters.put("COD_ORIGE", dorDto.getCOD_ORIGE   ());
			parameters.put("IMP_IMPORIVA", dorDto.getIMP_IMPORIVA());
			parameters.put("QTY_DETALLE", dorDto.getQTY_DETALLE ());
			parameters.put("COD_DIISOALF", dorDto.getCOD_DIISOALF());
			parameters.put("FEC_VALOCASH", dorDto.getFEC_VALOCASH());
			parameters.put("QNU_TIPCAMBI", dorDto.getQNU_TIPCAMBI());
			parameters.put("COD_REFDETAL", dorDto.getCOD_REFDETAL());
			parameters.put("COD_REFDOCUM", dorDto.getCOD_REFDOCUM());
			parameters.put("XSN_GASTOS", dorDto.getXSN_GASTOS  ());
			parameters.put("XSN_FORMPAGO", dorDto.getXSN_FORMPAGO());
			parameters.put("FEC_EXPEDICI", dorDto.getFEC_EXPEDICI());
			parameters.put("QNU_NUMPAGOS", dorDto.getQNU_NUMPAGOS());
			parameters.put("FEC_VENCCASH", dorDto.getFEC_VENCCASH());
			parameters.put("COD_DEVOLORD", dorDto.getCOD_DEVOLORD());
			parameters.put("DES_MOTIVDEV", dorDto.getDES_MOTIVDEV());
			parameters.put("DES_MOTIVDEL", dorDto.getDES_MOTIVDEL());
			parameters.put("XSN_CONCEPTO", dorDto.getXSN_CONCEPTO());
			parameters.put("FEC_ORIGENOR", dorDto.getFEC_ORIGENOR());
			parameters.put("COD_REFSEGUR", dorDto.getCOD_REFSEGUR());
			parameters.put("XTI_INSTRUCC", dorDto.getXTI_INSTRUCC());
			parameters.put("COD_MOTPAGOD", dorDto.getCOD_MOTPAGOD());
			parameters.put("COD_REFINTER", dorDto.getCOD_REFINTER());
			parameters.put("XTI_PROVEDOR", dorDto.getXTI_PROVEDOR());
			parameters.put("DES_FACTURA", dorDto.getDES_FACTURA ());
			parameters.put("COD_FACTURA", dorDto.getCOD_FACTURA ());
			parameters.put("FEC_FACTURA", dorDto.getFEC_FACTURA ());
			parameters.put("IMP_CUOTTA", dorDto.getIMP_CUOTTA  ());
			parameters.put("QTY_CUOTA", dorDto.getQTY_CUOTA   ());
			parameters.put("QTY_PRIMCUOT", dorDto.getQTY_PRIMCUOT());
			parameters.put("XTI_INACELER", dorDto.getXTI_INACELER());
			parameters.put("COD_OFICPLAZ", dorDto.getCOD_OFICPLAZ());
			parameters.put("QTY_CONCEPTO", dorDto.getQTY_CONCEPTO());
			parameters.put("COD_LNUMERO", dorDto.getCOD_LNUMERO ());
			parameters.put("DES_CPTO144", dorDto.getDES_CPTO144 ());
			parameters.put("AUD_FMODIFIC", dorDto.getAUD_FMODIFIC());
			parameters.put("AUD_USUARIO", dorDto.getAUD_USUARIO ());
			
			int resp=jdbcTemplate.update(QUERY_INSERT_PAYEE_DOR, parameters);
			LogNetCashMovil.logDebugPibee("Elemento creado OK-> "+resp);
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERY_INSERT_PAYEE_DOR);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERY_INSERT_PAYEE_DOR);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
	}
}
