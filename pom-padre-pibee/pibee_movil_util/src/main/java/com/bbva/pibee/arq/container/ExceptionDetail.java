package com.bbva.pibee.arq.container;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ExceptionDetail {
	

 private String code;
 
 private String message;

 @JsonProperty("code")
public String getCode() {
	return code;
}

public void setCode(String code) {
	this.code = code;
}

@JsonProperty("message")
public String getMenssage() {
	return message;
}

public void setMenssage(String menssage) {
	this.message = menssage;
}


}
