package com.bbva.pibee.cbd.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.UtilDto;
import com.bbva.pibee.dto.cbd.TtlbhdorDto;

public class TtlbhdorMapper extends UtilDto implements RowMapper<TtlbhdorDto>{
	
	public TtlbhdorMapper(){
		super (TtlbhdorDto.class);
	}

	@Override
	public TtlbhdorDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		TtlbhdorDto dto = new TtlbhdorDto();
		
		try {
			dto.setCOD_CLIECASH(rs.getString(getValueField("COD_CLIECASH")));
			dto.setCOD_CLASEORD(rs.getString(getValueField("COD_CLASEORD")));
			dto.setCOD_IDORDEN(rs.getString(getValueField("COD_IDORDEN")));
			dto.setCOD_CABECORI(rs.getInt(getValueField("COD_CABECORI")));
			dto.setCOD_DETALL(rs.getInt(getValueField("COD_DETALL")));
			dto.setCOD_ORIGE(rs.getString(getValueField("COD_ORIGE")));
			dto.setIMP_IMPORIVA(rs.getDouble(getValueField("IMP_IMPORIVA")));
			dto.setQTY_DETALLE(rs.getDouble(getValueField("QTY_DETALLE")));
			dto.setCOD_DIISOALF(rs.getString(getValueField("COD_DIISOALF")));
			dto.setFEC_VALOCASH(rs.getString(getValueField("FEC_VALOCASH")));
			dto.setQNU_TIPCAMBI(rs.getDouble(getValueField("QNU_TIPCAMBI")));
			dto.setCOD_REFDETAL(rs.getString(getValueField("COD_REFDETAL")));
			dto.setCOD_REFDOCUM(rs.getString(getValueField("COD_REFDOCUM")));
			dto.setXSN_GASTOS(rs.getString(getValueField("XSN_GASTOS")));
			dto.setXSN_FORMPAGO(rs.getString(getValueField("XSN_FORMPAGO")));
			dto.setFEC_EXPEDICI(rs.getString(getValueField("FEC_EXPEDICI")));
			dto.setQNU_NUMPAGOS(rs.getString(getValueField("QNU_NUMPAGOS")));
			dto.setFEC_VENCCASH(rs.getString(getValueField("FEC_VENCCASH")));
			dto.setCOD_DEVOLORD(rs.getString(getValueField("COD_DEVOLORD")));
			dto.setDES_MOTIVDEV(rs.getString(getValueField("DES_MOTIVDEV")));
			dto.setDES_MOTIVDEL(rs.getString(getValueField("DES_MOTIVDEL")));
			dto.setXSN_CONCEPTO(rs.getString(getValueField("XSN_CONCEPTO")));
			dto.setFEC_ORIGENOR(rs.getString(getValueField("FEC_ORIGENOR")));
			dto.setCOD_REFSEGUR(rs.getString(getValueField("COD_REFSEGUR")));
			dto.setXTI_INSTRUCC(rs.getString(getValueField("XTI_INSTRUCC")));
			dto.setCOD_MOTPAGOD(rs.getString(getValueField("COD_MOTPAGOD")));
			dto.setCOD_REFINTER(rs.getString(getValueField("COD_REFINTER")));
			dto.setXTI_PROVEDOR(rs.getString(getValueField("XTI_PROVEDOR")));
			dto.setDES_FACTURA(rs.getString(getValueField("DES_FACTURA")));
			dto.setCOD_FACTURA(rs.getString(getValueField("COD_FACTURA")));
			dto.setFEC_FACTURA(rs.getString(getValueField("FEC_FACTURA")));
			dto.setDES_FICHEROH(rs.getString(getValueField("DES_FICHEROH")));
			dto.setAUD_FMODIFIC(rs.getDate(getValueField("AUD_FMODIFIC")));
			dto.setAUD_USUARIO(rs.getString(getValueField("AUD_USUARIO")));
			dto.setIMP_CUOTTA(rs.getDouble(getValueField("IMP_CUOTTA")));
			dto.setQTY_CUOTA(rs.getDouble(getValueField("QTY_CUOTA")));
			dto.setQTY_PRIMCUOT(rs.getDouble(getValueField("QTY_PRIMCUOT")));
			dto.setXTI_INACELER(rs.getString(getValueField("XTI_INACELER")));
			dto.setCOD_OFICPLAZ(rs.getInt(getValueField("COD_OFICPLAZ")));
			dto.setQTY_CONCEPTO(rs.getInt(getValueField("QTY_CONCEPTO")));
			dto.setCOD_LNUMERO(rs.getString(getValueField("COD_LNUMERO")));
			dto.setDES_CPTO144(rs.getString(getValueField("DES_CPTO144")));
		}catch (SQLException e) {
			LogNetCashMovil.logErrorPibee("Error en mapper TtlbhdorMapper "+e.getMessage());
			throw new SQLException(e);
		}catch (Exception e2) {
			LogNetCashMovil.logErrorPibee("Error en mapper TtlbhdorMapper "+e2.getMessage());
			throw new SQLException(e2);
		} 
		return dto;
	}
}
