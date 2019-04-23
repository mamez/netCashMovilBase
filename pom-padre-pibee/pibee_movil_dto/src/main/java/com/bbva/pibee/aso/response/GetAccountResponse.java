package com.bbva.pibee.aso.response;

import com.bbva.pibee.aso.response.dto.Account;

public class GetAccountResponse {
	private Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "GetAccountResponse [account=" + account + "]";
	}
	
	
}
