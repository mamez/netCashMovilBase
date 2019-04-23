package com.bbva.pibee.pm.cbd.notification.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.UtilDto;
import com.bbva.pibee.dto.notification.NotificationDto;

public class NotificationMapper extends UtilDto implements RowMapper<NotificationDto>
{
	public NotificationMapper()
	{
		super(NotificationDto.class);
	}
	
	@Override
	public NotificationDto mapRow(ResultSet rs, int rowNum) throws SQLException 
	{	
		NotificationDto dto = new NotificationDto();
		try {
			
			
			dto.setID_NOTI(rs.getString(getValueField("ID_NOTI")));
			dto.setDATE_NOTI(rs.getString(getValueField("DATE_NOTI")));
			dto.setSTATE_NOTI(rs.getString(getValueField("STATE_NOTI")));
			dto.setTITLE_NOTI(rs.getString(getValueField("TITLE_NOTI")));
			dto.setDESCRIPTION_NOTI(rs.getString(getValueField("DESCRIPTION_NOTI")));		
			dto.setFK_CONFIGURATION(rs.getInt(getValueField("FK_CONFIGURATION")));
			dto.setCODE_TRAN(rs.getString(getValueField("CODE_TRAN")));
			dto.setORIGIN_NOTI(rs.getString(getValueField("ORIGIN_NOTI")));
			
			
		}catch (SQLException e) {
			LogNetCashMovil.logErrorPibee("Error en mapper FilesMapper "+e.getMessage());
			throw new SQLException(e);
		}catch (Exception e2) {
			LogNetCashMovil.logErrorPibee("Error en mapper FilesMapper "+e2.getMessage());
			throw new SQLException(e2);
		}
		return dto; 
	}
}
