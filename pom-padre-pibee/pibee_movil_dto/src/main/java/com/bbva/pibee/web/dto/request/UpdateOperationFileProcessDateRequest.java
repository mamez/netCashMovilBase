package com.bbva.pibee.web.dto.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class UpdateOperationFileProcessDateRequest {

	private String operationId;
	
	@NotNull
	private Date processDate;
	
	private String operationTypeId;

	public String getOperationId() {
		return operationId;
	}
	
	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}
	
	public Date getProcessDate() {
		return processDate;
	}
	
	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}
	
	public String getOperationTypeId() {
		return operationTypeId;
	}

	public void setOperationTypeId(String operationTypeId) {
		this.operationTypeId = operationTypeId;
	}
}
