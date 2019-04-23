package com.bbva.pibee.web.dto.response;

import java.io.Serializable;
import java.util.List;

import com.bbva.pibee.web.dto.response.entity.OperationsDelateModel;

public class OperationsDeleteServiceResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<OperationsDelateModel> operations;

	
	public List<OperationsDelateModel> getOperations() {
		return operations;
	}

	public void setOperations(List<OperationsDelateModel> operations) {
		this.operations = operations;
	}
    
}
