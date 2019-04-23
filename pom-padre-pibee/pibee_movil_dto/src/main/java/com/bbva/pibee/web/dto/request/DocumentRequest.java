package com.bbva.pibee.web.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DocumentRequest implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private DocumentEntityRequest document;
	
	@JsonProperty("document")
	public DocumentEntityRequest getDocument() {
		return document;
	}

	public void setDocument(DocumentEntityRequest document) {
		this.document = document;
	}
}
