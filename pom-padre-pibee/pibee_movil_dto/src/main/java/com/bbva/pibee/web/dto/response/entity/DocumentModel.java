package com.bbva.pibee.web.dto.response.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DocumentModel {
	private String number;
	private DocumentTypeModel documentType;
	
	@JsonProperty("number")
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	@JsonProperty("documentType")
	public DocumentTypeModel getDocumentType() {
		return documentType;
	}
	public void setDocumentType(DocumentTypeModel documentType) {
		this.documentType = documentType;
	}
	
}
