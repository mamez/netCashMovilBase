package com.bbva.pibee.web.dto.response;

import java.util.List;

import com.bbva.pibee.web.dto.response.entity.AccountTypeModel;
import com.bbva.pibee.web.dto.response.entity.PaginationModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountTypeServiceResponse extends PaginationModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<AccountTypeModel> listAccountTypeModel;
	
	
	@JsonProperty("accountTypes")
	public List<AccountTypeModel> getListAccountTypeModel() {
		return listAccountTypeModel;
	}

	public void setListAccountTypeModel(List<AccountTypeModel> listAccountTypeModel) {
		this.listAccountTypeModel = listAccountTypeModel;
	}
	
}
