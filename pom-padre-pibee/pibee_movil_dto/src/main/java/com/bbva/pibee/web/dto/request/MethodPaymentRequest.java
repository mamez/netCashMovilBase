package com.bbva.pibee.web.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MethodPaymentRequest implements Serializable
{
	private static final long serialVersionUID = 1L;
	@NotNull
	private MethodPaymentEntityRequest methodPayment;
	
	@JsonProperty("methodPayment")
	public MethodPaymentEntityRequest getMethodPayment() {
		return methodPayment;
	}
	public void setMethodPayment(MethodPaymentEntityRequest methodPayment) {
		this.methodPayment = methodPayment;
	}
}
