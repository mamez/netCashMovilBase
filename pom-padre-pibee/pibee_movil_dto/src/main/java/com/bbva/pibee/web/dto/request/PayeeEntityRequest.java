package com.bbva.pibee.web.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PayeeEntityRequest implements Serializable
{
	private static final long serialVersionUID = 1L;
	@NotNull
	private DocumentEntityRequest document;
	@NotNull
	private String name;
	@NotNull
	private String email;
	@NotNull
	private String address;
	@NotNull
	private MethodPaymentEntityRequest methodPayment;
	@NotNull
	private BanksEntityRequest bank;
	@NotNull
	private AccountPayeeEntityRequest accountPayees;
	@NotNull
	private IssuingEntityRequest issuing;
	
	@JsonProperty("identityDocuments")
	public DocumentEntityRequest getDocument() {
		return document;
	}
	public void setDocument(DocumentEntityRequest document) {
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
	public MethodPaymentEntityRequest getMethodPayment() {
		return methodPayment;
	}
	public void setMethodPayment(MethodPaymentEntityRequest methodPayment) {
		this.methodPayment = methodPayment;
	}
	@JsonProperty("bank")
	public BanksEntityRequest getBank() {
		return bank;
	}	
	public void setBank(BanksEntityRequest bank) {
		this.bank = bank;
	}
	@JsonProperty("accountPayees")
	public AccountPayeeEntityRequest getAccountPayees() {
		return accountPayees;
	}
	public void setAccountPayees(AccountPayeeEntityRequest accountPayees) {
		this.accountPayees = accountPayees;
	}
	@JsonProperty("issuing")
	public IssuingEntityRequest getIssuing() {
		return issuing;
	}
	public void setIssuing(IssuingEntityRequest issuing) {
		this.issuing = issuing;
	}
}
