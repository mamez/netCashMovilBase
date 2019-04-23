package com.bbva.pibee.web.dto.response.entity;

public class OperationModel {
	
	 private String id;
	 private String originAccount;
	 private String fileName;
	 private String stateId;
	 private String stateDescription;
	 private Integer numberOrders;
     private String percentageSignature;
     private String sourceDevice;
     private String createdDate;
     private String processDate;
     private AmountModel amount;
     private TypeModel operationTypes;
     private OperationStatus operationStatus;
     //variables trasferencias
     private String operationCreator;
     
     
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOriginAccount() {
		return originAccount;
	}
	public void setOriginAccount(String originAccount) {
		this.originAccount = originAccount;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getStateId() {
		return stateId;
	}
	public void setStateId(String stateId) {
		this.stateId = stateId;
	}
	public String getStateDescription() {
		return stateDescription;
	}
	public void setStateDescription(String stateDescription) {
		this.stateDescription = stateDescription;
	}
	public Integer getNumberOrders() {
		return numberOrders;
	}
	public void setNumberOrders(Integer numberOrders) {
		this.numberOrders = numberOrders;
	}
	public String getPercentageSignature() {
		return percentageSignature;
	}
	public void setPercentageSignature(String percentageSignature) {
		this.percentageSignature = percentageSignature;
	}
	public String getSourceDevice() {
		return sourceDevice;
	}
	public void setSourceDevice(String sourceDevice) {
		this.sourceDevice = sourceDevice;
	}
	
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getProcessDate() {
		return processDate;
	}
	public void setProcessDate(String processDate) {
		this.processDate = processDate;
	}
	public AmountModel getAmount() {
		return amount;
	}
	public void setAmount(AmountModel amount) {
		this.amount = amount;
	}
	public TypeModel getOperationTypes() {
		return operationTypes;
	}
	public void setOperationTypes(TypeModel typeModel) {
		this.operationTypes = typeModel;
	}
	public OperationStatus getOperationStatus() {
		return operationStatus;
	}
	public void setOperationStatus(OperationStatus operationStatus) {
		this.operationStatus = operationStatus;
	}
	public String getOperationCreator() {
		return operationCreator;
	}
	public void setOperationCreator(String operationCreator) {
		this.operationCreator = operationCreator;
	} 

}
