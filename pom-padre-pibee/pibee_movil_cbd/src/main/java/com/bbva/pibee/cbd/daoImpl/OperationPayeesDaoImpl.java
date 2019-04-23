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
import com.bbva.pibee.cbd.dao.OperationPayeesDao;
import com.bbva.pibee.cbd.mappers.TtlbhdesMapper;
import com.bbva.pibee.dto.cbd.TtlbhdesDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;

@ClientBd
public class OperationPayeesDaoImpl implements OperationPayeesDao
{	
	private final String QUERY_GET_PAYEES_BY_ISSUING = "SELECT * FROM TLCL.TTLBHDES WHERE COD_CLIECASH = :COD_CLIECASH AND COD_CLASEORD = :COD_CLASEORD AND COD_IDORIGEN = :COD_IDORIGEN ";
	private final String QUERY_VALIDATEPAYEE = "AND COD_IDESTINO = :COD_IDESTINO";	
	private final String QUERY_INSERT_PAYEE_DES = "INSERT INTO TTLBHDES (COD_CLIECASH,COD_CLASEORD,COD_IDORIGEN,COD_IDESTINO,DES_DESTINO,COD_NIFDESTI,DES_DOMIDES1,DES_DOMIDES2,DES_DOMIDES3,DES_CPLAZA,COD_PROVINCI,COD_CDIPOS,"
																			+"XTI_CLASEASU,COD_PAISOALF,DES_CUENDEST,COD_BANABA,DES_OFICIDES,COD_INSTRUC,COD_BANCSB,DES_TITULCTA,DES_BANCO,DES_INSTRUCC,COD_SWFIT,COD_ESTADIS,"
																			+ "COD_FORMASUN,XTI_DOCIDENT, COD_TELFPROV,DES_PRSCONT,COD_OFICPLAZ,COD_CDNITR,COD_SUFPRESE,COD_ENTREGA,COD_SUCURENT,COD_COMUNA,DES_DNOMBER,XTI_DIDEBCOT,"
																			+ "XTI_DIDEBCOI,COD_BANCINTE,DES_DDIRECC,DES_DDIRBCOT ,COD_DPAIBCOI,DES_DNOMCO,DES_DDIRBCOI,DES_DCUEBCOI,COD_GASTODES,COD_CDIPOS2,COD_PRSCONT,DES_EMAIL,"
																			+ "	COD_FAXPORT,XSN_FORMPAGO,COD_BANCASH,AUD_FMODIFIC,AUD_USUARIO"
																			+ ")"
																			+ " VALUES (:COD_CLIECASH, :COD_CLASEORD, :COD_IDORIGEN, :COD_IDESTINO, :DES_DESTINO, :COD_NIFDESTI, :DES_DOMIDES1, :DES_DOMIDES2, :DES_DOMIDES3, :DES_CPLAZA,"
																			+ " 0, 0, :XTI_CLASEASU, :COD_PAISOALF, :DES_CUENDEST, :COD_BANABA, :DES_OFICIDES, :COD_INSTRUC, :COD_BANCSB, :DES_TITULCTA, :DES_BANCO,"
																			+ " :DES_INSTRUCC, :COD_SWFIT, '', 0, :XTI_DOCIDENT, :COD_TELFPROV, :DES_PRSCONT, :COD_OFICPLAZ, :COD_CDNITR, :COD_SUFPRESE, :COD_ENTREGA, "
																			+ ":COD_SUCURENT, :COD_COMUNA, :DES_DNOMBER, :XTI_DIDEBCOT, :XTI_DIDEBCOI, :COD_BANCINTE, :DES_DDIRECC, :DES_DDIRBCOT, :COD_DPAIBCOI, :DES_DNOMCO,:DES_DDIRBCOI,"
																			+ " :DES_DCUEBCOI, :COD_GASTODES, 0, :COD_PRSCONT, :DES_EMAIL, '', :XSN_FORMPAGO, '', TO_CHAR(CURRENT_DATE, 'YYYY-MM-DD'), :AUD_USUARIO)";
		
	
	@Autowired
	@Qualifier("BTLCLCO1namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	private Map<String, Object> parameters;
	
	@Override
	public List<TtlbhdesDto> getPayeesByIssuing(String codCliecash, String codClaseord, String codIdorigen) throws BbvaClientCbdException
	{
		List<TtlbhdesDto> getPayees = new ArrayList<TtlbhdesDto>();
		parameters = new HashMap<String, Object>();		
		try
		{
			parameters.put("COD_CLIECASH", codCliecash);
			parameters.put("COD_CLASEORD", codClaseord);
			parameters.put("COD_IDORIGEN", codIdorigen);
			
			getPayees = (List<TtlbhdesDto>)jdbcTemplate.query(QUERY_GET_PAYEES_BY_ISSUING, parameters, new TtlbhdesMapper());
			LogNetCashMovil.logDebugPibee("Consulta realizada OK-> "+getPayees.size());
		}
		catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERY_GET_PAYEES_BY_ISSUING);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERY_GET_PAYEES_BY_ISSUING);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
		return getPayees;
	}
	
	@Override
	public List<TtlbhdesDto> getPayeeExist(String codClieCash ,String codClaseord ,TtlbhdesDto ttlbhdesDto) throws BbvaClientCbdException
	{
		List<TtlbhdesDto> getPayees = new ArrayList<TtlbhdesDto>();
		parameters = new HashMap<String, Object>();
		StringBuilder query=null;
		try
		{
			parameters.put("COD_CLIECASH", codClieCash);
			parameters.put("COD_CLASEORD", codClaseord);
			parameters.put("COD_IDORIGEN", ttlbhdesDto.getCOD_IDORIGEN());
			parameters.put("COD_IDESTINO", ttlbhdesDto.getCOD_IDESTINO());
			
			query = new StringBuilder(QUERY_GET_PAYEES_BY_ISSUING);
			query.append(QUERY_VALIDATEPAYEE);
			
			getPayees = (List<TtlbhdesDto>)jdbcTemplate.query(query.toString(), parameters, new TtlbhdesMapper());
			LogNetCashMovil.logDebugPibee("Consulta realizada OK-> "+getPayees.size());
		}
		catch (DataAccessException e2)
		{
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+query.toString());
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}
		catch (Exception e3)
		{
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+query.toString());
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
		return getPayees;
	}

	@Override
	public void insertDes(TtlbhdesDto desDto) throws BbvaClientCbdException
	{
		parameters = new HashMap<String, Object>();			
		try
		{
			parameters = new HashMap<String, Object>();
			
			parameters.put("COD_CLIECASH", desDto.getCOD_CLIECASH());
			parameters.put("COD_CLASEORD", desDto.getCOD_CLASEORD());
			parameters.put("COD_IDORIGEN", desDto.getCOD_IDORIGEN());
			parameters.put("COD_IDESTINO", desDto.getCOD_IDESTINO());
			parameters.put("DES_DESTINO" , desDto.getDES_DESTINO());
			parameters.put("COD_NIFDESTI", desDto.getCOD_NIFDESTI());
			parameters.put("DES_DOMIDES1", desDto.getDES_DOMIDES1());
			parameters.put("DES_DOMIDES2", desDto.getDES_DOMIDES2());
			parameters.put("DES_DOMIDES3", desDto.getDES_DOMIDES3());
			parameters.put("DES_CPLAZA"  , desDto.getDES_CPLAZA());			
			parameters.put("XTI_CLASEASU", desDto.getXTI_CLASEASU());
			parameters.put("COD_PAISOALF", desDto.getCOD_PAISOALF());
			parameters.put("DES_CUENDEST", desDto.getDES_CUENDEST());
			parameters.put("COD_BANABA"  , desDto.getCOD_BANABA());
			parameters.put("DES_OFICIDES", desDto.getDES_OFICIDES());		
			parameters.put("COD_INSTRUC" , desDto.getCOD_INSTRUC());
			parameters.put("COD_BANCSB"  , desDto.getCOD_BANCSB());
			parameters.put("DES_TITULCTA", desDto.getDES_TITULCTA());
			parameters.put("DES_BANCO"   , desDto.getDES_BANCO());
			parameters.put("DES_INSTRUCC", desDto.getDES_INSTRUCC());
			parameters.put("COD_SWFIT"   , desDto.getCOD_SWFIT());							
			parameters.put("XTI_DOCIDENT", desDto.getXTI_DOCIDENT());
			parameters.put("COD_TELFPROV", desDto.getCOD_TELFPROV());
			parameters.put("DES_PRSCONT",  desDto.getDES_PRSCONT());
			if(desDto.getXSN_FORMPAGO().equals("1"))			
				parameters.put("COD_OFICPLAZ", 0);
			else
				parameters.put("COD_OFICPLAZ", desDto.getCOD_OFICPLAZ());				
			parameters.put("COD_CDNITR"  , "*********");
			parameters.put("COD_SUFPRESE", "***");
			parameters.put("COD_ENTREGA" , desDto.getCOD_ENTREGA ());									
			parameters.put("COD_SUCURENT", desDto.getCOD_SUCURENT());
			parameters.put("COD_COMUNA"  , desDto.getCOD_COMUNA	 ());
			parameters.put("DES_DNOMBER" , desDto.getDES_DNOMBER ());
			parameters.put("XTI_DIDEBCOT", desDto.getXTI_DIDEBCOT());
			parameters.put("XTI_DIDEBCOI", desDto.getXTI_DIDEBCOI());
			parameters.put("COD_BANCINTE", desDto.getCOD_BANCINTE());
			parameters.put("DES_DDIRECC", desDto.getDES_DDIRECC());
			parameters.put("DES_DDIRBCOT", desDto.getDES_DDIRBCOT());
			parameters.put("COD_DPAIBCOI", desDto.getCOD_DPAIBCOI());
			parameters.put("DES_DNOMCO"  , desDto.getDES_DNOMCO  ());
			parameters.put("DES_DDIRBCOI", desDto.getDES_DDIRBCOI());
			parameters.put("DES_DCUEBCOI", desDto.getDES_DCUEBCOI());
			parameters.put("COD_GASTODES", desDto.getCOD_GASTODES());			
			parameters.put("COD_PRSCONT" , desDto.getCOD_PRSCONT ());
			parameters.put("DES_EMAIL"   , desDto.getDES_EMAIL	 ());	
			parameters.put("XSN_FORMPAGO", desDto.getXSN_FORMPAGO());		
			parameters.put("AUD_USUARIO" , desDto.getAUD_USUARIO ());
			
			int resp=jdbcTemplate.update(QUERY_INSERT_PAYEE_DES, parameters);
			LogNetCashMovil.logDebugPibee("Elemento creado OK-> "+resp);
		}
		catch (DataAccessException e2)
		{
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERY_INSERT_PAYEE_DES);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e2.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}
		catch (Exception e3)
		{
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: "+QUERY_INSERT_PAYEE_DES);
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
	}
}
