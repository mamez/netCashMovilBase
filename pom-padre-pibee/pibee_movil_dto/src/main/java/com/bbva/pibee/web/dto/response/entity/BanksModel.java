package com.bbva.pibee.web.dto.response.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BanksModel {
	private String id;
	private String description;
	
	@JsonProperty("id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	 
}
