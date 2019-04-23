package com.bbva.pibee.dto.cbd;

import com.bbva.pibee.arq.annotations.PosDetail;

public class DesOrdenOol {
	
	@PosDetail(posicion="009")
	private String concept;
	
	@PosDetail(posicion="003")
	private String accountIssuing;
	
	@PosDetail(posicion="005")
	private String accountPayee;
	
	@PosDetail(posicion="007")
	private String amount;
	
	@PosDetail(posicion="008")
	private String currency;

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	public String getAccountIssuing() {
		return accountIssuing;
	}

	public void setAccountIssuing(String accountIssuing) {
		this.accountIssuing = accountIssuing;
	}

	public String getAccountPayee() {
		return accountPayee;
	}

	public void setAccountPayee(String accountPayee) {
		this.accountPayee = accountPayee;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	
}
