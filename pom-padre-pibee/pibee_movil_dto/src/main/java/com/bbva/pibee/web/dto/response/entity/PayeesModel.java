package com.bbva.pibee.web.dto.response.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PayeesModel {
	private DocumentModel document;
	private String name;
	private String email;
	private String address;
	private MethodPaymentModel methodPayment;
	private BanksModel bank;
	private AccountModel accountPayees;
	private IssuingModel issuing;
	
	@JsonProperty("identityDocuments")
	public DocumentModel getDocument() {
		return document;
	}
	public void setDocument(DocumentModel document) {
		this.document = document;
	}
	
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty("email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@JsonProperty("address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@JsonProperty("methodPayment")
	public MethodPaymentModel getMethodPayment() {
		return methodPayment;
	}
	public void setMethodPayment(MethodPaymentModel methodPayment) {
		this.methodPayment = methodPayment;
	}
	
	@JsonProperty("bank")
	public BanksModel getBank() {
		return bank;
	}
	public void setBank(BanksModel bank) {
		this.bank = bank;
	}
	
	@JsonProperty("accountPayees")
	public AccountModel getAccountPayees() {
		return accountPayees;
	}
	public void setAccountPayees(AccountModel accountPayees) {
		this.accountPayees = accountPayees;
	}
	
	@JsonProperty("issuing")
	public IssuingModel getIssuing() {
		return issuing;
	}
	public void setIssuing(IssuingModel issuing) {
		this.issuing = issuing;
	}
	
	
	
}
