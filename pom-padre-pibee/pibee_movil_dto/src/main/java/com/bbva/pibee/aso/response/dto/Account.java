package com.bbva.pibee.aso.response.dto;

import java.util.Date;

public class Account {
	private String id;
	private String number;
	private Descriptor type;
	private String alias;
	private Amount availableBalance;
	private Amount currentBalance;
	private Amount pendingBalance;
	private CommonName bank;
	private Date openingDate;
	private Date cutOffDate;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Descriptor getType() {
		return type;
	}

	public void setType(Descriptor type) {
		this.type = type;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

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

	public Amount getPendingBalance() {
		return pendingBalance;
	}

	public void setPendingBalance(Amount pendingBalance) {
		this.pendingBalance = pendingBalance;
	}

	public CommonName getBank() {
		return bank;
	}

	public void setBank(CommonName bank) {
		this.bank = bank;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public Date getCutOffDate() {
		return cutOffDate;
	}

	public void setCutOffDate(Date cutOffDate) {
		this.cutOffDate = cutOffDate;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", number=" + number + ", type=" + type + ", alias=" + alias
				+ ", availableBalance=" + availableBalance + ", currentBalance=" + currentBalance + ", pendingBalance="
				+ pendingBalance + ", bank=" + bank + ", openingDate=" + openingDate + ", cutOffDate=" + cutOffDate
				+ "]";
	}

	
}
