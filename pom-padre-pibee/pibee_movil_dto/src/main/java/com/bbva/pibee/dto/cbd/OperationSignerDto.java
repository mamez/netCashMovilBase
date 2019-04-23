package com.bbva.pibee.dto.cbd;

import com.bbva.pibee.arq.annotations.Column;

public class OperationSignerDto 
{
	//Campos de la tabla TTLCLFFU.
	
	@Column(name="COD_CLIECASH")
	private  String COD_CLIECASH;
	
	@Column(name="COD_CLASEORD")
	private  String COD_CLASEORD;
	
	@Column(name="COD_IDORDEN")
	private  String COD_IDORDEN;
	
	@Column(name="COD_USUARIO")
	private  String COD_USUARIO;
	
	@Column(name="COD_NUMALEAT")
	private  String COD_NUMALEAT;
	
	@Column(name="XSN_FIRMADO")
	private  String XSN_FIRMADO;
	
	@Column(name="AUD_FMODIFIC")
	private  String AUD_FMODIFIC;
	
	@Column(name="AUD_USUARIO")
	private  String AUD_USUARIO;

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

	public String getCOD_IDORDEN() {
		return COD_IDORDEN;
	}

	public void setCOD_IDORDEN(String cOD_IDORDEN) {
		COD_IDORDEN = cOD_IDORDEN;
	}

	public String getCOD_USUARIO() {
		return COD_USUARIO;
	}

	public void setCOD_USUARIO(String cOD_USUARIO) {
		COD_USUARIO = cOD_USUARIO;
	}

	public String getCOD_NUMALEAT() {
		return COD_NUMALEAT;
	}

	public void setCOD_NUMALEAT(String cOD_NUMALEAT) {
		COD_NUMALEAT = cOD_NUMALEAT;
	}

	public String getXSN_FIRMADO() {
		return XSN_FIRMADO;
	}

	public void setXSN_FIRMADO(String xSN_FIRMADO) {
		XSN_FIRMADO = xSN_FIRMADO;
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
