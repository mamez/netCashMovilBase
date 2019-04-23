package com.bbva.pibee.cbd.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.UtilDto;
import com.bbva.pibee.dto.cbd.TtlbhfuaDto;

public class TtlbhfuaMapper extends UtilDto implements RowMapper<TtlbhfuaDto> {

	public TtlbhfuaMapper() {
		super(TtlbhfuaDto.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TtlbhfuaDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		TtlbhfuaDto dto = new TtlbhfuaDto();
		try {
		dto.setCOD_CLIECASH(rs.getString(getValueField("COD_CLIECASH")));
		dto.setCOD_CLASEORD(rs.getString(getValueField("COD_CLASEORD")));
		dto.setCOD_IDORDEN(rs.getString(getValueField("COD_IDORDEN")));
		dto.setCOD_ACCION(rs.getInt(getValueField("COD_ACCION")));
		dto.setCOD_IDACCION(rs.getInt(getValueField("COD_IDACCION")));
		dto.setCOD_USUARIO(rs.getString(getValueField("COD_USUARIO")));
		dto.setFEC_ACCIO(rs.getString(getValueField("FEC_ACCIO")));
		dto.setCOD_USUSFIRMA(rs.getString(getValueField("COD_USUFIRMA")));
		dto.setCOD_USUPODER(rs.getString(getValueField("COD_USUPODER")));
		dto.setCOD_ESTADFIC(rs.getString(getValueField("COD_ESTADFIC")));
		dto.setFEC_ACCION(rs.getString(getValueField("FEC_ACCION")));
		dto.setAUD_FMODIFIC(rs.getString(getValueField("AUD_FMODIFIC")));
		dto.setAUD_USUARIO(rs.getString(getValueField("AUD_USUARIO")));
		dto.setCOD_IPCLIENT(rs.getString(getValueField("COD_IPCLIENT")));
		}catch (SQLException e) {
			LogNetCashMovil.logErrorPibee("Error en mapper TtlbhfuaMapper "+e.getMessage());
			throw new SQLException(e);
		}catch (Exception e2) {
			LogNetCashMovil.logErrorPibee("Error en mapper TtlbhfuaMapper "+e2.getMessage());
			throw new SQLException(e2);
		} 
		return dto;
	}

}
