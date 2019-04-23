package com.bbva.pibee.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.bbva.pibee.util.SignOperationType;

@Component
public class SignOperationProvider implements ApplicationContextAware{

	 private static ApplicationContext CONTEXT;

	    @Override
	    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	        CONTEXT = applicationContext;
	    }

	    /**
	     * Obtiene un bean a partir de una clase
	     * @param beanClass
	     * @return
	     */
	    public static <T> T getBean(Class<T> beanClass) {
	        return CONTEXT.getBean(beanClass);
	    }
        
	    /**
	     * Obtiene un bean a partir de el nombre
	     * @param beanName
	     * @return
	     */
	    public static Object getBean(SignOperationType op) {
	        return CONTEXT.getBean(op.getNameSignOperation());
	    }


}
