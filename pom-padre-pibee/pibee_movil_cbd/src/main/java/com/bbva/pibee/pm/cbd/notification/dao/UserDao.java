package com.bbva.pibee.pm.cbd.notification.dao;

import java.util.Date;
import java.util.List;

import com.bbva.pibee.dto.notification.UserDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

public interface UserDao
{

	public UserDto getUser(String reference, String user)throws BbvaClientCbdException;
	public void createUser(UserDto userDto)throws BbvaClientCbdException;	
	public void modifyUser(UserDto userDto)throws BbvaClientCbdException;
	List<UserDto> getUsers(String reference, String user, String device, String token, String platform, String version,
			String creationDate, String modifiDate, String state, String enrollment) throws BbvaClientCbdException;
	
}
