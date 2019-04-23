package com.bbva.pibee.rest.exception;

public class BbvaFilterListException extends Exception {
 private FilterListExceptionType errorType;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BbvaFilterListException(FilterListExceptionType errorType){
	    this.errorType=errorType;
	}
	
	public Error getError(){
		Error e= null;
		switch (this.errorType) {
		case LIST_IS_EMPTY:
			e= new Error(CodClientException.NO_DATA, "No se encontro informacion");
			break;
		case PAGINATION_KEY_CERO:
			e= new Error(CodClientException.CLIENT_ERROR, "Numero de paginacion no valido");
			break;
		case PAGINATION_SIZE_CERO:
			e= new Error(CodClientException.CLIENT_ERROR, "Tamaño de paginacion no validio");
			break;
		case  PAGINATION_KEY_NO_VAL:
			e= new Error(CodClientException.CLIENT_ERROR, "Numero de paginacion no valido");
			break;
		case   GENERAL_ERROR:
			e= new Error(CodClientException.CLIENT_ERROR, "Error no esperado");
			break;			
		default:
			e= new Error(CodClientException.CLIENT_ERROR, "Error no esperado");
			break;
		}
		return e;
	}

	
}
