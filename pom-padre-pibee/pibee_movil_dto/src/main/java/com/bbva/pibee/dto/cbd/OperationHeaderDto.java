package com.bbva.pibee.dto.cbd;

import java.util.Date;

import com.bbva.pibee.arq.annotations.Column;

public class OperationHeaderDto 
{
	//Campos de la tabla TTLBHCAB.
	
	@Column(name="COD_CLIECASH")
	private  String COD_CLIECASH; 
	
	@Column(name="COD_CLASEORD")
	private String COD_CLASEORD; 		
	
	@Column(name="COD_IDORDEN")
	private String COD_IDORDEN;
	
	@Column(name="COD_CDNIFTR")
	private String COD_CDNIFTR;
	
	@Column(name="COD_SUFPRESE")
	private String COD_SUFPRESE;
	
	@Column(name="COD_DIISOALF")
	private String COD_DIISOALF;
	
	@Column(name="FEC_PROCESCA")
	private String FEC_PROCESCA;
	
	@Column(name="DES_REFICHER")
	private String DES_REFICHER;
	
	@Column(name="DES_NOMFICH")
	private String DES_NOMFICH;
	
	@Column(name="XSN_MEDCREAC")
	private String XSN_MEDCREAC;
	
	@Column(name="XSN_MODCREAC")
	private String XSN_MODCREAC;
	
	@Column(name="FEC_BORRCASH")
	private String FEC_BORRCASH;
	
	@Column(name="FEC_ESTACASH")
	private String FEC_ESTACASH;
	
	@Column(name="XSN_ACTAUTDE")
	private String XSN_ACTAUTDE;
	
	@Column(name="QTY_TOTIMPOR")
	private double QTY_TOTIMPOR;
	
	@Column(name="QNU_TOTREGIS")
	private int QNU_TOTREGIS;
	
	@Column(name="XSN_FORMPAGO")
	private String XSN_FORMPAGO;
	
	@Column(name="COD_ESTACASH")
	private String COD_ESTACASH;
	
	@Column(name="QNU_PESOFIR")
	private double QNU_PESOFIR;
	
	@Column(name="QNU_SIZE")
	private long QNU_SIZE;
	
	@Column(name="DES_NOMFICHE")
	private String DES_NOMFICHE;
	
	@Column(name="QNU_NUMITEM")
	private long QNU_NUMITEM;
	
	@Column(name="DES_PATH")
	private String DES_PATH;
	
	@Column(name="DES_FICHEROH")
	private String DES_FICHEROH;
	
	@Column(name="AUD_FMODIFIC")
	private Date AUD_FMODIFIC;
	
	@Column(name="AUD_USUARIO")
	private String AUD_USUARIO;
	
	@Column(name="COD_DETSEROR")
	private String COD_DETSEROR;
	
	@Column(name="XTI_DETSEROR")
	private String XTI_DETSEROR;
	
	@Column(name="COD_PRODCART")
	private String COD_PRODCART;
	
	@Column(name="XSN_SUCURSAL")
	private String XSN_SUCURSAL;
	
	@Column(name="DES_PATHXML")
	private String DES_PATHXML;
	
	@Column(name="DES_PATHHTML")
	private String DES_PATHHTML;
	
	@Column(name="DES_FXMLHTML")
	private String DES_FXMLHTML;
	
	@Column(name="XTI_VALPERT")
	private String XTI_VALPERT;
	
	@Column(name="COD_LTIPO")
	private String COD_LTIPO;
	
	@Column(name="DES_LDESC")
	private String DES_LDESC;
	
	@Column(name="XSN_BORRADO")
	private String XSN_BORRADO;
	
	@Column(name="QTY_IMPFINA")
	private double QTY_IMPFINA;
	
	@Column(name="QNU_NUMREME")
	private double QNU_NUMREME;
	
	@Column(name="TIM_ORDEN")
	private String TIM_ORDEN;

	public String getCOD_CLIECASH() {
		return COD_CLIECASH;
	}

	public void setCOD_CLIECASH(String cOD_CLIECASH) {
		COD_CLIECASH = cOD_CLIECASH;
	}

	public String getCOD_CLASEORD() {
		return COD_CLASEORD;
	}

	public void setCOD_CLASEORD(String cOD_CLASEORD) {
		COD_CLASEORD = cOD_CLASEORD;
	}

	public String getCOD_IDORDEN() {
		return COD_IDORDEN;
	}

	public void setCOD_IDORDEN(String cOD_IDORDEN) {
		COD_IDORDEN = cOD_IDORDEN;
	}

	public String getCOD_CDNIFTR() {
		return COD_CDNIFTR;
	}

	public void setCOD_CDNIFTR(String cOD_CDNIFTR) {
		COD_CDNIFTR = cOD_CDNIFTR;
	}

	public String getCOD_SUFPRESE() {
		return COD_SUFPRESE;
	}

	public void setCOD_SUFPRESE(String cOD_SUFPRESE) {
		COD_SUFPRESE = cOD_SUFPRESE;
	}

	public String getCOD_DIISOALF() {
		return COD_DIISOALF;
	}

	public void setCOD_DIISOALF(String cOD_DIISOALF) {
		COD_DIISOALF = cOD_DIISOALF;
	}

	public String getFEC_PROCESCA() {
		return FEC_PROCESCA;
	}

	public void setFEC_PROCESCA(String fEC_PROCESCA) {
		FEC_PROCESCA = fEC_PROCESCA;
	}

	public String getDES_REFICHER() {
		return DES_REFICHER;
	}

	public void setDES_REFICHER(String dES_REFICHER) {
		DES_REFICHER = dES_REFICHER;
	}

	public String getDES_NOMFICH() {
		return DES_NOMFICH;
	}

	public void setDES_NOMFICH(String dES_NOMFICH) {
		DES_NOMFICH = dES_NOMFICH;
	}

	public String getXSN_MEDCREAC() {
		return XSN_MEDCREAC;
	}

	public void setXSN_MEDCREAC(String xSN_MEDCREAC) {
		XSN_MEDCREAC = xSN_MEDCREAC;
	}

	public String getXSN_MODCREAC() {
		return XSN_MODCREAC;
	}

	public void setXSN_MODCREAC(String xSN_MODCREAC) {
		XSN_MODCREAC = xSN_MODCREAC;
	}

	public String getFEC_BORRCASH() {
		return FEC_BORRCASH;
	}

	public void setFEC_BORRCASH(String fEC_BORRCASH) {
		FEC_BORRCASH = fEC_BORRCASH;
	}

	public String getFEC_ESTACASH() {
		return FEC_ESTACASH;
	}

	public void setFEC_ESTACASH(String fEC_ESTACASH) {
		FEC_ESTACASH = fEC_ESTACASH;
	}

	public String getXSN_ACTAUTDE() {
		return XSN_ACTAUTDE;
	}

	public void setXSN_ACTAUTDE(String xSN_ACTAUTDE) {
		XSN_ACTAUTDE = xSN_ACTAUTDE;
	}

	public double getQTY_TOTIMPOR() {
		return QTY_TOTIMPOR;
	}

	public void setQTY_TOTIMPOR(double qTY_TOTIMPOR) {
		QTY_TOTIMPOR = qTY_TOTIMPOR;
	}

	public int getQNU_TOTREGIS() {
		return QNU_TOTREGIS;
	}

	public void setQNU_TOTREGIS(int qNU_TOTREGIS) {
		QNU_TOTREGIS = qNU_TOTREGIS;
	}

	public String getXSN_FORMPAGO() {
		return XSN_FORMPAGO;
	}

	public void setXSN_FORMPAGO(String xSN_FORMPAGO) {
		XSN_FORMPAGO = xSN_FORMPAGO;
	}

	public String getCOD_ESTACASH() {
		return COD_ESTACASH;
	}

	public void setCOD_ESTACASH(String cOD_ESTACASH) {
		COD_ESTACASH = cOD_ESTACASH;
	}

	public double getQNU_PESOFIR() {
		return QNU_PESOFIR;
	}

	public void setQNU_PESOFIR(double qNU_PESOFIR) {
		QNU_PESOFIR = qNU_PESOFIR;
	}

	public long getQNU_SIZE() {
		return QNU_SIZE;
	}

	public void setQNU_SIZE(long qNU_SIZE) {
		QNU_SIZE = qNU_SIZE;
	}

	public String getDES_NOMFICHE() {
		return DES_NOMFICHE;
	}

	public void setDES_NOMFICHE(String dES_NOMFICHE) {
		DES_NOMFICHE = dES_NOMFICHE;
	}

	public long getQNU_NUMITEM() {
		return QNU_NUMITEM;
	}

	public void setQNU_NUMITEM(long qNU_NUMITEM) {
		QNU_NUMITEM = qNU_NUMITEM;
	}

	public String getDES_PATH() {
		return DES_PATH;
	}

	public void setDES_PATH(String dES_PATH) {
		DES_PATH = dES_PATH;
	}

	public String getDES_FICHEROH() {
		return DES_FICHEROH;
	}

	public void setDES_FICHEROH(String dES_FICHEROH) {
		DES_FICHEROH = dES_FICHEROH;
	}

	public Date getAUD_FMODIFIC() {
		return AUD_FMODIFIC;
	}

	public void setAUD_FMODIFIC(Date aUD_FMODIFIC) {
		AUD_FMODIFIC = aUD_FMODIFIC;
	}

	public String getAUD_USUARIO() {
		return AUD_USUARIO;
	}

	public void setAUD_USUARIO(String aUD_USUARIO) {
		AUD_USUARIO = aUD_USUARIO;
	}

	public String getCOD_DETSEROR() {
		return COD_DETSEROR;
	}

	public void setCOD_DETSEROR(String cOD_DETSEROR) {
		COD_DETSEROR = cOD_DETSEROR;
	}

	public String getXTI_DETSEROR() {
		return XTI_DETSEROR;
	}

	public void setXTI_DETSEROR(String xTI_DETSEROR) {
		XTI_DETSEROR = xTI_DETSEROR;
	}

	public String getCOD_PRODCART() {
		return COD_PRODCART;
	}

	public void setCOD_PRODCART(String cOD_PRODCART) {
		COD_PRODCART = cOD_PRODCART;
	}

	public String getXSN_SUCURSAL() {
		return XSN_SUCURSAL;
	}

	public void setXSN_SUCURSAL(String xSN_SUCURSAL) {
		XSN_SUCURSAL = xSN_SUCURSAL;
	}

	public String getDES_PATHXML() {
		return DES_PATHXML;
	}

	public void setDES_PATHXML(String dES_PATHXML) {
		DES_PATHXML = dES_PATHXML;
	}

	public String getDES_PATHHTML() {
		return DES_PATHHTML;
	}

	public void setDES_PATHHTML(String dES_PATHHTML) {
		DES_PATHHTML = dES_PATHHTML;
	}

	public String getDES_FXMLHTML() {
		return DES_FXMLHTML;
	}

	public void setDES_FXMLHTML(String dES_FXMLHTML) {
		DES_FXMLHTML = dES_FXMLHTML;
	}

	public String getXTI_VALPERT() {
		return XTI_VALPERT;
	}

	public void setXTI_VALPERT(String xTI_VALPERT) {
		XTI_VALPERT = xTI_VALPERT;
	}

	public String getCOD_LTIPO() {
		return COD_LTIPO;
	}

	public void setCOD_LTIPO(String cOD_LTIPO) {
		COD_LTIPO = cOD_LTIPO;
	}

	public String getDES_LDESC() {
		return DES_LDESC;
	}

	public void setDES_LDESC(String dES_LDESC) {
		DES_LDESC = dES_LDESC;
	}

	public String getXSN_BORRADO() {
		return XSN_BORRADO;
	}

	public void setXSN_BORRADO(String xSN_BORRADO) {
		XSN_BORRADO = xSN_BORRADO;
	}

	public double getQTY_IMPFINA() {
		return QTY_IMPFINA;
	}

	public void setQTY_IMPFINA(double qTY_IMPFINA) {
		QTY_IMPFINA = qTY_IMPFINA;
	}

	public double getQNU_NUMREME() {
		return QNU_NUMREME;
	}

	public void setQNU_NUMREME(double qNU_NUMREME) {
		QNU_NUMREME = qNU_NUMREME;
	}

	public String getTIM_ORDEN() {
		return TIM_ORDEN;
	}

	public void setTIM_ORDEN(String tIM_ORDEN) {
		TIM_ORDEN = tIM_ORDEN;
	}
	
	
	
	
	
}
