package com.bbva.pibee.cbd.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.pibee.arq.annotations.ResourceClientBd;
import com.bbva.pibee.cbd.dao.OperationFileItemDao;
import com.bbva.pibee.config.cbd.DevelopmentProfileConfigCbd;
import com.bbva.pibee.dto.cbd.OperationFileItemDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

@ContextConfiguration(classes={ConfigContext.class,DevelopmentProfileConfigCbd.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
public class OperationFileItemTest 
{
	@ResourceClientBd
	OperationFileItemDao operationFileItemDao;
	
	OperationFileItemDto dto = new OperationFileItemDto();
	
	String var1 = "612108802242";
	long var2 = Long.parseLong(var1);
	
//	@Test
//	public void update() throws BbvaClientCbdException
//	{
//		operationFileItemDao.update("00006298", "A",26,82,"00006298",36290168l);
//	}
	
	
	@Test
	public void getBit() throws BbvaClientCbdException
	{
		dto = operationFileItemDao.getOperationFileItem(var2);
		System.out.println(dto.getQNU_NUMITEM());
	}
	
	
}
