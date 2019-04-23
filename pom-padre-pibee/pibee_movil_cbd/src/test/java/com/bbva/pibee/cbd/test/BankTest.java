package com.bbva.pibee.cbd.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import com.bbva.pibee.arq.annotations.ResourceClientBd;
import com.bbva.pibee.cbd.dao.BankDao;
import com.bbva.pibee.cbd.dao.OperationHeaderDao;
import com.bbva.pibee.config.cbd.DevelopmentProfileConfigCbd;
import com.bbva.pibee.dto.cbd.BankDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

@ContextConfiguration(classes=DevelopmentProfileConfigCbd.class)  
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")	
public class BankTest extends AbstractTestNGSpringContextTests
{
	@ResourceClientBd
	BankDao bankDao;
	
	@ResourceClientBd
	OperationHeaderDao operationHeaderDao;
	
	@Test
	public void getBank() throws BbvaClientCbdException{		
		List<BankDto> getListBanks = bankDao.getBanks();
		for(BankDto in : getListBanks)
		{
			BankDto dto = getListBanks.get(0);
			System.out.println(in.getCOD_BANCSB());
			System.out.println(in.getDES_DNOMCO());
		}
	}
}
