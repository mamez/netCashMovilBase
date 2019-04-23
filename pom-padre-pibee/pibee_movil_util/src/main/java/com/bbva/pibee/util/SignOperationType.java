package com.bbva.pibee.util;

public enum SignOperationType {
INTERNAL_TRANSFER("internalTrasfer"),
GENERIC_OPERATION("genericOperation");
	
	 private String nameSignOperation;
		
		private SignOperationType(String nameSignOperation){
			this.nameSignOperation = nameSignOperation;
		}
		
		public String getNameSignOperation(){
			return this.nameSignOperation;
		}
	
}
