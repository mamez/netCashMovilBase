package com.bbva.pibee.web.dto.response.entity;

import java.io.Serializable;

public class PaginationModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int paginationKey;
	protected int pageSize;
	
	public int getPaginationKey() {
		return paginationKey;
	}
	public void setPaginationKey(int paginationKey) {
		this.paginationKey = paginationKey;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	

}
