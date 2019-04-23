package com.bbva.pibee.web.dto.notifi.response;

import java.util.List;

import com.bbva.pibee.web.dto.notifi.entity.ServiceModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ServicesResponse 
{
	private List<ServiceModel> ServiceModel;

	@JsonProperty("services")
	public List<ServiceModel> getServiceModel() {
		return ServiceModel;
	}

	public void setServiceModel(List<ServiceModel> serviceModel) {
		ServiceModel = serviceModel;
	}
	
	
}
