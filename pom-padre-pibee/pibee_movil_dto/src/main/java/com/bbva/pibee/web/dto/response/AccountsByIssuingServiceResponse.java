package com.bbva.pibee.web.dto.response;

import java.util.List;

import com.bbva.pibee.web.dto.response.entity.AccountModel;
import com.bbva.pibee.web.dto.response.entity.PaginationModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountsByIssuingServiceResponse extends PaginationModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1421153809597465878L;
	
	List<AccountModel> listAccountsByIssuingModel;
	
	
	@JsonProperty("accounts")
	public List<AccountModel> getListAccountsByIssuingModel() {
		return listAccountsByIssuingModel;
	}

	public void setListAccountsByIssuingModel(List<AccountModel> listAccountsByIssuingModel) {
		this.listAccountsByIssuingModel = listAccountsByIssuingModel;
	}
	
}
