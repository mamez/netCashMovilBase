package com.bbva.pibee.arq.container;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class BbvaExceptionController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<ExceptionDetail> error;
	
	@JsonProperty("error")
	public ArrayList<ExceptionDetail> getError() {
		return error;
	}
	public void setError(ArrayList<ExceptionDetail> error) {
		this.error = error;
	}

	

}
