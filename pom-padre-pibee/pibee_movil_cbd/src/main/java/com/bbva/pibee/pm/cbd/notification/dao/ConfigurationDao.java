package com.bbva.pibee.pm.cbd.notification.dao;

import java.util.List;
import com.bbva.pibee.dto.notification.ConfigurationDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

public interface ConfigurationDao  
{		
	public boolean existConfigByOperation(int fkOPeration,String reference, String idUser) throws BbvaClientCbdException;
	public boolean existConfigByUser(int idConfig, String reference, String idUser) throws BbvaClientCbdException;
	public int insertConfiguration(String stateConf,String refeUser, String userId, int fkOpera) throws BbvaClientCbdException;
	public int updateConfiguration(String state, int fkOperacion, String user, String reference) throws BbvaClientCbdException;
}
