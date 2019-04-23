package com.bbva.pibee.cbd.dao;

import java.util.List;

import com.bbva.pibee.dto.cbd.OperationHeaderDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

public interface OperationHeaderDao 
{
	/**
	 * 
	 * @param codIdOrden
	 * @return
	 * @throws BbvaClientCbdException
	 */
	public OperationHeaderDto getOperationHead(String codIdOrden) throws BbvaClientCbdException;
	/**
	 * 
	 * @param codIdOrden
	 * @return
	 * @throws BbvaClientCbdException
	 */
	public List<OperationHeaderDto> getListOrderId(String codIdOrden) throws BbvaClientCbdException;
	/**
	 * 
	 * @param objTtbhcabDto
	 * @throws BbvaClientCbdException
	 */
	public void update(OperationHeaderDto objTtbhcabDto) throws BbvaClientCbdException;
	/**
	 * 
	 * @param codClieCash
	 * @param codClaseOrd
	 * @param codIdOrden
	 * @throws BbvaClientCbdException
	 */
	public void deleteLogical(String codIdOrden) throws BbvaClientCbdException;
	
	public void signUpdate(OperationHeaderDto objTtbhcabDto, String signerUser) throws BbvaClientCbdException;
	
	public int updateDateProcess(String codIdOrden,String userId,String processDate) throws BbvaClientCbdException;
	
	public void createOperationHeader(OperationHeaderDto operationHeaderDto)throws BbvaClientCbdException;
	
}
