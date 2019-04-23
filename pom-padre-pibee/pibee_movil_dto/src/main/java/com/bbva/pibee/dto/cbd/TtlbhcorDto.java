package com.bbva.pibee.dto.cbd;

import java.util.Date;

import com.bbva.pibee.arq.annotations.Column;

public class TtlbhcorDto {
	
	//Campos de la tabla TTLBHCOR.
	@Column(name="COD_IDORDEN")
	private String COD_IDORDEN;

	@Column(name="COD_CLIECASH")
	private String COD_CLIECASH;

	@Column(name="COD_CLASEORD")
	private String COD_CLASEORD;

	@Column(name="COD_CABECORI")
	private Integer COD_CABECORI;

	@Column(name="COD_CDNITR")
	private String COD_CDNITR;

	@Column(name="COD_SUFPRESE")
	private String COD_SUFPRESE;

	@Column(name="COD_IDORIGEN")
	private String COD_IDORIGEN;

	@Column(name="DES_CUENORIG")
	private String DES_CUENORIG;

	@Column(name="COD_BANCINTE")
	private String COD_BANCINTE;

	@Column(name="COD_BANCSB")
	private Integer COD_BANCSB;

	@Column(name="COD_DIISOALF")
	private String COD_DIISOALF;

	@Column(name="COD_FORMASUN")
	private Integer COD_FORMASUN;

	@Column(name="XTI_CLASEASU")
	private String XTI_CLASEASU;

	@Column(name="COD_SWIFT")
	private String COD_SWIFT;

	@Column(name="COD_BANABA")
	private String COD_BANABA;

	@Column(name="DES_FICHEROH")
	private String DES_FICHEROH;

	@Column(name="AUD_FMODIFIC")
	private Date AUD_FMODIFIC;

	@Column(name="AUD_USUARIO")
	private String AUD_USUARIO;

	@Column(name="XTI_EMISOR")
	private String XTI_EMISOR;

	@Column(name="DES_ORDPAGO")
	private String DES_ORDPAGO;

	@Column(name="XTI_INDMODAL")
	private String XTI_INDMODAL;

	public String getCOD_IDORDEN() {
		return COD_IDORDEN;
	}

	public void setCOD_IDORDEN(String cOD_IDORDEN) {
		COD_IDORDEN = cOD_IDORDEN;
	}

	public String getCOD_CLIECASH() {
		return COD_CLIECASH;
	}

	public void setCOD_CLIECASH(String cOD_CLIECASH) {
		COD_CLIECASH = cOD_CLIECASH;
	}

	public String getCOD_CLASEORD() {
		return COD_CLASEORD;
	}

	public void setCOD_CLASEORD(String cOD_CLASEORD) {
		COD_CLASEORD = cOD_CLASEORD;
	}

	public Integer getCOD_CABECORI() {
		return COD_CABECORI;
	}

	public void setCOD_CABECORI(Integer cOD_CABECORI) {
		COD_CABECORI = cOD_CABECORI;
	}

	public String getCOD_CDNITR() {
		return COD_CDNITR;
	}

	public void setCOD_CDNITR(String cOD_CDNITR) {
		COD_CDNITR = cOD_CDNITR;
	}

	public String getCOD_SUFPRESE() {
		return COD_SUFPRESE;
	}

	public void setCOD_SUFPRESE(String cOD_SUFPRESE) {
		COD_SUFPRESE = cOD_SUFPRESE;
	}

	public String getCOD_IDORIGEN() {
		return COD_IDORIGEN;
	}

	public void setCOD_IDORIGEN(String cOD_IDORIGEN) {
		COD_IDORIGEN = cOD_IDORIGEN;
	}

	public String getDES_CUENORIG() {
		return DES_CUENORIG;
	}

	public void setDES_CUENORIG(String dES_CUENORIG) {
		DES_CUENORIG = dES_CUENORIG;
	}

	public String getCOD_BANCINTE() {
		return COD_BANCINTE;
	}

	public void setCOD_BANCINTE(String cOD_BANCINTE) {
		COD_BANCINTE = cOD_BANCINTE;
	}

	public Integer getCOD_BANCSB() {
		return COD_BANCSB;
	}
	
	public void setCOD_BANCSB(Integer cOD_BANCSB) {
		COD_BANCSB = cOD_BANCSB;
	}

	public String getCOD_DIISOALF() {
		return COD_DIISOALF;
	}

	public void setCOD_DIISOALF(String cOD_DIISOALF) {
		COD_DIISOALF = cOD_DIISOALF;
	}

	public Integer getCOD_FORMASUN() {
		return COD_FORMASUN;
	}

	public void setCOD_FORMASUN(Integer cOD_FORMASUN) {
		COD_FORMASUN = cOD_FORMASUN;
	}

	public String getXTI_CLASEASU() {
		return XTI_CLASEASU;
	}

	public void setXTI_CLASEASU(String xTI_CLASEASU) {
		XTI_CLASEASU = xTI_CLASEASU;
	}

	public String getCOD_SWIFT() {
		return COD_SWIFT;
	}

	public void setCOD_SWIFT(String cOD_SWIFT) {
		COD_SWIFT = cOD_SWIFT;
	}

	public String getCOD_BANABA() {
		return COD_BANABA;
	}

	public void setCOD_BANABA(String cOD_BANABA) {
		COD_BANABA = cOD_BANABA;
	}

	public String getDES_FICHEROH() {
		return DES_FICHEROH;
	}

	public void setDES_FICHEROH(String dES_FICHEROH) {
		DES_FICHEROH = dES_FICHEROH;
	}

	public Date getAUD_FMODIFIC() {
		return AUD_FMODIFIC;
	}

	public void setAUD_FMODIFIC(Date aUD_FMODIFIC) {
		AUD_FMODIFIC = aUD_FMODIFIC;
	}

	public String getAUD_USUARIO() {
		return AUD_USUARIO;
	}

	public void setAUD_USUARIO(String aUD_USUARIO) {
		AUD_USUARIO = aUD_USUARIO;
	}

	public String getXTI_EMISOR() {
		return XTI_EMISOR;
	}

	public void setXTI_EMISOR(String xTI_EMISOR) {
		XTI_EMISOR = xTI_EMISOR;
	}

	public String getDES_ORDPAGO() {
		return DES_ORDPAGO;
	}

	public void setDES_ORDPAGO(String dES_ORDPAGO) {
		DES_ORDPAGO = dES_ORDPAGO;
	}

	public String getXTI_INDMODAL() {
		return XTI_INDMODAL;
	}

	public void setXTI_INDMODAL(String xTI_INDMODAL) {
		XTI_INDMODAL = xTI_INDMODAL;
	}
}
