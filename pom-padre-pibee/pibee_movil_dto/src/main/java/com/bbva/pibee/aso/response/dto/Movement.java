package com.bbva.pibee.aso.response.dto;

import java.util.Date;

public class Movement {
	private Amount availableBalance;
	private Amount currentBalance;
	private Date operationDate;
	private Date valueDate;
	private String description;
	private String observation;
	private Descriptor type;
	private CommonName bank;
	private String id;
	private String accountNumber;

	public Amount getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(Amount availableBalance) {
		this.availableBalance = availableBalance;
	}

	public Amount getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Amount currentBalance) {
		this.currentBalance = currentBalance;
	}

	public Date getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

	public Date getValueDate() {
		return valueDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Descriptor getType() {
		return type;
	}

	public void setType(Descriptor type) {
		this.type = type;
	}

	public CommonName getBank() {
		return bank;
	}

	public void setBank(CommonName bank) {
		this.bank = bank;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "Movement [availableBalance=" + availableBalance + ", currentBalance=" + currentBalance
				+ ", operationDate=" + operationDate + ", valueDate=" + valueDate + ", description=" + description
				+ ", observation=" + observation + ", type=" + type + ", bank=" + bank + ", id=" + id
				+ ", accountNumber=" + accountNumber + "]";
	}
	
	
}