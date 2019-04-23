package com.bbva.pibee.cbd.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.UtilDto;
import com.bbva.pibee.dto.cbd.BankDto;

public class BankMapper extends UtilDto implements RowMapper<BankDto>
{

	public BankMapper()
	{
		super(BankDto.class);
	}
	@Override
	public BankDto mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		BankDto dto = new BankDto();
		
		try
		{
			dto.setCOD_BANCOGBL(rs.getInt(getValueField("COD_BANCOGBL")));
			dto.setCOD_BANCSB(rs.getInt(getValueField("COD_BANCSB")));
			dto.setDES_DNOMCO(rs.getString(getValueField("DES_DNOMCO")));		
			dto.setXTI_ACTIVIDA(rs.getString(getValueField("XTI_ACTIVIDA")));
			dto.setCOD_BANCOINT(rs.getInt(getValueField("COD_BANCOINT")));
			dto.setAUD_FMODIFIC(rs.getString(getValueField("AUD_FMODIFIC")));
			dto.setAUD_USUARIO(rs.getString(getValueField("AUD_USUARIO")));			
		}catch (SQLException e) {
			LogNetCashMovil.logErrorPibee("Error en mapper BankMapper "+e.getMessage());
			throw new SQLException(e);
		}catch (Exception e2) {
			LogNetCashMovil.logErrorPibee("Error en mapper BankMapper "+e2.getMessage());
			throw new SQLException(e2);
		}		
				
		return dto;
	}

}
