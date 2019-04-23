
package com.bbva.pibee.aso.noti.dto;

public class Enrollment {

	private String deviceAlias;

	private String deviceId;

	private String version;

	private Platform platform;

	private String token;

	public String getDeviceAlias() {
		return deviceAlias;
	}

	public void setDeviceAlias(String deviceAlias) {
		this.deviceAlias = deviceAlias;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "ClassPojo [deviceAlias = " + deviceAlias + ", deviceId = " + deviceId + ", version = " + version
				+ ", platform = " + platform + ", token = " + token + "]";
	}

}
