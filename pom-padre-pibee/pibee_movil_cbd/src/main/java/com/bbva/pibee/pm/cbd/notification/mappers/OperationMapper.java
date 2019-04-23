package com.bbva.pibee.pm.cbd.notification.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.UtilDto;
import com.bbva.pibee.dto.notification.ConfigurationDto;
import com.bbva.pibee.dto.notification.OperationDto;

public class OperationMapper extends UtilDto implements RowMapper<OperationDto> 
{
	public OperationMapper()
	{
		super(OperationDto.class);
	}
	
	@Override
	public OperationDto mapRow(ResultSet rs, int rowNum) throws SQLException 
	{	
		OperationDto dto = new OperationDto();
		ConfigurationDto config = new ConfigurationDto();
		
		try
		{
			dto.setID_OPE(rs.getInt(getValueField("ID_OPE")));
			dto.setCOD_OPE(rs.getString(getValueField("COD_OPE")));
			dto.setNAME_OPE(rs.getString(getValueField("NAME_OPE")));
			dto.setACTION_OPE(rs.getString(getValueField("ACTION_OPE")));
			dto.setSTATE_OPE(rs.getString(getValueField("STATE_OPE")));			
			dto.setFK_SERVICES(rs.getInt(getValueField("FK_SERVICES")));
			config.setID_CONF(rs.getInt("ID_CONF"));
			config.setSTATE_CONF(rs.getString("STATE_CONF"));
			if(!rs.wasNull())
			{
				dto.setConfigurationDto(config);  
			}
		}
		catch (SQLException e) {
			LogNetCashMovil.logErrorPibee("Error en mapper OperationMapper "+e.getMessage());
			throw new SQLException(e);
		}catch (Exception e2) {
			LogNetCashMovil.logErrorPibee("Error en mapper OperationMapper "+e2.getMessage());
			throw new SQLException(e2);
		}	
		
		return dto;
	}
}
