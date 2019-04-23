package com.bbva.pibee.dto.cbd;


import java.sql.Date;

import com.bbva.pibee.arq.annotations.Column;

/**
 * Esta clase contiene los campos necesarios de la unión de las tablas
 * TTLBHCAB y TTLBHCOR. Requerida para los detalles de ficheros en el
 * proceso de Firmas.
 *
 * Creation date: (22/01/2003 18:56:33)
 * @author: Miguel Angel Fernández Valderrama
 */
public class OperationDetailDto   {

	//Campos de la tabla TTLBHCAB que se recuperarán en una select.
	@Column(name="COD_CLIECASH")
	private  String codCliente; 
	
	@Column(name="COD_CLASEORD")
	private String claseOrden; 		
	
	@Column(name="COD_IDORDEN")
	private String idOrden; 
	
	@Column(name="FEC_PROCESCA")
	private String fechaProceso;
	
	@Column(name="DES_NOMFICH")
	private String nombreFichero; 
	
	@Column(name="QTY_TOTIMPOR")
	private String importe; 	
	
	@Column(name="QNU_TOTREGIS")
	private int numOrdenes; 	
	
	@Column(name="COD_ESTACASH")
	private String codEstado; 	
	
	@Column(name="QNU_PESOFIR")
	private double pesoFirma; 	
	
	@Column(name="QNU_NUMITEM")
	private long qnu_numItem; 	
	
	@Column(name="QNU_SIZE")
	private long tamanio;		
	
	@Column(name="DES_REFICHER")
	private String desRefFicher;			 

	//campos de la tabla TTLBHCOR que se recuperarán en la select
	@Column(name="COD_CABECORI")
	private int codCabeceraOrigen;		
	
	@Column(name="DES_CUENORIG")
	private String cuentaOrigen;		
	
	@Column(name="COD_IDORIGEN")
	private String codIdOrigen;		
	
	@Column(name="COD_BANCSB")
	private short codBanco;
	
	@Column(name="COD_DIISOALF")
	private String codDivisa;	

	//campos de la tabla TTLBHFUA que se recuperarán en la select
	@Column(name="FEC_ACCIO")
	private String fechaCreacion;	
	
	@Column(name="COD_USUARIO")
	private String usuarioCreacion;	
	
	@Column(name="AUD_FMODIFIC")
	private Date 	sFechaModif; 	
	
	@Column(name="AUD_USUARIO")
	private String 	sUsuarioModif;	
	

	@Column(name="XSN_MEDCREAC")
	private String medioCreacion;	 
	
	@Column(name="XSN_MODCREAC")
	private String codModoCreacion; 
	
	@Column(name="DES_PATHXML")
	private String desPathXML;	 
	
	@Column(name="DES_PATHHTML")
	private String desPathHTML;	 
	
	@Column(name="DES_FXMLHTML")
	private String desFXmlHtml;	 
	
	@Column(name="DES_NOMFICHE")
	private String nombreFichero2;
	
	@Column(name="DES_FICHEROH")
	private String nombreFicheroP;
	
	@Column(name="COD_SUFPRESE")
	private String codigoSebra; 	 
	
	@Column(name="COD_LTIPO")
	private String portafolio;	 
	
	@Column(name="QTY_IMPFINA")
	private double valorComision;	
	
	@Column(name="COD_PRODCART")
	private String codigoBanco;
	
	@Column(name="DES_PATH")
	private String observacion;
	
	
public OperationDetailDto() {
	
	this.codCliente = ""; 			
	this.claseOrden = "";
	this.idOrden = "";
	this.fechaProceso = "";
	this.nombreFichero = "";
	this.importe = "";
	this.numOrdenes = 0;
	this.codEstado = "";
	this.pesoFirma = 0.00;
	this.qnu_numItem = 0;
	this.tamanio = 0;
	this.desRefFicher ="";

	//campos de la tabla TTLBHCOR que se recuperarán
	this.codCabeceraOrigen = 0;
	this.cuentaOrigen = "";
	this.codIdOrigen = "";					//TTLBHCOR.COD_IDORIGEN
	this.codBanco = 0;
	
//	campos de la tabla TTLBHFUA que se recuperarán
	this.fechaCreacion = "";
	this.usuarioCreacion = "";
	
// campos de auditoria de la tabla TTLBHCAB
	this.sFechaModif = null;			 		//AUD_FMODIFIC
	this.sUsuarioModif = "";					//AUD_USUARIO
	
	this.medioCreacion	= "";
	this.codModoCreacion = "";
	this.desPathXML 		= "";
	this.desPathHTML 	= "";
	this.desFXmlHtml 	= "";
	this.nombreFichero2	= "";
	this.nombreFicheroP	= "";
	
	//	GP12638  SEBRA INICIO
	this.codigoSebra     ="";
	this.portafolio      ="";
	this.valorComision   =0.00;
	this.codigoBanco     ="";
	this.observacion     ="";
	//GP12638  SEBRA FIN
}


public String getCodCliente() {
	return codCliente;
}


public void setCodCliente(String codCliente) {
	this.codCliente = codCliente;
}


public String getClaseOrden() {
	return claseOrden;
}


public void setClaseOrden(String claseOrden) {
	this.claseOrden = claseOrden;
}


public String getIdOrden() {
	return idOrden;
}


public void setIdOrden(String idOrden) {
	this.idOrden = idOrden;
}


public String getFechaProceso() {
	return fechaProceso;
}


public void setFechaProceso(String fechaProceso) {
	this.fechaProceso = fechaProceso;
}


public String getNombreFichero() {
	return nombreFichero;
}


public void setNombreFichero(String nombreFichero) {
	this.nombreFichero = nombreFichero;
}


public String getImporte() {
	return importe;
}


public void setImporte(String importe) {
	this.importe = importe;
}


public int getNumOrdenes() {
	return numOrdenes;
}


public void setNumOrdenes(int numOrdenes) {
	this.numOrdenes = numOrdenes;
}


public String getCodEstado() {
	return codEstado;
}


public void setCodEstado(String codEstado) {
	this.codEstado = codEstado;
}


public double getPesoFirma() {
	return pesoFirma;
}


public void setPesoFirma(double pesoFirma) {
	this.pesoFirma = pesoFirma;
}


public long getQnu_numItem() {
	return qnu_numItem;
}


public void setQnu_numItem(long qnu_numItem) {
	this.qnu_numItem = qnu_numItem;
}


public long getTamanio() {
	return tamanio;
}


public void setTamanio(long tamanio) {
	this.tamanio = tamanio;
}


public String getDesRefFicher() {
	return desRefFicher;
}


public void setDesRefFicher(String desRefFicher) {
	this.desRefFicher = desRefFicher;
}


public int getCodCabeceraOrigen() {
	return codCabeceraOrigen;
}


public void setCodCabeceraOrigen(int codCabeceraOrigen) {
	this.codCabeceraOrigen = codCabeceraOrigen;
}


public String getCuentaOrigen() {
	return cuentaOrigen;
}


public void setCuentaOrigen(String cuentaOrigen) {
	this.cuentaOrigen = cuentaOrigen;
}


public String getCodIdOrigen() {
	return codIdOrigen;
}


public void setCodIdOrigen(String codIdOrigen) {
	this.codIdOrigen = codIdOrigen;
}


public short getCodBanco() {
	return codBanco;
}


public void setCodBanco(short codBanco) {
	this.codBanco = codBanco;
}


public String getFechaCreacion() {
	return fechaCreacion;
}


public void setFechaCreacion(String fechaCreacion) {
	this.fechaCreacion = fechaCreacion;
}


public String getUsuarioCreacion() {
	return usuarioCreacion;
}


public void setUsuarioCreacion(String usuarioCreacion) {
	this.usuarioCreacion = usuarioCreacion;
}


public Date getsFechaModif() {
	return sFechaModif;
}


public void setsFechaModif(Date sFechaModif) {
	this.sFechaModif = sFechaModif;
}


public String getsUsuarioModif() {
	return sUsuarioModif;
}


public void setsUsuarioModif(String sUsuarioModif) {
	this.sUsuarioModif = sUsuarioModif;
}


public String getMedioCreacion() {
	return medioCreacion;
}


public void setMedioCreacion(String medioCreacion) {
	this.medioCreacion = medioCreacion;
}


public String getCodModoCreacion() {
	return codModoCreacion;
}


public void setCodModoCreacion(String codModoCreacion) {
	this.codModoCreacion = codModoCreacion;
}


public String getDesPathXML() {
	return desPathXML;
}


public void setDesPathXML(String desPathXML) {
	this.desPathXML = desPathXML;
}


public String getDesPathHTML() {
	return desPathHTML;
}


public void setDesPathHTML(String desPathHTML) {
	this.desPathHTML = desPathHTML;
}


public String getDesFXmlHtml() {
	return desFXmlHtml;
}


public void setDesFXmlHtml(String desFXmlHtml) {
	this.desFXmlHtml = desFXmlHtml;
}


public String getNombreFichero2() {
	return nombreFichero2;
}


public void setNombreFichero2(String nombreFichero2) {
	this.nombreFichero2 = nombreFichero2;
}


public String getNombreFicheroP() {
	return nombreFicheroP;
}


public void setNombreFicheroP(String nombreFicheroP) {
	this.nombreFicheroP = nombreFicheroP;
}


public String getCodigoSebra() {
	return codigoSebra;
}


public void setCodigoSebra(String codigoSebra) {
	this.codigoSebra = codigoSebra;
}


public String getPortafolio() {
	return portafolio;
}


public void setPortafolio(String portafolio) {
	this.portafolio = portafolio;
}


public double getValorComision() {
	return valorComision;
}


public void setValorComision(double valorComision) {
	this.valorComision = valorComision;
}


public String getCodigoBanco() {
	return codigoBanco;
}


public void setCodigoBanco(String codigoBanco) {
	this.codigoBanco = codigoBanco;
}


public String getObservacion() {
	return observacion;
}


public void setObservacion(String observacion) {
	this.observacion = observacion;
}

public String getCodDivisa() {
		return codDivisa;
	}

public void setCodDivisa(String codDivisa) {
	this.codDivisa = codDivisa;
}
}