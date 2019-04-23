package com.bbva.pibee.pm.cbd.notification.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.UtilDto;
import com.bbva.pibee.dto.notification.ServicesDto;

public class ServicesMapper extends UtilDto implements RowMapper<ServicesDto>
{
	public ServicesMapper()
	{
		super(ServicesDto.class);
	}

	@Override
	public ServicesDto mapRow(ResultSet rs, int rowNum) throws SQLException 
	{	
		ServicesDto dto = new ServicesDto();		
		
		try
		{
			dto.setID_SER(rs.getInt(getValueField("ID_SER")));
			dto.setNAME_SER(rs.getString(getValueField("NAME_SER")));
		}
		catch (SQLException e) {
			LogNetCashMovil.logErrorPibee("Error en mapper ServicesMapper "+e.getMessage());
			throw new SQLException(e);
		}catch (Exception e2) {
			LogNetCashMovil.logErrorPibee("Error en mapper ServicesMapper "+e2.getMessage());
			throw new SQLException(e2);
		}	
		
		return dto;
	}
}
