package com.bbva.pibee.util;

import java.util.Hashtable;

import com.bbva.pibee.arq.annotations.OperationNotificationType;

/**
 * 
 * @author vyg0069
 *
 */
public class NotificationDetail {
private String codeTransaction;
private OperationNotificationType operationType;
private String idTemplate;
private Hashtable<String , String> data;
private int costructor;

public NotificationDetail(String codeTransaction,OperationNotificationType operationType,String idTemplate,Hashtable<String , String> data) {
	if(codeTransaction == null  || operationType  == null || idTemplate  == null ||  data == null) {
	    throw new IllegalArgumentException(
	      String.format("Los parametros no pueden ser nulos: codeTransaction=%s  , operationType=%s , idTemplate=%s ,  data=%s",codeTransaction,operationType,idTemplate,data.toString()));
	}
	this.codeTransaction=codeTransaction;
	this.operationType=operationType;
	this.idTemplate=idTemplate;
	this.data=data;
	this.costructor=1;
}

public NotificationDetail(OperationNotificationType operationType,String idTemplate,Hashtable<String , String> data) {
	if( operationType  == null || idTemplate  == null ||  data == null) {
	    throw new IllegalArgumentException(
	      String.format("Los parametros no pueden ser nulos:  operationType=%s , idTemplate=%s ,  data=%s",operationType,idTemplate,data.toString()));
	}
	this.operationType=operationType;
	this.idTemplate=idTemplate;
	this.data=data;
	this.costructor=2;
}

public NotificationDetail(String codeTransaction,OperationNotificationType operationType,String idTemplate) {
	if(codeTransaction == null  || operationType  == null || idTemplate  == null ) {
	    throw new IllegalArgumentException(
	      String.format("Los parametros no pueden ser nulos: codeTransaction=%s  , operationType=%s , idTemplate=%s ",codeTransaction,operationType,idTemplate));
	}
	this.codeTransaction=codeTransaction;
	this.operationType=operationType;
	this.idTemplate=idTemplate;
	this.costructor=3;
}

public NotificationDetail(OperationNotificationType operationType,String idTemplate) {
	if( operationType  == null || idTemplate  == null ) {
	    throw new IllegalArgumentException(
	      String.format("Los parametros no pueden ser nulos:  operationType=%s , idTemplate=%s ",operationType,idTemplate));
	}
	this.operationType=operationType;
	this.idTemplate=idTemplate;
	this.costructor=4;
}



public int getCostructor() {
	return costructor;
}

public String getcodeTransaction() {
	return codeTransaction;
}

public OperationNotificationType getOperationType() {
	return operationType;
}
public String getIdTemplate() {
	return idTemplate;
}
public Hashtable<String, String> getData() {
	return data;
}



}
