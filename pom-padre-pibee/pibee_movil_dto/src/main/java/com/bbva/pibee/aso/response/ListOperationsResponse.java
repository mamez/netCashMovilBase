package com.bbva.pibee.aso.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.bbva.pibee.aso.response.dto.Pagination;
import com.bbva.pibee.aso.response.dto.Operation;

public class ListOperationsResponse {
	
	@XmlElement(name="transaction")
	private List<Operation> transaction;
	
	@XmlElement(name="pagination")
	private Pagination pagination;

	
	public List<Operation> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Operation> transaction) {
		this.transaction = transaction;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	@Override
	public String toString() {
		return "ListOperationsResponse [transaction=" + transaction + ", pagination=" + pagination + "]";
	}
	
	
	
}
