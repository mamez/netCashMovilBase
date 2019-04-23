package com.bbva.pibee.web.dto.response.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String accountId;
	private String accountNumber;
	private String accountType;
	private String accountDescription;
	private String accountAlias;
	private AmountModel availableBalance;
	private AmountModel currentBalance;
	
	@JsonProperty("accountId")
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
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
	
	 @JsonProperty("accountDescription")
	public String getAccountDescription() {
		return accountDescription;
	}
	public void setAccountDescription(String accountDescription) {
		this.accountDescription = accountDescription;
	}
	
	 @JsonProperty("accountAlias")
	public String getAccountAlias() {
		return accountAlias;
	}
	public void setAccountAlias(String accountAlias) {
		this.accountAlias = accountAlias;
	}
	
	@JsonProperty("availableBalance")
	public AmountModel getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(AmountModel availableBalance) {
		this.availableBalance = availableBalance;
	}
	
	@JsonProperty("currentBalance")
	public AmountModel getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(AmountModel currentBalance) {
		this.currentBalance = currentBalance;
	} 
}
