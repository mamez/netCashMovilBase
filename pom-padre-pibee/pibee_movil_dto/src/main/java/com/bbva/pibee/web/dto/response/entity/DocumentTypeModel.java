package com.bbva.pibee.web.dto.response.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DocumentTypeModel {
	private String id;
	private String internalCode;
	private String description;
	
	@JsonProperty("id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@JsonProperty("internalCode")
	public String getInternalCode() {
		return internalCode;
	}
	public void setInternalCode(String internalCode) {
		this.internalCode = internalCode;
	}	
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
  
}
