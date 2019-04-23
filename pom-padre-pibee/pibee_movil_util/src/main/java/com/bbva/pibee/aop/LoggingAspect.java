package com.bbva.pibee.aop;

import java.util.Arrays;

import org.apache.cxf.interceptor.Fault;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.pibee.context.RequestInterceptor;
import com.bbva.pibee.rest.exception.BbvaClientAsoException;
import com.bbva.pibee.rest.exception.BbvaClientBackException;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.BbvaClientCwsException;
import com.bbva.pibee.rest.exception.CodClientException;
import com.bbva.pibee.rest.exception.Error;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Aspect
@Component
public class LoggingAspect {
	
	@Autowired
	RequestInterceptor requestInterceptor;
	
	
	public static Logger logger = Logger.getLogger("auditoria");
	
	@Before("execution( public * com.bbva.pibee.web.controllerImpl.*.*(..)) || execution( public * com.bbva.pibee.cws.clientImpl.*.*(..)) || "
		  + "execution( public * com.bbva.pibee.cbd.daoImpl.*.*(..)) || execution( public * com.bbva.pibee.aso.service.impl.*.*(..)) || "
		  + "execution( public * com.bbva.pibee.back..*.*(..)) || execution( public * com.bbva.pibee.web.servicesImpl.*.*(..)) || execution( public * com.bbva.pibee.filesystem.back..*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		 logger.debug("[0] "+joinPoint.getThis() + " .:. "+joinPoint.getSignature().getName() +" .:. "+Arrays.toString(joinPoint.getArgs()));       
	}
	
	
	@After("execution( public * com.bbva.pibee.web.controllerImpl.*.*(..)) || execution( public * com.bbva.pibee.cws.clientImpl.*.*(..)) || "
			  + "execution( public * com.bbva.pibee.cbd.daoImpl.*.*(..)) || execution( public * com.bbva.pibee.aso.service.impl.*.*(..)) || "
			  + "execution( public * com.bbva.pibee.back..*.*(..)) || execution( public * com.bbva.pibee.web.servicesImpl.*.*(..)) || execution( public * com.bbva.pibee.filesystem.back..*.*(..))")
		public void logAfter(JoinPoint joinPoint) {
		logger.debug("[1] "+joinPoint.getThis() + " .:. "+joinPoint.getSignature().getName() +" .:. "+Arrays.toString(joinPoint.getArgs()));
		}
	
	
	@Around("execution( public * com.bbva.pibee.web.controllerImpl.*.*(..)) || execution( public * com.bbva.pibee.back..*.*(..)) || execution( public * com.bbva.pibee.web.servicesImpl.*.*(..)) || execution( public * com.bbva.pibee.filesystem.back..*.*(..))")
	 public Object catchException(ProceedingJoinPoint joinpoint) throws Throwable {
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		  Object exit = null;
		  try {
		   exit = joinpoint.proceed();
		  } catch (Exception except) {
			  logger.error("****************************** ERROR -GENERANDO RESPUESTA- ************************************************");
			  logger.error("Reporte de Error capturado ");
			  logger.error("Clase : "+joinpoint.getTarget().getClass());
			  logger.error("Metodo : "+joinpoint.getSignature().getName());
			  try {
				  logger.error("Variables : "+objectMapper.writeValueAsString(joinpoint.getArgs()));
			  }catch (Exception e) {
				  logger.error("Variables : NA");
			}
			  logger.error("User : "+requestInterceptor.getIvUser());
			  if(except instanceof BbvaClientBackException){
				  BbvaClientBackException ex=(BbvaClientBackException)except;
				  if(ex.getMessage() != null){
					  logger.error("Message : "+ex.getMessage());
				  }
				  if(ex.getCause() !=null){
					  logger.error("Causa : "+ex.getCause());
				  }
				  if(ex.getError() !=null){
					  logger.error("Detalle Error msg : "+ex.getError().getMsg());
					  logger.error("Detalle Error cod: "+ex.getError().getCod());
					  if(ex.getError().getErrorInterno() != null){
						  logger.error("Detalle Error interno msg: "+ex.getError().getErrorInterno().getMsgInterno());
						  logger.error("Detalle Error interno cod: "+ex.getError().getErrorInterno().getCodInterno());
					  }
				  }
				  logger.error(" ");
				  throw new BbvaClientBackException(ex.getError());
			  }else if(except instanceof BbvaClientAsoException){
				  logger.error("Detalle : Mensaje no controlado de tipo capa ASO");
				  logger.error(" ");
				  throw new BbvaClientAsoException(CodClientException.CLIENT_ERROR); 
			  }else if(except instanceof BbvaClientCbdException){
				    logger.error("Detalle : Mensaje no controlado de tipo capa CBD");
					  logger.error(" ");
					  throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR); 
			  }else if(except instanceof BbvaClientCwsException){
				  logger.error("Detalle : Mensaje no controlado de tipo capa CWS");
				  logger.error(" ");
				  throw new BbvaClientCwsException(CodClientException.CLIENT_ERROR); 
			  }else{
				  logger.error("Detalle : Mensaje no controlado de tipo capa BACK");
				  if(except.getMessage() != null){
					  logger.error("Detalle(2) :"+except.getMessage());  
				  }
				  logger.error(" ");
			      throw new BbvaClientBackException(CodClientException.INTERNAL_ERROR);
			  }
		  }
		  return exit;
		 }
	
	
	
	 @Around("execution(public * com.bbva.pibee.aso..*.*(..))")
	 public Object catchAsoException(ProceedingJoinPoint joinpoint) throws Throwable {
		ObjectMapper objectMapper = new ObjectMapper();
		 Object exit = null;
		  try {
			  exit = joinpoint.proceed();
		  } catch (Exception except) {
			  logger.error("******************************************** ERROR ASO ****************************************************");
			  logger.error("Reporte de Error capturado ");
			  logger.error("Clase : "+joinpoint.getTarget().getClass());
			  logger.error("Metodo : "+joinpoint.getSignature().getName());
			  try {
				  logger.error("Variables : "+objectMapper.writeValueAsString(joinpoint.getArgs()));
			  }catch (Exception e) {
				  logger.error("Variables : NA");
			}
			 
			  logger.error("User : "+requestInterceptor.getIvUser());
			  if(except instanceof BbvaClientAsoException){
				  BbvaClientAsoException ex=(BbvaClientAsoException)except;
				  Error error= ex.getError();
				  if(error.getCod()  != null){
			    		logger.error("CodClientException : "+error.getCod());
			    	}
			    	if(error.getErrorInterno() != null){
			    		logger.error("ERROR codInterno : "+error.getErrorInterno().getCodInterno());
			    		logger.error("ERROR msgInterno: "+error.getErrorInterno().getMsgInterno());
			    	}
			    	if(error.getMsg() != null){
			    		logger.error("mensaje : "+error.getMsg());
			    	}
			    	
			    	if(error.getE() != null){
			    		logger.error("Exception : "+error.getE().getMessage());
			    	} 
			    	logger.error(" ");
			    	 throw new BbvaClientAsoException(error);
			  }if(except instanceof Fault) {
				  throw new BbvaClientAsoException(CodClientException.CLIENT_ERROR,"001","Error al conectar grantingTicket"); 
			  }  else{
				  logger.error("Detalle : Mensaje no controlado en la capa ASO");
				  if(except.getMessage() != null){
					  logger.error("Detalle(2) :"+except.getMessage());  
				  }
			      logger.error(" ");
				  throw new BbvaClientAsoException(CodClientException.CLIENT_ERROR); 
			  }
			 
		  }
		  return exit;
		 }
	
	
	 /**
	  * Captura de error de la capa de bases de datos
	  * @param joinpoint
	  * @return
	  * @throws Throwable
	  */
	@Around("execution(public * com.bbva.pibee.cbd..*.*(..))")
	 public Object catchCbdException(ProceedingJoinPoint joinpoint) throws Throwable {
		ObjectMapper objectMapper = new ObjectMapper();
		 Object exit = null;
		  try {
			  exit = joinpoint.proceed();
		  } catch (Exception except) {
			  logger.error("******************************************** ERROR CBD ****************************************************");
			  logger.error("Reporte de Error capturado ");
			  logger.error("Clase : "+joinpoint.getTarget().getClass());
			  logger.error("Metodo : "+joinpoint.getSignature().getName());
			  try {
				  logger.error("Variables : "+objectMapper.writeValueAsString(joinpoint.getArgs()));
			  }catch (Exception e) {
				  logger.error("Variables : NA");
			}
			  logger.error("User : "+requestInterceptor.getIvUser());
			  if(except instanceof BbvaClientCbdException){
				  BbvaClientCbdException ex=(BbvaClientCbdException)except;
				  Error error= ex.getError();
				  if(error.getCod()  != null){
			    		logger.error("CodClientException : "+error.getCod());
			    	}
			    	if(error.getErrorInterno() != null){
			    		logger.error("ERROR codInterno : "+error.getErrorInterno().getCodInterno());
			    		logger.error("ERROR msgInterno: "+error.getErrorInterno().getMsgInterno());
			    	}
			    	if(error.getMsg() != null){
			    		logger.error("mensaje : "+error.getMsg());
			    	}
			    	
			    	if(error.getE() != null){
			    		logger.error("Exception : "+error.getE().getMessage());
			    	} 
			    	logger.error(" ");
			    	 throw new BbvaClientCbdException(ex.getError());
			  }else{
				  logger.error("Detalle : Mensaje no controlado en la capa CBD");
				  if(except.getMessage() != null){
					  logger.error("Detalle(2) :"+except.getMessage());  
				  }
				  logger.error(" ");
				  throw new BbvaClientCbdException(CodClientException.CLIENT_ERROR); 
			  }
			 
		  }
		  return exit;
		 }
	
	/**
	 * Metodo para capturar los errores de la capa de webservices 
	 * @param joinpoint
	 * @return
	 * @throws Throwable
	 */
	@Around("execution(public * com.bbva.pibee.cws..*.*(..))")
	 public Object catchCwsException(ProceedingJoinPoint joinpoint) throws Throwable {
		ObjectMapper objectMapper = new ObjectMapper();
		 Object exit = null;
		  try {
			  exit = joinpoint.proceed();
		  } catch (Exception except) {
			  logger.error("******************************************** ERROR CWS ****************************************************");
			  logger.error("Reporte de Error capturado ");
			  logger.error("Clase : "+joinpoint.getTarget().getClass());
			  logger.error("Metodo : "+joinpoint.getSignature().getName());
			  try {
				  logger.error("Variables : "+objectMapper.writeValueAsString(joinpoint.getArgs()));
			  }catch (Exception e) {
				  logger.error("Variables : NA");
			}
			  logger.error("User : "+requestInterceptor.getIvUser());
			  if(except instanceof BbvaClientCwsException){
				  BbvaClientCwsException ex=(BbvaClientCwsException)except;
				  Error error= ex.getError();
				  if(error.getCod()  != null){
			    		logger.error("CodClientException : "+error.getCod());
			    	}
			    	if(error.getErrorInterno() != null){
			    		logger.error("ERROR codInterno : "+error.getErrorInterno().getCodInterno());
			    		logger.error("ERROR msgInterno: "+error.getErrorInterno().getMsgInterno());
			    	}
			    	if(error.getMsg() != null){
			    		logger.error("mensaje : "+error.getMsg());
			    	}
			    	
			    	if(error.getE() != null){
			    		logger.error("Exception : "+error.getE().getMessage());
			    	} 
			    	logger.error(" ");
			    	 throw new BbvaClientCwsException(ex.getError());
			  }else{
				  logger.error("Detalle : Mensaje no controlado en la capa CWS");
				  if(except.getMessage() != null){
					  logger.error("Detalle(2) :"+except.getMessage());  
				  }
				  logger.error(" ");
				  throw new BbvaClientCwsException(CodClientException.CLIENT_ERROR); 
			  }
			 
		  }
		  return exit;
		 }
	
}
