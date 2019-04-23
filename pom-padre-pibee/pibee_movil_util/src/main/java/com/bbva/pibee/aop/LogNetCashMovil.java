package com.bbva.pibee.aop;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.pibee.context.RequestInterceptor;

@Component
public class LogNetCashMovil {
	private static Logger logger = Logger.getLogger("pibee");
	
	/**
	 * Merodo para imprimir el log con parametros indicados
	 * @param msg
	 */
	public static void  logDebugPibee(String msg) {
		logger.debug("[-] "+msg); 
	}
	
	/**
	 * Merodo para imprimir el log con parametros indicados
	 * @param msg
	 */
	public static void  logErrorPibee(String msg) {
		logger.debug("[-] "+msg); 
	}
    
	
}
