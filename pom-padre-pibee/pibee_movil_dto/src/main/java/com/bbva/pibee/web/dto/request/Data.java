package com.bbva.pibee.web.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	private String idOrder;
	
	@NotNull
	private String codClaseOrd;
	
	@JsonProperty("idOrder")
	public String getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}
	
	@JsonProperty("codClaseOrd")
	public String getCodClaseOrd() {
		return codClaseOrd;
	}
	public void setCodClaseOrd(String codClaseOrd) {
		this.codClaseOrd = codClaseOrd;
	}

}
