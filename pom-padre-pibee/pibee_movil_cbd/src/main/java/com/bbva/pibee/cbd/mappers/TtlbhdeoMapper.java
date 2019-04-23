package com.bbva.pibee.cbd.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.UtilDto;
import com.bbva.pibee.dto.cbd.TtlbhdeoDto;

public class TtlbhdeoMapper extends UtilDto implements RowMapper<TtlbhdeoDto> {

	public TtlbhdeoMapper() {
		super(TtlbhdeoDto.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TtlbhdeoDto mapRow(ResultSet rs, int rowNum) throws SQLException{
		// TODO Auto-generated method stub
		TtlbhdeoDto dto = new TtlbhdeoDto();
		try {
			dto.setCOD_CLIECASH(rs.getString(getValueField("COD_CLIECASH")));
			dto.setCOD_CLASEORD(rs.getString(getValueField("COD_CLASEORD")));
			dto.setCOD_IDORDEN(rs.getString(getValueField("COD_IDORDEN")));
			dto.setCOD_DETALL(rs.getInt(getValueField("COD_DETALL")));
			dto.setCOD_CABECORI(rs.getInt(getValueField("COD_CABECORI")));
			dto.setCOD_IDORIGEN(rs.getString(getValueField("COD_IDORIGEN")));
			dto.setCOD_IDESTINO(rs.getString(getValueField("COD_IDESTINO")));
			dto.setDES_DESTINO(rs.getString(getValueField("DES_DESTINO")));
			dto.setDES_DOMIDES1(rs.getString(getValueField("DES_DOMIDES1")));
			dto.setDES_DOMIDES2(rs.getString(getValueField("DES_DOMIDES2")));
			dto.setDES_DOMIDES3(rs.getString(getValueField("DES_DOMIDES3")));
			dto.setDES_CPLAZA(rs.getString(getValueField("DES_CPLAZA")));
			dto.setCOD_FORMASUN(rs.getShort(getValueField("COD_FORMASUN")));
			dto.setXTI_CLASEASU(rs.getString(getValueField("XTI_CLASEASU")));
			dto.setDES_CUENDEST(rs.getString(getValueField("DES_CUENDEST")));
			dto.setCOD_PROVINCI(rs.getShort(getValueField("COD_PROVINCI")));
			dto.setCOD_CDIPOS(rs.getInt(getValueField("COD_CDIPOS")));
			dto.setXSN_DOMICILI(rs.getString(getValueField("XSN_DOMICILI")));
			dto.setCOD_BANCASH(rs.getString(getValueField("COD_BANCASH")));
			dto.setCOD_BANCSB(rs.getShort(getValueField("COD_BANCSB")));
			dto.setCOD_OFICPLAZ(rs.getShort(getValueField("COD_OFICPLAZ")));
			dto.setDES_OFICIDES(rs.getString(getValueField("DES_OFICIDES")));
			dto.setXTI_DOCIDENT(rs.getString(getValueField("XTI_DOCIDENT")));
			dto.setCOD_NIFDESTI(rs.getString(getValueField("COD_NIFDESTI")));
			dto.setCOD_INSTRUC(rs.getString(getValueField("COD_INSTRUC")));
			dto.setCOD_CDNITR(rs.getString(getValueField("COD_CDNITR")));
			dto.setCOD_SUFPRESE(rs.getString(getValueField("COD_SUFPRESE")));
			dto.setDES_TITULCTA(rs.getString(getValueField("DES_TITULCTA")));
			dto.setDES_BANCO(rs.getString(getValueField("DES_BANCO")));
			dto.setDES_PRSCONT(rs.getString(getValueField("DES_PRSCONT")));
			dto.setDES_LIBRADO(rs.getString(getValueField("DES_LIBRADO")));
			dto.setCOD_SWFIT(rs.getString(getValueField("COD_SWFIT")));
			dto.setCOD_BANABA(rs.getString(getValueField("COD_BANABA")));
			dto.setCOD_ESTADIS(rs.getString(getValueField("COD_ESTADIS")));
			dto.setCOD_PAISESTA(rs.getString(getValueField("COD_PAISESTA")));
			dto.setCOD_PAISOALF(rs.getString(getValueField("COD_PAISOALF")));
			dto.setDES_INSTRUCC(rs.getString(getValueField("DES_INSTRUCC")));
			dto.setCOD_TIPTAB(rs.getShort(getValueField("COD_TIPTAB")));
			dto.setXSN_PAGO(rs.getString(getValueField("XSN_PAGO")));
			dto.setDES_BANCINTE(rs.getString(getValueField("DES_BANCINTE")));
			dto.setDES_DIRBANIN(rs.getString(getValueField("DES_DIRBANIN")));
			dto.setDES_PLABANIN(rs.getString(getValueField("DES_PLABANIN")));
			dto.setCOD_TELFPROV(rs.getString(getValueField("COD_TELFPROV")));
			dto.setCOD_FAXPORT(rs.getString(getValueField("COD_FAXPORT")));
			dto.setXSN_IDENTFIS(rs.getString(getValueField("XSN_IDENTFIS")));
			dto.setCOD_CLAFPROV(rs.getString(getValueField("COD_CLAFPROV")));
			dto.setDES_FICHEROH(rs.getString(getValueField("DES_FICHEROH")));
			dto.setAUD_FMODIFIC(rs.getDate(getValueField("AUD_FMODIFIC")));
			dto.setAUD_USUARIO(rs.getString(getValueField("AUD_USUARIO")));
			dto.setCOD_COMUNA(rs.getString(getValueField("COD_COMUNA")));
			dto.setCOD_ENTREGA(rs.getString(getValueField("COD_ENTREGA")));
			dto.setCOD_SUCURENT(rs.getString(getValueField("COD_SUCURENT")));
			dto.setDES_EMAIL(rs.getString(getValueField("DES_EMAIL")));
			dto.setCOD_PRSCONT(rs.getString(getValueField("COD_PRSCONT")));
			dto.setDES_DNOMBER(rs.getString(getValueField("DES_DNOMBER")));
			dto.setXTI_DIDEBCOT(rs.getString(getValueField("XTI_DIDEBCOT")));
			dto.setXTI_DIDEBCOI(rs.getString(getValueField("XTI_DIDEBCOI")));
			dto.setCOD_BANCINTE(rs.getString(getValueField("COD_BANCINTE")));
			dto.setDES_DDIRECC(rs.getString(getValueField("DES_DDIRECC")));
			dto.setDES_DDIRBCOT(rs.getString(getValueField("DES_DDIRBCOT")));
			dto.setCOD_DPAIBCOI(rs.getString(getValueField("COD_DPAIBCOI")));
			dto.setDES_DNOMCO(rs.getString(getValueField("DES_DNOMCO")));
			dto.setDES_DDIRBCOI(rs.getString(getValueField("DES_DDIRBCOI")));
			dto.setDES_DCUEBCOI(rs.getString(getValueField("DES_DCUEBCOI")));
			dto.setCOD_GASTODES(rs.getString(getValueField("COD_GASTODES")));
			dto.setCOD_CDIPOS2(rs.getInt(getValueField("COD_CDIPOS2")));
			dto.setFEC_NACIMTIT(rs.getString(getValueField("FEC_NACIMTIT")));
			dto.setXSN_FORMPAGO(rs.getString(getValueField("XSN_FORMPAGO")));
		} catch (SQLException e) {
			LogNetCashMovil.logErrorPibee("Error en mapper TtlbhdeoMapper"+e.getMessage());
			throw new SQLException(e);
		}catch (Exception e2) {
			LogNetCashMovil.logErrorPibee("Error en mapper TtlbhdeoMapper "+e2.getMessage());
			throw new SQLException(e2);
		} 
		return dto;
	}

}
