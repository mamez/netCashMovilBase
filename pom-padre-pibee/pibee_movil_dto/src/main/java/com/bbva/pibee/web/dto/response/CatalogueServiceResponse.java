package com.bbva.pibee.web.dto.response;

import java.util.List;

import com.bbva.pibee.web.dto.response.entity.CatalogueModel;
import com.bbva.pibee.web.dto.response.entity.PaginationModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CatalogueServiceResponse extends PaginationModel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<CatalogueModel> getListState;

	@JsonProperty("stateOperations")
	public List<CatalogueModel> getGetListState() {
		return getListState;
	}

	public void setGetListState(List<CatalogueModel> getListState) {
		this.getListState = getListState;
	}	
}
