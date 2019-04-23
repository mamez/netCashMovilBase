package com.bbva.pibee.cbd.notification.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.pibee.arq.annotations.ResourceClientBd;
import com.bbva.pibee.config.cbd.DevelopmentNotiProfileConfigCbd;
import com.bbva.pibee.config.cbd.DevelopmentProfileConfigCbd;
import com.bbva.pibee.dto.notification.NotificationDto;
import com.bbva.pibee.pm.cbd.notification.dao.NotificationDao;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

@ContextConfiguration(classes=DevelopmentNotiProfileConfigCbd.class )
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev-noti")
public class NotificationTest
{
	String codNoti = "3";
	String stateNoti = "Vista";
	String titleNoti = "Noti prueba";
	String descripNoti = "descripcion prueba";
	String idFichero = "";
	String codeTran ="";
	int fkConfi = 3;	
	String date="2018/05/05";
	String usuRefe = "0026008240003009";
	String usuId = "SEBAS90";
	
	@ResourceClientBd
	NotificationDao notificationDao;
	
//	@Test
//	public void getNotification() throws BbvaClientCbdException
//	{		
//		List<NotificationDto> getListNoti = notificationDao.getNotification(usuRefe, usuId);
//		for(NotificationDto in : getListNoti)
//		{
//			NotificationDto dto = getListNoti.get(0);
//			System.out.println(in.getID_NOTI());
//			System.out.println(in.getDATE_NOTI());
//			System.out.println(in.getTITLE_NOTI());
//			System.out.println(in.getDESCRIPTION_NOTI());
//			System.out.println(in.getSTATE_NOTI());
//			System.out.println(in.getCODE_TRAN());
//			System.out.println(in.getFK_CONFIGURATION());
//		}
//	}
	
//	@Test
//	public void insertUser() throws BbvaClientCbdException
//	{
//		notificationDao.insertNotification(codNoti, stateNoti,date,titleNoti, descripNoti,codeTran, fkConfi);
//	}
	
//	@Test
//	public void insertNotification()throws BbvaClientCbdException{		
//			try {
//				NotificationDto n = new NotificationDto();
//
//				n.setID_NOTI(codNoti);
//				n.setDATE_NOTI(date);
//				n.setSTATE_NOTI(stateNoti);
//				n.setTITLE_NOTI(titleNoti);
//				n.setDESCRIPTION_NOTI(descripNoti);
//				n.setCODE_TRAN(codeTran);
//				n.setFK_CONFIGURATION(fkConfi);
//				notificationDao.insertNotification("prueba N", "sajdsdf", "84", 81, "APP");
//
//				
//			} catch( BbvaClientCbdException e) {
//				System.out.println("Error al insertar "+e.getMessage());
//			}
//		}
			
		     
//	@Test
//	public void deleteNotification() throws BbvaClientCbdException
//	{
//		notificationDao.deleteAllNotificationByUser("40003009", "OMARZI");
//	}
	
//	@Test
//	public void deleteNotification() throws BbvaClientCbdException
//	{
//		notificationDao.deleteNotification("3");
//	}	
	
}

