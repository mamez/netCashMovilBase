package com.bbva.pibee.dto.cbd;

import java.io.Serializable;

import com.bbva.pibee.arq.annotations.Column;

public class UsuarioModel  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="id_usuario")
	private int id;
	private String nombre;
	private String apellido;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
}
