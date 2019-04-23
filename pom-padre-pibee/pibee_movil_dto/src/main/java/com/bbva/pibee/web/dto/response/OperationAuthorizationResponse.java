package com.bbva.pibee.web.dto.response;

import java.io.Serializable;
import java.util.List;

import com.bbva.pibee.web.dto.response.entity.OperationModel;

public class OperationAuthorizationResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<OperationModel> operationAuthorization;

	public List<OperationModel> getOperationAuthorization() {
		return operationAuthorization;
	}

	public void setOperationAuthorization(List<OperationModel> operationAuthorization) {
		this.operationAuthorization = operationAuthorization;
	}

}
