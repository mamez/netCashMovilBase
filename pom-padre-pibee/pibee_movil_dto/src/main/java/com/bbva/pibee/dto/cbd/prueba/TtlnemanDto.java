package com.bbva.pibee.dto.cbd.prueba;

import com.bbva.pibee.arq.annotations.Column;

public class TtlnemanDto {
	
	@Column(name="TLNE_IDORDEN")	
private String	idOrden;
	
	@Column(name="TLNE_REFERENCIA")
private String	referencia;

	public String getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(String idOrden) {
		this.idOrden = idOrden;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}



}
