package com.bbva.pibee.cbd.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.UtilDto;
import com.bbva.pibee.dto.cbd.OperationListDetailsDto;

public class OperationListDetailsMapper extends UtilDto implements RowMapper<OperationListDetailsDto>{
	
	public OperationListDetailsMapper(){
		super (OperationListDetailsDto.class);
	}

	@Override
	public OperationListDetailsDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		OperationListDetailsDto dto = new OperationListDetailsDto();
		
		try {
			//Setear registros de la tabla TTLBHDOR al DTO
//			dto.setCOD_CLIECASH(rs.getString(getValueField("COD_CLIECASH")));
//			dto.setCOD_CLASEORD(rs.getString(getValueField("COD_CLASEORD")));
//			dto.setCOD_IDORDEN(rs.getString(getValueField("COD_IDORDEN")));
//			dto.setCOD_CABECORI(rs.getInt(getValueField("COD_CABECORI")));
				dto.setCOD_DETALL(rs.getInt(getValueField("COD_DETALL")));
//			dto.setCOD_ORIGE(rs.getString(getValueField("COD_ORIGE")));
//			dto.setIMP_IMPORIVA(rs.getDouble(getValueField("IMP_IMPORIVA")));
				dto.setQTY_DETALLE(rs.getDouble(getValueField("QTY_DETALLE")));
				dto.setCOD_DIISOALF(rs.getString(getValueField("COD_DIISOALF")));
//			dto.setFEC_VALOCASH(rs.getString(getValueField("FEC_VALOCASH")));
//			dto.setQNU_TIPCAMBI(rs.getDouble(getValueField("QNU_TIPCAMBI")));
//			dto.setCOD_REFDETAL(rs.getString(getValueField("COD_REFDETAL")));
//			dto.setCOD_REFDOCUM(rs.getString(getValueField("COD_REFDOCUM")));
//			dto.setXSN_GASTOS(rs.getString(getValueField("XSN_GASTOS")));
//			dto.setXSN_FORMPAGO(rs.getString(getValueField("XSN_FORMPAGO")));
//			dto.setFEC_EXPEDICI(rs.getString(getValueField("FEC_EXPEDICI")));
//			dto.setQNU_NUMPAGOS(rs.getString(getValueField("QNU_NUMPAGOS")));
//			dto.setFEC_VENCCASH(rs.getString(getValueField("FEC_VENCCASH")));
				dto.setCOD_DEVOLORD(rs.getString(getValueField("COD_DEVOLORD")));
				dto.setDES_MOTIVDEV(rs.getString(getValueField("DES_MOTIVDEV")));
//			dto.setDES_MOTIVDEL(rs.getString(getValueField("DES_MOTIVDEL")));
				dto.setXSN_CONCEPTO(rs.getString(getValueField("XSN_CONCEPTO")));
//			dto.setFEC_ORIGENOR(rs.getString(getValueField("FEC_ORIGENOR")));
//			dto.setCOD_REFSEGUR(rs.getString(getValueField("COD_REFSEGUR")));
//			dto.setXTI_INSTRUCC(rs.getString(getValueField("XTI_INSTRUCC")));
//			dto.setCOD_MOTPAGOD(rs.getString(getValueField("COD_MOTPAGOD")));
				dto.setCOD_REFINTER(rs.getString(getValueField("COD_REFINTER")));
//			dto.setXTI_PROVEDOR(rs.getString(getValueField("XTI_PROVEDOR")));
//			dto.setDES_FACTURA(rs.getString(getValueField("DES_FACTURA")));
				dto.setCOD_FACTURA(rs.getString(getValueField("COD_FACTURA")));
//			dto.setFEC_FACTURA(rs.getString(getValueField("FEC_FACTURA")));
//			dto.setDES_FICHEROH(rs.getString(getValueField("DES_FICHEROH")));
//			dto.setAUD_FMODIFIC(rs.getString(getValueField("AUD_FMODIFIC")));
//			dto.setAUD_USUARIO(rs.getString(getValueField("AUD_USUARIO")));
//			dto.setIMP_CUOTTA(rs.getDouble(getValueField("IMP_CUOTTA")));
//			dto.setQTY_CUOTA(rs.getDouble(getValueField("QTY_CUOTA")));
//			dto.setQTY_PRIMCUOT(rs.getDouble(getValueField("QTY_PRIMCUOT")));
//			dto.setXTI_INACELER(rs.getString(getValueField("XTI_INACELER")));
//			dto.setCOD_OFICPLAZ(rs.getInt(getValueField("COD_OFICPLAZ")));
//			dto.setQTY_CONCEPTO(rs.getInt(getValueField("QTY_CONCEPTO")));
				dto.setCOD_LNUMERO(rs.getString(getValueField("COD_LNUMERO")));
//			dto.setDES_CPTO144(rs.getString(getValueField("DES_CPTO144")));
			
			//Setear registros de la tabla TTLBHDEO al DTO
				dto.setCOD_CLIECASH_DEO(rs.getString(getValueField("COD_CLIECASH")));
				dto.setCOD_CLASEORD_DEO(rs.getString(getValueField("COD_CLASEORD")));
				dto.setCOD_IDORDEN_DEO(rs.getString(getValueField("COD_IDORDEN")));
				dto.setCOD_DETALL_DEO(rs.getInt(getValueField("COD_DETALL")));
				dto.setCOD_CABECORI_DEO(rs.getInt(getValueField("COD_CABECORI")));
//			dto.setCOD_IDORIGEN(rs.getString(getValueField("COD_IDORIGEN")));
				dto.setCOD_IDESTINO(rs.getString(getValueField("COD_IDESTINO")));
				dto.setDES_DESTINO(rs.getString(getValueField("DES_DESTINO")));
//			dto.setDES_DOMIDES1(rs.getString(getValueField("DES_DOMIDES1")));
//			dto.setDES_DOMIDES2(rs.getString(getValueField("DES_DOMIDES2")));
//			dto.setDES_DOMIDES3(rs.getString(getValueField("DES_DOMIDES3")));
//			dto.setDES_CPLAZA(rs.getString(getValueField("DES_CPLAZA")));
//			dto.setCOD_FORMASUN(rs.getShort(getValueField("COD_FORMASUN")));
//			dto.setXTI_CLASEASU(rs.getString(getValueField("XTI_CLASEASU")));
				dto.setDES_CUENDEST(rs.getString(getValueField("DES_CUENDEST")));
//			dto.setCOD_PROVINCI(rs.getShort(getValueField("COD_PROVINCI")));
//			dto.setCOD_CDIPOS(rs.getInt(getValueField("COD_CDIPOS")));
//			dto.setXSN_DOMICILI(rs.getString(getValueField("XSN_DOMICILI")));
//			dto.setCOD_BANCASH(rs.getString(getValueField("COD_BANCASH")));
//			dto.setCOD_BANCSB(rs.getShort(getValueField("COD_BANCSB")));
//			dto.setCOD_OFICPLAZ_DEO(rs.getShort(getValueField("COD_OFICPLAZ")));
//			dto.setDES_OFICIDES(rs.getString(getValueField("DES_OFICIDES")));
//			dto.setXTI_DOCIDENT(rs.getString(getValueField("XTI_DOCIDENT")));
				dto.setCOD_NIFDESTI(rs.getString(getValueField("COD_NIFDESTI")));
//			dto.setCOD_INSTRUC(rs.getString(getValueField("COD_INSTRUC")));
//			dto.setCOD_CDNITR(rs.getString(getValueField("COD_CDNITR")));
//			dto.setCOD_SUFPRESE(rs.getString(getValueField("COD_SUFPRESE")));
//			dto.setDES_TITULCTA(rs.getString(getValueField("DES_TITULCTA")));
//			dto.setDES_BANCO(rs.getString(getValueField("DES_BANCO")));
//			dto.setDES_PRSCONT(rs.getString(getValueField("DES_PRSCONT")));
				dto.setDES_LIBRADO(rs.getString(getValueField("DES_LIBRADO")));
//			dto.setCOD_SWFIT(rs.getString(getValueField("COD_SWFIT")));
//			dto.setCOD_BANABA(rs.getString(getValueField("COD_BANABA")));
//			dto.setCOD_ESTADIS(rs.getString(getValueField("COD_ESTADIS")));
//			dto.setCOD_PAISESTA(rs.getString(getValueField("COD_PAISESTA")));
//			dto.setCOD_PAISOALF(rs.getString(getValueField("COD_PAISOALF")));
//			dto.setDES_INSTRUCC(rs.getString(getValueField("DES_INSTRUCC")));
//			dto.setCOD_TIPTAB(rs.getShort(getValueField("COD_TIPTAB")));
//			dto.setXSN_PAGO(rs.getString(getValueField("XSN_PAGO")));
//			dto.setDES_BANCINTE(rs.getString(getValueField("DES_BANCINTE")));
//			dto.setDES_DIRBANIN(rs.getString(getValueField("DES_DIRBANIN")));
//			dto.setDES_PLABANIN(rs.getString(getValueField("DES_PLABANIN")));
//			dto.setCOD_TELFPROV(rs.getString(getValueField("COD_TELFPROV")));
//			dto.setCOD_FAXPORT(rs.getString(getValueField("COD_FAXPORT")));
//			dto.setXSN_IDENTFIS(rs.getString(getValueField("XSN_IDENTFIS")));
//			dto.setCOD_CLAFPROV(rs.getString(getValueField("COD_CLAFPROV")));
//			dto.setDES_FICHEROH_DEO(rs.getString(getValueField("DES_FICHEROH")));
//			dto.setAUD_FMODIFIC_DEO(rs.getString(getValueField("AUD_FMODIFIC")));
//			dto.setAUD_USUARIO_DEO(rs.getString(getValueField("AUD_USUARIO")));
//			dto.setCOD_COMUNA(rs.getString(getValueField("COD_COMUNA")));
//			dto.setCOD_ENTREGA(rs.getString(getValueField("COD_ENTREGA")));
//			dto.setCOD_SUCURENT(rs.getString(getValueField("COD_SUCURENT")));
//			dto.setDES_EMAIL(rs.getString(getValueField("DES_EMAIL")));
//			dto.setCOD_PRSCONT(rs.getString(getValueField("COD_PRSCONT")));
//			dto.setDES_DNOMBER(rs.getString(getValueField("DES_DNOMBER")));
//			dto.setXTI_DIDEBCOT(rs.getString(getValueField("XTI_DIDEBCOT")));
//			dto.setXTI_DIDEBCOI(rs.getString(getValueField("XTI_DIDEBCOI")));
//			dto.setCOD_BANCINTE(rs.getString(getValueField("COD_BANCINTE")));
//			dto.setDES_DDIRECC(rs.getString(getValueField("DES_DDIRECC")));
//			dto.setDES_DDIRBCOT(rs.getString(getValueField("DES_DDIRBCOT")));
//			dto.setCOD_DPAIBCOI(rs.getString(getValueField("COD_DPAIBCOI")));
//			dto.setDES_DNOMCO(rs.getString(getValueField("DES_DNOMCO")));
//			dto.setDES_DDIRBCOI(rs.getString(getValueField("DES_DDIRBCOI")));
//			dto.setDES_DCUEBCOI(rs.getString(getValueField("DES_DCUEBCOI")));
//			dto.setCOD_GASTODES(rs.getString(getValueField("COD_GASTODES")));
//			dto.setCOD_CDIPOS2(rs.getInt(getValueField("COD_CDIPOS2")));
//			dto.setFEC_NACIMTIT(rs.getString(getValueField("FEC_NACIMTIT")));
//			dto.setXSN_FORMPAGO_DEO(rs.getString(getValueField("XSN_FORMPAGO")));
		}catch (SQLException e) {
			LogNetCashMovil.logErrorPibee("Error en mapper OperationListDetailsMapper "+e.getMessage());
			throw new SQLException(e);
		}catch (Exception e2) {
			LogNetCashMovil.logErrorPibee("Error en mapper OperationListDetailsMapper "+e2.getMessage());
			throw new SQLException(e2);
		}
		return dto;
	}
}
