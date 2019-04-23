package com.bbva.pibee.util;

public enum CatalogType {
	ACCOUN_TYPE("XTI_TCCOL"),
	PAYMENT_METHOD("XTI_FPCOL"),
	FILE_DESCRIPTION_STATE("ESTADOFR"),	
	STATE_OPERATION_SEG("STATESEGBM");
	
    private String codigoCatalogo;
	
	private CatalogType(String codigoCatalog){
		this.codigoCatalogo = codigoCatalog;
	}
	
	public String getCatalogCode(){
		return this.codigoCatalogo;
	}
}
