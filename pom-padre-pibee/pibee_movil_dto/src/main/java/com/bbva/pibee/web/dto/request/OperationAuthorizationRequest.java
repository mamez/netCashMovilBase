package com.bbva.pibee.web.dto.request;

import javax.validation.constraints.NotNull;

public class OperationAuthorizationRequest {
	
 @NotNull	
 private String id;

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}
}
