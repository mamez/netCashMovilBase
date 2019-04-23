package com.bbva.pibee.cbd.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import com.bbva.pibee.arq.annotations.ResourceClientBd;
import com.bbva.pibee.cbd.dao.OperationSignerDao;
import com.bbva.pibee.config.cbd.DevelopmentProfileConfigCbd;
import com.bbva.pibee.dto.cbd.OperationSignerDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

@ContextConfiguration(classes=DevelopmentProfileConfigCbd.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class OperationSignerTest extends AbstractTestNGSpringContextTests 
{
	@ResourceClientBd
	private OperationSignerDao operationSignerDao;
	
	@Test
	public void listOrderId() throws BbvaClientCbdException
	{
		List<OperationSignerDto> listaDto = operationSignerDao.listOrderId("ARA00172");
		for(OperationSignerDto dto : listaDto)
		{
			System.out.println(dto.getCOD_CLIECASH());
			System.out.println(dto.getCOD_CLASEORD());
			System.out.println(dto.getCOD_USUARIO());
		}		
	}
}
