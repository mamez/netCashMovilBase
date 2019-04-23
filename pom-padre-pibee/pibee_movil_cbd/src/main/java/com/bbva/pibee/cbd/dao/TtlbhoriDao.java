package com.bbva.pibee.cbd.dao;

import java.util.List;

import com.bbva.pibee.dto.cbd.TtlbhoriDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

public interface TtlbhoriDao 
{
	@Deprecated
	public List<TtlbhoriDto> getTtlbhori() throws BbvaClientCbdException;
	
	public List<TtlbhoriDto> getIssuings(String codCliecash, String codClaseord) throws BbvaClientCbdException;
	
	public TtlbhoriDto getTtlbhori(String codCliecash, String codClaseord, String codIdOrigen) throws BbvaClientCbdException;
}
