package com.bbva.pibee.cbd.dao;

import com.bbva.pibee.dto.cbd.OperationFileItemDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

public interface OperationFileItemDao 
{
	public void update(String codLogonapl, String xtiBuzon, int codCanalDi , int codBancoInt,String  codLogonaplId,Long qnuNUmItem) throws BbvaClientCbdException;
	public OperationFileItemDto getOperationFileItem(Long qnuItem) throws BbvaClientCbdException;
	public void createOperationFileItem(OperationFileItemDto operationFileItemDto) throws BbvaClientCbdException;
}
