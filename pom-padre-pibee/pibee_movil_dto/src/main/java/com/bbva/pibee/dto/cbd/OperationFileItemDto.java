package com.bbva.pibee.dto.cbd;

import java.util.Date;

import com.bbva.pibee.arq.annotations.Column;

public class OperationFileItemDto 
{
	//Campos de la tabla TBDBZBIT.
	
		@Column(name="COD_CANALDI")
		private  int COD_CANALDI;
		
		@Column(name="COD_BANCOINT")
		private  int COD_BANCOINT;
		
		@Column(name="COD_LOGONAPL")
		private  String COD_LOGONAPL;
		
		@Column(name="XTI_BUZON")
		private  String XTI_BUZON;
		
		@Column(name="QNU_NUMITEM")
		private  long QNU_NUMITEM;
		
		@Column(name="FEC_RECEPCIO")
		private  Date FEC_RECEPCIO;
		
		@Column(name="HMS_RECEPCIO")
		private  String HMS_RECEPCIO;
		
		@Column(name="AUD_USUARIO")
		private  String AUD_USUARIO;
		
		@Column(name="AUD_FMODIFIC")
		private  Date AUD_FMODIFIC;

		@Column(name="COD_PID")
		private  int COD_PID;

		public int getCOD_CANALDI() {
			return COD_CANALDI;
		}

		public void setCOD_CANALDI(int cOD_CANALDI) {
			COD_CANALDI = cOD_CANALDI;
		}

		public int getCOD_BANCOINT() {
			return COD_BANCOINT;
		}

		public void setCOD_BANCOINT(int cOD_BANCOINT) {
			COD_BANCOINT = cOD_BANCOINT;
		}

		public String getCOD_LOGONAPL() {
			return COD_LOGONAPL;
		}

		public void setCOD_LOGONAPL(String cOD_LOGONAPL) {
			COD_LOGONAPL = cOD_LOGONAPL;
		}

		public String getXTI_BUZON() {
			return XTI_BUZON;
		}

		public void setXTI_BUZON(String xTI_BUZON) {
			XTI_BUZON = xTI_BUZON;
		}

		public long getQNU_NUMITEM() {
			return QNU_NUMITEM;
		}

		public void setQNU_NUMITEM(long qNU_NUMITEM) {
			QNU_NUMITEM = qNU_NUMITEM;
		}

		public Date getFEC_RECEPCIO() {
			return FEC_RECEPCIO;
		}

		public void setFEC_RECEPCIO(Date fEC_RECEPCIO) {
			FEC_RECEPCIO = fEC_RECEPCIO;
		}

		public String getHMS_RECEPCIO() {
			return HMS_RECEPCIO;
		}

		public void setHMS_RECEPCIO(String hMS_RECEPCIO) {
			HMS_RECEPCIO = hMS_RECEPCIO;
		}

		public String getAUD_USUARIO() {
			return AUD_USUARIO;
		}

		public void setAUD_USUARIO(String aUD_USUARIO) {
			AUD_USUARIO = aUD_USUARIO;
		}

		public Date getAUD_FMODIFIC() {
			return AUD_FMODIFIC;
		}

		public void setAUD_FMODIFIC(Date aUD_FMODIFIC) {
			AUD_FMODIFIC = aUD_FMODIFIC;
		}

		public int getCOD_PID() {
			return COD_PID;
		}

		public void setCOD_PID(int cOD_PID) {
			COD_PID = cOD_PID;
		}
}
