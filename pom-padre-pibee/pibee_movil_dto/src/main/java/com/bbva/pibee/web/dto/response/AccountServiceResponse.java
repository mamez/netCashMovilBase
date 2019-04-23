package com.bbva.pibee.web.dto.response;

import java.util.List;

import com.bbva.pibee.web.dto.response.entity.AccountModel;
import com.bbva.pibee.web.dto.response.entity.PaginationModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountServiceResponse extends PaginationModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<AccountModel> listAccount;
    
	 @JsonProperty("accounts")
	public List<AccountModel> getListAccount() {
		return listAccount;
	}

	public void setListAccount(List<AccountModel> listAccount) {
		this.listAccount = listAccount;
	}
}
