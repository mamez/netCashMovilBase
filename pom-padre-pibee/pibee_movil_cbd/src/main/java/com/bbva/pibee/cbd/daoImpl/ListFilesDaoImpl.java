package com.bbva.pibee.cbd.daoImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.ClientBd;
import com.bbva.pibee.cbd.dao.ListFilesDao;
import com.bbva.pibee.cbd.mappers.FilesMapper;
import com.bbva.pibee.dto.cbd.OperationDetailDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;

@ClientBd
public class ListFilesDaoImpl implements ListFilesDao{
	
	static final String QUERYLISTFILES =  "SELECT" 
			+" A.COD_CLIECASH,A.COD_CLASEORD,A.COD_IDORDEN,A.FEC_PROCESCA,A.DES_NOMFICH,A.QTY_TOTIMPOR,"
			+" A.QNU_TOTREGIS,A.COD_ESTACASH,A.QNU_PESOFIR,A.QNU_NUMITEM,A.QNU_SIZE,A.DES_REFICHER,B.COD_CABECORI,"
			+" B.DES_CUENORIG,B.COD_IDORIGEN,B.COD_BANCSB,B.COD_DIISOALF, C.FEC_ACCIO,C.COD_USUARIO,A.AUD_FMODIFIC,A.AUD_USUARIO,"
			+" A.XSN_MEDCREAC,A.XSN_MODCREAC,A.DES_PATHXML,A.DES_PATHHTML,A.DES_FXMLHTML,A.DES_NOMFICHE,A.DES_FICHEROH,"
			+" A.COD_SUFPRESE,A.COD_LTIPO,A.QTY_IMPFINA,A.COD_PRODCART,A.DES_PATH"  
			+" FROM"
			+" TTLBHCAB A"
			+" INNER JOIN TTLBHCOR B ON (A.COD_CLIECASH = B.COD_CLIECASH"
			+" AND A.COD_CLASEORD = B.COD_CLASEORD AND A.COD_IDORDEN = B.COD_IDORDEN)"
			+" INNER JOIN  TTLBHFUA C ON (A.COD_CLIECASH = C.COD_CLIECASH AND A.COD_CLASEORD = C.COD_CLASEORD AND" 
			+" A.COD_IDORDEN = C.COD_IDORDEN  AND C.COD_ACCION = 1)";
		
	static final String WHERE = " WHERE A.COD_CLIECASH =:companyReference AND A.COD_ESTACASH IN (:states)";
	
	static final String OPERATION_TYPE_WHERE = " AND A.COD_CLASEORD IN (:operationTypes)";
	
	static final String DATE_FROM_WHERE = " AND A.FEC_PROCESCA >= TO_CHAR(:dateFrom, 'YYYYMMDD')";
	
	static final String DATE_TO_WHERE = " AND A.FEC_PROCESCA <= TO_CHAR(:dateTo, 'YYYYMMDD')";
	
	static final String AMMOUNT_FROM_WHERE = " AND A.QTY_TOTIMPOR >= :ammountFrom";
	
	static final String AMMOUNT_TO_WHERE = " AND A.QTY_TOTIMPOR <= :ammountTo";
	
	static final String CREATOR_USER_WHERE = " AND C.COD_USUARIO = :codUsuario";
	
	static final String ID_WHERE = " WHERE A.COD_IDORDEN = :id";
	
	static final String GROUP_BY = " GROUP BY" 
			+" A.COD_CLIECASH,A.COD_CLASEORD,A.COD_IDORDEN,A.FEC_PROCESCA,A.DES_NOMFICH,A.QTY_TOTIMPOR,"
			+" A.QNU_TOTREGIS,A.COD_ESTACASH,A.QNU_PESOFIR,A.QNU_NUMITEM,A.QNU_SIZE,A.DES_REFICHER,B.COD_CABECORI,"
			+" B.DES_CUENORIG,B.COD_IDORIGEN,B.COD_BANCSB,B.COD_DIISOALF,C.FEC_ACCIO,C.COD_USUARIO,A.AUD_FMODIFIC,A.AUD_USUARIO,"
			+" A.XSN_MEDCREAC,A.XSN_MODCREAC,A.DES_PATHXML,A.DES_PATHHTML,A.DES_FXMLHTML,A.DES_NOMFICHE,A.DES_FICHEROH,"
			+" A.COD_SUFPRESE,A.COD_LTIPO,A.QTY_IMPFINA,A.COD_PRODCART,A.DES_PATH";
	
	static final String ORDER_BY = " ORDER BY A.FEC_PROCESCA DESC";
	
	@Autowired
	@Qualifier("BTLCLCO1namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate JdbcTemplate;
	 
	private Map<String, Object> parameters;
	 	 
	@Override
	public List<OperationDetailDto> getListaFicherosPendiente(String companyReference, List<String> serviceStateList, String creatorUser, List<String> operationTypeIdList,
			Date dateFrom, Date dateTo, Double ammountFrom, Double ammountTo) throws BbvaClientCbdException {	
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		StringBuilder query = new StringBuilder(QUERYLISTFILES).append(WHERE);
		
		if(creatorUser != null && creatorUser.trim() != ""){
			query.append(CREATOR_USER_WHERE);
		}
		
		if(operationTypeIdList!=null && !operationTypeIdList.isEmpty()){
			query.append(OPERATION_TYPE_WHERE);
		}
		
		if(dateFrom != null){
			query.append(DATE_FROM_WHERE);
		}
		
		if(dateTo != null){
			query.append(DATE_TO_WHERE);
		}
		
		if(ammountFrom != null){
			query.append(AMMOUNT_FROM_WHERE);
		}
		
		if(ammountTo != null){
			query.append(AMMOUNT_TO_WHERE);
		}
		
		query.append(GROUP_BY).append(ORDER_BY);
		
		List<OperationDetailDto> listReponseFiles = new ArrayList<OperationDetailDto>();
		parameters = new HashMap<String, Object>();
		parameters.put("companyReference", companyReference);
		
		if(creatorUser != null && creatorUser.trim() != ""){
			parameters.put("codUsuario", creatorUser);
		}
		
		if(operationTypeIdList!=null && !operationTypeIdList.isEmpty()){
			parameters.put("operationTypes", operationTypeIdList);
		}
		
		if(dateFrom != null){
			
			parameters.put("dateFrom", formatter.format(dateFrom));
		}
		
		if(dateTo != null){
			parameters.put("dateTo", formatter.format(dateTo));
		}
		
		if(ammountFrom != null){
			parameters.put("ammountFrom", ammountFrom);
		}
		
		if(ammountTo != null){
			parameters.put("ammountTo", ammountTo);
		}
		
		parameters.put("states", serviceStateList);
		try{
			listReponseFiles=(List<OperationDetailDto>)JdbcTemplate.query(query.toString(),parameters,new FilesMapper());	
			LogNetCashMovil.logDebugPibee("Listado realizado OK :"+listReponseFiles.size());
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+query.toString());
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+query.toString());
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
		return listReponseFiles;
	}

	@Override
	public OperationDetailDto getOperationDetailById(String id)  throws BbvaClientCbdException{
		
		OperationDetailDto operationDetailDto = null;
		
		StringBuilder query = new StringBuilder(QUERYLISTFILES).append(ID_WHERE);
		parameters = new HashMap<String, Object>();
		parameters.put("id", id);
		
		List<OperationDetailDto> listReponseFiles = new ArrayList<OperationDetailDto>();
		try{
			listReponseFiles=(List<OperationDetailDto>)JdbcTemplate.query(query.toString(),parameters,new FilesMapper());
			if(listReponseFiles != null && !listReponseFiles.isEmpty()){
				operationDetailDto = listReponseFiles.get(0);
			}
			LogNetCashMovil.logDebugPibee("Listado realizado OK :"+listReponseFiles.size());
		}catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+query.toString());
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+query.toString());
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
		return operationDetailDto;
	}

}
