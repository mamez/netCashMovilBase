package com.bbva.pibee.arq.container;

public enum StatusResponse {
	Error("NOK"),
    OK("OK");
    
    private String status;
    
    StatusResponse(String Status){
		this.status=Status;
	}
    
    public String status(){
    	return this.status;
    }
    
}
