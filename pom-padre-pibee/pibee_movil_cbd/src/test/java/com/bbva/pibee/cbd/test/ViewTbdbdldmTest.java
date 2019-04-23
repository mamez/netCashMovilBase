package com.bbva.pibee.cbd.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.pibee.arq.annotations.ResourceClientBd;
import com.bbva.pibee.cbd.dao.ViewTbdbdldmDao;
import com.bbva.pibee.config.cbd.DevelopmentProfileConfigCbd;
import com.bbva.pibee.dto.cbd.ViewTbdbdldmDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.util.CatalogType;
import com.bbva.pibee.util.CodeLanguage;

@ContextConfiguration(classes=DevelopmentProfileConfigCbd.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
public class ViewTbdbdldmTest 
{
	@ResourceClientBd
	ViewTbdbdldmDao viewTbdbdldmDao;
	
//	@Test
//	public void getAccountType() throws BbvaClientCbdException
//	{		
//		List<ViewTbdbdldmDto> getListAccountType = viewTbdbdldmDao.getAccountType();
//		for(ViewTbdbdldmDto in :getListAccountType)
//		{
//			ViewTbdbdldmDto dto = getListAccountType.get(0);
//			System.out.println(in.getDES_LITECOR());
//		}			
//	}
	
	@Test
	public void getPaymentMethod() throws BbvaClientCbdException		
	{		
		List<ViewTbdbdldmDto> getPaymentMethod = viewTbdbdldmDao.getViewInformation(CatalogType.FILE_DESCRIPTION_STATE, CodeLanguage.ES);
		for(ViewTbdbdldmDto in :getPaymentMethod)
		{
			ViewTbdbdldmDto dto = getPaymentMethod.get(0);
			System.out.println(in.getDES_LITECOR());
		}	
		
	}	
	
}
