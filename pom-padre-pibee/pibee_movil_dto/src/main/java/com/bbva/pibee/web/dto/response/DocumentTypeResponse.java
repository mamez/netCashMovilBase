package com.bbva.pibee.web.dto.response;

import java.util.List;

import com.bbva.pibee.web.dto.response.entity.DocumentTypeModel;
import com.bbva.pibee.web.dto.response.entity.PaginationModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DocumentTypeResponse extends PaginationModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<DocumentTypeModel> listAccount;	
	
	@JsonProperty("identityDocuments")
	public List<DocumentTypeModel> getListAccount() {
		return listAccount;
	}
	public void setListAccount(List<DocumentTypeModel> listAccount) {
		this.listAccount = listAccount;
	}
}
