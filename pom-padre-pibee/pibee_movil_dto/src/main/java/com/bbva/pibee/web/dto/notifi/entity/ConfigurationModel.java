package com.bbva.pibee.web.dto.notifi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConfigurationModel
{
	private int code;
	private String state;	
	private int idOperation;	

	
	@JsonProperty("code")
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	@JsonProperty("state")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@JsonProperty("idOperation")
	public int getIdOperation() {
		return idOperation;
	}
	public void setIdOperation(int idOperation) {
		this.idOperation = idOperation;
	}	
}
