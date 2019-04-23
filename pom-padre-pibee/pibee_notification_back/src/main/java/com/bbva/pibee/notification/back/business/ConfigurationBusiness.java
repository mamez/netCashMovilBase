package com.bbva.pibee.notification.back.business;

import com.bbva.pibee.rest.exception.BbvaClientBackException;
import com.bbva.pibee.web.dto.notifi.request.ConfigurationEntityRequest;
import com.bbva.pibee.web.dto.notifi.response.ServicesResponse;

public interface ConfigurationBusiness {
	public ServicesResponse getConfigurations() throws BbvaClientBackException;
	public void configuration(ConfigurationEntityRequest configurationEntityRequest)throws BbvaClientBackException;
}
