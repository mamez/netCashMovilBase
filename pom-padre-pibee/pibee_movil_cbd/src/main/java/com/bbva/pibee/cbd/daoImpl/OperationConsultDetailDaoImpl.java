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
import com.bbva.pibee.cbd.dao.OperationConsultDetailDao;
import com.bbva.pibee.cbd.mappers.TtlbhdorMapper;
import com.bbva.pibee.dto.cbd.TtlbhdorDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;

public class OperationConsultDetailDaoImpl implements OperationConsultDetailDao {
	
	static final String QUERYFILTER = "SELECT COD_CLIECASH, COD_CLASEORD, COD_IDORDEN, COD_DETALL, COD_CABECORI, COD_ORIGE, IMP_IMPORIVA, QTY_DETALLE, COD_DIISOALF, FEC_VALOCASH, QNU_TIPCAMBI, COD_REFDETAL, COD_REFDOCUM, XSN_GASTOS, XSN_FORMPAGO, FEC_EXPEDICI, QNU_NUMPAGOS, FEC_VENCCASH, COD_DEVOLORD, DES_MOTIVDEV, DES_MOTIVDEL, XSN_CONCEPTO, FEC_ORIGENOR, COD_REFSEGUR, XTI_INSTRUCC, COD_MOTPAGOD, COD_REFINTER, XTI_PROVEDOR, DES_FACTURA, COD_FACTURA, FEC_FACTURA, IMP_CUOTTA, QTY_CUOTA, QTY_PRIMCUOT, XTI_INACELER, COD_OFICPLAZ, QTY_CONCEPTO, COD_LNUMERO, DES_CPTO144, AUD_FMODIFIC, AUD_USUARIO ";
	
	static final String DESDE_FROM = "FROM TLCL.TTLBHDOR WHERE ";
	
	static final String COD_CLI_WHERE = "COD_CLIECASH = :codCliente ";
	
	static final String CLA_ORD_WHERE = "AND COD_CLASEORD = :claseOrden ";
	
	static final String COD_ORD_WHERE = "AND COD_IDORDEN = :idOrden ";
	
	static final String COD_DETALL_WHERE = "AND COD_DETALL = :idDetalle ";
	
	static final String COD_CABECORI_WHERE = "AND COD_CABECORI = :idCodCabOrigen";
	
	@Autowired
	@Qualifier("BTLNECO1namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	private Map<String, Object> parameters;
	
	@Override
	public List<TtlbhdorDto> generateFilter(String codCliente, String claseOrden, String idOrden, int idDetalle, int idCodCabOrigen) throws BbvaClientCbdException {
		
		List<TtlbhdorDto> filter = new ArrayList<TtlbhdorDto>();
		
		StringBuilder query = new StringBuilder(QUERYFILTER);
		
		parameters = new HashMap<String, Object>();
		
		try {
			int cont = 0;
			if(codCliente != null && codCliente.trim() != "") {
				cont++;
				query.append(COD_CLI_WHERE);
				parameters.put("codCliente", codCliente);
			}else {
				LogNetCashMovil.logDebugPibee("PARAMETRO CODIGO DE CLIENTE VACIO.........");
			}
			
			if(claseOrden != null && claseOrden.trim() != "") {
				cont++;
				query.append(CLA_ORD_WHERE);
				parameters.put("claseOrden", claseOrden);
			}else {
				LogNetCashMovil.logDebugPibee("PARAMETRO CLASE DE ORDEN VACIO.........");
			}
			
			if(idOrden != null && idOrden.trim() != "") {
				cont++;
				query.append(COD_ORD_WHERE);
				parameters.put("idOrden", idOrden);
			}else {
				LogNetCashMovil.logDebugPibee("PARAMETRO CODIGO DE ORDEN VACIO.........");
			}
			
			if((new Integer(idDetalle).toString()) != null && (new Integer(idDetalle).toString()).trim() != "") {
				cont++;
				query.append(COD_DETALL_WHERE);
				parameters.put("idDetalle", idDetalle);
			}else {
				LogNetCashMovil.logDebugPibee("PARAMETRO CODIGO DE DETALLE VACIO.........");
			}
			
			if((new Integer(idCodCabOrigen).toString()) != null && (new Integer(idCodCabOrigen).toString()).trim() != "" && cont == 4) {
				query.append(COD_CABECORI_WHERE);
				parameters.put("idCodCabOrigen", idCodCabOrigen);
				filter = (List<TtlbhdorDto>) jdbcTemplate.query(query.toString(), parameters,  new TtlbhdorMapper());
			}else {
				LogNetCashMovil.logDebugPibee("PARAMETRO CODIGO DE CABECERA ORIGEN VACIO.........");
			}
			
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+query.toString());
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+query.toString());
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}	
		return filter;
	}

}
