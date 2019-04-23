package com.bbva.pibee.aso.noti.core;

import org.apache.log4j.Logger;

import com.bbva.pibee.rest.exception.CodClientException;

public class HttpResponseCodeNoti {

	public static Logger logger = Logger.getLogger("pibee");

	public static final int OK = 200;
	public static final int NO_CONTENT = 204;
	public static final int CLIENT_ERROR = 400;
	public static final int TSEC_CADUCADO = 403;
	public static final int NOT_FOUND = 404;
	public static final int INTERNAL_ERROR = 409;
	public static final int SERVER_ERROR = 500;

	public static CodClientException convertAsocodeToInternalCode(int httpCode, String codHost) {
		logger.info("Homologando codigo: " + httpCode);
		switch (httpCode) {
		case NO_CONTENT:
			return CodClientException.NO_DATA;
		case CLIENT_ERROR:
			return CodClientException.INVALID_PARAMETERS;
		case NOT_FOUND:
			return CodClientException.CLIENT_ERROR;
		case TSEC_CADUCADO:
			return CodClientException.TSEC_EXPIRED;
		case INTERNAL_ERROR:
			if (codHost == "noData") {
				return CodClientException.NO_DATA;
			} else {
				return CodClientException.INTERNAL_ERROR;
			}
		case SERVER_ERROR:
			return CodClientException.INTERNAL_ERROR;
		default:
			return CodClientException.INTERNAL_ERROR;

		}
	}

	public static CodClientException convertAsocodeToInternalCode(int httpCode) {
		logger.info("Homologando codigo: " + httpCode);
		switch (httpCode) {
		case NO_CONTENT:
			return CodClientException.NO_DATA;
		case CLIENT_ERROR:
			return CodClientException.INVALID_PARAMETERS;
		case NOT_FOUND:
			return CodClientException.CLIENT_ERROR;
		case TSEC_CADUCADO:
			return CodClientException.TSEC_EXPIRED;
		case INTERNAL_ERROR:
			return CodClientException.INTERNAL_ERROR;
		case SERVER_ERROR:
			return CodClientException.INTERNAL_ERROR;
		default:
			return CodClientException.INTERNAL_ERROR;

		}
	}
}
