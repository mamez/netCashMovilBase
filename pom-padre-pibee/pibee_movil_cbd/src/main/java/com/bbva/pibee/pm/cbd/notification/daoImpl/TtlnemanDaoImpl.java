package com.bbva.pibee.pm.cbd.notification.daoImpl;

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
import com.bbva.pibee.cbd.mappers.TtlnemanMapper;
import com.bbva.pibee.dto.cbd.prueba.TtlnemanDto;
import com.bbva.pibee.pm.cbd.notification.dao.TtlnemanDao;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.CodClientException;

@ClientBd
public class TtlnemanDaoImpl implements TtlnemanDao {
	
	public static Logger logger = Logger.getLogger("pibee");
	
	static final String GET_ALL="SELECT * FROM TTLNEMAN";
	
	@Autowired
	@Qualifier("BNCMCOnamedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	private Map<String, Object> parameters;	

	@Override
	public List<TtlnemanDto> getAllTtlneman() throws BbvaClientCbdException {
		
		List<TtlnemanDto> resp= null;
		try {
			 resp=(List<TtlnemanDto>)this.jdbcTemplate.query(GET_ALL, new TtlnemanMapper());
		}catch (EmptyResultDataAccessException e) {
			logger.debug("El usuario   no existe");
		} catch (DataAccessException e2) {
			LogNetCashMovil.logErrorPibee("ERROR AL EJECUTAR SQL: ");
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e2);
		}catch (Exception e3) {
			LogNetCashMovil.logErrorPibee("Detalle error: "+e3.getMessage());
			throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR, e3);
		}
		
		return resp;
	}
	

	@Override
	public TtlnemanDto getTtlneman(String idOrden) throws BbvaClientCbdException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTtlneman(String idOrden) throws BbvaClientCbdException {
		// TODO Auto-generated method stub

	}

}
