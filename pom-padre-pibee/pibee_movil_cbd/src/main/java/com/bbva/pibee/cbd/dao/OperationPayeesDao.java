package com.bbva.pibee.cbd.dao;

import java.util.List;
import com.bbva.pibee.dto.cbd.TtlbhdesDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

public interface OperationPayeesDao {	
	public List<TtlbhdesDto> getPayeesByIssuing(String codCliecash, String codClaseord, String codIdorigen) throws BbvaClientCbdException;
	public List<TtlbhdesDto> getPayeeExist(String codClieCash ,String codClaseord ,TtlbhdesDto ttlbhdesDto) throws BbvaClientCbdException;	
	public void insertDes(TtlbhdesDto desDto) throws BbvaClientCbdException;
}
