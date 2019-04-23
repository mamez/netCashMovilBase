package com.bbva.pibee.web.dto.notifi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserModel 
{
	private String reference;
	private String user;
	private String device;
	private String token;
	private String platform;
	private String version;
	private String alias;
	private String creationDate;
	private String modificationDate;
	private String state;
	private String stateProcess;
	
	@JsonProperty("reference")
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	@JsonProperty("user")
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	@JsonProperty("device")
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	
	@JsonProperty("token")
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	@JsonProperty("platform")
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	@JsonProperty("version")
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	@JsonProperty("alias")
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	@JsonProperty("creationDate")
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	@JsonProperty("modificationDate")
	public String getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(String modificationDate) {
		this.modificationDate = modificationDate;
	}
	
	@JsonProperty("state")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@JsonProperty("stateProcess")
	public String getStateProcess() {
		return stateProcess;
	}
	public void setStateProcess(String stateProcess) {
		this.stateProcess = stateProcess;
	}
}
