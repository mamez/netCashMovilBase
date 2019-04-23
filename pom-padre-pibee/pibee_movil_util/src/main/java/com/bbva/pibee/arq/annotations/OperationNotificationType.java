package com.bbva.pibee.arq.annotations;

public enum OperationNotificationType {

	PEND_FIRMA("OPF"), ORD_FIRMADA("OFR"), TRANS_TERCEROS("TRA"), TRANS_BBVA("TPO");

	private String op;

	OperationNotificationType(String op) {
		this.op = op;
	}

	public String op() {
		return op;
	}
}
