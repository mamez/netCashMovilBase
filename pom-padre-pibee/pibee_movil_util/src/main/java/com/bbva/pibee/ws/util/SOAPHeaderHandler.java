package com.bbva.pibee.ws.util;

import java.util.Set;
import java.util.TreeSet;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeader;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class SOAPHeaderHandler implements SOAPHandler<SOAPMessageContext>{
	 private final String ast;

	    public SOAPHeaderHandler(String ast) {
	        this.ast = ast;
	    }

	    public boolean handleMessage(SOAPMessageContext context) {
	        Boolean outboundProperty =(Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
	        if (outboundProperty.booleanValue()) {
	            try {
	                SOAPEnvelope envelope = context.getMessage().getSOAPPart().getEnvelope();
	                SOAPFactory factory = SOAPFactory.newInstance();
	                SOAPElement securityElem =factory.createElement("iv-sesion");
	                securityElem.addTextNode(this.ast);
	                SOAPHeader header = envelope.getHeader();
	                header.addChildElement(securityElem);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        } else {
	            // inbound
	        }
	        return true;
	    }

	    public Set<QName> getHeaders() {
	        return new TreeSet();
	    }

	    public boolean handleFault(SOAPMessageContext context) {
	        return false;
	    }

	    public void close(MessageContext context) {
	        //
	    }
}
