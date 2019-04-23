package com.bbva.pibee.util;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFormatter {
	  

	    public static String format(String format, Map<String, String> objects) {
	    	String fieldStart = "\\$\\{";
	  	    String fieldEnd = "\\}";
	        String regex = fieldStart + "([^}]+)" + fieldEnd;
	  	    Pattern pattern = Pattern.compile(regex);
	    	format=format.replace("%{", "${");
	        Matcher m = pattern.matcher(format);
	        String result = format;
	        int cont=0;
	        while (m.find()) {
	        	try {
	            String[] found = m.group(1).split("\\.");
	            String newVal=objects.get(found[cont]);
	            result = result.replaceFirst(regex, newVal);
	        	}catch (NullPointerException e) {
					System.out.println("losdatos no concuerdan");
				}
	        }
	        return result;
	    }
	    
}
