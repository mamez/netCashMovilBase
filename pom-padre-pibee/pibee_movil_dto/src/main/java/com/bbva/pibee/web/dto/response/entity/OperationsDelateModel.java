package com.bbva.pibee.web.dto.response.entity;

public class OperationsDelateModel {
	private String idOrder;
	private String codClaseOrd;
	private OperationStatus operationStatus; 
	
	public String getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}
	public String getCodClaseOrd() {
		return codClaseOrd;
	}
	public void setCodClaseOrd(String codClaseOrd) {
		this.codClaseOrd = codClaseOrd;
	}
	public OperationStatus getOperationStatus() {
		return operationStatus;
	}
	public void setOperationStatus(OperationStatus operationStatus) {
		this.operationStatus = operationStatus;
	}
	
}
