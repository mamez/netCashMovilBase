package com.bbva.pibee.cbd.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.UtilDto;
import com.bbva.pibee.dto.cbd.OperationHeaderDto;

public class OperationHeaderMapper extends UtilDto implements RowMapper<OperationHeaderDto>
{
	public OperationHeaderMapper() 
	{
		super(OperationHeaderDto.class);	
	}
	
	@Override
	public OperationHeaderDto mapRow(ResultSet rs, int arg1) throws SQLException 
	{
		OperationHeaderDto dto = new OperationHeaderDto();
		
		try
		{
			dto.setCOD_CLIECASH(rs.getString(getValueField("COD_CLIECASH")));
			dto.setCOD_CLASEORD(rs.getString(getValueField("COD_CLASEORD")));
			dto.setCOD_IDORDEN(rs.getString(getValueField("COD_IDORDEN")));
			dto.setCOD_CDNIFTR(rs.getString(getValueField("COD_CDNIFTR")));
			dto.setCOD_SUFPRESE(rs.getString(getValueField("COD_SUFPRESE")));
			dto.setCOD_DIISOALF(rs.getString(getValueField("COD_DIISOALF")));
			dto.setFEC_PROCESCA(rs.getString(getValueField("FEC_PROCESCA")));
			dto.setDES_REFICHER(rs.getString(getValueField("DES_REFICHER")));
			dto.setDES_NOMFICH(rs.getString(getValueField("DES_NOMFICH")));
			dto.setXSN_MEDCREAC(rs.getString(getValueField("XSN_MEDCREAC")));
			dto.setXSN_MODCREAC(rs.getString(getValueField("XSN_MODCREAC")));
			dto.setFEC_BORRCASH(rs.getString(getValueField("FEC_BORRCASH")));
			dto.setFEC_ESTACASH(rs.getString(getValueField("FEC_ESTACASH")));
			dto.setXSN_ACTAUTDE(rs.getString(getValueField("XSN_ACTAUTDE")));
			dto.setQTY_TOTIMPOR(rs.getDouble(getValueField("QTY_TOTIMPOR")));
			dto.setQNU_TOTREGIS(rs.getInt(getValueField("QNU_TOTREGIS")));			
			dto.setXSN_FORMPAGO(rs.getString(getValueField("XSN_FORMPAGO")));
			dto.setCOD_ESTACASH(rs.getString(getValueField("COD_ESTACASH")));
			dto.setQNU_PESOFIR(rs.getDouble(getValueField("QNU_PESOFIR")));
			dto.setQNU_SIZE(rs.getLong(getValueField("QNU_SIZE")));
			dto.setDES_NOMFICHE(rs.getString(getValueField("DES_NOMFICHE")));
			dto.setQNU_NUMITEM(rs.getLong(getValueField("QNU_NUMITEM")));
			dto.setDES_PATH(rs.getString(getValueField("DES_PATH")));
			dto.setDES_FICHEROH(rs.getString(getValueField("DES_FICHEROH")));
			dto.setAUD_FMODIFIC(rs.getDate(getValueField("AUD_FMODIFIC")));
			dto.setAUD_USUARIO(rs.getString(getValueField("AUD_USUARIO")));
			dto.setCOD_DETSEROR(rs.getString(getValueField("COD_DETSEROR")));
			dto.setXTI_DETSEROR(rs.getString(getValueField("XTI_DETSEROR")));
			dto.setCOD_PRODCART(rs.getString(getValueField("COD_PRODCART")));
			dto.setXSN_SUCURSAL(rs.getString(getValueField("XSN_SUCURSAL")));
			dto.setDES_PATHXML(rs.getString(getValueField("DES_PATHXML")));
			dto.setDES_PATHHTML(rs.getString(getValueField("DES_PATHHTML")));
			dto.setDES_FXMLHTML(rs.getString(getValueField("DES_FXMLHTML")));
			dto.setXTI_VALPERT(rs.getString(getValueField("XTI_VALPERT")));
			dto.setCOD_LTIPO(rs.getString(getValueField("COD_LTIPO")));
			dto.setDES_LDESC(rs.getString(getValueField("DES_LDESC")));
			dto.setXSN_BORRADO(rs.getString(getValueField("XSN_BORRADO")));
			dto.setQTY_IMPFINA(rs.getDouble(getValueField("QTY_IMPFINA")));
			dto.setQNU_NUMREME(rs.getDouble(getValueField("QNU_NUMREME")));
			dto.setTIM_ORDEN(rs.getString(getValueField("TIM_ORDEN")));
		}catch (SQLException e) {
			LogNetCashMovil.logErrorPibee("Error en mapper OperationHeaderMapper "+e.getMessage());
			throw new SQLException(e);
		}catch (Exception e2) {
			LogNetCashMovil.logErrorPibee("Error en mapper OperationHeaderMapper "+e2.getMessage());
			throw new SQLException(e2);
		}
		
		return dto;
	}
}
