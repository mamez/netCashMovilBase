package com.bbva.pibee.dto.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="data")
public class OperationTypesServicesResponse {

	@XmlElement(name="operationTypes")
	private List<OperationType> operationTypeList;

	public List<OperationType> getOperationTypeList() {
		return operationTypeList;
	}

	public void setOperationTypeList(List<OperationType> operationTypeList) {
		this.operationTypeList = operationTypeList;
	}

	@Override
	public String toString() {
		return "OperationTypesServicesResponse [operationTypeList=" + operationTypeList + "]";
	}
	
	
}
