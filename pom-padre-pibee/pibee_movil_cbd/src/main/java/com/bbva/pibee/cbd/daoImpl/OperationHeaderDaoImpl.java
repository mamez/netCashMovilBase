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
import com.bbva.pibee.cbd.dao.OperationHeaderDao;
import com.bbva.pibee.cbd.mappers.OperationHeaderMapper;
import com.bbva.pibee.dto.cbd.OperationHeaderDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;

@ClientBd
public class OperationHeaderDaoImpl implements OperationHeaderDao {

	static final String QUERYLISTORDERID = "SELECT * FROM TLCL.TTLBHCAB"
			+ " WHERE COD_IDORDEN = (:COD_IDORDEN)";

	static final String QUERYUPDATE = "UPDATE TLCL.TTLBHCAB SET COD_CDNIFTR = :COD_CDNIFTR, COD_SUFPRESE = :COD_SUFPRESE, "
			+ "COD_DIISOALF = :COD_DIISOALF, FEC_PROCESCA = :FEC_PROCESCA, DES_REFICHER = :DES_REFICHER, DES_NOMFICH = :DES_NOMFICH, XSN_MEDCREAC = :XSN_MEDCREAC, "
			+ "XSN_MODCREAC = :XSN_MODCREAC, FEC_BORRCASH = :FEC_BORRCASH, FEC_ESTACASH = :FEC_ESTACASH, XSN_ACTAUTDE = :XSN_ACTAUTDE, QTY_TOTIMPOR = :QTY_TOTIMPOR, "
			+ "QNU_TOTREGIS = :QNU_TOTREGIS, XSN_FORMPAGO = :XSN_FORMPAGO, COD_ESTACASH = :COD_ESTACASH, QNU_PESOFIR = :QNU_PESOFIR, QNU_SIZE = :QNU_SIZE, "
			+ "DES_NOMFICHE = :DES_NOMFICHE, QNU_NUMITEM = :QNU_NUMITEM, DES_PATH = :DES_PATH, DES_FICHEROH = :DES_FICHEROH, AUD_FMODIFIC = :AUD_FMODIFIC, "
			+ "AUD_USUARIO = :AUD_USUARIO, COD_DETSEROR = :COD_DETSEROR, XTI_DETSEROR = :XTI_DETSEROR, COD_PRODCART = :COD_PRODCART, XSN_SUCURSAL = :XSN_SUCURSAL, "
			+ "DES_PATHXML = :DES_PATHXML, DES_PATHHTML = :DES_PATHHTML, DES_FXMLHTML = :DES_FXMLHTML, XTI_VALPERT = :XTI_VALPERT, COD_LTIPO = :COD_LTIPO, "
			+ "DES_LDESC = :DES_LDESC, XSN_BORRADO = :XSN_BORRADO, QTY_IMPFINA = :QTY_IMPFINA, QNU_NUMREME = :QNU_NUMREME, TIM_ORDEN = :TIM_ORDEN "
			+ "WHERE COD_CLIECASH = :COD_CLIECASH AND COD_CLASEORD = :COD_CLASEORD AND COD_IDORDEN = :COD_IDORDEN";

	static final String SIGN_UPDATE = "UPDATE TLCL.TTLBHCAB SET QNU_PESOFIR = :QNU_PESOFIR, COD_ESTACASH = (:COD_ESTACASH), "
			+ " AUD_FMODIFIC = CURRENT_DATE , AUD_USUARIO = :AUD_USUARIO "
			+ " WHERE COD_IDORDEN = (:COD_IDORDEN) ";
	
	static final String DELETELOGICAL = "UPDATE TLCL.TTLBHCAB SET COD_ESTACASH = '999' "
			+ " WHERE COD_IDORDEN = (:COD_IDORDEN) ";
	
	static final String UPDATEDATEPROCESS = "UPDATE TLCL.TTLBHCAB SET FEC_PROCESCA = :FECHA_PROCESO , AUD_FMODIFIC = CURRENT_DATE, AUD_USUARIO = :ID_USUARIO WHERE COD_IDORDEN = :COD_IDORDEN"; 

	static final String INSERT_QUERY = "INSERT INTO TLCL.TTLBHCAB VALUES (:COD_CLIECASH, :COD_CLASEORD, :COD_IDORDEN, :COD_CDNIFTR, :COD_SUFPRESE, :COD_DIISOALF, "
			+ ":FEC_PROCESCA, :DES_REFICHER, :DES_NOMFICH, :XSN_MEDCREAC, :XSN_MODCREAC, :FEC_BORRCASH, :FEC_ESTACASH, :XSN_ACTAUTDE, :QTY_TOTIMPOR, :QNU_TOTREGIS, "
			+ ":XSN_FORMPAGO, :COD_ESTACASH, :QNU_PESOFIR, :QNU_SIZE, :DES_NOMFICHE, :QNU_NUMITEM, :DES_PATH, :DES_FICHEROH, :AUD_FMODIFIC, :AUD_USUARIO, :COD_DETSEROR, "
			+ ":XTI_DETSEROR, :COD_PRODCART, :XSN_SUCURSAL, :DES_PATHXML, :DES_PATHHTML, :DES_FXMLHTML, :XTI_VALPERT, :COD_LTIPO, :DES_LDESC, :XSN_BORRADO, :QTY_IMPFINA, "
			+ ":QNU_NUMREME, :TIM_ORDEN)";
	
	@Autowired
	@Qualifier("BTLCLCO1namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;

	private Map<String, Object> parameters;

	/**
	 * Metodo para listar las cabeceras de un operación por IDORDEN 
	 */
	@Override
	public List<OperationHeaderDto> getListOrderId(String codIdOrden) throws BbvaClientCbdException{
		List<OperationHeaderDto> listOrderId = new ArrayList<OperationHeaderDto>();
		parameters = new HashMap<String, Object>();
		parameters.put("COD_IDORDEN", codIdOrden);
		try{
			listOrderId = (List<OperationHeaderDto>) jdbcTemplate.query(QUERYLISTORDERID, parameters, new OperationHeaderMapper());
			LogNetCashMovil.logDebugPibee("Listado realizado OK "+listOrderId.size());
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYLISTORDERID);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYLISTORDERID);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
		return listOrderId;
	}
	
	/**
	 * Metodo para actualizar cabeceras de un operación * 
	 * 
	 */
	public void update(OperationHeaderDto operationHeaderDto) throws BbvaClientCbdException
	{
		parameters = new HashMap<String, Object>();
		parameters.put("COD_CLIECASH", operationHeaderDto.getCOD_CLIECASH());
		parameters.put("COD_CLASEORD", operationHeaderDto.getCOD_CLASEORD());
		parameters.put("COD_IDORDEN", operationHeaderDto.getCOD_IDORDEN());
		parameters.put("COD_CDNIFTR", operationHeaderDto.getCOD_CDNIFTR());
		parameters.put("COD_SUFPRESE", operationHeaderDto.getCOD_SUFPRESE());
		parameters.put("COD_DIISOALF", operationHeaderDto.getCOD_DIISOALF());
		parameters.put("FEC_PROCESCA", operationHeaderDto.getFEC_PROCESCA());
		parameters.put("DES_REFICHER", operationHeaderDto.getDES_REFICHER());
		parameters.put("DES_NOMFICH", operationHeaderDto.getDES_NOMFICH());
		parameters.put("XSN_MEDCREAC", operationHeaderDto.getXSN_MEDCREAC());
		parameters.put("XSN_MODCREAC", operationHeaderDto.getXSN_MODCREAC());		
		parameters.put("FEC_BORRCASH", operationHeaderDto.getFEC_BORRCASH());
		parameters.put("FEC_ESTACASH", operationHeaderDto.getFEC_ESTACASH());
		parameters.put("XSN_ACTAUTDE", operationHeaderDto.getXSN_ACTAUTDE());
		parameters.put("QTY_TOTIMPOR", operationHeaderDto.getQTY_TOTIMPOR());
		parameters.put("QNU_TOTREGIS", operationHeaderDto.getQNU_TOTREGIS());
		parameters.put("XSN_FORMPAGO", operationHeaderDto.getXSN_FORMPAGO());
		parameters.put("COD_ESTACASH", operationHeaderDto.getCOD_ESTACASH());
		parameters.put("QNU_PESOFIR", operationHeaderDto.getQNU_PESOFIR());		
		parameters.put("QNU_SIZE", operationHeaderDto.getQNU_SIZE());
		parameters.put("DES_NOMFICHE", operationHeaderDto.getDES_NOMFICHE());
		parameters.put("QNU_NUMITEM", operationHeaderDto.getQNU_NUMITEM());		
		parameters.put("DES_PATH", operationHeaderDto.getDES_PATH());
		parameters.put("DES_FICHEROH", operationHeaderDto.getDES_FICHEROH());
		parameters.put("AUD_FMODIFIC", operationHeaderDto.getAUD_FMODIFIC());
		parameters.put("AUD_USUARIO", operationHeaderDto.getAUD_USUARIO());		
		parameters.put("COD_DETSEROR", operationHeaderDto.getCOD_DETSEROR());
		parameters.put("XTI_DETSEROR", operationHeaderDto.getXTI_DETSEROR());
		parameters.put("COD_PRODCART", operationHeaderDto.getCOD_PRODCART());
		parameters.put("XSN_SUCURSAL", operationHeaderDto.getXSN_SUCURSAL());
		parameters.put("DES_PATHXML", operationHeaderDto.getDES_PATHXML());
		parameters.put("DES_PATHHTML", operationHeaderDto.getDES_PATHHTML());
		parameters.put("DES_FXMLHTML", operationHeaderDto.getDES_FXMLHTML());		
		parameters.put("XTI_VALPERT", operationHeaderDto.getXTI_VALPERT());
		parameters.put("COD_LTIPO", operationHeaderDto.getCOD_LTIPO());
		parameters.put("DES_LDESC", operationHeaderDto.getDES_LDESC());
		parameters.put("XSN_BORRADO", operationHeaderDto.getXSN_BORRADO());
		parameters.put("QTY_IMPFINA", operationHeaderDto.getQTY_IMPFINA());
		parameters.put("QNU_NUMREME", operationHeaderDto.getQNU_NUMREME());
		parameters.put("TIM_ORDEN", operationHeaderDto.getTIM_ORDEN());		

		try 
		{
			int res=jdbcTemplate.update(QUERYUPDATE, parameters);
			LogNetCashMovil.logDebugPibee("Elementos actualizados "+res);
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYUPDATE);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYUPDATE);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}		
	}
	
	/**
	 * Metodo para eliminar cabeceras de un operación
	 */
	public void deleteLogical(String codIdOrden) throws BbvaClientCbdException 
	{		
		parameters = new HashMap<String, Object>();
		parameters.put("COD_IDORDEN", codIdOrden);

		try 
		{
			int res=jdbcTemplate.update(DELETELOGICAL, parameters);
			LogNetCashMovil.logDebugPibee("Elementos actualizados "+res);
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+DELETELOGICAL);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+DELETELOGICAL);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}		
	}

	@Override
	public OperationHeaderDto getOperationHead(String codIdOrden) throws BbvaClientCbdException {
		OperationHeaderDto operationHead = null;
		parameters = new HashMap<String, Object>();
		parameters.put("COD_IDORDEN", codIdOrden);

		try 
		{
			List<OperationHeaderDto> resultList = (List<OperationHeaderDto>) jdbcTemplate.query(QUERYLISTORDERID, parameters, new OperationHeaderMapper());
			if(resultList != null && !resultList.isEmpty()){
				operationHead = resultList.get(0);
				LogNetCashMovil.logDebugPibee("Consulta realizada OK "+resultList.size());
			}
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYLISTORDERID);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYLISTORDERID);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
		return operationHead;
	}

	@Override
	public void signUpdate(OperationHeaderDto objTtbhcabDto, String signerUser) throws BbvaClientCbdException {
		parameters = new HashMap<String, Object>();
		parameters.put("QNU_PESOFIR", objTtbhcabDto.getQNU_PESOFIR());
		parameters.put("COD_ESTACASH", objTtbhcabDto.getCOD_ESTACASH());
		parameters.put("AUD_USUARIO", signerUser);
		parameters.put("COD_IDORDEN", objTtbhcabDto.getCOD_IDORDEN());
		try{
			int res=jdbcTemplate.update(SIGN_UPDATE, parameters);
			LogNetCashMovil.logDebugPibee("Actualizacion realizada OK "+res);
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+SIGN_UPDATE);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+SIGN_UPDATE);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
	}

	@Override
	public int updateDateProcess(String codIdOrden,String userId,String processDate) throws BbvaClientCbdException 
	{
		int res=0;
		parameters = new HashMap<String, Object>();
		
		parameters.put("COD_IDORDEN", codIdOrden);
		parameters.put("FECHA_PROCESO", processDate);
		parameters.put("ID_USUARIO", userId);
		
		try{
			 res=jdbcTemplate.update(UPDATEDATEPROCESS, parameters);
			LogNetCashMovil.logDebugPibee("Actualizacion realizada OK "+res);
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+UPDATEDATEPROCESS);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+UPDATEDATEPROCESS);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
		return res;
	}

	@Override
	public void createOperationHeader(OperationHeaderDto operationHeaderDto) throws BbvaClientCbdException {
		
		parameters = new HashMap<String, Object>();
		parameters.put("COD_CLIECASH", operationHeaderDto.getCOD_CLIECASH());
		parameters.put("COD_CLASEORD", operationHeaderDto.getCOD_CLASEORD());
		parameters.put("COD_IDORDEN", operationHeaderDto.getCOD_IDORDEN());
		parameters.put("COD_CDNIFTR", operationHeaderDto.getCOD_CDNIFTR());
		parameters.put("COD_SUFPRESE", operationHeaderDto.getCOD_SUFPRESE());
		parameters.put("COD_DIISOALF", operationHeaderDto.getCOD_DIISOALF());
		parameters.put("FEC_PROCESCA", operationHeaderDto.getFEC_PROCESCA());
		parameters.put("DES_REFICHER", operationHeaderDto.getDES_REFICHER());
		parameters.put("DES_NOMFICH", operationHeaderDto.getDES_NOMFICH());
		parameters.put("XSN_MEDCREAC", operationHeaderDto.getXSN_MEDCREAC());
		parameters.put("XSN_MODCREAC", operationHeaderDto.getXSN_MODCREAC());		
		parameters.put("FEC_BORRCASH", operationHeaderDto.getFEC_BORRCASH());
		parameters.put("FEC_ESTACASH", operationHeaderDto.getFEC_ESTACASH());
		parameters.put("XSN_ACTAUTDE", operationHeaderDto.getXSN_ACTAUTDE());
		parameters.put("QTY_TOTIMPOR", operationHeaderDto.getQTY_TOTIMPOR());
		parameters.put("QNU_TOTREGIS", operationHeaderDto.getQNU_TOTREGIS());
		parameters.put("XSN_FORMPAGO", operationHeaderDto.getXSN_FORMPAGO());
		parameters.put("COD_ESTACASH", operationHeaderDto.getCOD_ESTACASH());
		parameters.put("QNU_PESOFIR", operationHeaderDto.getQNU_PESOFIR());		
		parameters.put("QNU_SIZE", operationHeaderDto.getQNU_SIZE());
		parameters.put("DES_NOMFICHE", operationHeaderDto.getDES_NOMFICHE());
		parameters.put("QNU_NUMITEM", operationHeaderDto.getQNU_NUMITEM());		
		parameters.put("DES_PATH", operationHeaderDto.getDES_PATH());
		parameters.put("DES_FICHEROH", operationHeaderDto.getDES_FICHEROH());
		parameters.put("AUD_FMODIFIC", operationHeaderDto.getAUD_FMODIFIC());
		parameters.put("AUD_USUARIO", operationHeaderDto.getAUD_USUARIO());		
		parameters.put("COD_DETSEROR", operationHeaderDto.getCOD_DETSEROR());
		parameters.put("XTI_DETSEROR", operationHeaderDto.getXTI_DETSEROR());
		parameters.put("COD_PRODCART", operationHeaderDto.getCOD_PRODCART());
		parameters.put("XSN_SUCURSAL", operationHeaderDto.getXSN_SUCURSAL());
		parameters.put("DES_PATHXML", operationHeaderDto.getDES_PATHXML());
		parameters.put("DES_PATHHTML", operationHeaderDto.getDES_PATHHTML());
		parameters.put("DES_FXMLHTML", operationHeaderDto.getDES_FXMLHTML());		
		parameters.put("XTI_VALPERT", operationHeaderDto.getXTI_VALPERT());
		parameters.put("COD_LTIPO", operationHeaderDto.getCOD_LTIPO());
		parameters.put("DES_LDESC", operationHeaderDto.getDES_LDESC());
		parameters.put("XSN_BORRADO", operationHeaderDto.getXSN_BORRADO());
		parameters.put("QTY_IMPFINA", operationHeaderDto.getQTY_IMPFINA());
		parameters.put("QNU_NUMREME", operationHeaderDto.getQNU_NUMREME());
		parameters.put("TIM_ORDEN", operationHeaderDto.getTIM_ORDEN());		
		try 
		{
			int res=jdbcTemplate.update(INSERT_QUERY, parameters);
			LogNetCashMovil.logDebugPibee("Elementos actualizados "+res);
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYUPDATE);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERYUPDATE);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}	
	}	
	
}
