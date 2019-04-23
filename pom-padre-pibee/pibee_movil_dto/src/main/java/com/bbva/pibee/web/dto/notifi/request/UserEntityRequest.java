package com.bbva.pibee.web.dto.notifi.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserEntityRequest implements Serializable{
	private static final long serialVersionUID = 1L;
		
	private String reference;
	private String user;
	private String device;
	private String token;
	private String platform;
	private String version;
	private String creationDate;	
	private String modificationDate;
	private StateUsuario state;
	public String Erollment;
	
	public String getErollment() {
		return Erollment;
	}
	public void setErollment(String Erollment) {
		this.Erollment = Erollment;
	}
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
	public StateUsuario getState() {
		return state;
	}
	public void setState(StateUsuario state) {
		this.state = state;
	}

}
