package com.bbva.pibee.web.dto.response;

import java.util.List;

import com.bbva.pibee.web.dto.response.entity.PaginationModel;
import com.bbva.pibee.web.dto.response.entity.PayeesModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PayeesServiceResponse extends PaginationModel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5621747301584943921L;
	List<PayeesModel> listPayeesModel;
	
	
	@JsonProperty("payees")
	public List<PayeesModel> getListPayeesModel() {
		return listPayeesModel;
	}

	public void setListPayeesModel(List<PayeesModel> listPayeesModel) {
		this.listPayeesModel = listPayeesModel;
	}
	
}
