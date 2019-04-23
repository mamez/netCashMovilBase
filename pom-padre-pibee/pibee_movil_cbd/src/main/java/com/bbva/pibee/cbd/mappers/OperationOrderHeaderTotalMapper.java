package com.bbva.pibee.cbd.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.UtilDto;
import com.bbva.pibee.dto.cbd.OperationOrderHeaderTotalDto;

public class OperationOrderHeaderTotalMapper extends UtilDto implements RowMapper<OperationOrderHeaderTotalDto> {

	public OperationOrderHeaderTotalMapper() {
		super(OperationOrderHeaderTotalDto.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public OperationOrderHeaderTotalDto mapRow(ResultSet rs, int rowNum) throws SQLException{
		// TODO Auto-generated method stub
		OperationOrderHeaderTotalDto dto = new OperationOrderHeaderTotalDto();
		try {
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
			dto.setQNU_SIZE(rs.getDouble(getValueField("QNU_SIZE")));
			dto.setDES_NOMFICHE(rs.getString(getValueField("DES_NOMFICHE")));
			dto.setQNU_NUMITEM(rs.getDouble(getValueField("QNU_NUMITEM")));
			dto.setDES_PATH(rs.getString(getValueField("DES_PATH")));
			dto.setDES_FICHEROH(rs.getString(getValueField("DES_FICHEROH")));
			dto.setAUD_FMODIFIC(rs.getString(getValueField("AUD_FMODIFIC")));
			dto.setAUD_USUARIO(rs.getString(getValueField("AUD_USUARIO")));
			dto.setCOD_DETSEROR(rs.getString(getValueField("COD_DETSEROR")));
			dto.setCOD_PRODCART(rs.getString(getValueField("COD_PRODCART")));
			dto.setXTI_DETSEROR(rs.getString(getValueField("XTI_DETSEROR")));
			dto.setXSN_SUCURSAL(rs.getString(getValueField("XSN_SUCURSAL")));
			dto.setXTI_VALPERT(rs.getString(getValueField("XTI_VALPERT")));
			dto.setCOD_LTIPO(rs.getString(getValueField("COD_LTIPO")));
			dto.setDES_LDESC(rs.getString(getValueField("DES_LDESC")));
			dto.setXSN_BORRADO(rs.getString(getValueField("XSN_BORRADO")));
			dto.setQTY_IMPFINA(rs.getDouble(getValueField("QTY_IMPFINA")));
			dto.setQNU_NUMREME(rs.getLong(getValueField("QNU_NUMREME")));
			dto.setCOD_CABECORI(rs.getInt(getValueField("COD_CABECORI")));
			dto.setCOD_CDNITR(rs.getString(getValueField("COD_CDNITR")));
			dto.setCOD_SUFPRESE_COR(rs.getString(getValueField("COD_SUFPRESE")));
			dto.setCOD_IDORIGEN_COR(rs.getString(getValueField("COD_IDORIGEN")));
			dto.setDES_CUENORIG(rs.getString(getValueField("DES_CUENORIG")));
			dto.setCOD_BANCINTE(rs.getString(getValueField("COD_BANCINTE")));
			dto.setCOD_BANCSB(rs.getInt(getValueField("COD_BANCSB")));
			dto.setCOD_DIISOALF_COR(rs.getString(getValueField("COD_DIISOALF")));
			dto.setCOD_FORMASUN(rs.getInt(getValueField("COD_FORMASUN")));
			dto.setXTI_CLASEASU(rs.getString(getValueField("XTI_CLASEASU")));
			dto.setCOD_SWIFT(rs.getString(getValueField("COD_SWIFT")));
			dto.setCOD_BANABA(rs.getString(getValueField("COD_BANABA")));
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
			dto.setCOD_CDIPOS(rs.getLong(getValueField("COD_CDIPOS")));
			dto.setQNU_REFEREN(rs.getDouble(getValueField("QNU_REFEREN")));
			dto.setXSN_REFEREN(rs.getString(getValueField("XSN_REFEREN")));
			dto.setDES_REFEROPE(rs.getString(getValueField("DES_REFEROPE")));
			dto.setXSN_MODELCON(rs.getString(getValueField("XSN_MODELCON")));
			dto.setCOD_ALFANUM(rs.getString(getValueField("COD_ALFANUM")));
			dto.setCOD_REFEREXT(rs.getString(getValueField("COD_REFEREXT")));
			dto.setCOD_NIFORIGN(rs.getString(getValueField("COD_NIFORIGN")));
			dto.setXTI_PROVEDOR(rs.getString(getValueField("XTI_PROVEDOR")));
			dto.setCOD_CTASIGN(rs.getString(getValueField("COD_CTASIGN")));
			dto.setCOD_OFITOMAD(rs.getString(getValueField("COD_OFITOMAD")));
			dto.setCOD_FICHERO(rs.getString(getValueField("COD_FICHERO")));
			dto.setCOD_SOCIEDAD(rs.getString(getValueField("COD_SOCIEDAD")));
			dto.setDES_ONOMBRE(rs.getString(getValueField("DES_ONOMBRE")));
			dto.setDES_ODIRECC(rs.getString(getValueField("DES_ODIRECC")));
			//dto.setDES_OCP2(rs.getLong(getValueField("DES_OCP2")));
			dto.setXTI_EMISOR(rs.getString(getValueField("XTI_EMISOR")));
			dto.setDES_ORDPAGO(rs.getString(getValueField("DES_ORDPAGO")));
		}catch (SQLException e) {
			LogNetCashMovil.logErrorPibee("Error en mapper OperationOrderHeaderTotalMapper "+e.getMessage());
			throw new SQLException(e);
		}catch (Exception e2) {
			LogNetCashMovil.logErrorPibee("Error en mapper OperationOrderHeaderTotalMapper "+e2.getMessage());
			throw new SQLException(e2);
		} 
		return dto;
	}

}
