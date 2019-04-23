package com.bbva.pibee.web.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PruebaResponse {
String nombre;
String apellido;
String edad;

public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
@JsonProperty("ape")
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public String getEdad() {
	return edad;
}
public void setEdad(String edad) {
	this.edad = edad;
}
}
