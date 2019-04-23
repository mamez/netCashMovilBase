package com.bbva.pibee.dto.cbd;

import java.io.Serializable;

import com.bbva.pibee.arq.annotations.Column;

public class CuentasUsuarioDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="id_cuenta")
	private int id;
	
	private int usuario;
	private int cuenta;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUsuario() {
		return usuario;
	}
	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}
	public int getCuenta() {
		return cuenta;
	}
	public void setCuenta(int cuenta) {
		this.cuenta = cuenta;
	}
	
	

}
