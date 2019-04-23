package com.bbva.pibee.cbd.dao;

import java.util.List;

import com.bbva.pibee.dto.cbd.OperationListDetailsDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

public interface OperationListDetailsDao {
	public List<OperationListDetailsDto> getListDetails(String sCodigoCliente, String sClaseOrden, String sCodigoOrden) throws BbvaClientCbdException;
}
