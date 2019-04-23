package com.bbva.pibee.cbd.dao;

import java.util.List;

import com.bbva.pibee.dto.cbd.TtlbhoolDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

public interface TtlbhoolDao {
	
	public void insertOOL(TtlbhoolDto orderOnLine) throws BbvaClientCbdException;

	public List<TtlbhoolDto> getOrderTpo(long qnuNumItem, String typeOrder) throws BbvaClientCbdException;
	 
}
