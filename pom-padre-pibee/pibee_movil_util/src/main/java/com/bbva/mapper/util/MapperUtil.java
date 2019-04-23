package com.bbva.mapper.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperUtil {
	

	@SuppressWarnings("unchecked")
	public static <T> T getValueFromResultSet(final ResultSet rs,String columnLabel, T defaultValue) {
	    try {
	    	if(defaultValue instanceof Long) {
	    	  Long value=(Long)rs.getObject(columnLabel);
	    	  if(value==null) {
	    		  value= new Long("0");
	    	  }
	    		  return (T) value;  
	    	  
	    	}else {
	    		 return (T) rs.getObject(columnLabel);
	    	}
	    } catch (Exception e) {
	        return defaultValue;
	    }
	}

}
