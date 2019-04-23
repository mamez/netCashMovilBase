package com.bbva.pibee.pm.cbd.notification.mappers;

import java.io.ObjectInputStream.GetField;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.UtilDto;
import com.bbva.pibee.dto.notification.UserDto;

public class UserMapper extends UtilDto implements RowMapper<UserDto> 
{
	public UserMapper()
	{
		super(UserDto.class);
	}

	@Override
	public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		UserDto dto = new UserDto();
		try {
			dto.setREFERENCE_USU(rs.getString(getValueField("REFERENCE_USU")));
			dto.setID_USU(rs.getString(getValueField("ID_USU")));
			dto.setDEVICE_USU(rs.getString(getValueField("DEVICE_USU")));
			dto.setTOKEN_USU(rs.getString(getValueField("TOKEN_USU")));
			dto.setPLATFORM_USU(rs.getString(getValueField("PLATFORM_USU")));
			dto.setVERSION_USU(rs.getString(getValueField("VERSION_USU")));	
			dto.setCREATIONDATE_USU(rs.getString(getValueField("CREATIONDATE_USU")));
			dto.setMODIFIDATE_USU(rs.getString(getValueField("MODIFIDATE_USU")));
			dto.setSTATE_USU(rs.getString(getValueField("STATE_USU")));
			dto.setENROLLMENT(rs.getString(getValueField("ENROLLMENT")));
			
			return dto;
		} catch (SQLException e) {
			LogNetCashMovil.logErrorPibee("Error en mapper FilesMapper "+e.getMessage());
			throw new SQLException(e);
		}catch (Exception e2) {
			LogNetCashMovil.logErrorPibee("Error en mapper FilesMapper "+e2.getMessage());
			throw new SQLException(e2);
		}
		
	}
	
}
