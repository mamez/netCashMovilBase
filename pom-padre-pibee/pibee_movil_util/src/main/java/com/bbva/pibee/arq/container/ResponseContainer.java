package com.bbva.pibee.arq.container;

public class ResponseContainer<T> {
	private String tsec;
	private int httpCode;
	private String backEndcode;
	private String message;
	private T ResponseObject;
	private StatusBBVA status;
	
	public String getTsec() {
		return tsec;
	}
	public void setTsec(String tsec) {
		this.tsec = tsec;
	}
	public T getResponseObject() {
		return ResponseObject;
	}
	public void setResponseObject(T responseObject) {
		ResponseObject = responseObject;
	}
	public int getHttpCode() {
		return httpCode;
	}
	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public StatusBBVA getStatus() {
		return status;
	}
	public void setStatus(StatusBBVA status) {
		this.status = status;
	}
	public String getBackEndcode() {
		return backEndcode;
	}
	public void setBackEndcode(String backEndcode) {
		this.backEndcode = backEndcode;
	}
	
	
	
}
