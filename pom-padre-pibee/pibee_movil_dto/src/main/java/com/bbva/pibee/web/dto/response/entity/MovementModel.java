package com.bbva.pibee.web.dto.response.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovementModel implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dateTransaction;
	 private String dateValue;
	 private String movementDescription;
	 private String observation;
	 private String movementType;
	 private String bank;
     private String account;
     private AmountModel availableBalance;
     private AmountModel currentBalance;
     
     @JsonProperty("dateTransaction")
	public String getDateTransaction() {
		return dateTransaction;
	}
	public void setDateTransaction(String dateTransaction) {
		this.dateTransaction = dateTransaction;
	}
	
	@JsonProperty("dateValue")
	public String getDateValue() {
		return dateValue;
	}
	public void setDateValue(String dateValue) {
		this.dateValue = dateValue;
	}
	
	@JsonProperty("movementDescription")
	public String getMovementDescription() {
		return movementDescription;
	}
	public void setMovementDescription(String movementDescription) {
		this.movementDescription = movementDescription;
	}
	
	@JsonProperty("observation")
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	
	@JsonProperty("movementType")
	public String getMovementType() {
		return movementType;
	}
	public void setMovementType(String movementType) {
		this.movementType = movementType;
	}
	
	@JsonProperty("bank")
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	
	@JsonProperty("account")
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
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
