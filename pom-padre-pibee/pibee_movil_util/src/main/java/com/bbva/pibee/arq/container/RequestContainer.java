package com.bbva.pibee.arq.container;

/**
 * Clase generica para peticiones rest
 * 
 * @author Grupo cmc
 *
 * @param <T>
 */
public class RequestContainer<T> {
	private String tsec;
	private String sesionAst;
	private String reference;
	private String userId;
	private String languageCode;
	private T requestObject;
	public String getTsec() {
		return tsec;
	}
	public void setTsec(String tsec) {
		this.tsec = tsec;
	}
	public String getSesionAst() {
		return sesionAst;
	}
	public void setSesionAst(String sesionAst) {
		this.sesionAst = sesionAst;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLanguageCode() {
		return languageCode;
	}
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	public T getRequestObject() {
		return requestObject;
	}
	public void setRequestObject(T requestObject) {
		this.requestObject = requestObject;
	}

}
