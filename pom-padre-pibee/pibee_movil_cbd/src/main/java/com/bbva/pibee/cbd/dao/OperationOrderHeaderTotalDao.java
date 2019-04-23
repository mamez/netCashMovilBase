package com.bbva.pibee.cbd.dao;

import java.util.List;

import com.bbva.pibee.dto.cbd.OperationOrderHeaderTotalDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

public interface OperationOrderHeaderTotalDao {
	public List<OperationOrderHeaderTotalDto> getOperationOrderHeader(String sCodigoCliente, String sClaseOrden, String sIdOrden, int iIdCabeceraOrigen) throws BbvaClientCbdException;
}
