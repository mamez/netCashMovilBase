package com.bbva.pibee.web.dto.request;
import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OperationsRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	private List<Data> operations;
	
	@JsonProperty("operations")
	public List<Data> getOperations() {
		return operations;
	}
	public void setOperations(List<Data> operations) {
		this.operations = operations;
	}

}
