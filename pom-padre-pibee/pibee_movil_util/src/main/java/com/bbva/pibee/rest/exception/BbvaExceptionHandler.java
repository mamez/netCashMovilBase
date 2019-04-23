package com.bbva.pibee.rest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.bbva.pibee.arq.container.StatusBBVA;

public class BbvaExceptionHandler implements ExceptionMapper<BbvaClientBackException> { 

	@Override
	public Response toResponse(BbvaClientBackException exception) {
		//determinamos si se envia un error
		
		try {
		if(exception.getError().getErrorInterno() != null){
			String codInterno=exception.getError().getErrorInterno().getCodInterno();
			
			boolean isNoData=codInterno.equalsIgnoreCase("KNEE001") || codInterno.equalsIgnoreCase("E006") || codInterno.equalsIgnoreCase("F01");
			
			//Validacion de usuario no autorizado
			boolean isNotAutorize= codInterno.equalsIgnoreCase("E001") ||codInterno.equalsIgnoreCase("E002") ||codInterno.equalsIgnoreCase("E003") ||codInterno.equalsIgnoreCase("E004") || codInterno.equalsIgnoreCase("S06")  ||
					codInterno.equalsIgnoreCase("S01")  ||codInterno.equalsIgnoreCase("S02")  ||codInterno.equalsIgnoreCase("S03") || codInterno.equalsIgnoreCase("S07") ||codInterno.equalsIgnoreCase("E009");
			
			//Errores del file system
			boolean isErrorFileSystem =codInterno.equalsIgnoreCase("F08") || codInterno.equalsIgnoreCase("F02") || codInterno.equalsIgnoreCase("F03") || codInterno.equalsIgnoreCase("F04") || codInterno.equalsIgnoreCase("F05") ||
			codInterno.equalsIgnoreCase("F06") || codInterno.equalsIgnoreCase("F07") || codInterno.equalsIgnoreCase("S05") || codInterno.equalsIgnoreCase("S04");
			
			//Error de cliente
			boolean isClientError=codInterno.equalsIgnoreCase("E007");
			 
			//Error interno
			 boolean isInternalError=codInterno.equalsIgnoreCase("E008");
			    
			//parametros invalido 
			boolean isParamerInvalid=codInterno.equalsIgnoreCase("E005") || codInterno.equalsIgnoreCase("S08");
			
			if(isNoData){
    			return  StatusBBVA.NoContent.Status();
    		}else if(isNotAutorize){
    			return  StatusBBVA.Unauthorized.Status(codInterno,exception.getError().getMsg());
    		}else if(isParamerInvalid){
    			return  StatusBBVA.Forbidden.Status(codInterno,exception.getError().getMsg());
    		}else if(isErrorFileSystem || isClientError || isInternalError) {
    			return  StatusBBVA.ServerError.Status(codInterno,exception.getError().getMsg());
    		}else{
    			try {
    				return  StatusBBVA.ServerError.Status(codInterno, exception.getError().getErrorInterno().getMsgInterno()); 
    			}catch (Exception e) {
    				return  StatusBBVA.ServerError.Status(codInterno, exception.getError().getMsg()); 
				}
     		
    		}    	
		}
		//se determina si llega un error normal
		else if(exception.getError().getCod() != null){
			   String codInterno=exception.getError().getCod().cod();
			   boolean isNoData=codInterno.equalsIgnoreCase("KNEE001") || codInterno.equalsIgnoreCase("E006") || codInterno.equalsIgnoreCase("F01");
			   boolean isNotAutorize= codInterno.equalsIgnoreCase("E001") ||codInterno.equalsIgnoreCase("E002") ||codInterno.equalsIgnoreCase("E003") ||codInterno.equalsIgnoreCase("E004") || codInterno.equalsIgnoreCase("S06")  ||
						codInterno.equalsIgnoreCase("S01")  ||codInterno.equalsIgnoreCase("S02")  ||codInterno.equalsIgnoreCase("S03");
				boolean isErrorFileSystem =codInterno.equalsIgnoreCase("F08") || codInterno.equalsIgnoreCase("F02") || codInterno.equalsIgnoreCase("F03") || codInterno.equalsIgnoreCase("F04") || codInterno.equalsIgnoreCase("F05") ||
				codInterno.equalsIgnoreCase("F06") || codInterno.equalsIgnoreCase("F07") || codInterno.equalsIgnoreCase("S05") || codInterno.equalsIgnoreCase("S04");
				boolean isClientError=codInterno.equalsIgnoreCase("E007");
				boolean isInternalError=codInterno.equalsIgnoreCase("E008");  
				boolean isParamerInvalid=codInterno.equalsIgnoreCase("E005");
				if(isNoData){
	    			return  StatusBBVA.NoContent.Status();
	    		}else if(isNotAutorize){
	    			return  StatusBBVA.Unauthorized.Status();
	    		}else if(isParamerInvalid){
	    			return  StatusBBVA.Forbidden.Status();
	    		}else if(isErrorFileSystem || isClientError || isInternalError) {
	    			return  StatusBBVA.ServerError.Status();
	    		}else{
	    		    return  StatusBBVA.ServerError.Status(); 
	    			}
           }
		//Se determina si se pasa como parametro un error diferente
		else if(exception.getError().getE() != null){
     		return  StatusBBVA.ServerError.Status(exception.getError().getCod().cod(), exception.getError().getE().getMessage());
     	}else {
     		return  StatusBBVA.ServerError.Status("0032","Error Arqbbva");
     	}
		}catch (Exception e) {
			return  StatusBBVA.ServerError.Status("0032","Error al realizar la transacción");
		}
	}
	
	
}
