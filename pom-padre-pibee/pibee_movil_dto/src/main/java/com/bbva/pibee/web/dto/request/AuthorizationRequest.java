package com.bbva.pibee.web.dto.request;

import java.util.List;

import javax.validation.constraints.NotNull;

public class AuthorizationRequest {
	
	@NotNull
	private String Token;
	
	@NotNull
	private String operationKey;
	
	@NotNull
	private List<OperationAuthorizationRequest> operationAuthorization;
	
	public String getOperationKey() {
		return operationKey;
	}
	public void setOperationKey(String operationKey) {
		this.operationKey = operationKey;
	}
	public String getToken() {
		return Token;
	}
	public void setToken(String token) {
		Token = token;
	}
	public List<OperationAuthorizationRequest> getOperationAuthorization() {
		return operationAuthorization;
	}
	public void setOperationAuthorization(List<OperationAuthorizationRequest> operationAuthorization) {
		this.operationAuthorization = operationAuthorization;
	}
	
	
}

