package com.bbva.pibee.enumeration;

public enum AuditAction {

	iCREACION (1),
	iMODIFICACION (2),
	iVALIDADO (3),
	iFIRMADO (4),
	iPDTEDEENVIO (5),
	iEXPORTADOADISCO (6),
	iENVIADO (7),
	iBORRADO (8),
	iAUDITADO (9),
	iGENERARLISTADO (10),
	iFINALIZADO (12),
	iRECEPCION (11),
	iEJECUCION_CORRECTA (13),
	iEJECUCION_ERRONEA (14),
	iEJECUCION_PARCIAL (15);
	
	private int actionCode;
	
	private AuditAction(int actionCode){
		this.actionCode = actionCode;
	}
	
	public int getActionCode(){
		return this.actionCode;
	}
}
