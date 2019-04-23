package com.bbva.pibee.enumeration;

public enum SignerType {
	AUTHORIZER_SIGNER ("P"),
	AUDIT_SIGNER ("A");
	
	private String signerTypeCode;
	
	private SignerType(String signerTypeCode){
		this.signerTypeCode = signerTypeCode;
	}
	
	public String getSignerTypeCode(){
		return signerTypeCode;
	}
	
	public static SignerType getSignerType(String signerTypeCode){
		for(SignerType signerType : SignerType.values()){
			if(signerType.getSignerTypeCode().equals(signerTypeCode)){
				return signerType;
			}
		}
		return null;
	}
}
