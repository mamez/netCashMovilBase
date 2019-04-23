package com.bbva.pibee.web.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountPayeeEntityRequest implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String accountNumber;
	@NotNull
	private String accountType;
	
	@JsonProperty("accountNumber")
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	@JsonProperty("accountType")
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
}
