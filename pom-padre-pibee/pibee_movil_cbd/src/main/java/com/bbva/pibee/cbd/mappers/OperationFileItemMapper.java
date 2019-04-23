package com.bbva.pibee.cbd.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.UtilDto;
import com.bbva.pibee.dto.cbd.OperationFileItemDto;

public class OperationFileItemMapper extends UtilDto implements RowMapper<OperationFileItemDto>{

	public OperationFileItemMapper() {
		super(OperationFileItemDto.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public OperationFileItemDto mapRow(ResultSet rs, int arg1) throws SQLException {
		OperationFileItemDto fileItem = new OperationFileItemDto();
		try {
		fileItem.setCOD_CANALDI(rs.getInt("COD_CANALDI"));
		fileItem.setCOD_BANCOINT(rs.getInt("COD_BANCOINT"));
		fileItem.setCOD_LOGONAPL(rs.getString("COD_LOGONAPL"));
		fileItem.setXTI_BUZON(rs.getString("XTI_BUZON"));
		fileItem.setQNU_NUMITEM(rs.getLong("QNU_NUMITEM"));
		fileItem.setFEC_RECEPCIO(rs.getDate("FEC_RECEPCIO"));
		fileItem.setHMS_RECEPCIO(rs.getString("HMS_RECEPCIO"));
		fileItem.setAUD_USUARIO(rs.getString("AUD_USUARIO"));
		fileItem.setAUD_FMODIFIC(rs.getDate("AUD_FMODIFIC"));		
		fileItem.setCOD_PID(rs.getInt("COD_PID"));
		}catch (SQLException e) {
			LogNetCashMovil.logErrorPibee("Error en mapper OperationFileItemMapper "+e.getMessage());
			throw new SQLException(e);
		}catch (Exception e2) {
			LogNetCashMovil.logErrorPibee("Error en mapper OperationFileItemMapper "+e2.getMessage());
			throw new SQLException(e2);
		}
		return fileItem;
	}



}
