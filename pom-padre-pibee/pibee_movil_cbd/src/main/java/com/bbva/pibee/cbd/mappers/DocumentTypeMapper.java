package com.bbva.pibee.cbd.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.UtilDto;
import com.bbva.pibee.dto.cbd.DocumentTypeDto;

public class DocumentTypeMapper extends UtilDto implements RowMapper<DocumentTypeDto>
{
	public DocumentTypeMapper()
	{
		super(DocumentTypeDto.class);
	}
	
	public DocumentTypeDto mapRow(ResultSet rs , int arg1) throws SQLException
	{
		DocumentTypeDto dto = new DocumentTypeDto();
		try
		{
			dto.setCOD_BANCOGBL(rs.getInt(getValueField("COD_BANCOGBL")));
			dto.setXTI_DOCIDLEG(rs.getString(getValueField("XTI_DOCIDLEG")));
			dto.setXTI_PERSFISC(rs.getString(getValueField("XTI_PERSFISC")));
			dto.setDES_DOCIDLEG(rs.getString(getValueField("DES_DOCIDLEG")));
			dto.setAUD_FMODIFIC(rs.getString(getValueField("AUD_FMODIFIC")));
			dto.setAUD_USUARIO(rs.getString(getValueField("AUD_USUARIO")));
			dto.setCOD_IDIOMA(rs.getString(getValueField("COD_IDIOMA")));			
		}catch (SQLException e) {
			LogNetCashMovil.logErrorPibee("Error en mapper DocumentTypeMapper "+e.getMessage());
			throw new SQLException(e);
		}catch (Exception e2) {
			LogNetCashMovil.logErrorPibee("Error en mapper DocumentTypeMapper "+e2.getMessage());
			throw new SQLException(e2);
		}
		return dto;
	}
}
