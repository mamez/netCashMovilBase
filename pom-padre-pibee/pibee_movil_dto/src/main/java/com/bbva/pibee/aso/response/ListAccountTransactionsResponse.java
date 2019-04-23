package com.bbva.pibee.aso.response;

import java.util.List;

import com.bbva.pibee.aso.response.dto.Movement;
import com.bbva.pibee.aso.response.dto.Pagination;

public class ListAccountTransactionsResponse {
	
	private List<Movement> movement;
	private Pagination pagination;
	public List<Movement> getMovement() {
		return movement;
	}
	public void setMovement(List<Movement> movement) {
		this.movement = movement;
	}
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	@Override
	public String toString() {
		return "ListAccountTransactionsResponse [movement=" + movement + ", pagination=" + pagination + "]";
	}
	
	
}
