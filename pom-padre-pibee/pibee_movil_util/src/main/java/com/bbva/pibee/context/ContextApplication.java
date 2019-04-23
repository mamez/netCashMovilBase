package com.bbva.pibee.context;

import java.util.Hashtable;


public class ContextApplication {

	private Hashtable<String , String> context;
	private Hashtable<String, Object>  contextObject;

	/**
	 * Obtener todo el contexto del request de la aplicación
	 * @return
	 */
	public Hashtable<String, String> getContext() {
		return context;
	}

	/**
	 * Ingresar valor a todo el contexto del request de la aplicación
	 * @param context
	 */
	public void setContext(Hashtable<String, String> context) {
		this.context = context;
	}
	
	/**
	 * Obtener un objeto especifico del contexto del request de la aplicación
	 * @return
	 */
	public Hashtable<String, Object> getContextObject() {
		return contextObject;
	}

	/**
	 * Ingresar un objeto especifico el contexto del request de la aplicación
	 * @param contextObject
	 */
	public void setContextObject(Hashtable<String, Object> contextObject) {
		this.contextObject = contextObject;
	}
	
	/**
	 * Ingresar un valor especifico al contexto del request de la aplicación
	 * @param key
	 * @param value
	 */
	public void setValue(String key, String value){
		context.put(key, value);
	}
	
	/**
	 * Obtener un objeto especifico del contexto del request de la aplicación
	 * @param key
	 * @param value
	 */
	public void setObjectValue(String key, Object value){
		contextObject.put(key, value);
	}
	
	/**
	 * Obtener un valor del contexto del request de la aplicación
	 * @param key
	 * @return
	 */
	public String getValue(String key){
		try{
			return this.context.get(key);
		}catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * Obtener un objeto especifico del contexto del request de la aplicación
	 * @param key
	 * @return
	 */
	public Object getObjectValue(String key){
		try{
			return this.contextObject.get(key);
		}catch (Exception e) {
			return null;
		}
	}
	
}
