package com.bbva.pibee.cbd.dao;

import java.util.List;

import com.bbva.pibee.dto.cbd.OperationSignerDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

public interface OperationSignerDao 
{
	/**
	 * 
	 * @param codIdOrden
	 * @return
	 */
	public List<OperationSignerDto> listOrderId(String codIdOrden) throws BbvaClientCbdException;
	
	public OperationSignerDto getOperationSigner(String codIdOrden, String userId) throws BbvaClientCbdException;
	
	public void udateOperationSigner(OperationSignerDto operationSignerDto) throws BbvaClientCbdException;
}
