package com.bbva.pibee.cbd.dao;

import com.bbva.pibee.dto.cbd.OperationOrderSourceDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

public interface TtlbhoroDtoDao {

	public void createTtlbhoroDto(OperationOrderSourceDto ttlbhoroDto) throws BbvaClientCbdException;
	
}
