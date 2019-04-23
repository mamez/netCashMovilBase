package com.bbva.pibee.dto.cbd;

import java.util.Date;

import com.bbva.pibee.arq.annotations.Column;

public class OperationOrderSourceDto {
	
	//CAMPOS DE LA TABLA TTLBHORO
	
	@Column(name="COD_IDORDEN")
	private String COD_IDORDEN;
	
	@Column(name="COD_CLIECASH")
	private String COD_CLIECASH;
	
	@Column(name="COD_CLASEORD")
	private String COD_CLASEORD;
	
	@Column(name="COD_CABECORI")
	private int COD_CABECORI;
	
	@Column(name="COD_CDNITR")
	private String COD_CDNITR;
	
	@Column(name="COD_SUFPRESE")
	private String COD_SUFPRESE;
	
	@Column(name="COD_IDORIGEN")
	private String COD_IDORIGEN;
	
	@Column(name="XTI_DOCIDENT")
	private String XTI_DOCIDENT;
	
	@Column(name="DES_DOCIDENT")
	private String DES_DOCIDENT;
	
	@Column(name="DES_PRSCONT")
	private String DES_PRSCONT;
	
	@Column(name="DES_TFNOCONT")
	private String DES_TFNOCONT;
	
	@Column(name="DES_ORIGEN")
	private String DES_ORIGEN;
	
	@Column(name="DES_DOMIORI1")
	private String DES_DOMIORI1;
	
	@Column(name="DES_DOMIORI2")
	private String DES_DOMIORI2;
	
	@Column(name="DES_DOMIORI3")
	private String DES_DOMIORI3;
	
	@Column(name="DES_LOCALI")
	private String DES_LOCALI;
	
	@Column(name="COD_PROVINCI")
	private int COD_PROVINCI;
	
	@Column(name="COD_CDIPOS")
	private double COD_CDIPOS;
	
	@Column(name="QNU_REFEREN")
	private double QNU_REFEREN;
	
	@Column(name="XSN_REFEREN")
	private String XSN_REFEREN;
	
	@Column(name="DES_REFEROPE")
	private String DES_REFEROPE;
	
	@Column(name="XSN_MODELCON")
	private String XSN_MODELCON;
	
	@Column(name="COD_ALFANUM")
	private String COD_ALFANUM;
	
	@Column(name="COD_REFEREXT")
	private String COD_REFEREXT;
	
	@Column(name="COD_SWIFT")
	private String COD_SWIFT;
	
	@Column(name="COD_NIFORIGN")
	private String COD_NIFORIGN;
	
	@Column(name="XTI_PROVEDOR")
	private String XTI_PROVEDOR;
	
	@Column(name="COD_CTASIGN")
	private String COD_CTASIGN;
	
	@Column(name="COD_OFITOMAD")
	private String COD_OFITOMAD;
	
	@Column(name="COD_FICHERO")
	private String COD_FICHERO;
	
	@Column(name="COD_SOCIEDAD")
	private String COD_SOCIEDAD;
	
	@Column(name="DES_FICHEROH")
	private String DES_FICHEROH;
	
	@Column(name="AUD_FMODIFIC")
	private Date AUD_FMODIFIC;
	
	@Column(name="AUD_USUARIO")
	private String AUD_USUARIO;
	
	@Column(name="XTI_EMISOR")
	private String XTI_EMISOR;
	
	@Column(name="DES_ONOMBRE")
	private String DES_ONOMBRE;
	
	@Column(name="DES_ODIRECC")
	private String DES_ODIRECC;
	
	@Column(name="COD_OCP2")
	private double COD_OCP2;

	public String getCOD_IDORDEN() {
		return COD_IDORDEN;
	}

	public void setCOD_IDORDEN(String cOD_IDORDEN) {
		COD_IDORDEN = cOD_IDORDEN;
	}

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

	public int getCOD_CABECORI() {
		return COD_CABECORI;
	}

	public void setCOD_CABECORI(int cOD_CABECORI) {
		COD_CABECORI = cOD_CABECORI;
	}

	public String getCOD_CDNITR() {
		return COD_CDNITR;
	}

	public void setCOD_CDNITR(String cOD_CDNITR) {
		COD_CDNITR = cOD_CDNITR;
	}

	public String getCOD_SUFPRESE() {
		return COD_SUFPRESE;
	}

	public void setCOD_SUFPRESE(String cOD_SUFPRESE) {
		COD_SUFPRESE = cOD_SUFPRESE;
	}

	public String getCOD_IDORIGEN() {
		return COD_IDORIGEN;
	}

	public void setCOD_IDORIGEN(String cOD_IDORIGEN) {
		COD_IDORIGEN = cOD_IDORIGEN;
	}

	public String getXTI_DOCIDENT() {
		return XTI_DOCIDENT;
	}

	public void setXTI_DOCIDENT(String xTI_DOCIDENT) {
		XTI_DOCIDENT = xTI_DOCIDENT;
	}

	public String getDES_DOCIDENT() {
		return DES_DOCIDENT;
	}

	public void setDES_DOCIDENT(String dES_DOCIDENT) {
		DES_DOCIDENT = dES_DOCIDENT;
	}

	public String getDES_PRSCONT() {
		return DES_PRSCONT;
	}

	public void setDES_PRSCONT(String dES_PRSCONT) {
		DES_PRSCONT = dES_PRSCONT;
	}

	public String getDES_TFNOCONT() {
		return DES_TFNOCONT;
	}

	public void setDES_TFNOCONT(String dES_TFNOCONT) {
		DES_TFNOCONT = dES_TFNOCONT;
	}

	public String getDES_ORIGEN() {
		return DES_ORIGEN;
	}

	public void setDES_ORIGEN(String dES_ORIGEN) {
		DES_ORIGEN = dES_ORIGEN;
	}

	public String getDES_DOMIORI1() {
		return DES_DOMIORI1;
	}

	public void setDES_DOMIORI1(String dES_DOMIORI1) {
		DES_DOMIORI1 = dES_DOMIORI1;
	}

	public String getDES_DOMIORI2() {
		return DES_DOMIORI2;
	}

	public void setDES_DOMIORI2(String dES_DOMIORI2) {
		DES_DOMIORI2 = dES_DOMIORI2;
	}

	public String getDES_DOMIORI3() {
		return DES_DOMIORI3;
	}

	public void setDES_DOMIORI3(String dES_DOMIORI3) {
		DES_DOMIORI3 = dES_DOMIORI3;
	}

	public String getDES_LOCALI() {
		return DES_LOCALI;
	}

	public void setDES_LOCALI(String dES_LOCALI) {
		DES_LOCALI = dES_LOCALI;
	}

	public int getCOD_PROVINCI() {
		return COD_PROVINCI;
	}

	public void setCOD_PROVINCI(int cOD_PROVINCI) {
		COD_PROVINCI = cOD_PROVINCI;
	}

	public double getCOD_CDIPOS() {
		return COD_CDIPOS;
	}

	public void setCOD_CDIPOS(double cOD_CDIPOS) {
		COD_CDIPOS = cOD_CDIPOS;
	}

	public double getQNU_REFEREN() {
		return QNU_REFEREN;
	}

	public void setQNU_REFEREN(double qNU_REFEREN) {
		QNU_REFEREN = qNU_REFEREN;
	}

	public String getXSN_REFEREN() {
		return XSN_REFEREN;
	}

	public void setXSN_REFEREN(String xSN_REFEREN) {
		XSN_REFEREN = xSN_REFEREN;
	}

	public String getDES_REFEROPE() {
		return DES_REFEROPE;
	}

	public void setDES_REFEROPE(String dES_REFEROPE) {
		DES_REFEROPE = dES_REFEROPE;
	}

	public String getXSN_MODELCON() {
		return XSN_MODELCON;
	}

	public void setXSN_MODELCON(String xSN_MODELCON) {
		XSN_MODELCON = xSN_MODELCON;
	}

	public String getCOD_ALFANUM() {
		return COD_ALFANUM;
	}

	public void setCOD_ALFANUM(String cOD_ALFANUM) {
		COD_ALFANUM = cOD_ALFANUM;
	}

	public String getCOD_REFEREXT() {
		return COD_REFEREXT;
	}

	public void setCOD_REFEREXT(String cOD_REFEREXT) {
		COD_REFEREXT = cOD_REFEREXT;
	}

	public String getCOD_SWIFT() {
		return COD_SWIFT;
	}

	public void setCOD_SWIFT(String cOD_SWIFT) {
		COD_SWIFT = cOD_SWIFT;
	}

	public String getCOD_NIFORIGN() {
		return COD_NIFORIGN;
	}

	public void setCOD_NIFORIGN(String cOD_NIFORIGN) {
		COD_NIFORIGN = cOD_NIFORIGN;
	}

	public String getXTI_PROVEDOR() {
		return XTI_PROVEDOR;
	}

	public void setXTI_PROVEDOR(String xTI_PROVEDOR) {
		XTI_PROVEDOR = xTI_PROVEDOR;
	}

	public String getCOD_CTASIGN() {
		return COD_CTASIGN;
	}

	public void setCOD_CTASIGN(String cOD_CTASIGN) {
		COD_CTASIGN = cOD_CTASIGN;
	}

	public String getCOD_OFITOMAD() {
		return COD_OFITOMAD;
	}

	public void setCOD_OFITOMAD(String cOD_OFITOMAD) {
		COD_OFITOMAD = cOD_OFITOMAD;
	}

	public String getCOD_FICHERO() {
		return COD_FICHERO;
	}

	public void setCOD_FICHERO(String cOD_FICHERO) {
		COD_FICHERO = cOD_FICHERO;
	}

	public String getCOD_SOCIEDAD() {
		return COD_SOCIEDAD;
	}

	public void setCOD_SOCIEDAD(String cOD_SOCIEDAD) {
		COD_SOCIEDAD = cOD_SOCIEDAD;
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

	public String getXTI_EMISOR() {
		return XTI_EMISOR;
	}

	public void setXTI_EMISOR(String xTI_EMISOR) {
		XTI_EMISOR = xTI_EMISOR;
	}

	public String getDES_ONOMBRE() {
		return DES_ONOMBRE;
	}

	public void setDES_ONOMBRE(String dES_ONOMBRE) {
		DES_ONOMBRE = dES_ONOMBRE;
	}

	public String getDES_ODIRECC() {
		return DES_ODIRECC;
	}

	public void setDES_ODIRECC(String dES_ODIRECC) {
		DES_ODIRECC = dES_ODIRECC;
	}

	public double getCOD_OCP2() {
		return COD_OCP2;
	}

	public void setCOD_OCP2(double cOD_OCP2) {
		COD_OCP2 = cOD_OCP2;
	}
}
