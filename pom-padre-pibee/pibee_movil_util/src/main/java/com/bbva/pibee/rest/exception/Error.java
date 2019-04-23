package com.bbva.pibee.rest.exception;

/**
 * 
 * @author Grupocmc
 *Clase para crear errores propios y enviar descripciones al front
 */
public class Error {
private CodClientException Cod;
private String msg;
private Exception e;
private int errorType;
private ErrorInterno errorInterno;

public Error(CodClientException Cod,String msg) {
	errorType=1;
	this.Cod=Cod;
	this.msg=msg;
}

public Error(CodClientException Cod,Exception e) {
	errorType=2;
	this.Cod=Cod;
	this.e=e;
}

public Error(CodClientException Cod,String msg,ErrorInterno errorInterno) {
	errorType=3;
	this.errorInterno= errorInterno;
	this.Cod=Cod;
	this.msg=msg;
}

public int getErrorType() {
	return errorType;
}

public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}

public Exception getE() {
	return e;
}

public CodClientException getCod() {
	return Cod;
}

public ErrorInterno getErrorInterno() {
	return errorInterno;
}

}
