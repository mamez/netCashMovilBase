package com.bbva.pibee.dto.cbd;

import com.bbva.pibee.arq.annotations.Column;

public class BankDto
{
	// Tabla TTLCLBSP - Bancos
	@Column(name="COD_BANCOGBL")
	private int COD_BANCOGBL;

	@Column(name="COD_BANCSB")
	private int COD_BANCSB;
	
	@Column(name="DES_DNOMCO")
	private String DES_DNOMCO;
	
	@Column(name="XTI_ACTIVIDA")
	private String XTI_ACTIVIDA;
	
	@Column(name="COD_BANCOINT")
	private int COD_BANCOINT;
	
	@Column(name="AUD_FMODIFIC")
	private String AUD_FMODIFIC;
	
	@Column(name="AUD_USUARIO")
	private String AUD_USUARIO;

	public int getCOD_BANCOGBL() {
		return COD_BANCOGBL;
	}

	public void setCOD_BANCOGBL(int cOD_BANCOGBL) {
		COD_BANCOGBL = cOD_BANCOGBL;
	}

	public int getCOD_BANCSB() {
		return COD_BANCSB;
	}

	public void setCOD_BANCSB(int cOD_BANCSB) {
		COD_BANCSB = cOD_BANCSB;
	}

	public String getDES_DNOMCO() {
		return DES_DNOMCO;
	}

	public void setDES_DNOMCO(String dES_DNOMCO) {
		DES_DNOMCO = dES_DNOMCO;
	}

	public String getXTI_ACTIVIDA() {
		return XTI_ACTIVIDA;
	}

	public void setXTI_ACTIVIDA(String xTI_ACTIVIDA) {
		XTI_ACTIVIDA = xTI_ACTIVIDA;
	}

	public int getCOD_BANCOINT() {
		return COD_BANCOINT;
	}

	public void setCOD_BANCOINT(int cOD_BANCOINT) {
		COD_BANCOINT = cOD_BANCOINT;
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
