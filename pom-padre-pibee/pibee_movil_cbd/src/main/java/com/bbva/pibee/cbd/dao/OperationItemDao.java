package com.bbva.pibee.cbd.dao;

import com.bbva.pibee.dto.cbd.OperationItemDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

public interface OperationItemDao {

	public void createOperationItem(OperationItemDto operationItemDto) throws BbvaClientCbdException;
	
}
