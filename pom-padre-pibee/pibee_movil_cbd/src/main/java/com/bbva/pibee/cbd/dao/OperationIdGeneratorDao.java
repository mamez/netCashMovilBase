package com.bbva.pibee.cbd.dao;

import com.bbva.pibee.dto.cbd.OperationIdGeneratorDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

public interface OperationIdGeneratorDao {

	public OperationIdGeneratorDto getOperationIdGenerator(String sLocal, String sCodControl) throws BbvaClientCbdException;
	
	public void createOperationIdGenerator(OperationIdGeneratorDto operationIdGeneratorDto) throws BbvaClientCbdException;
	
	public void updateOperationIdGenerator(OperationIdGeneratorDto operationIdGeneratorDto) throws BbvaClientCbdException;
	
}
