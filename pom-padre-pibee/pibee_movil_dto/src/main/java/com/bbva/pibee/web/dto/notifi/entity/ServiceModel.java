package com.bbva.pibee.web.dto.notifi.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServiceModel
{
	private int id;
	private String name;
	private List<OperationModel> listOperationModel;
	
	@JsonProperty("id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	@JsonProperty("operations")
	public List<OperationModel> getListOperationModel() {
		return listOperationModel;
	}
	public void setListOperationModel(List<OperationModel> listOperationModel) {
		this.listOperationModel = listOperationModel;
	}
	
	
}
