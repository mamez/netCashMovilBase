package com.bbva.pibee.cbd.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.UtilDto;
import com.bbva.pibee.dto.cbd.ViewTbdbdldmDto;

public class ViewTbdbdldmMapper extends UtilDto implements RowMapper<ViewTbdbdldmDto>
{
	public ViewTbdbdldmMapper()
	{
		super(ViewTbdbdldmDto.class);
	}
	
	public ViewTbdbdldmDto mapRow(ResultSet rs, int arg1) throws SQLException
	{
		ViewTbdbdldmDto dto = new ViewTbdbdldmDto();
		try
		{
			dto.setCOD_CATALOG(rs.getString(getValueField("COD_CATALOG").trim()));
			dto.setCOD_CLAVELIT(rs.getString(getValueField("COD_CLAVELIT").trim()));
			dto.setCOD_IDIOMA(rs.getInt(getValueField("COD_IDIOMA")));
			dto.setDES_LITECOR(rs.getString(getValueField("DES_LITECOR").trim()));
			dto.setDES_LITELAR(rs.getString(getValueField("DES_LITELAR").trim()));
			dto.setAUD_USUARIO(rs.getString(getValueField("AUD_USUARIO").trim()));
			dto.setAUD_FMODIFIC(rs.getString(getValueField("AUD_FMODIFIC").trim()));
		}catch (SQLException e) {
			LogNetCashMovil.logErrorPibee("Error en mapper ViewTbdbdldmMapper "+e.getMessage());
			throw new SQLException(e);
		}catch (Exception e2) {
			LogNetCashMovil.logErrorPibee("Error en mapper ViewTbdbdldmMapper "+e2.getMessage());
			throw new SQLException(e2);
		} 
		
		return dto;
	}
}
