package com.bbva.pibee.cbd.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.pibee.arq.annotations.ResourceClientBd;
import com.bbva.pibee.cbd.dao.OperationAuditDao;
import com.bbva.pibee.config.cbd.DevelopmentProfileConfigCbd;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

@ContextConfiguration(classes=DevelopmentProfileConfigCbd.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
public class OperationAuditTest {
	@ResourceClientBd
	private OperationAuditDao operationAuditDao;
	
	String codClieCash = "0026008200143421";
	String codClaseOrd = "PAP";
	String codIdOrden = "1820CAQL";
//	int codAccion = 1;
//	int codIdAccion = 0;
//	String codUsuario = "SEBAS90";
//	String fecAccio = "20150424";
	String codUsuFirma = "C342160I";
//	String codUsuPoder = "S";
//	String codEstadFic = "001";
//	String fecAccion = "09033090";
//	String audUsuario = "CEMUNOZ1";
//	String codIpClient = "172.16.20.116";
	
//	@Test
//	public void insert() throws BbvaClientCbdException{
////		operationAuditDao.insert(codClieCash, codClaseOrd, codIdOrden, codAccion, codIdAccion, codUsuario, codUsuFirma, codUsuPoder, codEstadFic, audUsuario, codIpClient);
//	}
	
	@Test
	public void select() throws BbvaClientCbdException{
		operationAuditDao.getOperationAuditBySignerUser(codClieCash, codClaseOrd, codIdOrden, codUsuFirma);
	}
}
