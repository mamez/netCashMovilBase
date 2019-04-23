package com.bbva.pibee.cbd.notification.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.pibee.arq.annotations.ResourceClientBd;
import com.bbva.pibee.config.cbd.DevelopmentNotiProfileConfigCbd;
import com.bbva.pibee.dto.notification.GenericServicesDto;
import com.bbva.pibee.pm.cbd.notification.dao.ServiceDao;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

@ContextConfiguration(classes=DevelopmentNotiProfileConfigCbd.class )
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev-noti")
public class GenericServicesTest {

	@ResourceClientBd
	private ServiceDao serviceDao;
	
	@Test
	public void getListConfigurations() throws BbvaClientCbdException{
		List<GenericServicesDto> list= serviceDao.getGenericServices("0026008240003009", "MBARRERO");
		for(GenericServicesDto in : list) {
			System.out.println(in.getID_SER() + "  "+ in.getNAME_SER());
		}
	}
	
//	@Test
//	public void getAllServices()throws BbvaClientCbdException{
//		List<GenericServicesDto> resp= serviceDao.getAllServices();
//		for(GenericServicesDto in:resp) {
//			System.out.println(resp);
//		}
//	}
	
}
