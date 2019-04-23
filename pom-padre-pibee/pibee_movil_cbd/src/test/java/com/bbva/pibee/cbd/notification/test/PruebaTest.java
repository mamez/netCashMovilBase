package com.bbva.pibee.cbd.notification.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.pibee.arq.annotations.ResourceClientBd;
import com.bbva.pibee.config.cbd.DevelopmentNotiProfileConfigCbd;
import com.bbva.pibee.dto.cbd.prueba.TtlnemanDto;
import com.bbva.pibee.pm.cbd.notification.dao.TtlnemanDao;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

@ContextConfiguration(classes=DevelopmentNotiProfileConfigCbd.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev-noti")
public class PruebaTest {

	@ResourceClientBd
	TtlnemanDao  ttlnemanDao;
	
	
	@Test
	public void listar() {
	
		try {
			List<TtlnemanDto> list= ttlnemanDao.getAllTtlneman();
			for(TtlnemanDto in: list) {
				System.out.println(in.getIdOrden());
			}
			
		} catch (BbvaClientCbdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
