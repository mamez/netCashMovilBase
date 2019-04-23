package com.bbva.pibee.web.dto.notifi.request;

import java.io.Serializable;
import java.util.List;

import com.bbva.pibee.arq.annotations.Column;
import com.bbva.pibee.dto.notification.ConfigurationDto;

public class OperationEntyRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="ID_OPE")
	private int ID_OPE;
	
	@Column(name="COD_OPE")
	private String COD_OPE;
	
	@Column(name="NAME_OPE")
	private String NAME_OPE;
	
	@Column(name="ACTION_OPE")
	private String ACTION_OPE;
	
	@Column(name="STATE_OPE")
	private String STATE_OPE;
	
	@Column(name="FK_SERVICES")
	private int FK_SERVICES;
	
	private List<ConfigurationDto> lisConfigurationDto;
	private ConfigurationDto configurationDto;
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
	public String getSTATE_OPE() {
		return STATE_OPE;
	}
	public void setSTATE_OPE(String sTATE_OPE) {
		STATE_OPE = sTATE_OPE;
	}
	public int getFK_SERVICES() {
		return FK_SERVICES;
	}
	public void setFK_SERVICES(int fK_SERVICES) {
		FK_SERVICES = fK_SERVICES;
	}
	public List<ConfigurationDto> getLisConfigurationDto() {
		return lisConfigurationDto;
	}
	public void setLisConfigurationDto(List<ConfigurationDto> lisConfigurationDto) {
		this.lisConfigurationDto = lisConfigurationDto;
	}
	public ConfigurationDto getConfigurationDto() {
		return configurationDto;
	}
	public void setConfigurationDto(ConfigurationDto configurationDto) {
		this.configurationDto = configurationDto;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
