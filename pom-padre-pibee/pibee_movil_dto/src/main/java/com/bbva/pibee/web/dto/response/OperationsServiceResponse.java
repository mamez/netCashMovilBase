package com.bbva.pibee.web.dto.response;

import java.util.List;

import com.bbva.pibee.web.dto.response.entity.OperationModel;
import com.bbva.pibee.web.dto.response.entity.PaginationModel;

public class OperationsServiceResponse extends PaginationModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<OperationModel> operations;

	public List<OperationModel> getOperations() {
		return operations;
	}

	public void setOperations(List<OperationModel> operations) {
		this.operations = operations;
	}	
}
