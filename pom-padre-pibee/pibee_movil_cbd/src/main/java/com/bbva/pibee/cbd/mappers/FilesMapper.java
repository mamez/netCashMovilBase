package com.bbva.pibee.cbd.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bbva.pibee.aop.LogNetCashMovil;
import com.bbva.pibee.arq.annotations.UtilDto;
import com.bbva.pibee.dto.cbd.OperationDetailDto;

public class FilesMapper extends UtilDto implements RowMapper<OperationDetailDto>{

	public FilesMapper() {
		super(OperationDetailDto.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public OperationDetailDto mapRow(ResultSet st, int arg1) throws SQLException {
		//Se hace mapeo del DTO con los nombres de los campos de la Base de datos.
		OperationDetailDto model= new OperationDetailDto();
		try{			
			model.setCodCliente(st.getString(getValueField("codCliente")));
			model.setCodEstado(st.getString(getValueField("codEstado")));
			model.setClaseOrden(st.getString(getValueField("claseOrden")));
			model.setIdOrden(st.getString(getValueField("idOrden")));
			model.setFechaProceso(st.getString(getValueField("fechaProceso")));
			model.setNombreFichero(st.getString(getValueField("nombreFichero")));
			model.setImporte(st.getString(getValueField("importe")));
			model.setNumOrdenes(st.getInt(getValueField("numOrdenes")));
			model.setCodEstado(st.getString(getValueField("codEstado")));
			model.setPesoFirma(st.getDouble(getValueField("pesoFirma")));
			model.setQnu_numItem(st.getLong(getValueField("qnu_numItem")));
			model.setTamanio(st.getLong(getValueField ("tamanio")));
			model.setDesRefFicher(st.getString(getValueField("desRefFicher")));
			model.setCodCabeceraOrigen(st.getInt(getValueField("codCabeceraOrigen")));
			model.setCuentaOrigen(st.getString(getValueField("cuentaOrigen")));
			model.setCodIdOrigen(st.getString(getValueField("codIdOrigen")));
			model.setCodBanco(st.getShort(getValueField("codBanco")));
			model.setCodDivisa(st.getString(getValueField("codDivisa")));
			model.setFechaCreacion(st.getString(getValueField("fechaCreacion")));
			model.setUsuarioCreacion(st.getString(getValueField("usuarioCreacion")));		
			model.setsFechaModif(st.getDate(getValueField("sFechaModif")));		
			model.setsUsuarioModif(st.getString(getValueField("sUsuarioModif")));
			model.setMedioCreacion(st.getString(getValueField("medioCreacion")));
			model.setCodModoCreacion(st.getString(getValueField("codModoCreacion")));
			model.setDesPathXML(st.getString(getValueField("desPathXML")));
			model.setDesPathHTML(st.getString(getValueField("desPathHTML")));
			model.setDesFXmlHtml(st.getString(getValueField("desFXmlHtml")));
			model.setNombreFichero2(st.getString(getValueField("nombreFichero2")));
			model.setNombreFicheroP(st.getString(getValueField("nombreFicheroP")));
			model.setCodigoSebra(st.getString(getValueField("codigoSebra")));
			model.setPortafolio(st.getString(getValueField("portafolio")));
			model.setValorComision(st.getDouble(getValueField("valorComision")));
			model.setCodigoBanco(st.getString(getValueField("codigoBanco")));
			model.setObservacion(st.getString(getValueField("observacion")));
			
			
					
			
		}catch (SQLException e) {
			LogNetCashMovil.logErrorPibee("Error en mapper FilesMapper "+e.getMessage());
			throw new SQLException(e);
		}catch (Exception e2) {
			LogNetCashMovil.logErrorPibee("Error en mapper FilesMapper "+e2.getMessage());
			throw new SQLException(e2);
		}
		return model;
	}
}
