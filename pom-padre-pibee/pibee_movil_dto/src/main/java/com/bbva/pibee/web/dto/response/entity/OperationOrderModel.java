package com.bbva.pibee.web.dto.response.entity;

public class OperationOrderModel {
	
	private String concept;
	
	private double amount;
	
	private PayeesModel payee;

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double ammount) {
		this.amount = ammount;
	}

	public PayeesModel getPayee() {
		return payee;
	}

	public void setPayee(PayeesModel payee) {
		this.payee = payee;
	}	
	
	
	
}
