package com.bbva.pibee.aso.response.dto;

import java.util.Date;

public class Operation {

	private String id;
	private Descriptor type;
	private Date operationDate;
	private Amount amount;
	private String originAccount;
	private String fileName;
	private Descriptor status;
	private Date processDate;
	private String ordersNumber;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Descriptor getType() {
		return type;
	}
	public void setType(Descriptor type) {
		this.type = type;
	}
	public Amount getAmount() {
		return amount;
	}
	public void setAmount(Amount amount) {
		this.amount = amount;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Descriptor getStatus() {
		return status;
	}
	public void setStatus(Descriptor status) {
		this.status = status;
	}
	public String getOrdersNumber() {
		return ordersNumber;
	}
	public void setOrdersNumber(String ordersNumber) {
		this.ordersNumber = ordersNumber;
	}
	public Date getOperationDate() {
		return operationDate;
	}
	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}
	public String getOriginAccount() {
		return originAccount;
	}
	public void setOriginAccount(String originAccount) {
		this.originAccount = originAccount;
	}
	public Date getProcessDate() {
		return processDate;
	}
	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}
	@Override
	public String toString() {
		return "Operation [id=" + id + ", type=" + type + ", operationDate=" + operationDate + ", amount=" + amount
				+ ", originAccount=" + originAccount + ", fileName=" + fileName + ", status=" + status
				+ ", processDate=" + processDate + ", ordersNumber=" + ordersNumber + "]";
	}
	
	
}
