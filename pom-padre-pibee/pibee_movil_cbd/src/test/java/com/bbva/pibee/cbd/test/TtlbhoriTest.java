package com.bbva.pibee.cbd.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import com.bbva.pibee.arq.annotations.ResourceClientBd;
import com.bbva.pibee.cbd.dao.TtlbhoriDao;
import com.bbva.pibee.config.cbd.DevelopmentProfileConfigCbd;
import com.bbva.pibee.dto.cbd.TtlbhoriDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

@ContextConfiguration(classes=DevelopmentProfileConfigCbd.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")

public class TtlbhoriTest extends AbstractTestNGSpringContextTests
{
	@ResourceClientBd
	TtlbhoriDao ttlbhoriDao;
	
	@Test
	public void getTtlbhori() throws BbvaClientCbdException
	{
		List<TtlbhoriDto> listGetPayees = ttlbhoriDao.getTtlbhori();
		for(TtlbhoriDto in :listGetPayees)
		{
			TtlbhoriDto dto = listGetPayees.get(0);
			System.out.println(in.getCOD_CLIECASH());
		}				
	}
}
