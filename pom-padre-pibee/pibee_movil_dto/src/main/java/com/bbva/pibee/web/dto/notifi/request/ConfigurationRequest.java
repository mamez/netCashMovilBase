package com.bbva.pibee.web.dto.notifi.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConfigurationRequest implements Serializable
{
	private static final long serialVersionUID = 1L;	
	@NotNull
	private ConfigurationEntityRequest config;
	
	@JsonProperty("configuration")
	public ConfigurationEntityRequest getConfig() {
		return config;
	}
	public void setConfig(ConfigurationEntityRequest config) {
		this.config = config;
	}
	
}
