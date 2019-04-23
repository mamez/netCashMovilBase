package com.bbva.pibee.dto.request;

public enum TransferType {
ONLINE("ORIGIN_TRANSFER_TO_ACCOUNT"),
BATCH("DESTINATION_TRANSFER_FROM_ACCOUNT");
	
	 private String type;
		
		private TransferType(String type){
			this.type = type;
		}
		
		public String getType(){
			return this.type;
		}
	
	
}
