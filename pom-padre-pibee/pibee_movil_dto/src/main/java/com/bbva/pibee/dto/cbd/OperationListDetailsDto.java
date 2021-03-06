package com.bbva.pibee.dto.cbd;

import com.bbva.pibee.arq.annotations.Column;

public class OperationListDetailsDto {
	
	//SALIDA LISTA DETALLES
	
	// campos tabla TTLBHDOR
	
	@Column(name="COD_CLIECASH")
	private String COD_CLIECASH;
	
	@Column(name="COD_CLASEORD")
	private String COD_CLASEORD;
	
	@Column(name="COD_IDORDEN")
	private String COD_IDORDEN;

	@Column(name="COD_CABECORI")
	private int COD_CABECORI;
	
	@Column(name="COD_DETALL")
	private int COD_DETALL;
	
	@Column(name="COD_ORIGE")
	private String COD_ORIGE;
	
	@Column(name="IMP_IMPORIVA")
	private double IMP_IMPORIVA;
	
	@Column(name="QTY_DETALLE")
	private double QTY_DETALLE;
	
	@Column(name="COD_DIISOALF")
	private String COD_DIISOALF;
	
	@Column(name="FEC_VALOCASH")
	private String FEC_VALOCASH;
	
	@Column(name="QNU_TIPCAMBI")
	private double QNU_TIPCAMBI;
	
	@Column(name="COD_REFDETAL")
	private String COD_REFDETAL;
	
	@Column(name="COD_REFDOCUM")
	private String COD_REFDOCUM;
	
	@Column(name="XSN_GASTOS")
	private String XSN_GASTOS;
	
	@Column(name="XSN_FORMPAGO")
	private String XSN_FORMPAGO;
	
	@Column(name="FEC_EXPEDICI")
	private String FEC_EXPEDICI;
	
	@Column(name="QNU_NUMPAGOS")
	private String QNU_NUMPAGOS;
	
	@Column(name="FEC_VENCCASH")
	private String FEC_VENCCASH;
	
	@Column(name="COD_DEVOLORD")
	private String COD_DEVOLORD;
	
	@Column(name="DES_MOTIVDEV")
	private String DES_MOTIVDEV;
	
	@Column(name="DES_MOTIVDEL")
	private String DES_MOTIVDEL;
	
	@Column(name="XSN_CONCEPTO")
	private String XSN_CONCEPTO;
	
	@Column(name="FEC_ORIGENOR")
	private String FEC_ORIGENOR;
	
	@Column(name="COD_REFSEGUR")
	private String COD_REFSEGUR;
	
	@Column(name="XTI_INSTRUCC")
	private String XTI_INSTRUCC;
	
	@Column(name="COD_MOTPAGOD")
	private String COD_MOTPAGOD;
	
	@Column(name="COD_REFINTER")
	private String COD_REFINTER;
	
	@Column(name="XTI_PROVEDOR")
	private String XTI_PROVEDOR;
	
	@Column(name="DES_FACTURA")
	private String DES_FACTURA;
	
	@Column(name="COD_FACTURA")
	private String COD_FACTURA;
	
	@Column(name="FEC_FACTURA")
	private String FEC_FACTURA;
	
	@Column(name="DES_FICHEROH")
	private String DES_FICHEROH;
	
	@Column(name="AUD_FMODIFIC")
	private String AUD_FMODIFIC;
	
	@Column(name="AUD_USUARIO")
	private String AUD_USUARIO;
	
	@Column(name="IMP_CUOTTA")
	private double IMP_CUOTTA;
	
	@Column(name="QTY_CUOTA")
	private double QTY_CUOTA;
	
	@Column(name="QTY_PRIMCUOT")
	private double QTY_PRIMCUOT;
	
	@Column(name="XTI_INACELER")
	private String XTI_INACELER;
	
	@Column(name="COD_OFICPLAZ")
	private int COD_OFICPLAZ;
	
	@Column(name="QTY_CONCEPTO")
	private int QTY_CONCEPTO;
	
	@Column(name="COD_LNUMERO")
	private String COD_LNUMERO;
	
	@Column(name="DES_CPTO144")
	private String DES_CPTO144;
	
	// campos tabla TTLBHDEO
	@Column(name="COD_CLIECASH")
	private String COD_CLIECASH_DEO;

	@Column(name="COD_CLASEORD")
	private String COD_CLASEORD_DEO;

	@Column(name="COD_IDORDEN")
	private String COD_IDORDEN_DEO;

	@Column(name="COD_DETALL")
	private int COD_DETALL_DEO;

	@Column(name="COD_CABECORI")
	private int COD_CABECORI_DEO;

	@Column(name="COD_IDORIGEN")
	private String COD_IDORIGEN;

	@Column(name="COD_IDESTINO")
	private String COD_IDESTINO;

	@Column(name="DES_DESTINO")
	private String DES_DESTINO;

	@Column(name="DES_DOMIDES1")
	private String DES_DOMIDES1;

	@Column(name="DES_DOMIDES2")
	private String DES_DOMIDES2;

	@Column(name="DES_DOMIDES3")
	private String DES_DOMIDES3;

	@Column(name="DES_CPLAZA")
	private String DES_CPLAZA;

	@Column(name="COD_FORMASUN")
	private int COD_FORMASUN;

	@Column(name="XTI_CLASEASU")
	private String XTI_CLASEASU;

	@Column(name="DES_CUENDEST")
	private String DES_CUENDEST;

	@Column(name="COD_PROVINCI")
	private int COD_PROVINCI;

	@Column(name="COD_CDIPOS")
	private int COD_CDIPOS;

	@Column(name="XSN_DOMICILI")
	private String XSN_DOMICILI;

	@Column(name="COD_BANCASH")
	private String COD_BANCASH;

	@Column(name="COD_BANCSB")
	private int COD_BANCSB;

	@Column(name="COD_OFICPLAZ")
	private int COD_OFICPLAZ_DEO;

	@Column(name="DES_OFICIDES")
	private String DES_OFICIDES;

	@Column(name="XTI_DOCIDENT")
	private String XTI_DOCIDENT;

	@Column(name="COD_NIFDESTI")
	private String COD_NIFDESTI;

	@Column(name="COD_INSTRUC")
	private String COD_INSTRUC;

	@Column(name="COD_CDNITR")
	private String COD_CDNITR;

	@Column(name="COD_SUFPRESE")
	private String COD_SUFPRESE;

	@Column(name="DES_TITULCTA")
	private String DES_TITULCTA;

	@Column(name="DES_BANCO")
	private String DES_BANCO;

	@Column(name="DES_PRSCONT")
	private String DES_PRSCONT;

	@Column(name="DES_LIBRADO")
	private String DES_LIBRADO;

	@Column(name="COD_SWFIT")
	private String COD_SWFIT;

	@Column(name="COD_BANABA")
	private String COD_BANABA;

	@Column(name="COD_ESTADIS")
	private String COD_ESTADIS;

	@Column(name="COD_PAISESTA")
	private String COD_PAISESTA;

	@Column(name="COD_PAISOALF")
	private String COD_PAISOALF;

	@Column(name="DES_INSTRUCC")
	private String DES_INSTRUCC;

	@Column(name="COD_TIPTAB")
	private int COD_TIPTAB;

	@Column(name="XSN_PAGO")
	private String XSN_PAGO;

	@Column(name="DES_BANCINTE")
	private String DES_BANCINTE;

	@Column(name="DES_DIRBANIN")
	private String DES_DIRBANIN;

	@Column(name="DES_PLABANIN")
	private String DES_PLABANIN;

	@Column(name="COD_TELFPROV")
	private String COD_TELFPROV;

	@Column(name="COD_FAXPORT")
	private String COD_FAXPORT;
	
	@Column(name="XSN_IDENTFIS")
	private String XSN_IDENTFIS;

	@Column(name="COD_CLAFPROV")
	private String COD_CLAFPROV;

	@Column(name="DES_FICHEROH")
	private String DES_FICHEROH_DEO;

	@Column(name="AUD_FMODIFIC")
	private String AUD_FMODIFIC_DEO;

	@Column(name="AUD_USUARIO")
	private String AUD_USUARIO_DEO;

	@Column(name="COD_COMUNA")
	private String COD_COMUNA;

	@Column(name="COD_ENTREGA")
	private String COD_ENTREGA;

	@Column(name="COD_SUCURENT")
	private String COD_SUCURENT;

	@Column(name="DES_EMAIL")
	private String DES_EMAIL;

	@Column(name="COD_PRSCONT")
	private String COD_PRSCONT;

	@Column(name="DES_DNOMBER")
	private String DES_DNOMBER;

	@Column(name="XTI_DIDEBCOT")
	private String XTI_DIDEBCOT;

	@Column(name="XTI_DIDEBCOI")
	private String XTI_DIDEBCOI;

	@Column(name="COD_BANCINTE")
	private String COD_BANCINTE;

	@Column(name="DES_DDIRECC")
	private String DES_DDIRECC;

	@Column(name="DES_DDIRBCOT")
	private String DES_DDIRBCOT;

	@Column(name="COD_DPAIBCOI")
	private String COD_DPAIBCOI;

	@Column(name="DES_DNOMCO")
	private String DES_DNOMCO;

	@Column(name="DES_DDIRBCOI")
	private String DES_DDIRBCOI;

	@Column(name="DES_DCUEBCOI")
	private String DES_DCUEBCOI;

	@Column(name="COD_GASTODES")
	private String COD_GASTODES;

	@Column(name="COD_CDIPOS2")
	private int COD_CDIPOS2;

	@Column(name="FEC_NACIMTIT")
	private String FEC_NACIMTIT;

	@Column(name="XSN_FORMPAGO")
	private String XSN_FORMPAGO_DEO;

	// GET's & SET's

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

	public int getCOD_CABECORI() {
		return COD_CABECORI;
	}

	public void setCOD_CABECORI(int cOD_CABECORI) {
		COD_CABECORI = cOD_CABECORI;
	}

	public int getCOD_DETALL() {
		return COD_DETALL;
	}

	public void setCOD_DETALL(int cOD_DETALL) {
		COD_DETALL = cOD_DETALL;
	}

	public String getCOD_ORIGE() {
		return COD_ORIGE;
	}

	public void setCOD_ORIGE(String cOD_ORIGE) {
		COD_ORIGE = cOD_ORIGE;
	}

	public double getIMP_IMPORIVA() {
		return IMP_IMPORIVA;
	}

	public void setIMP_IMPORIVA(double iMP_IMPORIVA) {
		IMP_IMPORIVA = iMP_IMPORIVA;
	}

	public double getQTY_DETALLE() {
		return QTY_DETALLE;
	}

	public void setQTY_DETALLE(double qTY_DETALLE) {
		QTY_DETALLE = qTY_DETALLE;
	}

	public String getCOD_DIISOALF() {
		return COD_DIISOALF;
	}

	public void setCOD_DIISOALF(String cOD_DIISOALF) {
		COD_DIISOALF = cOD_DIISOALF;
	}

	public String getFEC_VALOCASH() {
		return FEC_VALOCASH;
	}

	public void setFEC_VALOCASH(String fEC_VALOCASH) {
		FEC_VALOCASH = fEC_VALOCASH;
	}

	public double getQNU_TIPCAMBI() {
		return QNU_TIPCAMBI;
	}

	public void setQNU_TIPCAMBI(double qNU_TIPCAMBI) {
		QNU_TIPCAMBI = qNU_TIPCAMBI;
	}

	public String getCOD_REFDETAL() {
		return COD_REFDETAL;
	}

	public void setCOD_REFDETAL(String cOD_REFDETAL) {
		COD_REFDETAL = cOD_REFDETAL;
	}

	public String getCOD_REFDOCUM() {
		return COD_REFDOCUM;
	}

	public void setCOD_REFDOCUM(String cOD_REFDOCUM) {
		COD_REFDOCUM = cOD_REFDOCUM;
	}

	public String getXSN_GASTOS() {
		return XSN_GASTOS;
	}

	public void setXSN_GASTOS(String xSN_GASTOS) {
		XSN_GASTOS = xSN_GASTOS;
	}

	public String getXSN_FORMPAGO() {
		return XSN_FORMPAGO;
	}

	public void setXSN_FORMPAGO(String xSN_FORMPAGO) {
		XSN_FORMPAGO = xSN_FORMPAGO;
	}

	public String getFEC_EXPEDICI() {
		return FEC_EXPEDICI;
	}

	public void setFEC_EXPEDICI(String fEC_EXPEDICI) {
		FEC_EXPEDICI = fEC_EXPEDICI;
	}

	public String getQNU_NUMPAGOS() {
		return QNU_NUMPAGOS;
	}

	public void setQNU_NUMPAGOS(String qNU_NUMPAGOS) {
		QNU_NUMPAGOS = qNU_NUMPAGOS;
	}

	public String getFEC_VENCCASH() {
		return FEC_VENCCASH;
	}

	public void setFEC_VENCCASH(String fEC_VENCCASH) {
		FEC_VENCCASH = fEC_VENCCASH;
	}

	public String getCOD_DEVOLORD() {
		return COD_DEVOLORD;
	}

	public void setCOD_DEVOLORD(String cOD_DEVOLORD) {
		COD_DEVOLORD = cOD_DEVOLORD;
	}

	public String getDES_MOTIVDEV() {
		return DES_MOTIVDEV;
	}

	public void setDES_MOTIVDEV(String dES_MOTIVDEV) {
		DES_MOTIVDEV = dES_MOTIVDEV;
	}

	public String getDES_MOTIVDEL() {
		return DES_MOTIVDEL;
	}

	public void setDES_MOTIVDEL(String dES_MOTIVDEL) {
		DES_MOTIVDEL = dES_MOTIVDEL;
	}

	public String getXSN_CONCEPTO() {
		return XSN_CONCEPTO;
	}

	public void setXSN_CONCEPTO(String xSN_CONCEPTO) {
		XSN_CONCEPTO = xSN_CONCEPTO;
	}

	public String getFEC_ORIGENOR() {
		return FEC_ORIGENOR;
	}

	public void setFEC_ORIGENOR(String fEC_ORIGENOR) {
		FEC_ORIGENOR = fEC_ORIGENOR;
	}

	public String getCOD_REFSEGUR() {
		return COD_REFSEGUR;
	}

	public void setCOD_REFSEGUR(String cOD_REFSEGUR) {
		COD_REFSEGUR = cOD_REFSEGUR;
	}

	public String getXTI_INSTRUCC() {
		return XTI_INSTRUCC;
	}

	public void setXTI_INSTRUCC(String xTI_INSTRUCC) {
		XTI_INSTRUCC = xTI_INSTRUCC;
	}

	public String getCOD_MOTPAGOD() {
		return COD_MOTPAGOD;
	}

	public void setCOD_MOTPAGOD(String cOD_MOTPAGOD) {
		COD_MOTPAGOD = cOD_MOTPAGOD;
	}

	public String getCOD_REFINTER() {
		return COD_REFINTER;
	}

	public void setCOD_REFINTER(String cOD_REFINTER) {
		COD_REFINTER = cOD_REFINTER;
	}

	public String getXTI_PROVEDOR() {
		return XTI_PROVEDOR;
	}

	public void setXTI_PROVEDOR(String xTI_PROVEDOR) {
		XTI_PROVEDOR = xTI_PROVEDOR;
	}

	public String getDES_FACTURA() {
		return DES_FACTURA;
	}

	public void setDES_FACTURA(String dES_FACTURA) {
		DES_FACTURA = dES_FACTURA;
	}

	public String getCOD_FACTURA() {
		return COD_FACTURA;
	}

	public void setCOD_FACTURA(String cOD_FACTURA) {
		COD_FACTURA = cOD_FACTURA;
	}

	public String getFEC_FACTURA() {
		return FEC_FACTURA;
	}

	public void setFEC_FACTURA(String fEC_FACTURA) {
		FEC_FACTURA = fEC_FACTURA;
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

	public double getIMP_CUOTTA() {
		return IMP_CUOTTA;
	}

	public void setIMP_CUOTTA(double iMP_CUOTTA) {
		IMP_CUOTTA = iMP_CUOTTA;
	}

	public double getQTY_CUOTA() {
		return QTY_CUOTA;
	}

	public void setQTY_CUOTA(double qTY_CUOTA) {
		QTY_CUOTA = qTY_CUOTA;
	}

	public double getQTY_PRIMCUOT() {
		return QTY_PRIMCUOT;
	}

	public void setQTY_PRIMCUOT(double qTY_PRIMCUOT) {
		QTY_PRIMCUOT = qTY_PRIMCUOT;
	}

	public String getXTI_INACELER() {
		return XTI_INACELER;
	}

	public void setXTI_INACELER(String xTI_INACELER) {
		XTI_INACELER = xTI_INACELER;
	}

	public int getCOD_OFICPLAZ() {
		return COD_OFICPLAZ;
	}

	public void setCOD_OFICPLAZ(int cOD_OFICPLAZ) {
		COD_OFICPLAZ = cOD_OFICPLAZ;
	}

	public int getQTY_CONCEPTO() {
		return QTY_CONCEPTO;
	}

	public void setQTY_CONCEPTO(int qTY_CONCEPTO) {
		QTY_CONCEPTO = qTY_CONCEPTO;
	}

	public String getCOD_LNUMERO() {
		return COD_LNUMERO;
	}

	public void setCOD_LNUMERO(String cOD_LNUMERO) {
		COD_LNUMERO = cOD_LNUMERO;
	}

	public String getDES_CPTO144() {
		return DES_CPTO144;
	}

	public void setDES_CPTO144(String dES_CPTO144) {
		DES_CPTO144 = dES_CPTO144;
	}

	public String getCOD_CLIECASH_DEO() {
		return COD_CLIECASH_DEO;
	}

	public void setCOD_CLIECASH_DEO(String cOD_CLIECASH_DEO) {
		COD_CLIECASH_DEO = cOD_CLIECASH_DEO;
	}

	public String getCOD_CLASEORD_DEO() {
		return COD_CLASEORD_DEO;
	}

	public void setCOD_CLASEORD_DEO(String cOD_CLASEORD_DEO) {
		COD_CLASEORD_DEO = cOD_CLASEORD_DEO;
	}

	public String getCOD_IDORDEN_DEO() {
		return COD_IDORDEN_DEO;
	}

	public void setCOD_IDORDEN_DEO(String cOD_IDORDEN_DEO) {
		COD_IDORDEN_DEO = cOD_IDORDEN_DEO;
	}

	public int getCOD_DETALL_DEO() {
		return COD_DETALL_DEO;
	}

	public void setCOD_DETALL_DEO(int cOD_DETALL_DEO) {
		COD_DETALL_DEO = cOD_DETALL_DEO;
	}

	public int getCOD_CABECORI_DEO() {
		return COD_CABECORI_DEO;
	}

	public void setCOD_CABECORI_DEO(int cOD_CABECORI_DEO) {
		COD_CABECORI_DEO = cOD_CABECORI_DEO;
	}

	public String getCOD_IDORIGEN() {
		return COD_IDORIGEN;
	}

	public void setCOD_IDORIGEN(String cOD_IDORIGEN) {
		COD_IDORIGEN = cOD_IDORIGEN;
	}

	public String getCOD_IDESTINO() {
		return COD_IDESTINO;
	}

	public void setCOD_IDESTINO(String cOD_IDESTINO) {
		COD_IDESTINO = cOD_IDESTINO;
	}

	public String getDES_DESTINO() {
		return DES_DESTINO;
	}

	public void setDES_DESTINO(String dES_DESTINO) {
		DES_DESTINO = dES_DESTINO;
	}

	public String getDES_DOMIDES1() {
		return DES_DOMIDES1;
	}

	public void setDES_DOMIDES1(String dES_DOMIDES1) {
		DES_DOMIDES1 = dES_DOMIDES1;
	}

	public String getDES_DOMIDES2() {
		return DES_DOMIDES2;
	}

	public void setDES_DOMIDES2(String dES_DOMIDES2) {
		DES_DOMIDES2 = dES_DOMIDES2;
	}

	public String getDES_DOMIDES3() {
		return DES_DOMIDES3;
	}

	public void setDES_DOMIDES3(String dES_DOMIDES3) {
		DES_DOMIDES3 = dES_DOMIDES3;
	}

	public String getDES_CPLAZA() {
		return DES_CPLAZA;
	}

	public void setDES_CPLAZA(String dES_CPLAZA) {
		DES_CPLAZA = dES_CPLAZA;
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

	public String getDES_CUENDEST() {
		return DES_CUENDEST;
	}

	public void setDES_CUENDEST(String dES_CUENDEST) {
		DES_CUENDEST = dES_CUENDEST;
	}

	public int getCOD_PROVINCI() {
		return COD_PROVINCI;
	}

	public void setCOD_PROVINCI(int cOD_PROVINCI) {
		COD_PROVINCI = cOD_PROVINCI;
	}

	public int getCOD_CDIPOS() {
		return COD_CDIPOS;
	}

	public void setCOD_CDIPOS(int cOD_CDIPOS) {
		COD_CDIPOS = cOD_CDIPOS;
	}

	public String getXSN_DOMICILI() {
		return XSN_DOMICILI;
	}

	public void setXSN_DOMICILI(String xSN_DOMICILI) {
		XSN_DOMICILI = xSN_DOMICILI;
	}

	public String getCOD_BANCASH() {
		return COD_BANCASH;
	}

	public void setCOD_BANCASH(String cOD_BANCASH) {
		COD_BANCASH = cOD_BANCASH;
	}

	public int getCOD_BANCSB() {
		return COD_BANCSB;
	}

	public void setCOD_BANCSB(int cOD_BANCSB) {
		COD_BANCSB = cOD_BANCSB;
	}

	public int getCOD_OFICPLAZ_DEO() {
		return COD_OFICPLAZ_DEO;
	}

	public void setCOD_OFICPLAZ_DEO(int cOD_OFICPLAZ_DEO) {
		COD_OFICPLAZ_DEO = cOD_OFICPLAZ_DEO;
	}

	public String getDES_OFICIDES() {
		return DES_OFICIDES;
	}

	public void setDES_OFICIDES(String dES_OFICIDES) {
		DES_OFICIDES = dES_OFICIDES;
	}

	public String getXTI_DOCIDENT() {
		return XTI_DOCIDENT;
	}

	public void setXTI_DOCIDENT(String xTI_DOCIDENT) {
		XTI_DOCIDENT = xTI_DOCIDENT;
	}

	public String getCOD_NIFDESTI() {
		return COD_NIFDESTI;
	}

	public void setCOD_NIFDESTI(String cOD_NIFDESTI) {
		COD_NIFDESTI = cOD_NIFDESTI;
	}

	public String getCOD_INSTRUC() {
		return COD_INSTRUC;
	}

	public void setCOD_INSTRUC(String cOD_INSTRUC) {
		COD_INSTRUC = cOD_INSTRUC;
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

	public String getDES_TITULCTA() {
		return DES_TITULCTA;
	}

	public void setDES_TITULCTA(String dES_TITULCTA) {
		DES_TITULCTA = dES_TITULCTA;
	}

	public String getDES_BANCO() {
		return DES_BANCO;
	}

	public void setDES_BANCO(String dES_BANCO) {
		DES_BANCO = dES_BANCO;
	}

	public String getDES_PRSCONT() {
		return DES_PRSCONT;
	}

	public void setDES_PRSCONT(String dES_PRSCONT) {
		DES_PRSCONT = dES_PRSCONT;
	}

	public String getDES_LIBRADO() {
		return DES_LIBRADO;
	}

	public void setDES_LIBRADO(String dES_LIBRADO) {
		DES_LIBRADO = dES_LIBRADO;
	}

	public String getCOD_SWFIT() {
		return COD_SWFIT;
	}

	public void setCOD_SWFIT(String cOD_SWFIT) {
		COD_SWFIT = cOD_SWFIT;
	}

	public String getCOD_BANABA() {
		return COD_BANABA;
	}

	public void setCOD_BANABA(String cOD_BANABA) {
		COD_BANABA = cOD_BANABA;
	}

	public String getCOD_ESTADIS() {
		return COD_ESTADIS;
	}

	public void setCOD_ESTADIS(String cOD_ESTADIS) {
		COD_ESTADIS = cOD_ESTADIS;
	}

	public String getCOD_PAISESTA() {
		return COD_PAISESTA;
	}

	public void setCOD_PAISESTA(String cOD_PAISESTA) {
		COD_PAISESTA = cOD_PAISESTA;
	}

	public String getCOD_PAISOALF() {
		return COD_PAISOALF;
	}

	public void setCOD_PAISOALF(String cOD_PAISOALF) {
		COD_PAISOALF = cOD_PAISOALF;
	}

	public String getDES_INSTRUCC() {
		return DES_INSTRUCC;
	}

	public void setDES_INSTRUCC(String dES_INSTRUCC) {
		DES_INSTRUCC = dES_INSTRUCC;
	}

	public int getCOD_TIPTAB() {
		return COD_TIPTAB;
	}

	public void setCOD_TIPTAB(int cOD_TIPTAB) {
		COD_TIPTAB = cOD_TIPTAB;
	}

	public String getXSN_PAGO() {
		return XSN_PAGO;
	}

	public void setXSN_PAGO(String xSN_PAGO) {
		XSN_PAGO = xSN_PAGO;
	}

	public String getDES_BANCINTE() {
		return DES_BANCINTE;
	}

	public void setDES_BANCINTE(String dES_BANCINTE) {
		DES_BANCINTE = dES_BANCINTE;
	}

	public String getDES_DIRBANIN() {
		return DES_DIRBANIN;
	}

	public void setDES_DIRBANIN(String dES_DIRBANIN) {
		DES_DIRBANIN = dES_DIRBANIN;
	}

	public String getDES_PLABANIN() {
		return DES_PLABANIN;
	}

	public void setDES_PLABANIN(String dES_PLABANIN) {
		DES_PLABANIN = dES_PLABANIN;
	}

	public String getCOD_TELFPROV() {
		return COD_TELFPROV;
	}

	public void setCOD_TELFPROV(String cOD_TELFPROV) {
		COD_TELFPROV = cOD_TELFPROV;
	}

	public String getCOD_FAXPORT() {
		return COD_FAXPORT;
	}

	public void setCOD_FAXPORT(String cOD_FAXPORT) {
		COD_FAXPORT = cOD_FAXPORT;
	}

	public String getXSN_IDENTFIS() {
		return XSN_IDENTFIS;
	}

	public void setXSN_IDENTFIS(String xSN_IDENTFIS) {
		XSN_IDENTFIS = xSN_IDENTFIS;
	}

	public String getCOD_CLAFPROV() {
		return COD_CLAFPROV;
	}

	public void setCOD_CLAFPROV(String cOD_CLAFPROV) {
		COD_CLAFPROV = cOD_CLAFPROV;
	}

	public String getDES_FICHEROH_DEO() {
		return DES_FICHEROH_DEO;
	}

	public void setDES_FICHEROH_DEO(String dES_FICHEROH_DEO) {
		DES_FICHEROH_DEO = dES_FICHEROH_DEO;
	}

	public String getAUD_FMODIFIC_DEO() {
		return AUD_FMODIFIC_DEO;
	}

	public void setAUD_FMODIFIC_DEO(String aUD_FMODIFIC_DEO) {
		AUD_FMODIFIC_DEO = aUD_FMODIFIC_DEO;
	}

	public String getAUD_USUARIO_DEO() {
		return AUD_USUARIO_DEO;
	}

	public void setAUD_USUARIO_DEO(String aUD_USUARIO_DEO) {
		AUD_USUARIO_DEO = aUD_USUARIO_DEO;
	}

	public String getCOD_COMUNA() {
		return COD_COMUNA;
	}

	public void setCOD_COMUNA(String cOD_COMUNA) {
		COD_COMUNA = cOD_COMUNA;
	}

	public String getCOD_ENTREGA() {
		return COD_ENTREGA;
	}

	public void setCOD_ENTREGA(String cOD_ENTREGA) {
		COD_ENTREGA = cOD_ENTREGA;
	}

	public String getCOD_SUCURENT() {
		return COD_SUCURENT;
	}

	public void setCOD_SUCURENT(String cOD_SUCURENT) {
		COD_SUCURENT = cOD_SUCURENT;
	}

	public String getDES_EMAIL() {
		return DES_EMAIL;
	}

	public void setDES_EMAIL(String dES_EMAIL) {
		DES_EMAIL = dES_EMAIL;
	}

	public String getCOD_PRSCONT() {
		return COD_PRSCONT;
	}

	public void setCOD_PRSCONT(String cOD_PRSCONT) {
		COD_PRSCONT = cOD_PRSCONT;
	}

	public String getDES_DNOMBER() {
		return DES_DNOMBER;
	}

	public void setDES_DNOMBER(String dES_DNOMBER) {
		DES_DNOMBER = dES_DNOMBER;
	}

	public String getXTI_DIDEBCOT() {
		return XTI_DIDEBCOT;
	}

	public void setXTI_DIDEBCOT(String xTI_DIDEBCOT) {
		XTI_DIDEBCOT = xTI_DIDEBCOT;
	}

	public String getXTI_DIDEBCOI() {
		return XTI_DIDEBCOI;
	}

	public void setXTI_DIDEBCOI(String xTI_DIDEBCOI) {
		XTI_DIDEBCOI = xTI_DIDEBCOI;
	}

	public String getCOD_BANCINTE() {
		return COD_BANCINTE;
	}

	public void setCOD_BANCINTE(String cOD_BANCINTE) {
		COD_BANCINTE = cOD_BANCINTE;
	}

	public String getDES_DDIRECC() {
		return DES_DDIRECC;
	}

	public void setDES_DDIRECC(String dES_DDIRECC) {
		DES_DDIRECC = dES_DDIRECC;
	}

	public String getDES_DDIRBCOT() {
		return DES_DDIRBCOT;
	}

	public void setDES_DDIRBCOT(String dES_DDIRBCOT) {
		DES_DDIRBCOT = dES_DDIRBCOT;
	}

	public String getCOD_DPAIBCOI() {
		return COD_DPAIBCOI;
	}

	public void setCOD_DPAIBCOI(String cOD_DPAIBCOI) {
		COD_DPAIBCOI = cOD_DPAIBCOI;
	}

	public String getDES_DNOMCO() {
		return DES_DNOMCO;
	}

	public void setDES_DNOMCO(String dES_DNOMCO) {
		DES_DNOMCO = dES_DNOMCO;
	}

	public String getDES_DDIRBCOI() {
		return DES_DDIRBCOI;
	}

	public void setDES_DDIRBCOI(String dES_DDIRBCOI) {
		DES_DDIRBCOI = dES_DDIRBCOI;
	}

	public String getDES_DCUEBCOI() {
		return DES_DCUEBCOI;
	}

	public void setDES_DCUEBCOI(String dES_DCUEBCOI) {
		DES_DCUEBCOI = dES_DCUEBCOI;
	}

	public String getCOD_GASTODES() {
		return COD_GASTODES;
	}

	public void setCOD_GASTODES(String cOD_GASTODES) {
		COD_GASTODES = cOD_GASTODES;
	}

	public int getCOD_CDIPOS2() {
		return COD_CDIPOS2;
	}

	public void setCOD_CDIPOS2(int cOD_CDIPOS2) {
		COD_CDIPOS2 = cOD_CDIPOS2;
	}

	public String getFEC_NACIMTIT() {
		return FEC_NACIMTIT;
	}

	public void setFEC_NACIMTIT(String fEC_NACIMTIT) {
		FEC_NACIMTIT = fEC_NACIMTIT;
	}

	public String getXSN_FORMPAGO_DEO() {
		return XSN_FORMPAGO_DEO;
	}

	public void setXSN_FORMPAGO_DEO(String xSN_FORMPAGO_DEO) {
		XSN_FORMPAGO_DEO = xSN_FORMPAGO_DEO;
	}
}
