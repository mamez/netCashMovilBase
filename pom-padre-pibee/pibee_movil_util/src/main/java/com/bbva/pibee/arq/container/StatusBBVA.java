package com.bbva.pibee.arq.container;
import javax.ws.rs.core.Response;

import com.bbva.pibee.rest.exception.BbvaClientBackException;
import com.bbva.pibee.rest.exception.CodClientException;

import java.util.ArrayList;

public enum StatusBBVA {
	    Ok,
	    Create,
	    NoContent,
	    Unauthorized,
        Forbidden,
        NotFound,
        ServerError,
        ValidationError,
        Unsuported,
        AsoError,
        NoResponseError;
    
	/**
	 * Metodo para establecer estado a una peticion
	 * @param cod: codigo del mensaje
	 * @param msg: mensaje a mostrar
	 * @return
	 */
	public Response Status(String cod,String msg) {
	    	BbvaExceptionController generalError=new BbvaExceptionController();
	    	ArrayList<ExceptionDetail> lista= new ArrayList<ExceptionDetail>();
	    	ExceptionDetail error= new ExceptionDetail();
	    	error.setCode(cod);
       	    error.setMenssage(msg);
       	     lista.add(error);
            switch (this) {
                case NoContent:
                	 generalError.setError(lista);
	                 return Response.status(Response.Status.NO_CONTENT).header("Content-Type", "application/json").build();
                case Unauthorized:
                	 generalError.setError(lista);
                    return Response.status(Response.Status.UNAUTHORIZED).entity(generalError).header("Content-Type", "application/json").build();
                case Forbidden:
                	 generalError.setError(lista);
                   return Response.status(Response.Status.FORBIDDEN).entity(generalError).header("Content-Type", "application/json").build();
                case NotFound:
                	 generalError.setError(lista);
                    return Response.status(Response.Status.NOT_FOUND).entity(generalError).header("Content-Type", "application/json").build();
                case ServerError:
                	ExceptionDetail error2= new ExceptionDetail();
                	 error2.setCode("0030");
                	 error2.setMenssage("Error interno");
                	 lista.add(error2);
                     generalError.setError(lista);
                     return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(generalError).header("Content-Type", "application/json").build();
                default:
                	return Response.status(Response.Status.INTERNAL_SERVER_ERROR).header("Content-Type", "application/json").build();
            }
        }   
	
	
	public Response Status() {
    	BbvaExceptionController generalError=new BbvaExceptionController();
    	ArrayList<ExceptionDetail> lista= new ArrayList<ExceptionDetail>();
    	ExceptionDetail error= new ExceptionDetail();
        switch (this) {
        	case Ok:
        		return Response.status(Response.Status.OK).header("Content-Type", "application/json").build();
        	case Create:
        		return Response.status(Response.Status.CREATED).header("Content-Type", "application/json").build();
            case NoContent:
                 return Response.status(Response.Status.NO_CONTENT).header("Content-Type", "application/json").build();
            case Unauthorized:
            	error.setCode("E003");
           	    error.setMenssage("Error usuario no valido");
           	    lista.add(error);
                generalError.setError(lista);
                return Response.status(Response.Status.UNAUTHORIZED).entity(generalError).header("Content-Type", "application/json").build();
            case Forbidden:
               error.setCode("E005");
           	   error.setMenssage("Error parámetros no validos");
           	   lista.add(error);
               generalError.setError(lista);
               return Response.status(Response.Status.FORBIDDEN).entity(generalError).header("Content-Type", "application/json").build();
            case NotFound:
            	error.setCode("E010");
           	    error.setMenssage("Recurso no encontrado");
           	    lista.add(error);
                generalError.setError(lista);
                return Response.status(Response.Status.NOT_FOUND).entity(generalError).header("Content-Type", "application/json").build();
            case ServerError:
            	 error.setCode("E007");
            	 error.setMenssage("Error interno");
            	 lista.add(error);
                 generalError.setError(lista);
                 return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(generalError).header("Content-Type", "application/json").build();
            default:
            	return Response.status(Response.Status.INTERNAL_SERVER_ERROR).header("Content-Type", "application/json").build();
        }
    }   
	
	
	public <T> Response entity(Object clase){
		 return Response.status(Response.Status.OK).entity(clase).header("Content-Type", "application/json").build();
	}
}

