package com.bbva.pibee.cbd.dao;

import java.util.List;

import com.bbva.pibee.dto.cbd.TtlbhdorDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

public interface OperationConsultDetailDao {
	public List<TtlbhdorDto> generateFilter(String codCliente, String claseOrden, String idOrden, int idDetalle, int idCodCabOrigen) throws BbvaClientCbdException;
}
