package com.bbva.pibee.web.dto.response;

import java.util.List;

import com.bbva.pibee.web.dto.response.entity.AuthorizerUserModel;
import com.bbva.pibee.web.dto.response.entity.PaginationModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OperationCreatorUserServiceResponse extends PaginationModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<AuthorizerUserModel> listAuthorizerUser;

	 @JsonProperty("operationCreatorUser")
	public List<AuthorizerUserModel> getListAuthorizerUser() {
		return listAuthorizerUser;
	}

	public void setListAuthorizerUser(List<AuthorizerUserModel> listAuthorizerUser) {
		this.listAuthorizerUser = listAuthorizerUser;
	}
}
