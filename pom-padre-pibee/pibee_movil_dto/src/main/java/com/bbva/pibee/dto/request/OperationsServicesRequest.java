package com.bbva.pibee.dto.request;

import java.util.List;

import com.bbva.pibee.dto.response.Operation;

public class OperationsServicesRequest implements ServicesResquest{

	private List<Operation> listOperations;

	public List<Operation> getListOperations() {
		return listOperations;
	}

	public void setListOperations(List<Operation> listOperations) {
		this.listOperations = listOperations;
	}
	
}
