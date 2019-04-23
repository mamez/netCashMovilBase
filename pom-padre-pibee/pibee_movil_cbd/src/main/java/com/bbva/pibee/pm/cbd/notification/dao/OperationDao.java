package com.bbva.pibee.pm.cbd.notification.dao;

import com.bbva.pibee.dto.notification.OperationDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

public interface OperationDao 
{
	OperationDto getOperation(String referenceUser, String userId,int idOperacion) throws BbvaClientCbdException;
}
