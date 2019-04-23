package com.bbva.pibee.rest.exception;

import javax.ws.rs.ClientErrorException;

public class ConflictException extends ClientErrorException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConflictException(int status) {
		super(status);
	}

	
}
