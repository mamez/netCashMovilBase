package com.bbva.pibee.dto.notification;

import com.bbva.pibee.arq.annotations.Column;

public class UserDto 
{
	@Column(name="REFERENCE_USU")
	private String  REFERENCE_USU;
	
	@Column(name="ID_USU")
	private String  ID_USU;
	
	@Column(name="DEVICE_USU")
	private String  DEVICE_USU;
	
	@Column(name="TOKEN_USU")
	private String  TOKEN_USU;
	
	@Column(name="PLATFORM_USU")
	private String  PLATFORM_USU;
	
	@Column(name="VERSION_USU")
	private String  VERSION_USU;
	
	@Column(name="CREATIONDATE_USU")
	private String  CREATIONDATE_USU;
	
	@Column(name="MODIFIDATE_USU")
	private String  MODIFIDATE_USU;
	
	@Column(name="STATE_USU")
	private String  STATE_USU;
	
	@Column(name="ENROLLMENT")
	private String  ENROLLMENT;

	public String getENROLLMENT() {
		return ENROLLMENT;
	}

	public void setENROLLMENT(String eNROLLMENT) {
		ENROLLMENT = eNROLLMENT;
	}

	public String getREFERENCE_USU() {
		return REFERENCE_USU;
	}

	public void setREFERENCE_USU(String rEFERENCE_USU) {
		REFERENCE_USU = rEFERENCE_USU;
	}

	public String getID_USU() {
		return ID_USU;
	}

	public void setID_USU(String iD_USU) {
		ID_USU = iD_USU;
	}

	public String getDEVICE_USU() {
		return DEVICE_USU;
	}

	public void setDEVICE_USU(String dEVICE_USU) {
		DEVICE_USU = dEVICE_USU;
	}

	public String getTOKEN_USU() {
		return TOKEN_USU;
	}

	public void setTOKEN_USU(String tOKEN_USU) {
		TOKEN_USU = tOKEN_USU;
	}

	public String getPLATFORM_USU() {
		return PLATFORM_USU;
	}

	public void setPLATFORM_USU(String pLATFORM_USU) {
		PLATFORM_USU = pLATFORM_USU;
	}

	public String getVERSION_USU() {
		return VERSION_USU;
	}

	public void setVERSION_USU(String vERSION_USU) {
		VERSION_USU = vERSION_USU;
	}

	public String getCREATIONDATE_USU() {
		return CREATIONDATE_USU;
	}

	public void setCREATIONDATE_USU(String cREATIONDATE_USU) {
		CREATIONDATE_USU = cREATIONDATE_USU;
	}

	public String getMODIFIDATE_USU() {
		return MODIFIDATE_USU;
	}

	public void setMODIFIDATE_USU(String mODIFIDATE_USU) {
		MODIFIDATE_USU = mODIFIDATE_USU;
	}

	public String getSTATE_USU() {
		return STATE_USU;
	}

	public void setSTATE_USU(String sTATE_USU) {
		STATE_USU = sTATE_USU;
	}

	@Override
	public String toString() {
		return "UserDto [REFERENCE_USU=" + REFERENCE_USU + ", ID_USU=" + ID_USU + ", DEVICE_USU=" + DEVICE_USU
				+ ", TOKEN_USU=" + TOKEN_USU + ", PLATFORM_USU=" + PLATFORM_USU + ", VERSION_USU=" + VERSION_USU
				+ ", CREATIONDATE_USU=" + CREATIONDATE_USU + ", MODIFIDATE_USU=" + MODIFIDATE_USU + ", STATE_USU="
				+ STATE_USU + ", ENROLLMENT=" + ENROLLMENT + "]";
	}





		
}
