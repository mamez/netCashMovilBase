package com.bbva.pibee.cbd.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.UtilDto;
import com.bbva.pibee.dto.cbd.OperationSignerDto;

public class OperationSignerMapper extends UtilDto implements RowMapper<OperationSignerDto>
{
	public OperationSignerMapper() 
	{
		super(OperationSignerDto.class);	
	}
	
	@Override
	public OperationSignerDto mapRow(ResultSet rs, int arg1) throws SQLException 
	{
		OperationSignerDto dto = new OperationSignerDto();
		
		try
		{
			dto.setCOD_CLIECASH(rs.getString(getValueField("COD_CLIECASH")));
			dto.setCOD_CLASEORD(rs.getString(getValueField("COD_CLASEORD")));
			dto.setCOD_IDORDEN(rs.getString(getValueField("COD_IDORDEN")));			
			dto.setCOD_USUARIO(rs.getString(getValueField("COD_USUARIO")));
			dto.setCOD_NUMALEAT(rs.getString(getValueField("COD_NUMALEAT")));
			dto.setXSN_FIRMADO(rs.getString(getValueField("XSN_FIRMADO")));
			dto.setAUD_FMODIFIC(rs.getString(getValueField("AUD_FMODIFIC")));
			dto.setAUD_USUARIO(rs.getString(getValueField("AUD_USUARIO")));
			
		}catch (SQLException e) {
			LogNetCashMovil.logErrorPibee("Error en mapper OperationSignerMapper "+e.getMessage());
			throw new SQLException(e);
		}catch (Exception e2) {
			LogNetCashMovil.logErrorPibee("Error en mapper OperationSignerMapper "+e2.getMessage());
			throw new SQLException(e2);
		} 
		
		return dto;
	}	
}
