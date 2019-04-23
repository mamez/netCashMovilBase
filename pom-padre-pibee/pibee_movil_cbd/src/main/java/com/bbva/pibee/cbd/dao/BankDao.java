package com.bbva.pibee.cbd.dao;

import java.util.List;
import com.bbva.pibee.dto.cbd.BankDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

public interface BankDao 
{ 
	public List<BankDto> getBanks() throws BbvaClientCbdException;
}
