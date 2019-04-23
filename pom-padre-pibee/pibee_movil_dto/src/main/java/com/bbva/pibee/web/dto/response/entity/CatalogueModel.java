package com.bbva.pibee.web.dto.response.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CatalogueModel 
{
	private String code;
	private String description;
	
	@JsonProperty("code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
