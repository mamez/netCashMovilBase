package com.bbva.pibee.context;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.bbva.pibee.util.NotificationDetail;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestInterceptor {
	
	 private String tsec;
	 private String sesionAst;
	 private String reference;
	 private String userId;
	 private String languageCode;
	 private String ipHttp;
	 private String ivTicketService;
	 private String channel;
	 private String codBank;
	 private String ivUser;
	 private String lenguaje;
	 private String ivorigin;
	 private String idNotification;
	 public String getIdNotification() {
		return idNotification;
	}
	public void setIdNotification(String idNotification) {
		this.idNotification = idNotification;
	}
	private NotificationDetail notification;
	 
	public NotificationDetail getNotification() {
		return notification;
	}
	public void setNotification(NotificationDetail notification) {
		this.notification = notification;
	}
	public String getTsec() {
		return tsec;
	}
	public void setTsec(String tsec) {
		this.tsec = tsec;
	}
	public String getSesionAst() {
		return sesionAst;
	}
	public void setSesionAst(String sesionAst) {
		this.sesionAst = sesionAst;
	}
	public String getCompleteReference() {
		return getChannel()+getCodBank()+getReference();
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLanguageCode() {
		return languageCode;
	}
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	public String getIpHttp() {
		return ipHttp;
	}
	public void setIpHttp(String ipHttp) {
		this.ipHttp = ipHttp;
	}
	public String getIvTicketService() {
		return ivTicketService;
	}
	public void setIvTicketService(String ivTicketService) {
		this.ivTicketService = ivTicketService;
	}
	public String getCodBank() {
		return codBank;
	}
	public void setCodBank(String codBank) {
		this.codBank = codBank;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getIvUser() {
		return ivUser;
	}
	public void setIvUser(String ivUser) {
		this.ivUser = ivUser;
	}
	public String getLenguaje() {
		return lenguaje;
	}
	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}
	public String getIvorigin() {
		return ivorigin;
	}
	public void setIvorigin(String ivorigin) {
		this.ivorigin = ivorigin;
	}
	
}
