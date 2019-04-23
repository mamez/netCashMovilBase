package com.bbva.pibee.arq.annotations;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;


public class UtilDto {

	private Object obj=null;
	
	public <T>  UtilDto(Class<T> cls){
		try {
			obj = cls.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	protected String getValueField(String fieldName) {
		String nameColum="";
		 try {
			// Field[] field2=obj.getClass().getDeclaredFields();
			Field field =  obj.getClass().getDeclaredField(fieldName);
			Annotation annotation = field.getAnnotation(Column.class);
			if(annotation instanceof Column){
				Column myAnnotation = (Column) annotation;
			    nameColum=myAnnotation.name();
			}
			
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		
		return nameColum;
	}
	
	
}
