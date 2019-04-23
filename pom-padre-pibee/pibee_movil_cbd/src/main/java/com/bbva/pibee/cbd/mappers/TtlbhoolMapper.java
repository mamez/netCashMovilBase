package com.bbva.pibee.cbd.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.UtilDto;
import com.bbva.pibee.dto.cbd.DesOrdenOol;
import com.bbva.pibee.dto.cbd.TtlbhoolDto;
import com.bbva.pibee.util.MapUtilOol;

public class TtlbhoolMapper extends UtilDto implements RowMapper<TtlbhoolDto> {
	
	public TtlbhoolMapper(){
		super (TtlbhoolDto.class);
	}

	@Override
	public TtlbhoolDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		TtlbhoolDto dto = new TtlbhoolDto();
		
		try {
			
			dto.setQNU_NUMITEM(rs.getDouble(getValueField("QNU_NUMITEM")));
			dto.setTIM_ORDEN(rs.getString(getValueField("TIM_ORDEN")));
			dto.setQNU_ORDEN(rs.getInt(getValueField("QNU_ORDEN")));
			dto.setDES_ORDENOL(rs.getString(getValueField("DES_ORDENOL")));
			String tipoOrden=rs.getString(getValueField("COD_TIPORD")).trim();
			dto.setCOD_TIPORD(tipoOrden);
			dto.setCOD_BANCOGBL(rs.getInt(getValueField("COD_BANCOGBL")));
			dto.setAUD_FMODIFIC(rs.getDate(getValueField("AUD_FMODIFIC")));
			dto.setAUD_USUARIO(rs.getString(getValueField("AUD_USUARIO")));
			if(tipoOrden.equalsIgnoreCase("TPO")){
				MapUtilOol<DesOrdenOol> map = new MapUtilOol<DesOrdenOol>();
				dto.setOrderDetail(map.mapOol(DesOrdenOol.class, dto.getDES_ORDENOL()));
			}
			
		}catch (SQLException e) {
			LogNetCashMovil.logErrorPibee("Error en mapper TtlbhoolMapper "+e.getMessage());
			throw new SQLException(e);
		}catch (Exception e2) {
			LogNetCashMovil.logErrorPibee("Error en mapper TtlbhoolMapper "+e2.getMessage());
			throw new SQLException(e2);
		} 
		return dto;
	}
}
