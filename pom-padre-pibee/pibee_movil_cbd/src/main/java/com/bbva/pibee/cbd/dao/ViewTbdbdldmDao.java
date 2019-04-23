package com.bbva.pibee.cbd.dao;

import java.util.List;

import com.bbva.pibee.dto.cbd.ViewTbdbdldmDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.util.CatalogType;
import com.bbva.pibee.util.CodeLanguage;

public interface ViewTbdbdldmDao 
{
	public List<ViewTbdbdldmDto> getViewInformation(CatalogType catalogo, CodeLanguage idioma) throws BbvaClientCbdException;
}
