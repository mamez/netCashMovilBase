package com.bbva.pibee.cbd.daoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.ClientBd;
import com.bbva.pibee.cbd.dao.OperationListDetailsDao;
import com.bbva.pibee.cbd.mappers.OperationListDetailsMapper;
import com.bbva.pibee.dto.cbd.OperationListDetailsDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;

@ClientBd
public class OperationListDetailsDaoImpl implements OperationListDetailsDao{
	public static Logger logger = Logger.getLogger("pibee");
	static final String QUERYLISTDETAILS = "SELECT B.COD_DETALL, B.DES_DESTINO, B.COD_IDESTINO, B.COD_NIFDESTI, B.DES_CUENDEST, A.COD_DIISOALF, A.QTY_DETALLE, "
			+ "A.COD_CLIECASH, A.COD_CLASEORD, A.COD_IDORDEN, A.COD_DETALL, A.COD_CABECORI, A.XSN_CONCEPTO, "
			+ "A.COD_DEVOLORD, A.DES_MOTIVDEV, A.COD_REFINTER, A.COD_LNUMERO, B.DES_LIBRADO, A.COD_FACTURA ";
	
	static final String DESDE_FROM = "FROM TLCL.TTLBHDOR A INNER JOIN TLCL.TTLBHDEO B ON A.COD_CLIECASH = B.COD_CLIECASH AND A.COD_IDORDEN = B.COD_IDORDEN AND A.COD_CLASEORD = B.COD_CLASEORD AND A.COD_CABECORI = B.COD_CABECORI AND A.COD_DETALL = B.COD_DETALL ";
	
	static final String COD_CLI_WHERE = "AND A.COD_CLIECASH = :sCodigoCliente ";
	
	static final String CLA_ORD_WHERE = "AND A.COD_CLASEORD = :sClaseOrden ";
	
	static final String COD_ORD_WHERE = "AND A.COD_IDORDEN = :sCodigoOrden";
	
	@Autowired
	@Qualifier("BTLCLCO1namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	private Map<String, Object> parameters;
	
	@Override
	public List<OperationListDetailsDto> getListDetails(String sCodigoCliente, String sClaseOrden, String sCodigoOrden) throws BbvaClientCbdException {	
		
		List<OperationListDetailsDto> listGetDetails = new ArrayList<OperationListDetailsDto>();
		
		StringBuilder query = new StringBuilder(QUERYLISTDETAILS).append(DESDE_FROM);
		
		parameters = new HashMap<String, Object>();
		
		try {
			
			int cont = 0;
			if(sCodigoCliente != null && sCodigoCliente.trim() != "") {
				cont++;
				query.append(COD_CLI_WHERE);
				parameters.put("sCodigoCliente", sCodigoCliente);
			}else {
				LogNetCashMovil.logDebugPibee("PARAMETRO CODIGO DE CLIENTE VACIO.........");
			}
			
			if(sClaseOrden != null && sClaseOrden.trim() != "") {
				cont++;
				query.append(CLA_ORD_WHERE);
				parameters.put("sClaseOrden", sClaseOrden);
			}else {
				LogNetCashMovil.logDebugPibee("PARAMETRO CLASE DE ORDEN VACIO.........");
			}
			
			if(sCodigoOrden != null && sCodigoOrden.trim() != "" && cont == 2) {
				query.append(COD_ORD_WHERE);
				parameters.put("sCodigoOrden", sCodigoOrden);
				listGetDetails = (List<OperationListDetailsDto>) jdbcTemplate.query(query.toString(), parameters,  new OperationListDetailsMapper());
			}else {
				LogNetCashMovil.logDebugPibee("PARAMETRO CODIGO DE ORDEN VACIO.........");
			}
			
		}catch (EmptyResultDataAccessException e) {
			logger.debug("La lista  "+ listGetDetails+" no existe");
			listGetDetails = null;
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+query.toString());
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+query.toString());
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
		
		return listGetDetails;
	}
}
