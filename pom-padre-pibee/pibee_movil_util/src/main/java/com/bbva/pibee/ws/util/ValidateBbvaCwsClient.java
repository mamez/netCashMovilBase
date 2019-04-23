package com.bbva.pibee.ws.util;

import com.bbva.pibee.rest.exception.BbvaClientCwsException;
import com.bbva.pibee.rest.exception.CodClientException;

public class ValidateBbvaCwsClient {

	/**
	 * Metodo que genera la excepcion de acuerdo a la respuesta desde el ws para la funcionalidad del wsdl Modificacion Datos Basicos
	 * @param codRetorno
	 * @param descripcion
	 * @throws BbvaClientCwsException
	 */
	public void validateResponseBasicDataModification(String codRetorno, String descripcion) throws BbvaClientCwsException{
		String operacion = "basicData";
		if(codRetorno.equals("Error transaccion")) {
			throw new BbvaClientCwsException(CodClientException.AST_EXPIRED, obtenerCodInterno(descripcion, operacion), obtenerMsgInterno(descripcion, operacion));
		} else if(codRetorno.equals("Error obteniendo datos basicos del usuario")) {
			if (obtenerCodInterno(descripcion, operacion).equalsIgnoreCase("KNEO006")) {
				throw new BbvaClientCwsException(CodClientException.INVALID_REF, "E004", obtenerMsgInterno(descripcion, operacion));
			} else if (obtenerCodInterno(descripcion, operacion).equalsIgnoreCase("KNEO007")) {
				throw new BbvaClientCwsException(CodClientException.INVALID_USER, "E003", obtenerMsgInterno(descripcion, operacion));
			} else {
				throw new BbvaClientCwsException(CodClientException.INVALID_PARAMETERS);
			}
		} else {
			throw new BbvaClientCwsException(CodClientException.INTERNAL_ERROR);
		}
	}
	
	/**
	 * Metodo que genera la excepcion de acuerdo a la respuesta desde el ws para la funcionalidad del wsdl Informacion Empresas
	 * @param codRetorno
	 * @param descripcion
	 * @throws BbvaClientCwsException
	 */
	public void validateResponseCompanyInformation(String codRetorno, String descripcion) throws BbvaClientCwsException {
		if (descripcion.equalsIgnoreCase("Error inesperado en la transaccion KAQU")) {
			throw new BbvaClientCwsException(CodClientException.AST_EXPIRED);
		} else if (descripcion.equalsIgnoreCase("Servicio temporalmente no disponible. Por favor intentalo mas tarde. Error - ")) {
			throw new BbvaClientCwsException(CodClientException.INVALID_PARAMETERS);
		}
	}
	
	/**
	 * Metodo que genera la excepcion de acuerdo a la respuesta desde el ws para la funcionalidad del wsdl Informacion Servicios
	 * @param codRetorno
	 * @param descripcion
	 * @throws BbvaClientCwsException
	 */
	public void validateResponseServicesInformation(String codRetorno, String descripcion) throws BbvaClientCwsException {
		String operacion = "serviceInfo";  
		if(descripcion.substring(0, 35).equalsIgnoreCase("Error inesperado en la transaccion.")) {
			if(obtenerCodInterno(descripcion, operacion).equalsIgnoreCase("QCE0352"))
				throw new BbvaClientCwsException(CodClientException.AST_EXPIRED, "E001", obtenerMsgInterno(descripcion, operacion));
			else {
				throw new BbvaClientCwsException(CodClientException.INVALID_PARAMETERS, obtenerCodInterno(descripcion, operacion), obtenerMsgInterno(descripcion, operacion));
			}
		} else if (codRetorno.equalsIgnoreCase("IS0201")){
			throw new BbvaClientCwsException(CodClientException.NO_DATA, "E006" , descripcion);
		} else {
			throw new BbvaClientCwsException(CodClientException.INVALID_PARAMETERS);
		}
	}
	
	/**
	 * Metodo que genera la excepcion de acuerdo a la respuesta desde el ws para la funcionalidad del wsdl Informacion Usuarios
	 * @param codRetorno
	 * @param descripcion
	 * @throws BbvaClientCwsException
	 */
	public void validateResponseUserInformation(String codRetorno, String descripcion) throws BbvaClientCwsException {
		String operacion = "userIjfo";
		if(obtenerCodInterno(descripcion, operacion).equalsIgnoreCase("QCE0352")){
			throw new BbvaClientCwsException(CodClientException.AST_EXPIRED, "E001", obtenerMsgInterno(descripcion, operacion));
		} else if (codRetorno.equalsIgnoreCase("IS0201")){
			throw new BbvaClientCwsException(CodClientException.NO_DATA, "E006" , descripcion);
		} else {
			throw new BbvaClientCwsException(CodClientException.NO_DATA, "E006", descripcion);			
		}
	}
	
	/**
	 * Metodo que genera la excepcion de acuerdo a la respuesta desde el ws para la funcionalidad del wsdl Gestion Beneficiarios
	 * @param codRetorno
	 * @param descripcion
	 * @throws BbvaClientCwsException
	 */
	public void validateResponseManagementBeneficiaries(String codRetorno, String descripcion) throws BbvaClientCwsException {
		String operacion = "manaBene";  
		if(descripcion.substring(0, 35).equalsIgnoreCase("Error inesperado en la transaccion.")) {
			if(obtenerCodInterno(descripcion, operacion).equalsIgnoreCase("QCE0352"))
				throw new BbvaClientCwsException(CodClientException.AST_EXPIRED, "E001", obtenerMsgInterno(descripcion, operacion));
			else {
				throw new BbvaClientCwsException(CodClientException.INVALID_PARAMETERS, "E005", obtenerMsgInterno(descripcion, operacion));
			}
		} else if (codRetorno.equalsIgnoreCase("IS0201")){
			throw new BbvaClientCwsException(CodClientException.NO_DATA, "E006" , descripcion);
		} else {
			throw new BbvaClientCwsException(CodClientException.INVALID_PARAMETERS);
		}
	}
	
	/**
	 * Metodo que obtiene codigo de error de la respuesta del ws para generar excepcion 
	 * @param descripcion: String que retorna Ws
	 * @param operacion: String operacion que se encuentra en ejecucion
	 * @return CodInterno
	 */
	private String obtenerCodInterno(String descripcion, String operacion) {
		if (operacion.equalsIgnoreCase("basicData")){
			int iniCod = (descripcion.indexOf("codigoError")+12);
			int finCod = iniCod + 7;
			return descripcion.substring(iniCod,finCod);
		} else if (operacion.equalsIgnoreCase("serviceInfo")) {
			int iniCod = (descripcion.indexOf("Error - ")+8);
			int finCod = iniCod + 7;
			return descripcion.substring(iniCod,finCod);
		} else if (operacion.equalsIgnoreCase("userInfo")) {
			int iniCod = (descripcion.indexOf("codigoError")+12);
			int finCod = iniCod + 7;
			return descripcion.substring(iniCod,finCod);
		} else {
			return "";
		}
	}
	
	/**
	 * Metodo que obtiene Msg interno de la respuesta del ws para generar excepcion
	 * @param descripcion : String que retorna Ws
	 * @param operacion : String operacion que se encuentra en ejecucion
	 * @return Mensaje interno
	 */
	private String obtenerMsgInterno(String descripcion, String operacion) {
		if (operacion.equalsIgnoreCase("basicData")){
			int iniDesErr = (descripcion.indexOf("descripcionError")+17);
			int finDesErr = (descripcion.length())-1;
			return descripcion.substring(iniDesErr, finDesErr);
		} else if (operacion.equalsIgnoreCase("serviceInfo")) {
			int iniCod = (descripcion.indexOf("Error - ")+17);
			return descripcion.substring(iniCod);
		} else if (operacion.equalsIgnoreCase("userInfo")) {
			int iniDesErr = (descripcion.indexOf("descripcionError")+17);
			int finDesErr = (descripcion.length())-1;
			return descripcion.substring(iniDesErr, finDesErr);
		} else {
			return "";
		}
	}
}
