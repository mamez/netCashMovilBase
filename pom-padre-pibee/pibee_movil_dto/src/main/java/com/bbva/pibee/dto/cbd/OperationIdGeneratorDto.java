package com.bbva.pibee.dto.cbd;

import java.util.Date;

import com.bbva.pibee.arq.annotations.Column;

public class OperationIdGeneratorDto {

	//Campos de la tabla TTLCLGID
	
	@Column(name="COD_IDENTIFI")
	private String COD_IDENTIFI;
	
	@Column(name="COD_LOCALIZA")
	private String COD_LOCALIZA;
	
	@Column(name="COD_CCONTROL")
	private String COD_CCONTROL;
	
	@Column(name="QNU_IDORDEN")
	private Long QNU_IDORDEN;
	
	@Column(name="QNU_IDORDEN2")
	private String QNU_IDORDEN2;
	
	@Column(name="AUD_FMODIFIC")
	private Date AUD_FMODIFIC;
	
	@Column(name="AUD_USUARIO")
	private String AUD_USUARIO;

	public String getCOD_IDENTIFI() {
		return COD_IDENTIFI;
	}

	public void setCOD_IDENTIFI(String cOD_IDENTIFI) {
		COD_IDENTIFI = cOD_IDENTIFI;
	}

	public String getCOD_LOCALIZA() {
		return COD_LOCALIZA;
	}

	public void setCOD_LOCALIZA(String cOD_LOCALIZA) {
		COD_LOCALIZA = cOD_LOCALIZA;
	}

	public String getCOD_CCONTROL() {
		return COD_CCONTROL;
	}

	public void setCOD_CCONTROL(String cOD_CCONTROL) {
		COD_CCONTROL = cOD_CCONTROL;
	}

	public Long getQNU_IDORDEN() {
		return QNU_IDORDEN;
	}

	public void setQNU_IDORDEN(Long qNU_IDORDEN) {
		QNU_IDORDEN = qNU_IDORDEN;
	}

	public String getQNU_IDORDEN2() {
		return QNU_IDORDEN2;
	}

	public void setQNU_IDORDEN2(String qNU_IDORDEN2) {
		QNU_IDORDEN2 = qNU_IDORDEN2;
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
	
	
	
}
