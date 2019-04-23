package com.bbva.pibee.cbd.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.UtilDto;
import com.bbva.pibee.dto.cbd.TtlclfacDto;

public class TtlclfacMapper extends UtilDto implements RowMapper<TtlclfacDto>
{
	public TtlclfacMapper() 
	{
		super(TtlclfacDto.class);	
	}
	
	@Override
	public TtlclfacDto mapRow(ResultSet rs, int arg1) throws SQLException 
	{
		TtlclfacDto dto = new TtlclfacDto();
		
		try
		{
			dto.setCOD_CLIECASH(rs.getString(getValueField("COD_CLIECASH")));
			dto.setDES_CUENORIG(rs.getString(getValueField("DES_CUENORIG")));			
			dto.setCOD_USUARIO(rs.getString(getValueField("COD_USUARIO")));
			dto.setAUD_FMODIFIC(rs.getString(getValueField("AUD_FMODIFIC")));
			dto.setAUD_USUARIO(rs.getString(getValueField("AUD_USUARIO")));
		}catch (SQLException e) {
			LogNetCashMovil.logErrorPibee("Error en mapper TtlclfacMapper "+e.getMessage());
			throw new SQLException(e);
		}catch (Exception e2) {
			LogNetCashMovil.logErrorPibee("Error en mapper TtlclfacMapper "+e2.getMessage());
			throw new SQLException(e2);
		} 
		
		return dto;
	}
}
