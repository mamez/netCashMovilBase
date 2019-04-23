package com.bbva.pibee.cbd.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bbva.pibee.arq.annotations.UtilDto;
import com.bbva.pibee.dto.cbd.prueba.TtlnemanDto;

public class TtlnemanMapper extends UtilDto implements RowMapper<TtlnemanDto>{

	public TtlnemanMapper() {
		super(TtlnemanDto.class);
	}

	@Override
	public TtlnemanDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		TtlnemanDto dto= new TtlnemanDto();
		dto.setIdOrden(rs.getString(getValueField("idOrden").trim()));
		dto.setReferencia(rs.getString(getValueField("referencia").trim()));
		return dto;
	}

}
