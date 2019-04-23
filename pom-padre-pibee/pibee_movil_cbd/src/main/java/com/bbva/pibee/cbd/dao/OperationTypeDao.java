package com.bbva.pibee.cbd.dao;

import java.util.List;

import com.bbva.pibee.dto.response.OperationType;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

public interface OperationTypeDao {

	public List<OperationType> listOperationType(List<Integer> serviceCodeList, Integer languageCode) throws BbvaClientCbdException;
	
}
