package com.bbva.pibee.enumeration;

public enum OperationState {	
	
	PARTIALLY_SIGNED ("019"),
	AWAITING_AUDIT ("020"),
	SIGNED_RELEASE ("022"),
	REJECTED ("023"),
	AWAITING_APPROVAL ("024"),
	AWAITING_RELEASE ("025"),
	NOT_VALIDATED ("026"),
	IN_PROCESS ("027"),
	EXECITED ("028"),
	ERROR ("099"),
	REMOVED ("999");
	
	
	private String stateCode;
	
	private OperationState(String stateCode){
		this.stateCode = stateCode;
	}
	
	public String getStateCode(){
		return this.stateCode;
	}
	
	public static OperationState getOperationState(String stateCode){		
		for(OperationState operationState : OperationState.values()){
			if(operationState.getStateCode().equals(stateCode)){
				return operationState;
			}
		}
		return null;
	}
	
}
