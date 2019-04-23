package com.bbva.pibee.rest.util;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.bbva.pibee.arq.container.StatusBBVA;
import com.bbva.pibee.context.RequestInterceptor;


@Component
@Provider
@PreMatching
public class BbvaRequestFilters implements ContainerRequestFilter{
	
	public static Logger logger = Logger.getLogger(BbvaRequestFilters.class);
	
	@Autowired
	RequestInterceptor interceptor;
	
	
	@Autowired
	Environment env;
	
	@Override
	@Produces("application/json")
	public void filter(ContainerRequestContext requestContext) throws IOException {
		 logger.debug("Filtrando peticion ........");
		try{
			//Obtenemo el nombre de la clase
			String className=env.getProperty("com.bbva.pibee.web.filterClass", "NOK");
			
			if(!className.equalsIgnoreCase("NOK")){
				//Creamos el tipo de argumento a recibir 
				Class[] paramContext = new Class[2];
				paramContext[0]=ContainerRequestContext.class;
				paramContext[1]=RequestInterceptor.class;
				
				//Obtenemos la clase configurada 
				Class cls = Class.forName(className);
				Object obj = cls.newInstance();
				
				//Ejecytamos el metodo
				Method method = cls.getDeclaredMethod("filter", paramContext);
				method.invoke(obj, requestContext,this.interceptor);
			}else{
				 logger.debug("La aplicacion no tiene configurado un filtro.");
			}
		}catch (Exception e) {
			 requestContext.abortWith(StatusBBVA.ServerError.Status("001","Error al crear filtro de peticion"));
		}
	}

}
