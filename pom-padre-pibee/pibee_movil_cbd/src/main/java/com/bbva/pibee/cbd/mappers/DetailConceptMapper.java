package com.bbva.pibee.cbd.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.UtilDto;
import com.bbva.pibee.dto.cbd.DetailConceptDto;


public class DetailConceptMapper extends UtilDto implements RowMapper<DetailConceptDto>{

	public DetailConceptMapper() {
		super(DetailConceptDto.class);
	}

	@Override
	public DetailConceptDto mapRow(ResultSet rs, int arg1) throws SQLException {
		DetailConceptDto dto = new DetailConceptDto();		
		
		try{
			dto.setCOD_CLIECASH(rs.getString("COD_CLIECASH"));
			dto.setCOD_CLASEORD(rs.getString("COD_CLASEORD"));
			dto.setCOD_IDORDEN(rs.getString("COD_IDORDEN"));
			dto.setCOD_DETALL(rs.getInt("COD_DETALL"));
			dto.setCOD_IDCONCEP(rs.getInt("COD_IDCONCEP"));
			dto.setCOD_CABECORI(rs.getInt("COD_CABECORI"));
			dto.setDES_CONCCASH(rs.getString("DES_CONCCASH"));
			dto.setIMP_CONCEPTO(rs.getDouble("IMP_CONCEPTO"));
			dto.setXTI_CONCEP(rs.getString("XTI_CONCEP"));
			dto.setFEC_DOCUMENT(rs.getString("FEC_DOCUMENT"));
			//dto.setCOD_NUMDOCUM(rs.getString("COD_NUMDOCUM"));
			dto.setCOD_NUMDOCU(rs.getString("COD_NUMDOCU"));
			dto.setDES_MONBRU(rs.getString("DES_MONBRU"));
			dto.setDES_MONAJU(rs.getString("DES_MONAJU"));
			dto.setDES_MONNET(rs.getString("DES_MONNET"));
			dto.setCOD_CIBENE(rs.getString("COD_CIBENE"));
			dto.setDES_APELLID(rs.getString("DES_APELLID"));
			dto.setCOD_CTABE(rs.getString("COD_CTABE"));
			dto.setPOR_TPCPAGO(rs.getDouble("POR_TPCPAGO"));
			dto.setAUD_FMODIFIC(rs.getDate("AUD_FMODIFIC"));
			dto.setAUD_USUARIO(rs.getString("AUD_USUARIO"));
		}catch (SQLException e) {
			LogNetCashMovil.logErrorPibee("Error en mapper DetailConceptMapper "+e.getMessage());
			throw new SQLException(e);
		}catch (Exception e2) {
			LogNetCashMovil.logErrorPibee("Error en mapper DetailConceptMapper "+e2.getMessage());
			throw new SQLException(e2);
		}
		return dto;
	}
	
	

}
