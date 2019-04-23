package com.bbva.pibee.dto.notification;

import java.util.List;

import com.bbva.pibee.arq.annotations.Column;

public class ConfigurationDto 
{
	//Tabla TNCMCONF - Configuración
	
	@Column(name="ID_CONF")
	private int ID_CONF;
	
	@Column(name="STATE_CONF")
	private String STATE_CONF;
	
	@Column(name="REFERENCE_USU")
	private String REFERENCE_USU;
	
	@Column(name="ID_USU")
	private String ID_USU;
	
	@Column(name="DATE_AUDI")
	private String DATE_AUDI;
	
	@Column(name="FK_OPERATION")
	private int FK_OPERATION;
	
	private List<NotificationDto> listNotificationDto;

	public int getID_CONF() {
		return ID_CONF;
	}

	public void setID_CONF(int iD_CONF) {
		ID_CONF = iD_CONF;
	}

	public String getSTATE_CONF() {
		return STATE_CONF;
	}

	public void setSTATE_CONF(String sTATE_CONF) {
		STATE_CONF = sTATE_CONF;
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

	public String getDATE_AUDI() {
		return DATE_AUDI;
	}

	public void setDATE_AUDI(String dATE_AUDI) {
		DATE_AUDI = dATE_AUDI;
	}	

	public int getFK_OPERATION() {
		return FK_OPERATION;
	}

	public void setFK_OPERATION(int fK_OPERATION) {
		FK_OPERATION = fK_OPERATION;
	}

	public List<NotificationDto> getListNotificationDto() {
		return listNotificationDto;
	}

	public void setListNotificationDto(List<NotificationDto> listNotificationDto) {
		this.listNotificationDto = listNotificationDto;
	}
}
