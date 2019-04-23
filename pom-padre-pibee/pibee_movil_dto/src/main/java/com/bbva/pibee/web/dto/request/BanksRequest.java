package com.bbva.pibee.web.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BanksRequest implements Serializable
{
	private static final long serialVersionUID = 1L;
	@NotNull
	private BanksEntityRequest bank;

	@JsonProperty("bank")
	public BanksEntityRequest getBank() {
		return bank;
	}

	public void setBank(BanksEntityRequest bank) {
		this.bank = bank;
	}
}
