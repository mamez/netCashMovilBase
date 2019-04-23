package com.bbva.pibee.web.dto.request;

import com.bbva.pibee.web.dto.response.entity.IssuingModel;
import com.bbva.pibee.web.dto.response.entity.OperationOrderModel;
import javax.validation.constraints.NotNull;
public class PuntualTransferRequest {

	@NotNull
	private String operationFileName;
	
	@NotNull
	private IssuingModel issuing;
	
	@NotNull
	private OperationOrderModel order;
	
	public String getOperationFileName() {
		return operationFileName;
	}

	public void setOperationFileName(String operationFileName) {
		this.operationFileName = operationFileName;
	}

	public IssuingModel getIssuing() {
		return issuing;
	}

	public void setIssuing(IssuingModel issuing) {
		this.issuing = issuing;
	}

	public OperationOrderModel getOrder() {
		return order;
	}

	public void setOrder(OperationOrderModel order) {
		this.order = order;
	}
	
	
}
