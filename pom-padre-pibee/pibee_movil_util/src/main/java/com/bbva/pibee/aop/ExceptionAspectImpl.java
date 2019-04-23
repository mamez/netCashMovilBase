package com.bbva.pibee.aop;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.bbva.pibee.annotatios.excepcioncontrol.BbvaMovileArqException;

@Aspect
@Component
public class ExceptionAspectImpl {
	public static Logger logger = Logger.getLogger("auditoria");
	  	 
 @Pointcut("@annotation(com.bbva.pibee.arq.annotations.ExcepcionControl)")
 protected void exceptionControl() {}
	  
 @Around("exceptionControl()")
 public Object catchException(ProceedingJoinPoint joinpoint) throws Throwable {
	  Object exit = null;
	  try {
	   exit = joinpoint.proceed();
	  } catch (Exception except) {
		  logger.error("***********************************************************************************************************");
		  logger.error("**********************************      ERROR          ****************************************************");
		  logger.error("***********************************************************************************************************");
		  logger.error("Reporte de Error capturado ");
		  logger.error("Clase : "+joinpoint.getTarget().getClass());
		  logger.error("Metodo : "+joinpoint.getSignature().getName());
		  logger.error("Variables : "+Arrays.toString(joinpoint.getArgs()));
		 logger.error("Detalle del ERROR : "+except.getMessage(), except);
	   throw  new BbvaMovileArqException(except);
	  }
	  return exit;
	 }
}
