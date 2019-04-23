package com.bbva.pibee.dto.cbd;

import java.io.Serializable;

public class TlbhcabModel  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String CodCliencash;
	private String CodClaseord;
	private String CodIdorden;
	
	public String getCodCliencash() {
		return CodCliencash;
	}
	public void setCodCliencash(String codCliencash) {
		CodCliencash = codCliencash;
	}
	public String getCodClaseord() {
		return CodClaseord;
	}
	public void setCodClaseord(String codClaseord) {
		CodClaseord = codClaseord;
	}
	public String getCodIdorden() {
		return CodIdorden;
	}
	public void setCodIdorden(String codIdorden) {
		CodIdorden = codIdorden;
	}
}
