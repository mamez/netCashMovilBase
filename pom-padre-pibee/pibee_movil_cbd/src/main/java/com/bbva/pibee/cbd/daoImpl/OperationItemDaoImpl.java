package com.bbva.pibee.cbd.daoImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.ClientBd;
import com.bbva.pibee.cbd.dao.OperationItemDao;
import com.bbva.pibee.dto.cbd.OperationItemDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;

@ClientBd
public class OperationItemDaoImpl implements OperationItemDao{

	static final String INSERT_QUERY = "INSERT INTO BDBZ.TBDBZITE VALUES (:QNU_NUMITEM , :QNU_COPIA2, :DES_PATH, :DES_REFERENC, :DES_TIPFICHE, :DES_NOMBRE, "
			+ ":DES_NOMFICHE, :COD_COMREFEX, :TIM_TIMESTAM, :COD_TIPDATO2, :DES_EMISOR, :FEC_ENVIO, "
			+ ":HMS_ENVIO1, :QNU_SIZE, :DES_USUFIRMA, :DES_CABECER1, :COD_BANCOPR, :COD_SUBPRODU, "
			+ ":COD_PRODSERV, :AUD_USUARIO, :AUD_FMODIFIC, :QTY_CONSOLID) ";
	
	@Autowired
	@Qualifier("BTLNECO1namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	private Map<String, Object> parameters;
	
	@Override
	public void createOperationItem(OperationItemDto operationItemDto) throws BbvaClientCbdException {
		try{
			parameters = new HashMap<String, Object>();
			
			parameters.put("QNU_NUMITEM", operationItemDto.getQNU_NUMITEM());
			parameters.put("QNU_COPIA2", operationItemDto.getQNU_COPIA2());
			parameters.put("DES_PATH", operationItemDto.getDES_PATH());
			parameters.put("DES_REFERENC", operationItemDto.getDES_REFERENC());
			parameters.put("DES_TIPFICHE", operationItemDto.getDES_TIPFICHE());
			parameters.put("DES_NOMBRE", operationItemDto.getDES_NOMBRE());
			parameters.put("DES_NOMFICHE", operationItemDto.getDES_NOMFICHE());
			parameters.put("COD_COMREFEX", operationItemDto.getCOD_COMREFEX());
			parameters.put("TIM_TIMESTAM", operationItemDto.getTIM_TIMESTAM());
			parameters.put("COD_TIPDATO2", operationItemDto.getCOD_TIPDATO2());
			parameters.put("DES_EMISOR", operationItemDto.getDES_EMISOR());
			parameters.put("FEC_ENVIO", operationItemDto.getFEC_ENVIO());
			parameters.put("HMS_ENVIO1", operationItemDto.getHMS_ENVIO1());
			parameters.put("QNU_SIZE", operationItemDto.getQNU_SIZE());
			parameters.put("DES_USUFIRMA", operationItemDto.getDES_USUFIRMA());
			parameters.put("DES_CABECER1", operationItemDto.getDES_CABECER1());
			parameters.put("COD_BANCOPR", operationItemDto.getCOD_BANCOPR());
			parameters.put("COD_SUBPRODU", operationItemDto.getCOD_SUBPRODU());
			parameters.put("COD_PRODSERV", operationItemDto.getCOD_PRODSERV());
			parameters.put("AUD_USUARIO", operationItemDto.getAUD_USUARIO());
			parameters.put("AUD_FMODIFIC", operationItemDto.getAUD_FMODIFIC());
			parameters.put("QTY_CONSOLID", operationItemDto.getQTY_CONSOLID());

			int resp=jdbcTemplate.update(INSERT_QUERY, parameters);
			LogNetCashMovil.logDebugPibee("Registros acrualizados "+resp);
			
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
