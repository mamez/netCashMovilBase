package com.bbva.pibee.rest.exception;

import org.apache.cxf.logging.FaultListener;
import org.apache.cxf.message.Message;

public class CxfFaultListenerImpl implements FaultListener {

	@Override
	public boolean faultOccurred(Exception arg0, String arg1, Message arg2) {
		
		System.out.println("Error >>>>>>>>>"+arg0.getMessage());
		return false;
	}

}
