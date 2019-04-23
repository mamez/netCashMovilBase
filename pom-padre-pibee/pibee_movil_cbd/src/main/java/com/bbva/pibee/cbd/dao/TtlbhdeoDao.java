package com.bbva.pibee.cbd.dao;

import java.util.List;

import com.bbva.pibee.dto.cbd.TtlbhdeoDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

public interface TtlbhdeoDao {
	public List<TtlbhdeoDto> getTtlbhdeo(String codCliente, String claseOrden, String idOrden, String idDetalle, String idCodCabOrigen) throws BbvaClientCbdException;
	public void createOperationOrderDestination(TtlbhdeoDto operationOrderDestination)throws BbvaClientCbdException;
	public void insertDeo(TtlbhdeoDto deoDto) throws BbvaClientCbdException;
}
