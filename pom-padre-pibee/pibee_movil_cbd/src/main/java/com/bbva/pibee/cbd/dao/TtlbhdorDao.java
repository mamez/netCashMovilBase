package com.bbva.pibee.cbd.dao;

import com.bbva.pibee.dto.cbd.TtlbhdorDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

public interface TtlbhdorDao 
{
	public void insertDor(TtlbhdorDto dorDto) throws BbvaClientCbdException;
}
