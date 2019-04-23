package com.bbva.pibee.pm.cbd.notification.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bbva.mapper.util.MapperUtil;
import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.UtilDto;
import com.bbva.pibee.dto.notification.GenericServicesDto;

public class GenericServicesMapper extends UtilDto implements RowMapper<GenericServicesDto> {

	public GenericServicesMapper() {
		super(GenericServicesDto.class);
		
	}

	@Override
	public GenericServicesDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		GenericServicesDto dto = new GenericServicesDto();
		try {			
			dto.setID_SER(rs.getInt(getValueField("ID_SER")));
			dto.setNAME_SER(rs.getString(getValueField("NAME_SER")));
			dto.setID_OPE(rs.getInt(getValueField("ID_OPE")));
			dto.setCOD_OPE(rs.getString(getValueField("COD_OPE")));
			dto.setNAME_OPE(rs.getString(getValueField("NAME_OPE")));
			dto.setACTION_OPE(rs.getString(getValueField("ACTION_OPE")));
			String configuracion= MapperUtil.getValueFromResultSet(rs, getValueField("STATE_CONFIGURATION"), "uncheck");
			dto.setSTATE_CONFIGURATION(configuracion);
			Long idConfiguration=MapperUtil.getValueFromResultSet(rs, getValueField("ID_CONFIGURATION"), new Long(0));
			dto.setID_CONFIGURATION(Integer.parseInt(Long.toString(idConfiguration)));
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
