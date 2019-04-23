package com.bbva.pibee.cbd.mappers;

import java.sql.ResultSet;

import org.springframework.jdbc.core.RowMapper;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.UtilDto;
import com.bbva.pibee.dto.cbd.TtlbhoriDto;
import java.sql.SQLException;

public class TtlbhoriMapper extends UtilDto implements RowMapper<TtlbhoriDto> 
{
	public TtlbhoriMapper()
	{
		super (TtlbhoriDto.class);
	}
	
	@Override
	public TtlbhoriDto mapRow(ResultSet rs, int arg1) throws SQLException
	{
		TtlbhoriDto dto = new TtlbhoriDto();
		try
		{
			dto.setCOD_CLIECASH(rs.getString(getValueField("COD_CLIECASH")));
			dto.setCOD_CLASEORD(rs.getString(getValueField("COD_CLASEORD")));
			dto.setCOD_CDNITR(rs.getString(getValueField("COD_CDNITR")));
			dto.setCOD_SUFPRESE(rs.getString(getValueField("COD_SUFPRESE")));
			dto.setCOD_IDORIGEN(rs.getString(getValueField("COD_IDORIGEN")));
			dto.setXTI_DOCIDENT(rs.getString(getValueField("XTI_DOCIDENT")));
			dto.setDES_DOCIDENT(rs.getString(getValueField("DES_DOCIDENT")));
			dto.setDES_PRSCONT(rs.getString(getValueField("DES_PRSCONT")));
			dto.setDES_TFNOCONT(rs.getString(getValueField("DES_TFNOCONT")));
			dto.setCOD_PROVINCI(rs.getInt(getValueField("COD_PROVINCI")));
			dto.setDES_ORIGEN(rs.getString(getValueField("DES_ORIGEN")));
			dto.setDES_DOMIORI1(rs.getString(getValueField("DES_DOMIORI1")));
			dto.setDES_DOMIORI2(rs.getString(getValueField("DES_DOMIORI2")));
			dto.setDES_DOMIORI3(rs.getString(getValueField("DES_DOMIORI3")));
			dto.setDES_LOCALI(rs.getString(getValueField("DES_LOCALI")));
			dto.setCOD_CDIPOS(rs.getDouble(getValueField("COD_CDIPOS")));
			dto.setQNU_REFEREN(rs.getDouble(getValueField("QNU_REFEREN")));
			dto.setXSN_REFEREN(rs.getString(getValueField("XSN_REFEREN")));
			dto.setDES_REFEROPE(rs.getString(getValueField("DES_REFEROPE")));
			dto.setXSN_CONCEPTO(rs.getString(getValueField("XSN_CONCEPTO")));
			dto.setCOD_ALFANUM(rs.getString(getValueField("COD_ALFANUM")));
			dto.setCOD_REFEREXT(rs.getString(getValueField("COD_REFEREXT")));
			dto.setCOD_SWIFT(rs.getString(getValueField("COD_SWIFT")));
			//modificacion nueva funcionalidad
			getValueField("COD_NIFORIGN");
			if(rs.wasNull()) {
			dto.setCOD_NIFORIGN(rs.getString(getValueField("COD_NIFORIGN")));
			dto.setXTI_PROVEDOR(rs.getString(getValueField("XTI_PROVEDOR")));
			dto.setCOD_CTASIGN(rs.getString(getValueField("COD_CTASIGN")));
			dto.setCOD_OFITOMAD(rs.getString(getValueField("COD_OFITOMAD")));
			dto.setCOD_FICHERO(rs.getString(getValueField("COD_FICHERO")));
			dto.setCOD_SOCIEDAD(rs.getString(getValueField("COD_SOCIEDAD")));
			dto.setAUD_FMODIFIC(rs.getString(getValueField("AUD_FMODIFIC")));
			dto.setAUD_USUARIO(rs.getString(getValueField("AUD_USUARIO")));
			dto.setXTI_EMISOR(rs.getString(getValueField("XTI_EMISOR")));
			dto.setDES_ONOMBRE(rs.getString(getValueField("DES_ONOMBRE")));
			dto.setDES_ODIRECC(rs.getString(getValueField("DES_ODIRECC")));
			dto.setCOD_OCP2(rs.getDouble(getValueField("COD_OCP2")));		
			}
		}catch (SQLException e) {
			LogNetCashMovil.logErrorPibee("Error en mapper TtlbhoriMapper "+e.getMessage());
			throw new SQLException(e);
		}catch (Exception e2) {
			LogNetCashMovil.logErrorPibee("Error en mapper TtlbhoriMapper "+e2.getMessage());
			throw new SQLException(e2);
		} 
		
		return dto;
	}
}
