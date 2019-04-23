package com.bbva.pibee.dto.cbd;

import com.bbva.pibee.arq.annotations.Column;

public class TtlbhcuoDto {
	
	//Campos de la tabla Ttlbhcuo // Cuentas de Ordenantes
	
	@Column(name = "COD_CLIECASH")
	private String COD_CLIECASH;
	
	@Column(name = "COD_CLASEORD")
	private String COD_CLASEORD;
	
	@Column(name = "COD_CDNITR")
	private String COD_CDNITR;
	
	@Column(name = "COD_SUFPRESE")
	private String COD_SUFPRESE;
	
	@Column(name = "COD_IDORIGEN")
	private String COD_IDORIGEN;
	
	@Column(name = "DES_CUENORIG")
	private String DES_CUENORIG;
	
	@Column(name = "COD_BANCINTE")
	private String COD_BANCINTE;
	
	@Column(name = "COD_BANCASH")
	private String COD_BANCASH;
	
	@Column(name = "COD_BANCSB")
	private int COD_BANCSB;
	
	@Column(name = "COD_SWIFT")
	private String COD_SWIFT;
	
	@Column(name = "COD_BANABA")
	private String COD_BANABA;
	
	@Column(name = "COD_DIISOALF")
	private String COD_DIISOALF;
	
	@Column(name = "COD_FORMASUN")
	private int COD_FORMASUN;
	
	@Column(name = "XTI_CLASEASU")
	private String XTI_CLASEASU;
	
	@Column(name = "AUD_FMODIFIC")
	private String AUD_FMODIFIC;
	
	@Column(name = "AUD_USUARIO")
	private String AUD_USUARIO;
	
	//GET's & SET's de los campos de la tabla Ttlbhcuo // Cuentas de Ordenantes

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

	public String getCOD_BANCASH() {
		return COD_BANCASH;
	}

	public void setCOD_BANCASH(String cOD_BANCASH) {
		COD_BANCASH = cOD_BANCASH;
	}

	public int getCOD_BANCSB() {
		return COD_BANCSB;
	}

	public void setCOD_BANCSB(int cOD_BANCSB) {
		COD_BANCSB = cOD_BANCSB;
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

	public String getCOD_DIISOALF() {
		return COD_DIISOALF;
	}

	public void setCOD_DIISOALF(String cOD_DIISOALF) {
		COD_DIISOALF = cOD_DIISOALF;
	}

	public int getCOD_FORMASUN() {
		return COD_FORMASUN;
	}

	public void setCOD_FORMASUN(int cOD_FORMASUN) {
		COD_FORMASUN = cOD_FORMASUN;
	}

	public String getXTI_CLASEASU() {
		return XTI_CLASEASU;
	}

	public void setXTI_CLASEASU(String xTI_CLASEASU) {
		XTI_CLASEASU = xTI_CLASEASU;
	}

	public String getAUD_FMODIFIC() {
		return AUD_FMODIFIC;
	}

	public void setAUD_FMODIFIC(String aUD_FMODIFIC) {
		AUD_FMODIFIC = aUD_FMODIFIC;
	}

	public String getAUD_USUARIO() {
		return AUD_USUARIO;
	}

	public void setAUD_USUARIO(String aUD_USUARIO) {
		AUD_USUARIO = aUD_USUARIO;
	}
}
