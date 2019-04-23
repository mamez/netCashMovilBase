package com.bbva.pibee.cbd.dao;

import java.util.List;

import com.bbva.pibee.dto.cbd.TtlbhcorDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

public interface TtlbhcorDao {
	
	public List<TtlbhcorDto> getTtlbhcor() throws BbvaClientCbdException;	
	
	public void createOperationSourceHeader(TtlbhcorDto operationSourceHeader) throws BbvaClientCbdException;
	
}
