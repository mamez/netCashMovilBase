package com.bbva.pibee.dto.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="data")
public class AuthorizerUserServicesResponse {
	
	@XmlElement(name="userAuthorizer")
	private List<AuthorizerUser> authorizerUserList;

	public List<AuthorizerUser> getAuthorizerUserList() {
		return authorizerUserList;
	}

	public void setAuthorizerUserList(List<AuthorizerUser> authorizerUserList) {
		this.authorizerUserList = authorizerUserList;
	}

	@Override
	public String toString() {
		return "AuthorizerUserServicesResponse [authorizerUserList=" + authorizerUserList + "]";
	}	
	
}
