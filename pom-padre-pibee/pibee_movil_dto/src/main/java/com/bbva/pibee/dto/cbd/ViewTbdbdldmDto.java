package com.bbva.pibee.dto.cbd;

import com.bbva.pibee.arq.annotations.Column;

public class ViewTbdbdldmDto 
{
	//Vista para Tipo Documento y Forma de pagos
	
	@Column(name="COD_CATALOG")
	private String COD_CATALOG;
	
	@Column(name="COD_CLAVELIT")
	private String COD_CLAVELIT;
	
	@Column(name="COD_IDIOMA")
	private int COD_IDIOMA;
	
	@Column(name="DES_LITECOR")
	private String DES_LITECOR;
	
	@Column(name="DES_LITELAR")
	private String DES_LITELAR;
	
	@Column(name="AUD_USUARIO")
	private String AUD_USUARIO;
	
	@Column(name="AUD_FMODIFIC")
	private String AUD_FMODIFIC;

	public String getCOD_CATALOG() {
		return COD_CATALOG;
	}

	public void setCOD_CATALOG(String cOD_CATALOG) {
		COD_CATALOG = cOD_CATALOG;
	}

	public String getCOD_CLAVELIT() {
		return COD_CLAVELIT;
	}

	public void setCOD_CLAVELIT(String cOD_CLAVELIT) {
		COD_CLAVELIT = cOD_CLAVELIT;
	}

	public int getCOD_IDIOMA() {
		return COD_IDIOMA;
	}

	public void setCOD_IDIOMA(int cOD_IDIOMA) {
		COD_IDIOMA = cOD_IDIOMA;
	}

	public String getDES_LITECOR() {
		return DES_LITECOR;
	}

	public void setDES_LITECOR(String dES_LITECOR) {
		DES_LITECOR = dES_LITECOR;
	}

	public String getDES_LITELAR() {
		return DES_LITELAR;
	}

	public void setDES_LITELAR(String dES_LITELAR) {
		DES_LITELAR = dES_LITELAR;
	}

	public String getAUD_USUARIO() {
		return AUD_USUARIO;
	}

	public void setAUD_USUARIO(String aUD_USUARIO) {
		AUD_USUARIO = aUD_USUARIO;
	}

	public String getAUD_FMODIFIC() {
		return AUD_FMODIFIC;
	}

	public void setAUD_FMODIFIC(String aUD_FMODIFIC) {
		AUD_FMODIFIC = aUD_FMODIFIC;
	}
		
}
