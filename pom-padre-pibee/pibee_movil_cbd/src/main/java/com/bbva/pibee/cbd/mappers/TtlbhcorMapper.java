package com.bbva.pibee.cbd.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.UtilDto;
import com.bbva.pibee.dto.cbd.TtlbhcorDto;

public class TtlbhcorMapper extends UtilDto implements RowMapper<TtlbhcorDto>{

	public TtlbhcorMapper() {
		super(TtlbhcorDto.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TtlbhcorDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		TtlbhcorDto dto = new TtlbhcorDto();
		try {
			dto.setCOD_IDORDEN(rs.getString(getValueField("COD_IDORDEN")));
			dto.setCOD_CLIECASH(rs.getString(getValueField("COD_CLIECASH")));
			dto.setCOD_CLASEORD(rs.getString(getValueField("COD_CLASEORD")));
			dto.setCOD_CABECORI(rs.getInt(getValueField("COD_CABECORI")));
			dto.setCOD_CDNITR(rs.getString(getValueField("COD_CDNITR")));
			dto.setCOD_SUFPRESE(rs.getString(getValueField("COD_SUFPRESE")));
			dto.setCOD_IDORIGEN(rs.getString(getValueField("COD_IDORIGEN")));
			dto.setDES_CUENORIG(rs.getString(getValueField("DES_CUENORIG")));
			dto.setCOD_BANCINTE(rs.getString(getValueField("COD_BANCITE")));
			dto.setCOD_BANCSB(rs.getInt(getValueField("COD_BANCSB")));
			dto.setCOD_DIISOALF(rs.getString(getValueField("COD_DIISOLAF")));
			dto.setCOD_FORMASUN(rs.getInt(getValueField("COD_FORMASUN")));
			dto.setXTI_CLASEASU(rs.getString(getValueField("XTI_CLASEASU")));
			dto.setCOD_SWIFT(rs.getString(getValueField("COD_SWIFT")));
			dto.setCOD_BANABA(rs.getString(getValueField("COD_BANABA")));
			dto.setDES_FICHEROH(rs.getString(getValueField("DES_FICHEROH")));
			dto.setAUD_FMODIFIC(rs.getDate(getValueField("AUD_FMODIFIC")));
			dto.setAUD_USUARIO(rs.getString(getValueField("AUD_USUARIO")));
			dto.setXTI_EMISOR(rs.getString(getValueField("XTI_EMISOR")));
			dto.setDES_ORDPAGO(rs.getString(getValueField("DES_ORDPAGO")));
			dto.setXTI_INDMODAL(rs.getString(getValueField("XTI_INDMODAL")));
		}catch (SQLException e) {
			LogNetCashMovil.logErrorPibee("Error en mapper TtlbhcorMapper "+e.getMessage());
			throw new SQLException(e);
		}catch (Exception e2) {
			LogNetCashMovil.logErrorPibee("Error en mapper TtlbhcorMapper "+e2.getMessage());
			throw new SQLException(e2);
		} 
		return dto;
	}

}
