package com.bbva.pibee.cbd.dao;

import com.bbva.pibee.rest.exception.BbvaClientCbdException;

public interface OperationStateDao {

	public String getOperationStateDescription(String operationStateId, Integer languageCode) throws BbvaClientCbdException;
	
}
