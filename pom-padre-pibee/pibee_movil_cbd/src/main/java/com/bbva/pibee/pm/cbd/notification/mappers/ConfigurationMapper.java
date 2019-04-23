package com.bbva.pibee.pm.cbd.notification.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.UtilDto;
import com.bbva.pibee.dto.notification.ConfigurationDto;

public class ConfigurationMapper extends UtilDto implements RowMapper<ConfigurationDto> 
{

	public ConfigurationMapper()
	{
		super(ConfigurationDto.class);
	}

	@Override 
	public ConfigurationDto mapRow(ResultSet rs, int rowNum) throws SQLException 
	
	{		ConfigurationDto dto = new ConfigurationDto();	
		try {
				
			dto.setID_CONF(rs.getInt(getValueField("ID_CONF")));
			dto.setSTATE_CONF(rs.getString(getValueField("STATE_CONF")));
			dto.setREFERENCE_USU(rs.getString(getValueField("REFERENCE_USU")));
			dto.setID_USU(rs.getString(getValueField("ID_USU")));
			dto.setDATE_AUDI(rs.getString(getValueField("DATE_AUDI")));
			dto.setFK_OPERATION(rs.getInt(getValueField("FK_OPERATION")));

		} catch (SQLException e) {
			LogNetCashMovil.logErrorPibee("Error en mapper FilesMapper "+e.getMessage());
			throw new SQLException(e);
		}catch (Exception e2) {
			LogNetCashMovil.logErrorPibee("Error en mapper FilesMapper "+e2.getMessage());
			throw new SQLException(e2);
	  }
		return dto;
	}
}



