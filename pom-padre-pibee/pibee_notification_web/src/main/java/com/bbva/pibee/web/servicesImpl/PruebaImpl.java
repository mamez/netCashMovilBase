package com.bbva.pibee.web.servicesImpl;

import javax.ws.rs.core.Response;

import com.bbva.pibee.arq.container.StatusBBVA;
import com.bbva.pibee.web.dto.notifi.response.Person;
import com.bbva.pibee.web.services.Prueba;

public class PruebaImpl implements Prueba {

	@Override
	public Response getUsuario() {
		Person p= new Person();
		p.setNameUser("juancho");
		return StatusBBVA.Ok.entity(p);
	}

}
