package com.bbva.pibee.dto.notification;

import com.bbva.pibee.arq.annotations.Column;

public class NotificationDto 
{
	//Tabla TNCMCONF - Notificación
	
	@Column(name="ID_NOTI")
	private String ID_NOTI;
	
	@Column(name="DATE_NOTI")
	private String DATE_NOTI;
	
	@Column(name="STATE_NOTI")
	private String STATE_NOTI;
	
	@Column(name="TITLE_NOTI")
	private String TITLE_NOTI;
	
	@Column(name="DESCRIPTION_NOTI")
	private String DESCRIPTION_NOTI;
	
	@Column(name="CODE_TRAN")
	private String CODE_TRAN;
	
	@Column(name="FK_CONFIGURATION")
	private int FK_CONFIGURATION;
	
	@Column(name="ORIGIN_NOTI")
	private String ORIGIN_NOTI;

	public String getID_NOTI() {
		return ID_NOTI;
	}

	public void setID_NOTI(String iD_NOTI) {
		ID_NOTI = iD_NOTI;
	}

	public String getDATE_NOTI() {
		return DATE_NOTI;
	}

	public void setDATE_NOTI(String dATE_NOTI) {
		DATE_NOTI = dATE_NOTI;
	}

	public String getSTATE_NOTI() {
		return STATE_NOTI;
	}

	public void setSTATE_NOTI(String sTATE_NOTI) {
		STATE_NOTI = sTATE_NOTI;
	}

	public String getTITLE_NOTI() {
		return TITLE_NOTI;
	}

	public void setTITLE_NOTI(String tITLE_NOTI) {
		TITLE_NOTI = tITLE_NOTI;
	}

	public String getDESCRIPTION_NOTI() {
		return DESCRIPTION_NOTI;
	}

	public void setDESCRIPTION_NOTI(String dESCRIPTION_NOTI) {
		DESCRIPTION_NOTI = dESCRIPTION_NOTI;
	}

	public String getCODE_TRAN() {
		return CODE_TRAN;
	}

	public void setCODE_TRAN(String cODE_TRAN) {
		CODE_TRAN = cODE_TRAN;
	}

	public int getFK_CONFIGURATION() {
		return FK_CONFIGURATION;
	}

	public void setFK_CONFIGURATION(int fK_CONFIGURATION) {
		FK_CONFIGURATION = fK_CONFIGURATION;
	}

	public String getORIGIN_NOTI() {
		return ORIGIN_NOTI;
	}

	public void setORIGIN_NOTI(String oRIGIN_NOTI) {
		ORIGIN_NOTI = oRIGIN_NOTI;
	}
}
