package com.bbva.pibee.cbd.dao;

import java.util.List;

import com.bbva.pibee.dto.cbd.DocumentTypeDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

public interface DocumentTypeDao 
{
	public List<DocumentTypeDto> getTypeDocument() throws BbvaClientCbdException;
}
