package com.bbva.pibee.cbd.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.UtilDto;
import com.bbva.pibee.dto.cbd.OperationIdGeneratorDto;

public class OperationIdGeneratorMapper extends UtilDto implements RowMapper<OperationIdGeneratorDto>{

	public OperationIdGeneratorMapper() {
		super(OperationIdGeneratorDto.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public OperationIdGeneratorDto mapRow(ResultSet rs, int arg1) throws SQLException {
		
		OperationIdGeneratorDto dto = new OperationIdGeneratorDto();
		
		try{
			dto.setCOD_IDENTIFI(rs.getString("COD_IDENTIFI"));
			dto.setCOD_LOCALIZA(rs.getString("COD_LOCALIZA"));
			dto.setCOD_CCONTROL(rs.getString("COD_CCONTROL"));
			dto.setQNU_IDORDEN(rs.getLong("QNU_IDORDEN"));
			dto.setQNU_IDORDEN2(rs.getString("QNU_IDORDEN2"));
			dto.setAUD_FMODIFIC(rs.getDate("AUD_FMODIFIC"));
			dto.setAUD_USUARIO(rs.getString("AUD_USUARIO"));
			
		}catch (SQLException e) {
			LogNetCashMovil.logErrorPibee("Error en mapper OperationIdGeneratorMapper "+e.getMessage());
			throw new SQLException(e);
		}catch (Exception e2) {
			LogNetCashMovil.logErrorPibee("Error en mapper OperationIdGeneratorMapper "+e2.getMessage());
			throw new SQLException(e2);
		}
		
		return dto;
	}

}
