package com.bbva.pibee.web.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class FavouriteRequest {

@NotNull	
private String accountId;

@NotNull
@Pattern(regexp = "(A|S)")      
private String action;

public String getAccountEncrypted() {
	return accountEncrypted;
}
public void setAccountEncrypted(String accountEncrypted) {
	this.accountEncrypted = accountEncrypted;
}
@NotNull
private String accountEncrypted;

public String getAccountId() {
	return accountId;
}
public void setAccountId(String accountId) {
	this.accountId = accountId;
}
public String getAction() {
	return action;
}
public void setAction(String action) {
	this.action = action;
}

}
