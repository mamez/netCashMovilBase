package com.bbva.pibee.web.servicesImpl;

import javax.ws.rs.core.Response;

import com.bbva.pibee.arq.annotations.ResourceBusiness;
import com.bbva.pibee.arq.container.StatusBBVA;
import com.bbva.pibee.notification.back.business.ConfigurationBusiness;
import com.bbva.pibee.rest.exception.BbvaClientBackException;
import com.bbva.pibee.rest.exception.CodClientException;
import com.bbva.pibee.web.dto.notifi.request.ConfigurationEntityRequest;
import com.bbva.pibee.web.dto.notifi.response.ServicesResponse;
import com.bbva.pibee.web.services.ConfigurationService;


public class ConfigurationServiceImpl implements ConfigurationService {
	
	@ResourceBusiness
	private ConfigurationBusiness configurationBusinessImpl;

	@Override
	public Response getConfigurations() throws BbvaClientBackException {
		ServicesResponse configResp = null;
		try {
			configResp = configurationBusinessImpl.getConfigurations();
			if ((configResp != null) && (configResp.getServiceModel().isEmpty())) {
				return StatusBBVA.NoContent.Status();
			}
		} catch (BbvaClientBackException e) {
			throw new BbvaClientBackException(CodClientException.CLIENT_ERROR, e);
		} catch (Exception e) {
			throw new BbvaClientBackException(CodClientException.CLIENT_ERROR, e);
		}
		return StatusBBVA.Ok.entity(configResp);
	}

	@Override
	public Response insertConfiguration(ConfigurationEntityRequest configReq) throws BbvaClientBackException {
		try {
			   configurationBusinessImpl.configuration(configReq);
			   return StatusBBVA.Ok.Status();
		} catch (BbvaClientBackException ex) {
			if (ex.getError().getCod() == CodClientException.INVALID_PARAMETERS) {
				throw new BbvaClientBackException(CodClientException.INVALID_PARAMETERS, ex);
			} else {
				throw new BbvaClientBackException(CodClientException.CLIENT_ERROR, ex);
			}
		} catch (Exception e) {
			throw new BbvaClientBackException(CodClientException.CLIENT_ERROR, e);
		}
	}
}
