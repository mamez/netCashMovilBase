package com.bbva.pibee.cbd.dao;

import java.util.List;

import com.bbva.pibee.dto.cbd.TtlbhcuoDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

public interface TtlbhcuoDao {
	
	public List<TtlbhcuoDto> getTtlbhcuo() throws BbvaClientCbdException;
	
	public List<TtlbhcuoDto> getAccounts(String codCliecash, String codClaseord, String codIdorigen) throws BbvaClientCbdException;
	
	public void insertCUO(String codCliecash, String codClaseord, String codCdnitr, String codSufprese, String codIdorigen, String desCuenorig, String codBancinte, String codBancash, int codBancsb, String codSwift, String codBanaba, String codDiisoalf, int codFormasun, String xtiClaseasu, String audFmodific, String audUsuario) throws BbvaClientCbdException;
}
