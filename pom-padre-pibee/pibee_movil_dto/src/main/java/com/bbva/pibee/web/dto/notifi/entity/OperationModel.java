package com.bbva.pibee.web.dto.notifi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OperationModel 
{
	private int id;
	private String code;
	private String name;
	private String action;
	private String stateConfiguration;
	private String idConfiguration;
	
	@JsonProperty("id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@JsonProperty("code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@JsonProperty("action")
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	@JsonProperty("stateConfiguration")
	public String getStateConfiguration() {
		return stateConfiguration;
	}
	public void setStateConfiguration(String stateConfiguration) {
		this.stateConfiguration = stateConfiguration;
	}
	@JsonProperty("idConfiguration")
	public String getIdConfiguration() {
		return idConfiguration;
	}
	public void setIdConfiguration(String idConfiguration) {
		this.idConfiguration = idConfiguration;
	}
	
	
	
}
