package com.bbva.pibee.web.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PayeeRequest implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private PayeeEntityRequest payee;

	@JsonProperty("payee")
	public PayeeEntityRequest getPayee() {
		return payee;
	}

	public void setPayee(PayeeEntityRequest payee) {
		this.payee = payee;
	}
	
}
