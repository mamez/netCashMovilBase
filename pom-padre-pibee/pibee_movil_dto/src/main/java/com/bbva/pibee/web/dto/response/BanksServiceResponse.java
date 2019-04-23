package com.bbva.pibee.web.dto.response;

import java.util.List;

import com.bbva.pibee.web.dto.response.entity.BanksModel;
import com.bbva.pibee.web.dto.response.entity.PaginationModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BanksServiceResponse extends PaginationModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<BanksModel> listBanksModel;
	
	
	@JsonProperty("externalBanks")
	public List<BanksModel> getListBanksModel() {
		return listBanksModel;
	}

	public void setListBanksModel(List<BanksModel> listBanksModel) {
		this.listBanksModel = listBanksModel;
	}
	
}
