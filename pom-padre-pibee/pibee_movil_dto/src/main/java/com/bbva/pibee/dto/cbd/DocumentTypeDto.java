package com.bbva.pibee.dto.cbd;

import com.bbva.pibee.arq.annotations.Column;

public class DocumentTypeDto 
{
	//Campos tabla Ttlcltdl // Tipo Documento
	
	@Column(name="COD_BANCOGBL")
	private int COD_BANCOGBL;
	
	@Column(name="XTI_DOCIDLEG")
	private String XTI_DOCIDLEG;
	
	@Column(name="XTI_PERSFISC")
	private String XTI_PERSFISC;
	
	@Column(name="DES_DOCIDLEG")
	private String DES_DOCIDLEG;
	
	@Column(name="AUD_FMODIFIC")
	private String AUD_FMODIFIC;
	
	@Column(name="AUD_USUARIO")
	private String AUD_USUARIO;
	
	@Column(name="COD_IDIOMA")
	private String COD_IDIOMA;

	public int getCOD_BANCOGBL() {
		return COD_BANCOGBL;
	}

	public void setCOD_BANCOGBL(int cOD_BANCOGBL) {
		COD_BANCOGBL = cOD_BANCOGBL;
	}

	public String getXTI_DOCIDLEG() {
		return XTI_DOCIDLEG;
	}

	public void setXTI_DOCIDLEG(String xTI_DOCIDLEG) {
		XTI_DOCIDLEG = xTI_DOCIDLEG;
	}

	public String getXTI_PERSFISC() {
		return XTI_PERSFISC;
	}

	public void setXTI_PERSFISC(String xTI_PERSFISC) {
		XTI_PERSFISC = xTI_PERSFISC;
	}

	public String getDES_DOCIDLEG() {
		return DES_DOCIDLEG;
	}

	public void setDES_DOCIDLEG(String dES_DOCIDLEG) {
		DES_DOCIDLEG = dES_DOCIDLEG;
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

	public String getCOD_IDIOMA() {
		return COD_IDIOMA;
	}

	public void setCOD_IDIOMA(String cOD_IDIOMA) {
		COD_IDIOMA = cOD_IDIOMA;
	}		
}
