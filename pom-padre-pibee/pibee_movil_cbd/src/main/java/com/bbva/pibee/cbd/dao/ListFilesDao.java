package com.bbva.pibee.cbd.dao;

import java.util.Date;
import java.util.List;
import com.bbva.pibee.dto.cbd.OperationDetailDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

public interface ListFilesDao {
	/**
	 * 
	 * @param CodCliente
	 * @param estados
	 * @return
	 */
	List<OperationDetailDto> getListaFicherosPendiente(String companyReference,List<String> serviceStateList, String creatorUser, List<String> operationTypeIdList, 
			Date dateFrom, Date dateTo, Double ammountFrom, Double ammountTo) throws BbvaClientCbdException;
	
	OperationDetailDto getOperationDetailById(String id) throws BbvaClientCbdException;
}
