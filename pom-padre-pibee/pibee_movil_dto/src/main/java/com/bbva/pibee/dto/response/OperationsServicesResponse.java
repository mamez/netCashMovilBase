package com.bbva.pibee.dto.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="data")
public class OperationsServicesResponse {
     
	@XmlElement(name="operations")
	private List<Operation> listOperations;

	public List<Operation> getOperations() {
		return listOperations;
	}

	public void setOperations(List<Operation> operations) {
		this.listOperations = operations;
	}
	
}
