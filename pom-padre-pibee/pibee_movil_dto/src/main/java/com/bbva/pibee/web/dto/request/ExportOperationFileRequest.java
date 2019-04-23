package com.bbva.pibee.web.dto.request;

import javax.validation.constraints.NotNull;

public class ExportOperationFileRequest {

	@NotNull
	private String operationId;

	public String getOperationId() {
		return operationId;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}	
	
}
