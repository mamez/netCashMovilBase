package com.bbva.pibee.web.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DocumentEntityRequest implements Serializable
{	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String number;
	@NotNull
	private DocumentTypeEntityRequest documentType;
	
	@JsonProperty("number")
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@JsonProperty("documentType")
	public DocumentTypeEntityRequest getDocumentType() {
		return documentType;
	}
	public void DocumentTypeEntityRequest(DocumentTypeEntityRequest documentType) {
		this.documentType = documentType;
	}	
}
