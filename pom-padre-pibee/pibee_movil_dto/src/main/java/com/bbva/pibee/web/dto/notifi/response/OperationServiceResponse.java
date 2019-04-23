package com.bbva.pibee.web.dto.notifi.response;

import java.util.List;

import com.bbva.pibee.web.dto.notifi.entity.OperationModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OperationServiceResponse 
{
	private List<OperationModel> listOperationModel;

	@JsonProperty("operations")
	public List<OperationModel> getListOperationModel() {
		return listOperationModel;
	}

	public void setListOperationModel(List<OperationModel> listOperationModel) {
		this.listOperationModel = listOperationModel;
	}
	
}
