package com.bbva.pibee.notification.config.back;

//import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class InitContext {
	
	public static Logger logger = Logger.getLogger("pibee");
	
	@Autowired
	private Environment env;
	
	
}
