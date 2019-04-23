package com.bbva.pibee.web.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DocumentTypeRequest implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private DocumentTypeEntityRequest documentType;

	@JsonProperty("documentType")
	public DocumentTypeEntityRequest getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentTypeEntityRequest documentType) {
		this.documentType = documentType;
	}

}
