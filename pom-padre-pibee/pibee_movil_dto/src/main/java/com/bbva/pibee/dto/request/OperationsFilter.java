package com.bbva.pibee.dto.request;

import java.util.Date;

import com.bbva.pibee.dto.response.AuthorizerUser;
import com.bbva.pibee.dto.response.OperationType;
import com.bbva.pibee.enumeration.OperationState;

public class OperationsFilter {

	private Date dateFrom;
	private Date dateUntil;
	private Double importFrom;
	private Double importUntil;
	private AuthorizerUser operationCreatorUser;
	private OperationType operationType;
	private OperationState operationState;
	private Integer paginationKey;
	private Integer pageSize;
	private String fileId;
	
	public Date getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	public Date getDateUntil() {
		return dateUntil;
	}
	public void setDateUntil(Date dateUntil) {
		this.dateUntil = dateUntil;
	}
	public Double getImportFrom() {
		return importFrom;
	}
	public void setImportFrom(Double importFrom) {
		this.importFrom = importFrom;
	}
	public Double getImportUntil() {
		return importUntil;
	}
	public void setImportUntil(Double importUntil) {
		this.importUntil = importUntil;
	}
	public AuthorizerUser getOperationCreatorUser() {
		return operationCreatorUser;
	}
	public void setOperattionCreatorUser(AuthorizerUser operationCreatorUser) {
		this.operationCreatorUser = operationCreatorUser;
	}
	public OperationType getOperationType() {
		return operationType;
	}
	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}
	public OperationState getOperationState() {
		return operationState;
	}
	public void setOperationState(OperationState operationState) {
		this.operationState = operationState;
	}
	public Integer getPaginationKey() {
		return paginationKey;
	}
	public void setPaginationKey(Integer paginationKey) {
		this.paginationKey = paginationKey;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
		
}
