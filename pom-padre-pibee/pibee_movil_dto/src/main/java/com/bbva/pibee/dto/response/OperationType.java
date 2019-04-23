package com.bbva.pibee.dto.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="operationType")
public class OperationType {
	
	@XmlElement(name="operationTypeId")
	private String operationTypeId;
	
	@XmlElement(name="operationTypeDescription")
	private String operationTypeDescription;
		
	
	public OperationType() {
		super();
	}

	public OperationType(String operationTypeId) {
		super();
		this.operationTypeId = operationTypeId;
	}
	
	public OperationType(String operationTypeId, String operationTypeDescription) {
		super();
		this.operationTypeId = operationTypeId;
		this.operationTypeDescription = operationTypeDescription;
	}

	public String getOperationTypeId() {
		return operationTypeId;
	}
	public void setOperationTypeId(String operationTypeId) {
		this.operationTypeId = operationTypeId;
	}
	public String getOperationTypeDescription() {
		return operationTypeDescription;
	}
	public void setOperationTypeDescription(String operationTypeDescription) {
		this.operationTypeDescription = operationTypeDescription;
	}
	
	@Override
	public String toString() {
		return "OperationType [operationTypeId=" + operationTypeId + ", operationTypeDescription="
				+ operationTypeDescription + "]";
	}
	
}
