package com.bbva.pibee.web.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IssuingRequest implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private IssuingEntityRequest issuing;
	
	@JsonProperty("issuing")
	public IssuingEntityRequest getIssuing() {
		return issuing;
	}

	public void setIssuing(IssuingEntityRequest issuing) {
		this.issuing = issuing;
	}
}
