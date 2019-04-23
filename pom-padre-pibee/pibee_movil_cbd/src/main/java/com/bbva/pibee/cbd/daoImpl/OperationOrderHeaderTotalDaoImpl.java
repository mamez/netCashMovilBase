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
import com.bbva.pibee.cbd.dao.OperationOrderHeaderTotalDao;
import com.bbva.pibee.cbd.mappers.OperationOrderHeaderTotalMapper;
import com.bbva.pibee.dto.cbd.OperationOrderHeaderTotalDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;

@ClientBd
public class OperationOrderHeaderTotalDaoImpl implements OperationOrderHeaderTotalDao {
	
	
	static final String QUERYLISTFILESCAB = "SELECT A.COD_CLIECASH, A.COD_CLASEORD, A.COD_IDORDEN, A.COD_CDNIFTR, A.COD_SUFPRESE, A.COD_DIISOALF, "
			+ " A.FEC_PROCESCA, A.DES_REFICHER, A.DES_NOMFICH, A.XSN_MEDCREAC, A.XSN_MODCREAC, A.FEC_BORRCASH,"
			+ " A.FEC_ESTACASH, A.XSN_ACTAUTDE, A.QTY_TOTIMPOR, A.QNU_TOTREGIS, A.XSN_FORMPAGO, A.COD_ESTACASH,"
			+ " A.QNU_PESOFIR, A.QNU_SIZE, A.DES_NOMFICHE, A.QNU_NUMITEM, A.DES_PATH, A.COD_DETSEROR,"
			+ " A.COD_PRODCART, A.XTI_DETSEROR, A.XSN_SUCURSAL,  A.XTI_VALPERT,  A.COD_LTIPO, A.DES_LDESC,"
			+ " A.XSN_BORRADO, A.QTY_IMPFINA, A.QNU_NUMREME, A.DES_FICHEROH, A.AUD_FMODIFIC, A.AUD_USUARIO, ";
	
	static final String QUERYLISTFILESCOR = "B.COD_CABECORI, B.COD_CDNITR, B.COD_SUFPRESE, B.COD_IDORIGEN, B.DES_CUENORIG, B.COD_BANCINTE,"
			+ " B.COD_BANCSB, B.COD_DIISOALF, B.COD_FORMASUN, B.XTI_CLASEASU, B.COD_SWIFT, B.COD_BANABA, B.XTI_EMISOR, B.DES_ORDPAGO, ";
	
	static final String QUERYLISTFILESORO = "C.COD_IDORIGEN, C.XTI_DOCIDENT, C.DES_DOCIDENT, C.DES_PRSCONT, C.DES_TFNOCONT, C.COD_PROVINCI,"
			+ " C.DES_ORIGEN, C.DES_DOMIORI1, C.DES_DOMIORI2, C.DES_DOMIORI3, C.DES_LOCALI, C.COD_CDIPOS,"
			+ " C.QNU_REFEREN, C.XSN_REFEREN, C.DES_REFEROPE, C.XSN_MODELCON, C.COD_ALFANUM, C.COD_REFEREXT,"
			+ " C.COD_NIFORIGN, C.XTI_PROVEDOR, C.COD_CTASIGN, C.COD_OFITOMAD, C.COD_FICHERO, C.COD_SOCIEDAD,"
			+ " C.DES_ONOMBRE, C.DES_ODIRECC, C.COD_OCP2 ";
	
	static final String FROM = "FROM TLCL.TTLBHCAB A, TLCL.TTLBHCOR B, TLCL.TTLBHORO C ";
	
	static final String WHERE = "WHERE A.COD_CLIECASH  = :sCodigoCliente AND A.COD_CLASEORD = :sClaseOrden AND A.COD_IDORDEN = :sIdOrden AND"
							+ " B.COD_CABECORI = :iIdCabeceraOrigen AND A.COD_IDORDEN = B.COD_IDORDEN AND A.COD_CLIECASH = B.COD_CLIECASH AND"
							+ " A.COD_CLASEORD = B.COD_CLASEORD AND B.COD_CLIECASH = C.COD_CLIECASH AND B.COD_CLASEORD = C.COD_CLASEORD AND"
							+ " B.COD_CDNITR = C.COD_CDNITR AND B.COD_SUFPRESE = C.COD_SUFPRESE AND B.COD_CABECORI = :iIdCabeceraOrigen AND"
							+ " B.COD_IDORIGEN = C.COD_IDORIGEN AND B.COD_IDORDEN = C.COD_IDORDEN";

	@Autowired
	@Qualifier("BTLCLCO1namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;
	private HashMap<String, Object> parametros;
	
	@Override
	public List<OperationOrderHeaderTotalDto> getOperationOrderHeader(String sCodigoCliente, String sClaseOrden, String sIdOrden, int iIdCabeceraOrigen) throws BbvaClientCbdException {
		// TODO Auto-generated method stub
		List<OperationOrderHeaderTotalDto> getOperationOrderHeaderDto = new ArrayList<OperationOrderHeaderTotalDto>();
		StringBuilder query = new StringBuilder(QUERYLISTFILESCAB).append(QUERYLISTFILESCOR).append(QUERYLISTFILESORO).append(FROM).append(WHERE);
		try
		{
			if (!sCodigoCliente.isEmpty() || !sClaseOrden.isEmpty() || !sIdOrden.isEmpty() || iIdCabeceraOrigen == 0 ) {
				parametros = new HashMap<String, Object>();
				parametros.put("sCodigoCliente", sCodigoCliente);
				parametros.put("sClaseOrden", sClaseOrden);
				parametros.put("sIdOrden", sIdOrden);
				parametros.put("iIdCabeceraOrigen", iIdCabeceraOrigen);
				getOperationOrderHeaderDto = (List<OperationOrderHeaderTotalDto>) jdbcTemplate.query(query.toString(),parametros, new OperationOrderHeaderTotalMapper());
				LogNetCashMovil.logDebugPibee("Consulta realizada "+getOperationOrderHeaderDto.size());
			} else {
				String campos = "";
				campos += sCodigoCliente.isEmpty()?"COD_CLIECASH, ":"";
				campos += sClaseOrden.isEmpty()?"COD_CLASEORD, ":"";
				campos += sIdOrden.isEmpty()?"COD_IDORDEN, ":"";
				campos += iIdCabeceraOrigen == 0?"COD_CABECORI, ":"";
				LogNetCashMovil.logDebugPibee("Campo(s) "+campos+"vacio(s)");
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
		return getOperationOrderHeaderDto;
	}


}
