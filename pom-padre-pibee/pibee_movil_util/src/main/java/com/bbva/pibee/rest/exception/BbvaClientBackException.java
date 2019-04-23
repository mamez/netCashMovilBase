package com.bbva.pibee.rest.exception;


import com.bbva.pibee.aop.LogNetCashMovil;

public class BbvaClientBackException extends Exception{
	private static final long serialVersionUID = 1L;
	private CodClientException codException;
	private Exception e;
	private String codInterno;
	private String msgInterno;
	private int constructor;
	private Error error;
	
	public BbvaClientBackException(CodClientException cod){
		LogNetCashMovil.logErrorPibee("Instaciando error capturado BbvaClientBackException");
		LogNetCashMovil.logErrorPibee("Error Type     : "+cod);
		LogNetCashMovil.logErrorPibee("Codidigo Error : "+cod.cod());
		this.codException=cod;
		this.constructor=1;
	}
	
	public BbvaClientBackException(CodClientException cod, String codInterno, String msgInterno){
		LogNetCashMovil.logErrorPibee("Instaciando error capturado BbvaClientBackException");
		LogNetCashMovil.logErrorPibee("Error Type     : "+cod);
		LogNetCashMovil.logErrorPibee("Codidigo Error : "+cod.cod());
		LogNetCashMovil.logErrorPibee("msgInterno     : "+msgInterno);
		this.codException=cod;
		this.codInterno=codInterno;
		this.msgInterno=msgInterno;
		this.constructor=2;
	}
	
	public BbvaClientBackException(CodClientException cod, Exception e){
		LogNetCashMovil.logErrorPibee("Instaciando error capturado BbvaClientBackException");
		LogNetCashMovil.logErrorPibee("Error Type     : "+cod);
		LogNetCashMovil.logErrorPibee("Codidigo Error : "+cod.cod());
		LogNetCashMovil.logErrorPibee("Error          : "+e.getMessage());
		this.codException=cod;
		this.e=e;
		this.constructor=3;
		if(e instanceof BbvaClientCwsException){
			BbvaClientCwsException ex=(BbvaClientCwsException)e;
			try{
				this.error=ex.getError();
			}catch (Exception e2) {
				Error err= new Error(CodClientException.CLIENT_ERROR, e2.getMessage());
				this.error=err;
			}
		}else if(e instanceof BbvaClientAsoException){
			BbvaClientAsoException ex=(BbvaClientAsoException)e;
			try{
				this.error=ex.getError();
			}catch (Exception e2) {
				Error err= new Error(CodClientException.CLIENT_ERROR, e2.getMessage());
				this.error=err;
			}
		}else if(e instanceof BbvaClientCbdException){
			BbvaClientCbdException ex=(BbvaClientCbdException)e;
			try{
				this.error=ex.getError();
			}catch (Exception e2) {
				Error err= new Error(CodClientException.CLIENT_ERROR, e2.getMessage());
				this.error=err;
			}
		}else if(e instanceof BbvaClientBackException){
			BbvaClientBackException ex=(BbvaClientBackException)e;
			try{
				this.error=ex.getError();
			}catch (Exception e2) {
				Error err= new Error(CodClientException.CLIENT_ERROR, e2.getMessage());
				this.error=err;
			}
		}else {
			String msg;
			if(e.getMessage()==null) {msg="Error interno";}else {msg=e.getMessage();}
			Error err= new Error(CodClientException.CLIENT_ERROR, msg);
			this.error=err;
		}
	}
	
	
	
	public BbvaClientBackException(Error error){
		LogNetCashMovil.logErrorPibee("Instaciando error capturado BbvaClientBackException");
		if(error != null) {
			LogNetCashMovil.logErrorPibee("Codidigo Error : "+error.getCod());
			LogNetCashMovil.logErrorPibee("Error          : "+error.getMsg());
				this.codException=error.getCod();
				this.error=error;
				this.constructor=4;
		}else {
			LogNetCashMovil.logErrorPibee("Error no creado en capa BACK");
			LogNetCashMovil.logErrorPibee("Creando error generico.......");
			Error errorG= new Error(CodClientException.INTERNAL_ERROR, "Error no creado en capa BACK");
			this.codException=errorG.getCod();
			this.error=errorG;
			this.constructor=4;
		}
	}
	
	
	public Error getError() {
		return getErrorConst();
	}
    
	  private Error getErrorConst(){
	    	Error e=null;
	    if(this.codException != null){	
	    	if(this.constructor==1){
	    		ErrorInterno ei=new ErrorInterno();
	    		ei.setCodInterno(this.codException.cod());
	    		ei.setMsgInterno(getMensajeRetorno());
	    		e= new Error(this.codException, getMensajeRetorno(), ei);
	    	}else if(this.constructor==2){
	    		ErrorInterno ei=new ErrorInterno();
	    		ei.setCodInterno(this.codInterno);
	    		ei.setMsgInterno(this.msgInterno);
	    		e= new Error(this.codException, getMensajeRetorno(), ei);
	    	}else if(this.constructor==3){
	    		ErrorInterno ei=new ErrorInterno();
	    		ei.setCodInterno(this.codException.cod());
	    		String msg;
				if(this.e.getMessage()==null) {msg="Error interno";}else {msg=this.e.getMessage();}
	    		ei.setMsgInterno(msg);
	    		e= new Error(this.codException, getMensajeRetorno(), ei);
	    	}else if(this.constructor==4){
	    		ErrorInterno ei=new ErrorInterno();
	    		if(this.error.getErrorType() == 1 ) {
	        		ei.setCodInterno(this.codException.cod());
	        		ei.setMsgInterno(this.error.getMsg());
	    			e= new Error(this.error.getCod(), getMensajeRetorno(), ei);
	    		}else if(this.error.getErrorType() == 2 ){
	    			ei.setCodInterno(this.codException.cod());
	        		ei.setMsgInterno(this.error.getE().getMessage());
	    			e= new Error(this.error.getCod(), getMensajeRetorno(), ei);
	    		}else if(this.error.getErrorType() == 3 ){
	    			e= new Error(this.error.getCod(), getMensajeRetorno(), this.error.getErrorInterno());
	    		}
	    	}
	    }else{
	    	e= new Error(this.error.getCod(), getMensajeRetorno(), this.error.getErrorInterno());
	    }
			return e;
	    }
	    
	   private String getMensajeRetorno(){
		   	 switch (this.codException) {
		   	 case INVALID_REF:
		   	       //Referencia no valida
		   		 return "Servicio no disponible";
				case AST_EXPIRED:
					//Error la AST es invalida
					return "Servicio no disponible";
				case TSEC_EXPIRED:
					//Error el tsec es invalido
					return "Servicio no disponible. Error interno";
				case INVALID_USER:
					//Error usuario no valido
					return "Servicio no disponible. Error interno";
				case INVALID_PARAMETERS:
					//Error parametros no validos
					return "Dato ingresado no válido";
				case NO_DATA:
					//No hay data
					return "Información no disponible";
				case CLIENT_ERROR:
					//BBVA client error  
					return "Servicio no disponible. Error interno";
				case INTERNAL_ERROR:
					//BBVA client error 
					return "Servicio no disponible. Error interno";
				case INVALID_SIGNER_TYPE:
					//Perfil del firmante invalido.
					return "Usuario no habilitado para firmar archivos";
				case INVALID_SIGNATURE_PROFILE:
					//Poder de firma invalido.
					return "Usuario no habilitado para firmar archivos";
				case INVLID_SERVICE_CODE:
					//El usuario no tiene poder de firma sobre el servicio.
					return "Error al intentar firmar el archivo";
				case INVALID_OPERATION_STATE:
					//La operacion no está lista para ser firmada, estado invalido.
					return "Archivo pendiente de validación. No es posible ser firmado";
				case FILE_NOT_EXIST_ON_RELEASE:
					//Fichero para agrupación no encontrado
					return "Servicio no disponible. Error interno";	
				case INVALID_OPERATION_PROCESS_DATE:
					//Fecha de proceso invalida 
					return "La fecha de creación o firma del archivo debe ser superior o igual a la fecha actual";
				case ORDER_NOT_FOUND:
					//Orden no encontrada
					return "Archivo no encontrado";
				case ORDER_DETAILS_NOT_FOUND:
					//Detalle de orden no encontrada
					return "Detalle del archivo no encontrado";
				case ORDER_CONCEPTS_NOT_FOUND :
					//Conceptos de orden no encontrada
					return "Archivo con datos inconsistentes";
				case ERROR_ON_CREEATE_EXPORTABLE:
					//Error al crear el archivo
					return "Error al crear el archivo";
				case EXPORT_FUNCIONALITY_NOT_FOUND:
					//Error al crear el archivo
					return "No se encontró archivo para exportar";
				case ERROR_XML_EXPORT:
					//Error al exportar el XML 
					return "Error al exportar archivo";
				case ERROR_XML_TRANSFORM:
					//Error al leer el XML
					return "Error al intentar firmar el archivo";
				case ERROR_ON_READ_WRITE_FILE:
					//Error al leer archivo
					return "Error al leer el archivo";
				case INVALID_TOKEN:
					//Token invalido
					return "Error al validar credenciales";

				case SERVICE_NOT_CONTRACTED:
					//Servicio no contratado
					return "El usuario no tiene el servicio contratado";
				case MATTER_NOT_ASSOCIATED:
					//Asunto no asociado
					return "Asunto no asociado al servicio";
				default:
					return "Error interno";
				}
	   }
	    
    
   
}
