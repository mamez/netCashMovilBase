package com.bbva.pibee.notification.back.type;

public enum StatusOperation {
	CHECK("check"), UN_CHECK("uncheck");

	private String status;

	StatusOperation(String Status) {
		this.status = Status;
	}

	public String status() {
		return this.status;
	}

}
