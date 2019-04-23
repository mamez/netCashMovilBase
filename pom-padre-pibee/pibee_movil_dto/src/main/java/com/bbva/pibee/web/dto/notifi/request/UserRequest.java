package com.bbva.pibee.web.dto.notifi.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import com.bbva.pibee.web.dto.notifi.request.UserEntityRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
public class UserRequest implements Serializable
{
	private static final long serialVersionUID = 1L;
	@NotNull
	private UserEntityRequest user;
	
	@JsonProperty("user")
	public UserEntityRequest getUser() {
		return user;
	}
	public void setUser(UserEntityRequest user) {
		this.user = user;
	}
}
