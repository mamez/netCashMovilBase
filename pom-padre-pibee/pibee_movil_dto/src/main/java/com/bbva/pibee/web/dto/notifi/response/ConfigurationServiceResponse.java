package com.bbva.pibee.web.dto.notifi.response;

import java.util.List;
import com.bbva.pibee.web.dto.notifi.entity.ConfigurationModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ConfigurationServiceResponse
{
	public List<ConfigurationModel> listConfiguration;
	
	@JsonProperty("configuration")
	public List<ConfigurationModel> getListConfiguration() {
		return listConfiguration;
	}

	public void setListConfiguration(List<ConfigurationModel> listConfiguration) {
		this.listConfiguration = listConfiguration;
	}	
}
