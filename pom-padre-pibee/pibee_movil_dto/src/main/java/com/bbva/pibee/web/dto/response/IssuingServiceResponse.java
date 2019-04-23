package com.bbva.pibee.web.dto.response;

import java.util.List;

import com.bbva.pibee.web.dto.response.entity.IssuingModel;
import com.bbva.pibee.web.dto.response.entity.PaginationModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class IssuingServiceResponse extends PaginationModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1421153809597465878L;
	
	List<IssuingModel> listIssuingModel;
	
	
	@JsonProperty("issuing")
	public List<IssuingModel> getListIssuingModel() {
		return listIssuingModel;
	}

	public void setListIssuingModel(List<IssuingModel> listIssuingModel) {
		this.listIssuingModel = listIssuingModel;
	}
	
}
