package com.bbva.pibee.aso.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.bbva.pibee.aso.response.dto.Account;
import com.bbva.pibee.aso.response.dto.Pagination;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class ListAccountResponse {
	
	@XmlElement(name="accounts")
	private List<Account> accounts;
	
	@XmlElement(name="pagination")
	private Pagination pagination;

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	@Override
	public String toString() {
		return "ListAccountResponse [accounts=" + accounts + ", pagination=" + pagination + "]";
	}

	
}
