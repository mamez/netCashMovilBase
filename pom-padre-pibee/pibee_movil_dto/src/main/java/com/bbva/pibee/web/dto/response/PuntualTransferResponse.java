package com.bbva.pibee.web.dto.response;

import com.bbva.pibee.web.dto.response.entity.OperationModel;

public class PuntualTransferResponse {
	
		private String issuingName;
		
	    private OperationModel operation;
	    
		public String getIssuingName() {
			return issuingName;
		}
		public void setIssuingName(String issuingName) {
			this.issuingName = issuingName;
		}
		
		public OperationModel getOperation() {
			return operation;
		}
		public void setOperation(OperationModel operation) {
			this.operation = operation;
		}
}
