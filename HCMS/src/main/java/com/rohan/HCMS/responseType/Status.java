package com.rohan.HCMS.responseType;

public class Status {
	private boolean responseStatus;

	public Status() {

	}

	public Status(boolean responseStatus) {
		this.responseStatus = responseStatus;
	}

	public boolean isResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(boolean responseStatus) {
		this.responseStatus = responseStatus;
	}

	@Override
	public String toString() {
		return "Status [responseStatus=" + responseStatus + "]";
	}
}
