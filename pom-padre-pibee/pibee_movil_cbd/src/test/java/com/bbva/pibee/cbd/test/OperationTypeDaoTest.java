package com.bbva.pibee.cbd.test;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import com.bbva.pibee.arq.annotations.ResourceClientBd;
import com.bbva.pibee.cbd.dao.OperationTypeDao;
import com.bbva.pibee.cbd.daoImpl.OperationTypeDaoImpl;
import com.bbva.pibee.config.cbd.DevelopmentProfileConfigCbd;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

@ContextConfiguration(classes=DevelopmentProfileConfigCbd.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class OperationTypeDaoTest extends AbstractTestNGSpringContextTests{

	@ResourceClientBd
	private OperationTypeDao operationTypeDao;
	
	@Test
	public void listOperationTypes(){
		try {
			System.out.println(operationTypeDao.listOperationType(Arrays.asList(8600, 6002), 1));
		} catch (BbvaClientCbdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
