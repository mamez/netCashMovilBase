package com.bbva.pibee.cbd.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import com.bbva.pibee.arq.annotations.ResourceClientBd;
import com.bbva.pibee.cbd.dao.OperationPayeesDao;
import com.bbva.pibee.config.cbd.DevelopmentProfileConfigCbd;
import com.bbva.pibee.dto.cbd.TtlbhdesDto;
import com.bbva.pibee.dto.cbd.TtlbhoriDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

@ContextConfiguration(classes=DevelopmentProfileConfigCbd.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("dev")
public class PayeeTest extends AbstractTestNGSpringContextTests 
{
	
	@ResourceClientBd
	OperationPayeesDao payeeDao;
	

//	@Test
//	public void getBeneficiary() throws BbvaClientCbdException
//	{
//		String codClaseord= "TRA";
//		String codClieCash="0026008240003009";
//		TtlbhdesDto ttlbhdesDto = new TtlbhdesDto();	
//		ttlbhdesDto.setCOD_IDORIGEN("AJEAN");
//		ttlbhdesDto.setCOD_IDESTINO("0000000800839760");
//
//		List<TtlbhoriDto> listGetPayees = payeeDao.getPayeeExist("0026008240003009", "TRA","AJEAN");	
//		for(TtlbhoriDto in :listGetPayees)
//		{
//			TtlbhoriDto dto = listGetPayees.get(0);
//			System.out.println(in.getCOD_CLIECASH());
//			System.out.println(in.getCOD_IDORIGEN());
//			System.out.println(in.getCOD_CLASEORD());			
//		}				
//	}
	
//	@Test
//	public void insertPayee() throws BbvaClientCbdException {
//		TtlbhdesDto obj = new TtlbhdesDto(); 
//		obj.setCOD_CLIECASH("0026008240003009");
//		obj.setCOD_CLASEORD("PAP");
//		obj.setCOD_IDORIGEN("PRUEBA");
//		obj.setCOD_IDESTINO("0000014778523690");
//		obj.setDES_DESTINO ("Pruebas cmc 2");
//		obj.setCOD_NIFDESTI("01");
//		obj.setDES_DOMIDES1("Calle 132 por aqui no essss");
//		obj.setDES_DOMIDES2("");
//		obj.setDES_DOMIDES3("");
//		obj.setDES_CPLAZA  ("");
//		obj.setCOD_PROVINCI(0);
//		obj.setCOD_CDIPOS  (0);
//		obj.setXTI_CLASEASU("");
//		obj.setCOD_PAISOALF("");
//		obj.setDES_CUENDEST("123456789987456321");
//		obj.setCOD_BANABA  ("");
//		obj.setDES_OFICIDES("");
//		obj.setCOD_INSTRUC ("");
//		obj.setCOD_BANCSB  (59);
//		obj.setDES_TITULCTA("");
//		obj.setDES_BANCO   ("");
//		obj.setDES_INSTRUCC("");
//		obj.setCOD_SWFIT   ("");
//		obj.setCOD_ESTADIS ("");
//		obj.setCOD_FORMASUN(0);
//		obj.setXTI_DOCIDENT("");
//		obj.setDES_PRSCONT ("");
//		obj.setCOD_TELFPROV("");
//		obj.setCOD_OFICPLAZ(0);
//		obj.setCOD_CDNITR  ("");
//		obj.setCOD_SUFPRESE("");
//		obj.setCOD_ENTREGA ("");
//		obj.setCOD_SUCURENT("");
//		obj.setCOD_COMUNA  ("");
//		obj.setDES_DNOMBER ("");
//		obj.setXTI_DIDEBCOT("");
//		obj.setXTI_DIDEBCOI("");
//		obj.setCOD_BANCINTE("");
//		obj.setDES_DDIRECC ("");
//		obj.setDES_DDIRBCOT("");
//		obj.setCOD_DPAIBCOI("01");
//		obj.setDES_DNOMCO  ("");
//		obj.setDES_DDIRBCOI("");
//		obj.setDES_DCUEBCOI("");
//		obj.setCOD_GASTODES("");
//		obj.setCOD_CDIPOS2 (0);
//		obj.setCOD_PRSCONT ("");
//		obj.setDES_EMAIL   ("");
//		obj.setCOD_FAXPORT ("");
//		obj.setXSN_FORMPAGO("1");
//		obj.setCOD_BANCASH ("");
//		obj.setAUD_FMODIFIC("2018-01-09");
//		obj.setAUD_USUARIO ("SOLE2017");
//				
//		payeeDao.insertDes(obj);		
//	}
}
