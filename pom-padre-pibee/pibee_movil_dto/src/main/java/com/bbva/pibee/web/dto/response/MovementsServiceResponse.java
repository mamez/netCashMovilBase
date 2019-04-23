package com.bbva.pibee.web.dto.response;

import java.util.List;

import com.bbva.pibee.web.dto.response.entity.MovementModel;
import com.bbva.pibee.web.dto.response.entity.PaginationModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MovementsServiceResponse extends PaginationModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List< MovementModel> movements;
	
	@JsonProperty("movements")
	public List<MovementModel> getMovements() {
		return movements;
	}
	public void setMovements(List<MovementModel> movements) {
		this.movements = movements;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
