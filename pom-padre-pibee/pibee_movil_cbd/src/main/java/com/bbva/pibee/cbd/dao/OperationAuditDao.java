package com.bbva.pibee.cbd.dao;

import com.bbva.pibee.dto.cbd.OperationAuditDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

public interface OperationAuditDao 
{
	/**
	 * 
	 * @param codClieCash
	 * @param codClaseOrd
	 * @param codIdOrden
	 * @param codAccion
	 * @param codIdAccion
	 * @param codUsuario
	 * @param fecAccio
	 * @param codUsuFirma
	 * @param codUsuPoder
	 * @param codEstaFic
	 * @param fecAccion
	 * @param audFModific
	 * @param audUsuario
	 * @param codIpClient
	 * @throws BbvaClientCbdException
	 */
	public void insert(String codClieCash, String codClaseOrd, String codIdOrden, int codAccion, int codIdAccion, String codUsuario, String codUsuFirma, String codUsuPoder, String codEstaFic, String  audUsuario, String codIpClient) throws BbvaClientCbdException;
	
	public OperationAuditDto getOperationAuditBySignerUser(String codClieCash, String codClaseOrd, String codIdOrden, String codUsuFirma) throws BbvaClientCbdException;
}
