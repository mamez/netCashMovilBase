package com.bbva.pibee.cbd.notification.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.pibee.arq.annotations.ResourceClientBd;
import com.bbva.pibee.config.cbd.BncmcoDevelopmentProfileConfig;
import com.bbva.pibee.config.cbd.DevelopmentNotiProfileConfigCbd;
import com.bbva.pibee.config.cbd.DevelopmentProfileConfigCbd;
import com.bbva.pibee.dto.notification.ConfigurationDto;
import com.bbva.pibee.dto.notification.NotificationDto;
import com.bbva.pibee.pm.cbd.notification.dao.ConfigurationDao;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.web.dto.notifi.request.State;

@ContextConfiguration(classes=DevelopmentNotiProfileConfigCbd.class )
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev-noti")
public class ConfigurationTest
{	
	String stateConf = "No Chequeada";
	String refeUser = "40003009";
	String userId = "SEBAS90";
	int fkOpera = 27;
	
	@ResourceClientBd
	ConfigurationDao configurationDao;
	
	@Test
    public void  existConfigByUser() {
		try {
			boolean existe=configurationDao.existConfigByUser(129, "0026008240003226", "LORENABM");
			
			System.out.println("El usuario existe? "+ existe);
			
		} catch (BbvaClientCbdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	
	@Test
	@Ignore
	public void insertConfiguration() throws BbvaClientCbdException
	{
		configurationDao.insertConfiguration(stateConf, refeUser, userId, fkOpera);
	}
	
	//@Test
	public void updateConfiguration() {

		try {		
			configurationDao.updateConfiguration(State.check.toString(),1, "40003009", "SEBAS90");
		} catch (BbvaClientCbdException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void existConfigByOperation() throws BbvaClientCbdException
	{
	  boolean x=	configurationDao.existConfigByOperation(fkOpera, refeUser, userId);
	  System.out.println(x);
	}
	/*@Test
	public void updateConfiguration() throws BbvaClientCbdException
	{
		configurationDao.updateConfiguration(stateConf, codConf);
	}*/
}
