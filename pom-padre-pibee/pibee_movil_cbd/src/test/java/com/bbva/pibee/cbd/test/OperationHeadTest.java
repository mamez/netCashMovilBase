package com.bbva.pibee.cbd.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import com.bbva.pibee.arq.annotations.ResourceClientBd;
import com.bbva.pibee.cbd.dao.OperationHeaderDao;
import com.bbva.pibee.config.cbd.DevelopmentProfileConfigCbd;
import com.bbva.pibee.dto.cbd.OperationHeaderDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

@ContextConfiguration(classes=DevelopmentProfileConfigCbd.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")

public class OperationHeadTest extends AbstractTestNGSpringContextTests 
{
	@ResourceClientBd
	private OperationHeaderDao operationHeadDao;
	
	@Test
	public void listOrderId() throws BbvaClientCbdException
	{
		List<OperationHeaderDto> listaDto = operationHeadDao.getListOrderId("15C0004J");
		for(OperationHeaderDto dto : listaDto)
		{
			System.out.println(dto.getCOD_CLIECASH());
			System.out.println(dto.getCOD_CLASEORD());
		}		
	}
	
//	@Test
//	public void update() throws BbvaClientCbdException
//	{
//		List<OperationHeadDto> listaDto = operationHeadDao.getListOrderId("15C0004J");
//		OperationHeadDto dto = listaDto.get(0);
//		dto.setFEC_PROCESCA("20170601");
//		operationHeadDao.update(dto);		
//	}
//	
	
//	@Test
//	public void delete() throws BbvaClientCbdException
//	{
//		List<OperationHeadDto> listaDto = operationHeadDao.getListOrderId("15C0004J");
//		OperationHeadDto dto = listaDto.get(0);		
//		operationHeadDao.deleteLogical(dto.getCOD_IDORDEN());		
//	}
	
//	@Test
//	public void updateDateProcess() throws BbvaClientCbdException
//	{		
//		operationHeadDao.updateDateProcess("15C0004K");	
//	}
//		
	
}
