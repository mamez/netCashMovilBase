package com.bbva.pibee.dto.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.bbva.pibee.web.dto.response.entity.PaginationModel;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="operationType")
public class Operation extends PaginationModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String id;
	

	@XmlElement(name="operationType")
    private OperationType operationType;
	
	@XmlElement(name="createdDate")
    private String createdDate;
	
	@XmlElement(name="amount")
    private Amount amount;
	
	@XmlElement(name="originAccount")
    private String originAccount;
	
	@XmlElement(name="fileNamee")
    private String fileName;
	
	@XmlElement(name="stateId")
    private String stateId;
	
	@XmlElement(name="stateDescription")
    private String stateDescription;
	
	@XmlElement(name="processDate")
    private String processDate;
	
	@XmlElement(name="numberOrders")
    private String numberOrders;
	
	@XmlElement(name="percentageSignature")
    private String percentageSignature;
	
	@XmlElement(name="sourceDevice")
    private String sourceDevice;
    
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public OperationType getOperationType() {
		return operationType;
	}
	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public Amount getAmount() {
		return amount;
	}
	public void setAmount(Amount amount) {
		this.amount = amount;
	}
	public String getOriginAccount() {
		return originAccount;
	}
	public void setOriginAccount(String originAccount) {
		this.originAccount = originAccount;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getStateId() {
		return stateId;
	}
	public void setStateId(String stateId) {
		this.stateId = stateId;
	}
	public String getStateDescription() {
		return stateDescription;
	}
	public void setStateDescription(String stateDescription) {
		this.stateDescription = stateDescription;
	}
	public String getProcessDate() {
		return processDate;
	}
	public void setProcessDate(String processDate) {
		this.processDate = processDate;
	}
	public String getNumberOrders() {
		return numberOrders;
	}
	public void setNumberOrders(String numberOrders) {
		this.numberOrders = numberOrders;
	}
	public String getPercentageSignature() {
		return percentageSignature;
	}
	public void setPercentageSignature(String percentageSignature) {
		this.percentageSignature = percentageSignature;
	}
	public String getSourceDevice() {
		return sourceDevice;
	}
	public void setSourceDevice(String sourceDevice) {
		this.sourceDevice = sourceDevice;
	}
	@Override
	public String toString() {
		return "Operation [id=" + id + ", operationType=" + operationType + ", createdDate=" + createdDate + ", amount="
				+ amount + ", originAccount=" + originAccount + ", fileName=" + fileName + ", stateId=" + stateId
				+ ", stateDescription=" + stateDescription + ", processDate=" + processDate + ", numberOrders="
				+ numberOrders + ", percentageSignature=" + percentageSignature + ", sourceDevice=" + sourceDevice
				+ "]";
	}
	
}
