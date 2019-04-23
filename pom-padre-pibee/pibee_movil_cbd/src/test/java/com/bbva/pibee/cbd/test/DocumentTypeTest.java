package com.bbva.pibee.cbd.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.pibee.arq.annotations.ResourceClientBd;
import com.bbva.pibee.cbd.dao.BankDao;
import com.bbva.pibee.cbd.dao.DocumentTypeDao;
import com.bbva.pibee.config.cbd.DevelopmentProfileConfigCbd;
import com.bbva.pibee.dto.cbd.BankDto;
import com.bbva.pibee.dto.cbd.DocumentTypeDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

@ContextConfiguration(classes=DevelopmentProfileConfigCbd.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")

public class DocumentTypeTest 
{
	
	@ResourceClientBd
	DocumentTypeDao documentTypeDao;
		
	@Test
	public void getTtlbhori() throws BbvaClientCbdException
	{
		List<DocumentTypeDto> getListTypeDocument = documentTypeDao.getTypeDocument();
		for(DocumentTypeDto in :getListTypeDocument)
		{
			DocumentTypeDto dto = getListTypeDocument.get(0);
			System.out.println(in.getDES_DOCIDLEG());
		}				
	}
	
}
