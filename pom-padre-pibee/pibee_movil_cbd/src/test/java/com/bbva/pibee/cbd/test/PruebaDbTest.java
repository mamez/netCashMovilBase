package com.bbva.pibee.cbd.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import com.bbva.pibee.cbd.dao.ListFilesDao;
import com.bbva.pibee.cbd.dao.OperationTypeDao;
import com.bbva.pibee.config.cbd.DevelopmentProfileConfigCbd;
import com.bbva.pibee.context.RequestInterceptor;
import com.bbva.pibee.dto.cbd.OperationDetailDto;

@ContextConfiguration(classes={ConfigContext.class,DevelopmentProfileConfigCbd.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PruebaDbTest extends AbstractTestNGSpringContextTests{
	
	//@Autowired
	//private RequestInterceptor 	requestInterceptor; 
	
      //   @Autowired
      //   private ListFilesDao listar;
         
       //  @Autowired
     	//private OperationTypeDao operationTypeDaoImpl;
	     
	     @Test
	    public void insertar(){
	    	 
	    	// System.out.println(requestInterceptor.getUserId());
	    	 
//	    	 List<OperationDetailDto> user=listar.getListaFicherosPendiente("0026008200100301", Arrays.asList("019","024"));	    	 
//	 		for(OperationDetailDto in : user){
//				System.out.println(in.getNombreFichero()+ " "+
//								   in.getCodCliente()+ " "+
//								   in.getCodEstado()+ " "+
//								   in.getClaseOrden()+ " "+
//								   in.getIdOrden()+ " "+
//								   in.getFechaProceso()+ " "+
//								   in.getNombreFichero()+ " "+
//								   in.getImporte()+ " "+
//								   in.getNumOrdenes()+ " "+
//								   in.getPesoFirma()+ " "+
//								   in.getQnu_numItem()+ " "+
//								   in.getTamanio()+ " "+
//								   in.getDesRefFicher()+ " "+
//								   in.getCodCabeceraOrigen()+ " "+
//								   in.getCuentaOrigen()+ " "+
//								   in.getCodIdOrigen()+ " "+
//								   in.getCodBanco()+ " "+
//								   in.getFechaCreacion()+ " "+
//								   in.getUsuarioCreacion()+ " "+
//								   in.getsFechaModif()+ " "+
//								   in.getsUsuarioModif()+ " "+
//								   in.getMedioCreacion()+ " "+
//								   in.getCodModoCreacion()+ " "+
//								   in.getDesPathXML()+ " "+
//								   in.getDesPathHTML()+ " "+
//								   in.getDesFXmlHtml()+ " "+
//								   in.getNombreFichero2()+ " "+
//								   in.getNombreFicheroP()+ " "+
//								   in.getCodigoSebra()+ " "+
//								   in.getPortafolio()+ " "+
//								   in.getValorComision()+ " "+
//								   in.getCodigoBanco()+ " "+
//								   in.getObservacion()			
//						);
//			}
	    }
	     
		
	     
	     
	     
	    
	    @Test
	    public void Modificar(){
//	    	UsuarioModel user=new UsuarioModel();
//	    	user.setNombre("andrea");
//	    	user.setApellido("perez");
//	    	user.setId(4);
//	    	boolean d=prueba.modificarUsuario(user);
//	    	System.out.println(d);
	    }
}
