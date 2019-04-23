package com.bbva.pibee.pm.cbd.notification.dao;

import java.util.List;

import com.bbva.pibee.dto.notification.GenericServicesDto;
import com.bbva.pibee.dto.notification.ServicesDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

public interface ServiceDao {
	List<ServicesDto> getServices() throws BbvaClientCbdException;
	List<GenericServicesDto> getGenericServices(String reference, String user) throws BbvaClientCbdException;
	List<GenericServicesDto> getAllServices() throws BbvaClientCbdException;
}
