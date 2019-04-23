package com.bbva.pibee.aso.response.dto;

public class CommonName {
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "CommonName [id=" + id + ", name=" + name + "]";
	}
	
	
}
