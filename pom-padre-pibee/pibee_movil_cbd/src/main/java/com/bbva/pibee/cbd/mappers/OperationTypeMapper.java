package com.bbva.pibee.cbd.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.dto.response.OperationType;

public class OperationTypeMapper implements RowMapper<OperationType> {

	@Override
	public OperationType mapRow(ResultSet rs, int rowNum) throws SQLException {
		OperationType type = new OperationType();
		try {
		type.setOperationTypeId(rs.getString("COD_CLASEORD"));
		type.setOperationTypeDescription(rs.getString("DES_LITECOR"));
		}catch (SQLException e) {
			LogNetCashMovil.logErrorPibee("Error en mapper OperationTypeMapper "+e.getMessage());
			throw new SQLException(e);
		}catch (Exception e2) {
			LogNetCashMovil.logErrorPibee("Error en mapper OperationTypeMapper "+e2.getMessage());
			throw new SQLException(e2);
		} 
		return type;
	}

}
