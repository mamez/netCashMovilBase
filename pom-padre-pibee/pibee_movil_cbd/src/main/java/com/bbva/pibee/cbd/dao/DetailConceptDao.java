package com.bbva.pibee.cbd.dao;

import java.util.List;

import com.bbva.pibee.dto.cbd.DetailConceptDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

public interface DetailConceptDao {

	public List<DetailConceptDto> getDetailConceptList(String sCodCliente, String sClaseOrden,String sIdOrden, 
			   int iCodCabOri, int iIdDetalle) throws BbvaClientCbdException;
	
	public void createDetailConcept(DetailConceptDto detailConceptDto) throws BbvaClientCbdException; 
	
}
