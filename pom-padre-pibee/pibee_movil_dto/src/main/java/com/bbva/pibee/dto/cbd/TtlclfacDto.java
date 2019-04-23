package com.bbva.pibee.dto.cbd;

import com.bbva.pibee.arq.annotations.Column;

public class TtlclfacDto 
{
	@Column(name="COD_CLIECASH")
	private  String COD_CLIECASH;
	
	@Column(name="DES_CUENORIG")
	private  String DES_CUENORIG;
	
	@Column(name="COD_USUARIO")
	private  String COD_USUARIO;
	
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

	public String getDES_CUENORIG() {
		return DES_CUENORIG;
	}

	public void setDES_CUENORIG(String dES_CUENORIG) {
		DES_CUENORIG = dES_CUENORIG;
	}

	public String getCOD_USUARIO() {
		return COD_USUARIO;
	}

	public void setCOD_USUARIO(String cOD_USUARIO) {
		COD_USUARIO = cOD_USUARIO;
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
