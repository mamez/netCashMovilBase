package com.bbva.pibee.web.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountPayeeRequest implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private AccountPayeeEntityRequest accountPayees;

	@JsonProperty("accountPayees")
	public AccountPayeeEntityRequest getAccountPayees() {
		return accountPayees;
	}

	public void setAccountPayees(AccountPayeeEntityRequest accountPayees) {
		this.accountPayees = accountPayees;
	}
	
}
