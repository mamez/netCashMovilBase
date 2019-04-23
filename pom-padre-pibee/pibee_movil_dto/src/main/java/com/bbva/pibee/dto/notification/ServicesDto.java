package com.bbva.pibee.dto.notification;

import java.util.List;

import com.bbva.pibee.arq.annotations.Column;

public class ServicesDto
{
	//Tabla TNCMSERV -- Servicios
	
	@Column(name="ID_SER")
	private int ID_SER;
	
	@Column(name="NAME_SER")
	private String NAME_SER;
	
	private List<OperationDto> listOperationDto;

	public int getID_SER() {
		return ID_SER;
	}

	public void setID_SER(int ID_SER) {
		this.ID_SER = ID_SER;
	}

	public String getNAME_SER() {
		return NAME_SER;
	}

	public void setNAME_SER(String nAME_SER) {
		NAME_SER = nAME_SER;
	}

	public List<OperationDto> getListOperationDto() {
		return listOperationDto;
	}

	public void setListOperationDto(List<OperationDto> listOperationDto) {
		this.listOperationDto = listOperationDto;
	}
}
