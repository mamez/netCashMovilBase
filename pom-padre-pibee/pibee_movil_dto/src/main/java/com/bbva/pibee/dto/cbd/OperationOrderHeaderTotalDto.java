package com.bbva.pibee.dto.cbd;

import com.bbva.pibee.arq.annotations.Column;

public class OperationOrderHeaderTotalDto {
	
	//TABLA TTLBHCAB
	@Column(name="COD_CLIECASH")
	private String COD_CLIECASH;
	
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
	private double QNU_SIZE;
	
	@Column(name="DES_NOMFICHE")
	private String DES_NOMFICHE;
	
	@Column(name="QNU_NUMITEM")
	private double QNU_NUMITEM;
	
	@Column(name="DES_PATH")
	private String DES_PATH;
	
	@Column(name="DES_FICHEROH")
	private String DES_FICHEROH;
	
	@Column(name="AUD_FMODIFIC")
	private String AUD_FMODIFIC;
	
	@Column(name="AUD_USUARIO")
	private String AUD_USUARIO;
	
	@Column(name="COD_DETSEROR")
	private String COD_DETSEROR;
	
	@Column(name="COD_PRODCART")
	private String COD_PRODCART;
	
	@Column(name="XTI_DETSEROR")
	private String XTI_DETSEROR;
	
	@Column(name="XSN_SUCURSAL")
	private String XSN_SUCURSAL;

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
	private Long QNU_NUMREME;
	
	//TABLA TTLBHCOR
	@Column(name="COD_CABECORI")
	private int COD_CABECORI;
	
	@Column(name="COD_CDNITR")
	private String COD_CDNITR;
	
	@Column(name="COD_SUFPRESE")
	private String COD_SUFPRESE_COR;
	
	@Column(name="COD_IDORIGEN")
	private String COD_IDORIGEN_COR;
	
	@Column(name="DES_CUENORIG")
	private String DES_CUENORIG;
	
	@Column(name="COD_BANCINTE")
	private String COD_BANCINTE;
	
	@Column(name="COD_BANCSB")
	private int COD_BANCSB;
	
	@Column(name="COD_DIISOALF")
	private String COD_DIISOALF_COR;
	
	@Column(name="COD_FORMASUN")
	private int COD_FORMASUN;
	
	@Column(name="XTI_CLASEASU")
	private String XTI_CLASEASU;
	
	@Column(name="COD_SWIFT")
	private String COD_SWIFT;
	
	@Column(name="COD_BANABA")
	private String COD_BANABA;
	
	//TABLA TTLBHORO
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
	
	@Column(name="COD_PROVINCI")
	private int COD_PROVINCI;
	
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
	
	@Column(name="COD_CDIPOS")
	private long COD_CDIPOS;
	
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

	@Column(name="DES_ONOMBRE")
	private String DES_ONOMBRE;
	
	@Column(name="DES_ODIRECC")
	private String DES_ODIRECC;
	
	@Column(name="COD_OCP2")
	private long COD_OCP2;
	
	@Column(name="XTI_EMISOR")
	private String XTI_EMISOR;
	
	@Column(name="DES_ORDPAGO")
	private String DES_ORDPAGO;

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

	public double getQNU_SIZE() {
		return QNU_SIZE;
	}

	public void setQNU_SIZE(double qNU_SIZE) {
		QNU_SIZE = qNU_SIZE;
	}

	public String getDES_NOMFICHE() {
		return DES_NOMFICHE;
	}

	public void setDES_NOMFICHE(String dES_NOMFICHE) {
		DES_NOMFICHE = dES_NOMFICHE;
	}

	public double getQNU_NUMITEM() {
		return QNU_NUMITEM;
	}

	public void setQNU_NUMITEM(double qNU_NUMITEM) {
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

	public String getAUD_FMODIFIC() {
		return AUD_FMODIFIC;
	}

	public void setAUD_FMODIFIC(String aUD_FMODIFIC) {
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

	public String getCOD_PRODCART() {
		return COD_PRODCART;
	}

	public void setCOD_PRODCART(String cOD_PRODCART) {
		COD_PRODCART = cOD_PRODCART;
	}

	public String getXTI_DETSEROR() {
		return XTI_DETSEROR;
	}

	public void setXTI_DETSEROR(String xTI_DETSEROR) {
		XTI_DETSEROR = xTI_DETSEROR;
	}

	public String getXSN_SUCURSAL() {
		return XSN_SUCURSAL;
	}

	public void setXSN_SUCURSAL(String xSN_SUCURSAL) {
		XSN_SUCURSAL = xSN_SUCURSAL;
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

	public long getQNU_NUMREME() {
		return QNU_NUMREME;
	}

	public void setQNU_NUMREME(long qNU_NUMREME) {
		QNU_NUMREME = qNU_NUMREME;
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

	public String getCOD_SUFPRESE_COR() {
		return COD_SUFPRESE_COR;
	}

	public void setCOD_SUFPRESE_COR(String cOD_SUFPRESE_COR) {
		COD_SUFPRESE_COR = cOD_SUFPRESE_COR;
	}

	public String getCOD_IDORIGEN_COR() {
		return COD_IDORIGEN_COR;
	}

	public void setCOD_IDORIGEN_COR(String cOD_IDORIGEN_COR) {
		COD_IDORIGEN_COR = cOD_IDORIGEN_COR;
	}

	public String getDES_CUENORIG() {
		return DES_CUENORIG;
	}

	public void setDES_CUENORIG(String dES_CUENORIG) {
		DES_CUENORIG = dES_CUENORIG;
	}

	public String getCOD_BANCINTE() {
		return COD_BANCINTE;
	}

	public void setCOD_BANCINTE(String cOD_BANCINTE) {
		COD_BANCINTE = cOD_BANCINTE;
	}

	public int getCOD_BANCSB() {
		return COD_BANCSB;
	}

	public void setCOD_BANCSB(int cOD_BANCSB) {
		COD_BANCSB = cOD_BANCSB;
	}

	public String getCOD_DIISOALF_COR() {
		return COD_DIISOALF_COR;
	}

	public void setCOD_DIISOALF_COR(String cOD_DIISOALF_COR) {
		COD_DIISOALF_COR = cOD_DIISOALF_COR;
	}

	public int getCOD_FORMASUN() {
		return COD_FORMASUN;
	}

	public void setCOD_FORMASUN(int cOD_FORMASUN) {
		COD_FORMASUN = cOD_FORMASUN;
	}

	public String getXTI_CLASEASU() {
		return XTI_CLASEASU;
	}

	public void setXTI_CLASEASU(String xTI_CLASEASU) {
		XTI_CLASEASU = xTI_CLASEASU;
	}

	public String getCOD_SWIFT() {
		return COD_SWIFT;
	}

	public void setCOD_SWIFT(String cOD_SWIFT) {
		COD_SWIFT = cOD_SWIFT;
	}

	public String getCOD_BANABA() {
		return COD_BANABA;
	}

	public void setCOD_BANABA(String cOD_BANABA) {
		COD_BANABA = cOD_BANABA;
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

	public int getCOD_PROVINCI() {
		return COD_PROVINCI;
	}

	public void setCOD_PROVINCI(int cOD_PROVINCI) {
		COD_PROVINCI = cOD_PROVINCI;
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

	public long getCOD_CDIPOS() {
		return COD_CDIPOS;
	}

	public void setCOD_CDIPOS(long cOD_CDIPOS) {
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

	public long getCOD_OCP2() {
		return COD_OCP2;
	}

	public void setCOD_OCP2(long cOD_OCP2) {
		COD_OCP2 = cOD_OCP2;
	}

	public String getXTI_EMISOR() {
		return XTI_EMISOR;
	}

	public void setXTI_EMISOR(String xTI_EMISOR) {
		XTI_EMISOR = xTI_EMISOR;
	}

	public String getDES_ORDPAGO() {
		return DES_ORDPAGO;
	}

	public void setDES_ORDPAGO(String dES_ORDPAGO) {
		DES_ORDPAGO = dES_ORDPAGO;
	}
	
}
