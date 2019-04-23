package com.bbva.pibee.dto.cbd;

import java.util.Date;

import com.bbva.pibee.arq.annotations.Column;

public class OperationAuditDto 
{
	//Campos de la tabla TTLBHFUA.
	
	@Column(name="COD_CLIECASH")
	private  String COD_CLIECASH;
	
	@Column(name="COD_CLASEORD")
	private  String COD_CLASEORD;

	@Column(name="COD_IDORDEN")
	private  String COD_IDORDEN;
	
	@Column(name="COD_ACCION")
	private  int COD_ACCION;
	
	@Column(name="COD_IDACCION")
	private  int COD_IDACCION;
	
	@Column(name="COD_USUARIO")
	private  String COD_USUARIO;
	
	@Column(name="FEC_ACCIO")
	private  Date FEC_ACCIO;
	
	@Column(name="COD_USUFIRMA")
	private  String COD_USUFIRMA;
	
	@Column(name="COD_USUPODER")
	private  String COD_USUPODER;
	
	@Column(name="COD_ESTADFIC")
	private  String COD_ESTADFIC;
	
	@Column(name="FEC_ACCION")
	private  Date FEC_ACCION;
	
	@Column(name="AUD_FMODIFIC")
	private  Date AUD_FMODIFIC;
	
	@Column(name="AUD_USUARIO")
	private  String AUD_USUARIO;
	
	@Column(name="COD_IPCLIENT")
	private  String COD_IPCLIENT;
	
	@Column(name="COD_APPORIG")
	private  String COD_APPORIG;

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

	public int getCOD_ACCION() {
		return COD_ACCION;
	}

	public void setCOD_ACCION(int cOD_ACCION) {
		COD_ACCION = cOD_ACCION;
	}

	public int getCOD_IDACCION() {
		return COD_IDACCION;
	}

	public void setCOD_IDACCION(int cOD_IDACCION) {
		COD_IDACCION = cOD_IDACCION;
	}

	public String getCOD_USUARIO() {
		return COD_USUARIO;
	}

	public void setCOD_USUARIO(String cOD_USUARIO) {
		COD_USUARIO = cOD_USUARIO;
	}

	public Date getFEC_ACCIO() {
		return FEC_ACCIO;
	}

	public void setFEC_ACCIO(Date fEC_ACCIO) {
		FEC_ACCIO = fEC_ACCIO;
	}

	public String getCOD_USUFIRMA() {
		return COD_USUFIRMA;
	}

	public void setCOD_USUFIRMA(String cOD_USUFIRMA) {
		COD_USUFIRMA = cOD_USUFIRMA;
	}

	public String getCOD_USUPODER() {
		return COD_USUPODER;
	}

	public void setCOD_USUPODER(String cOD_USUPODER) {
		COD_USUPODER = cOD_USUPODER;
	}

	public String getCOD_ESTADFIC() {
		return COD_ESTADFIC;
	}

	public void setCOD_ESTADFIC(String cOD_ESTADFIC) {
		COD_ESTADFIC = cOD_ESTADFIC;
	}

	public Date getFEC_ACCION() {
		return FEC_ACCION;
	}

	public void setFEC_ACCION(Date fEC_ACCION) {
		FEC_ACCION = fEC_ACCION;
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

	public String getCOD_IPCLIENT() {
		return COD_IPCLIENT;
	}

	public void setCOD_IPCLIENT(String cOD_IPCLIENT) {
		COD_IPCLIENT = cOD_IPCLIENT;
	}

	public String getCOD_APPORIG() {
		return COD_APPORIG;
	}

	public void setCOD_APPORIG(String cOD_APPORIG) {
		COD_APPORIG = cOD_APPORIG;
	}	
	
}
