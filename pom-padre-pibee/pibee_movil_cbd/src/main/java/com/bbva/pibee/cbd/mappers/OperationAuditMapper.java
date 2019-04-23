package com.bbva.pibee.cbd.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.UtilDto;
import com.bbva.pibee.dto.cbd.OperationAuditDto;

public class OperationAuditMapper extends UtilDto implements RowMapper<OperationAuditDto>
{
	public OperationAuditMapper() 
	{
		super(OperationAuditDto.class);	
	}
	
	@Override
	public OperationAuditDto mapRow(ResultSet rs, int arg1) throws SQLException 
	{
		OperationAuditDto dto = new OperationAuditDto();
		
		try
		{
			dto.setCOD_CLIECASH(rs.getString(getValueField("COD_CLIECASH")));
			dto.setCOD_CLASEORD(rs.getString(getValueField("COD_CLASEORD")));
			dto.setCOD_IDORDEN(rs.getString(getValueField("COD_IDORDEN")));
			dto.setCOD_ACCION(rs.getInt(getValueField("COD_ACCION")));
			dto.setCOD_IDACCION(rs.getInt(getValueField("COD_IDACCION")));
			dto.setCOD_USUARIO(rs.getString(getValueField("COD_USUARIO")));
			dto.setFEC_ACCIO(rs.getDate(getValueField("FEC_ACCIO")));
			dto.setCOD_USUFIRMA(rs.getString(getValueField("COD_USUFIRMA")));
			dto.setCOD_USUPODER(rs.getString(getValueField("COD_USUPODER")));
			dto.setCOD_ESTADFIC(rs.getString(getValueField("COD_ESTADFIC")));
			dto.setFEC_ACCION(rs.getDate(getValueField("FEC_ACCION")));
			dto.setAUD_FMODIFIC(rs.getDate(getValueField("AUD_FMODIFIC")));
			dto.setAUD_USUARIO(rs.getString(getValueField("AUD_USUARIO")));
			dto.setCOD_IPCLIENT(rs.getString(getValueField("COD_IPCLIENT")));
			dto.setCOD_APPORIG(rs.getString(getValueField("COD_APPORIG")));
		}catch (SQLException e) {
			LogNetCashMovil.logErrorPibee("Error en mapper OperationAuditMapper "+e.getMessage());
			throw new SQLException(e);
		}catch (Exception e2) {
			LogNetCashMovil.logErrorPibee("Error en mapper OperationAuditMapper "+e2.getMessage());
			throw new SQLException(e2);
		}
		
		return dto;
	}
}
