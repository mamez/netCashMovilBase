package com.bbva.pibee.web.dto.notifi.response;

import java.util.List;

import com.bbva.pibee.web.dto.notifi.entity.UserModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserServiceResponse 
{
	public List<UserModel> listUser;

	@JsonProperty("user")
	public List<UserModel> getListUser() {
		return listUser;
	}

	public void setListUser(List<UserModel> listUser) {
		this.listUser = listUser;
	}
}
