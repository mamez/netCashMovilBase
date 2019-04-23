package com.bbva.pibee.aso.noti.inter;

import com.bbva.pibee.aso.noti.dto.Enrollment;
import com.bbva.pibee.rest.exception.BbvaClientAsoException;

public interface EnrollmentService
{
	public String createEnrollment(String idUser, String appId, String appKey,Enrollment user) throws BbvaClientAsoException;
	public void modifyEnrollment(String enrollmentId, String appId, String appKey, Enrollment user) throws BbvaClientAsoException;
}
