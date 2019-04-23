package com.bbva.pibee.cbd.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.UtilDto;
import com.bbva.pibee.dto.cbd.TtlbhcuoDto;

public class TtlbhcuoMapper extends UtilDto implements RowMapper<TtlbhcuoDto>{

	public TtlbhcuoMapper() {
		super(TtlbhcuoDto.class);
	}

	@Override
	public TtlbhcuoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		TtlbhcuoDto dto = new TtlbhcuoDto();
		
		try {
			
			dto.setCOD_CLIECASH(rs.getString(getValueField("COD_CLIECASH")));
			dto.setCOD_CLASEORD(rs.getString(getValueField("COD_CLASEORD")));
			dto.setCOD_CDNITR(rs.getString(getValueField("COD_CDNITR")));
			dto.setCOD_SUFPRESE(rs.getString(getValueField("COD_SUFPRESE")));
			dto.setCOD_IDORIGEN(rs.getString(getValueField("COD_IDORIGEN")));
			dto.setDES_CUENORIG(rs.getString(getValueField("DES_CUENORIG").trim()));
			dto.setCOD_BANCINTE(rs.getString(getValueField("COD_BANCINTE")));
			dto.setCOD_BANCASH(rs.getString(getValueField("COD_BANCASH")));
			dto.setCOD_BANCSB(rs.getInt(getValueField("COD_BANCSB")));
			dto.setCOD_SWIFT(rs.getString(getValueField("COD_SWIFT")));
			dto.setCOD_BANABA(rs.getString(getValueField("COD_BANABA")));
			dto.setCOD_DIISOALF(rs.getString(getValueField("COD_DIISOALF")));
			dto.setCOD_FORMASUN(rs.getInt(getValueField("COD_FORMASUN")));
			dto.setXTI_CLASEASU(rs.getString(getValueField("XTI_CLASEASU")));
			dto.setAUD_FMODIFIC(rs.getString(getValueField("AUD_FMODIFIC")));
			dto.setAUD_USUARIO(rs.getString(getValueField("AUD_USUARIO")));
			
		}catch (SQLException e) {
			LogNetCashMovil.logErrorPibee("Error en mapper TtlbhcuoMapper "+e.getMessage());
			throw new SQLException(e);
		}catch (Exception e2) {
			LogNetCashMovil.logErrorPibee("Error en mapper TtlbhcuoMapper "+e2.getMessage());
			throw new SQLException(e2);
		} 
		return dto;
	}

}









