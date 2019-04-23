package com.bbva.pibee.web.dto.notifi.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConfigurationEntityRequest implements Serializable
{
	private static final long serialVersionUID = 1L;

	@NotNull
	private int code;
	private State state;	
	private int idOperation;	
	private String userReference;	
	private String userId;
	
	private UserEntityRequest userEntityRequest;


	
	
	@JsonProperty("code")
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	@JsonProperty("state")
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	
	@JsonProperty("idOperation")
	public int getIdOperation() {
		return idOperation;
	}
	public void setIdOperation(int idOperation) {
		this.idOperation = idOperation;
	}
	@JsonProperty("userReference")
	public String getUserReference() {
		return userReference;
	}
	public void setUserReference(String userReference) {
		this.userReference = userReference;
	}
	@JsonProperty("userId")
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@JsonProperty("deviceInformation")
	public UserEntityRequest getUserEntityRequest() {
		return userEntityRequest;
	}
	public void setUserEntityRequest(UserEntityRequest userEntityRequest) {
		this.userEntityRequest = userEntityRequest;
	}

	
	
}
