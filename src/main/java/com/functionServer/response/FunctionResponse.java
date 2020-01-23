package com.functionServer.response;

import java.math.BigDecimal;

public class FunctionResponse {
	
	
	private String message = "";
	private boolean success = false;
	private BigDecimal result = null;
	
	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public BigDecimal getResult() {
		return result;
	}


	public void setResult(BigDecimal result) {
		this.result = result;
	}
	
	
	public FunctionResponse(String message, boolean success, BigDecimal result) {
		this.message = message;
		this.success = success;
		this.result = result;
	}
	
	
	public FunctionResponse() {
			
	}


}
