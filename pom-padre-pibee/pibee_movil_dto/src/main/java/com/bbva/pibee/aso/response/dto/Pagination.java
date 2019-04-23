package com.bbva.pibee.aso.response.dto;

public class Pagination {
	private String paginationKey;
	private String pageSize;

	public String getPaginationKey() {
		return paginationKey;
	}

	public void setPaginationKey(String paginationKey) {
		this.paginationKey = paginationKey;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "Pagination [paginationKey=" + paginationKey + ", pageSize=" + pageSize + "]";
	}
	
	
}
