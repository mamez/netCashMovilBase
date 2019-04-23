package com.bbva.pibee.web.dto.response.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AmountModel implements Serializable{ 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String amount;
	private String currency;
	
	@JsonProperty("amount")
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	@JsonProperty("currency")
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
