package com.bbva.pibee.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.bbva.pibee.arq.annotations.PosDetail;

public class MapUtilOol<T>  {
	
    public T mapOol(Class<T> classMap,   String detallePago){
    	T clase = null;
    	String[] detalleArray=dicvidirLinea(detallePago);
    	try {
			clase=(T) classMap.newInstance();
			Field[] campos= clase.getClass().getDeclaredFields(); 
			for(Field in : campos) {
				Annotation[] anotaciones=in.getAnnotations();
				for(Annotation annotacion : anotaciones) {
					if(annotacion instanceof PosDetail) {
						PosDetail posAnnotacion=(PosDetail) annotacion;
						String pos=posAnnotacion.posicion();
						String valor=getValor(detalleArray, pos);
						in.setAccessible(true);
						in.set(clase, valor);
					}
				}
			}
			
		} catch (InstantiationException e) {
			// error al instanciar la clawse
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// error al instanciar la clawse
			e.printStackTrace();
		}
    	return clase;
    }
    
    
    private String[] dicvidirLinea(String detallePago) {
    	String[] detalleArray=detallePago.split("#");
    	return detalleArray;
    }

    
    
    private String getValor(String[] detalleArray, String pos) {
    	String resp= "";
    	for(String in : detalleArray) {
    		String posicionElemento=in.trim().equals("")? "": in.trim().substring(0, pos.length());
    		if(posicionElemento.equalsIgnoreCase(pos)) {
    			resp=in.substring(pos.length());
    			if(resp.equals("-")) {
    				resp="";
    			}
    			break;
    		}
    	}
    	return resp;
    }
}
