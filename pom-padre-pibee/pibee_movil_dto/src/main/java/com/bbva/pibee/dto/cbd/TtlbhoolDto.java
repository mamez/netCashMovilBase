package com.bbva.pibee.dto.cbd;

import java.util.Date;

import com.bbva.pibee.arq.annotations.Column;

public class TtlbhoolDto {
	
	@Column (name = "QNU_NUMITEM")
	private double QNU_NUMITEM;
	
	@Column (name = "TIM_ORDEN")
	private String TIM_ORDEN;
	
	@Column (name = "QNU_ORDEN")
	private int QNU_ORDEN;
	
	@Column (name = "DES_ORDENOL")
	private String DES_ORDENOL;
	
	@Column (name = "COD_TIPORD")
	private String COD_TIPORD;
	
	@Column (name = "COD_BANCOGBL")
	private int COD_BANCOGBL;
	
	@Column (name = "AUD_FMODIFIC")
	private Date AUD_FMODIFIC;
	
	@Column (name = "AUD_USUARIO")
	private String AUD_USUARIO;
	
	DesOrdenOol orderDetail;

	public double getQNU_NUMITEM() {
		return QNU_NUMITEM;
	}

	public void setQNU_NUMITEM(double qNU_NUMITEM) {
		QNU_NUMITEM = qNU_NUMITEM;
	}

	public String getTIM_ORDEN() {
		return TIM_ORDEN;
	}

	public void setTIM_ORDEN(String tIM_ORDEN) {
		TIM_ORDEN = tIM_ORDEN;
	}

	public int getQNU_ORDEN() {
		return QNU_ORDEN;
	}

	public void setQNU_ORDEN(int qNU_ORDEN) {
		QNU_ORDEN = qNU_ORDEN;
	}

	public String getDES_ORDENOL() {
		return DES_ORDENOL;
	}

	public void setDES_ORDENOL(String dES_ORDENOL) {
		DES_ORDENOL = dES_ORDENOL;
	}

	public String getCOD_TIPORD() {
		return COD_TIPORD;
	}

	public void setCOD_TIPORD(String cOD_TIPORD) {
		COD_TIPORD = cOD_TIPORD;
	}

	public int getCOD_BANCOGBL() {
		return COD_BANCOGBL;
	}

	public void setCOD_BANCOGBL(int cOD_BANCOGBL) {
		COD_BANCOGBL = cOD_BANCOGBL;
	}

	public Date getAUD_FMODIFIC() {
		return AUD_FMODIFIC;
	}

	public void setAUD_FMODIFIC(Date date) {
		AUD_FMODIFIC = date;
	}

	public String getAUD_USUARIO() {
		return AUD_USUARIO;
	}

	public void setAUD_USUARIO(String aUD_USUARIO) {
		AUD_USUARIO = aUD_USUARIO;
	}

	public DesOrdenOol getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(DesOrdenOol orderDetail) {
		this.orderDetail = orderDetail;
	}
}
