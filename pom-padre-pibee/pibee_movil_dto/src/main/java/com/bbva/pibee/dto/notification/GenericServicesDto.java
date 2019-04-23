package com.bbva.pibee.dto.notification;

import com.bbva.pibee.arq.annotations.Column;

public class GenericServicesDto {
	
	//CAMPOS DE LA CONSULTA 
	
	@Column(name="ID_SER")
	private int ID_SER;
	
	@Column(name="NAME_SER")
	private String NAME_SER;
	
	@Column(name="ID_OPE")
	private int ID_OPE;
	
	@Column(name="COD_OPE")
	private String COD_OPE;
	
	@Column(name="NAME_OPE")
	private String NAME_OPE;
	
	@Column(name="ACTION_OPE")
	private String ACTION_OPE;
	
	@Column(name="STATE_CONFIGURATION")
	private String STATE_CONFIGURATION;
	
	@Column(name="ID_CONFIGURATION")
	private int ID_CONFIGURATION;

	public int getID_SER() {
		return ID_SER;
	}

	public void setID_SER(int iD_SER) {
		ID_SER = iD_SER;
	}

	public String getNAME_SER() {
		return NAME_SER;
	}

	public void setNAME_SER(String nAME_SER) {
		NAME_SER = nAME_SER;
	}

	public int getID_OPE() {
		return ID_OPE;
	}

	public void setID_OPE(int iD_OPE) {
		ID_OPE = iD_OPE;
	}

	public String getCOD_OPE() {
		return COD_OPE;
	}

	public void setCOD_OPE(String cOD_OPE) {
		COD_OPE = cOD_OPE;
	}

	public String getNAME_OPE() {
		return NAME_OPE;
	}

	public void setNAME_OPE(String nAME_OPE) {
		NAME_OPE = nAME_OPE;
	}

	public String getACTION_OPE() {
		return ACTION_OPE;
	}

	public void setACTION_OPE(String aCTION_OPE) {
		ACTION_OPE = aCTION_OPE;
	}

	public String getSTATE_CONFIGURATION() {
		return STATE_CONFIGURATION;
	}

	public void setSTATE_CONFIGURATION(String sTATE_CONFIGURATION) {
		STATE_CONFIGURATION = sTATE_CONFIGURATION;
	}

	public int getID_CONFIGURATION() {
		return ID_CONFIGURATION;
	}

	public void setID_CONFIGURATION(int iD_CONFIGURATION) {
		ID_CONFIGURATION = iD_CONFIGURATION;
	}

	
	
	
}
