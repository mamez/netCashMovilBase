package com.bbva.pibee.rest.exception;

public enum CodClientException {
	    AST_EXPIRED("E001"),
	    TSEC_EXPIRED("E002"),
	    INVALID_USER("E003"),
	    INVALID_REF("E004"),	    
	    INVALID_PARAMETERS("E005"),
	    NO_DATA("E006"),
	    INTERNAL_ERROR("E007"),
	    CLIENT_ERROR("E008"),
	    INVALID_TOKEN("E009"),
	    INVALID_SIGNATURE_PROFILE("S01"),
    	INVALID_SIGNER_TYPE("S02"),
    	INVLID_SERVICE_CODE("S03"),
    	INVALID_OPERATION_STATE("S04"),
    	FILE_NOT_EXIST_ON_RELEASE("S05"),
    	INVALID_OPERATION_PROCESS_DATE("S06"),
    	SERVICE_NOT_CONTRACTED("S07"),
    	MATTER_NOT_ASSOCIATED("S08"),
    	ORDER_NOT_FOUND("F01"),
    	ORDER_DETAILS_NOT_FOUND("F02"),
		ORDER_CONCEPTS_NOT_FOUND("F03"),
		ERROR_ON_CREEATE_EXPORTABLE("F04"),
		EXPORT_FUNCIONALITY_NOT_FOUND("F05"),
		ERROR_XML_EXPORT("F06"),
		ERROR_XML_TRANSFORM("F07"),
		ERROR_ON_READ_WRITE_FILE("F08");
	
	    private String cod;

	    CodClientException(String cod) {
	        this.cod = cod;
	    }

	    public String cod() {
	        return cod;
	    }
}
