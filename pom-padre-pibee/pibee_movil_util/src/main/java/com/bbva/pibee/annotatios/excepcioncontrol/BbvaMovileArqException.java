package com.bbva.pibee.annotatios.excepcioncontrol;
import java.util.Hashtable;

import javax.ws.rs.core.Response;

import com.bbva.pibee.arq.container.StatusBBVA;
public class BbvaMovileArqException extends Exception{
   private Exception except;
   private Response exceptResponse;
   private Hashtable<String, String> exceptHast;
   private StatusBBVA StatusResponse;
   private int estaoResponse;
   private String tsec;
   
   
	public int getEstaoResponse() {
	return estaoResponse;
}

	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * @param except
	 */
	public BbvaMovileArqException(Exception except){
		super();
		this.estaoResponse=1;
		this.except=except;
	}
	
	/**
	 * 
	 * @param except
	 */
	public BbvaMovileArqException(Response except){
		super();
		this.estaoResponse=2;
		this.exceptResponse=except;
	}
	
    /**
     * Validacion de variables
     * @param cod: codigo de error de validacion de variables
     * @param ssg: Mensaje a mostrar 
     */
	public BbvaMovileArqException(String cod,String msg,String tsec){
		super();
		this.estaoResponse=3;
		this.exceptHast= new Hashtable<String, String>();
		this.exceptHast.put("COD", cod);
		this.exceptHast.put("MSG",msg);
		this.tsec=tsec;
	}
	
	/**
	 * Exepcion controdada por medio de un statusBBVA
	 * @param status
	 * @param tsec
	 */
	public BbvaMovileArqException(StatusBBVA status,String tsec){
		super();
		this.estaoResponse=4;
		this.tsec=tsec;
		this.StatusResponse=status;
	}
	
	
	 @Override
     public String getMessage() {
          return "Error Al realizar la tranzaccion PIBEE:>> "+this.except.getMessage();
     }

	public Exception getExcept() {
		return except;
	}

	public Response getExceptResponse() {
		return exceptResponse;
	}

	public Hashtable<String, String> getExceptHast() {
		return exceptHast;
	}

	public StatusBBVA getStatusResponse() {
		return StatusResponse;
	}

	public String getTsec() {
		return tsec;
	}
	

}
