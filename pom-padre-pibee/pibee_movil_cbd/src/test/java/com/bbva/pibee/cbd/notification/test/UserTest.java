package com.bbva.pibee.cbd.notification.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.pibee.arq.annotations.ResourceClientBd;
import com.bbva.pibee.config.cbd.DevelopmentNotiProfileConfigCbd;
import com.bbva.pibee.dto.notification.UserDto;
import com.bbva.pibee.pm.cbd.notification.dao.UserDao;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

@ContextConfiguration(classes=DevelopmentNotiProfileConfigCbd.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev-noti")
public class UserTest 
{
	@ResourceClientBd
	UserDao userDao;
	
	String reference = "0026008240003226er";
	String user = "TANIA001";
	String device = "ZGlzcG9zaXRpdm8=123456";
	String token = "dG9rZW4==";
	String platform = "android";
	String version = "1.0";
	String alias = "Samsung J77";
	String state = "Inactivo";
	String modifiDate="2018/06/18";
	String creationDate="2018/05/05";

	

	
	//@Test
	public void createUser(){		
		try {
			UserDto dto = new UserDto();
			dto.setREFERENCE_USU(reference);
			dto.setID_USU(user);
			dto.setDEVICE_USU(device);
			dto.setTOKEN_USU(token);
			dto.setPLATFORM_USU(platform);
			dto.setVERSION_USU(version);
			dto.setMODIFIDATE_USU(modifiDate);
			dto.setSTATE_USU(state);
			userDao.createUser(dto);
		}catch ( BbvaClientCbdException e) {
			System.out.println("Error al insertar "+e.getMessage());
		}
		
	}	     
	
	//@Test
	public void modifiyUser(){	
		try {
		UserDto dto = new UserDto();
		dto.setREFERENCE_USU(reference);
		dto.setID_USU(user);
		dto.setDEVICE_USU(device);
		dto.setTOKEN_USU(token);
		dto.setPLATFORM_USU(platform);
		dto.setVERSION_USU(version);
		dto.setMODIFIDATE_USU(modifiDate);
		dto.setCREATIONDATE_USU(creationDate);
		dto.setSTATE_USU(state);
		userDao.modifyUser(dto);		
		}catch( BbvaClientCbdException e) {
			System.out.println("Error al modificar "+e.getMessage());
		}
	}
	

	
	@Test
	public void getUser() throws BbvaClientCbdException{
		
		UserDto dto=userDao.getUser(reference, user);
		if(dto != null) {
			System.out.println(dto.getREFERENCE_USU()+ "  "+dto.getID_USU()+ "  "+dto.getDEVICE_USU() + "  "+dto.getTOKEN_USU() 
			+ "  "+dto.getPLATFORM_USU()+ "  "+dto.getVERSION_USU()+"  "+dto.getMODIFIDATE_USU()+"  "+dto.getCREATIONDATE_USU()+"  "+dto.getSTATE_USU());
		}else {
			System.out.println("Usuario no existe");
		}
		
	 }
	
}
