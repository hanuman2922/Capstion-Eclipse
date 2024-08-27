package com.exceptions;

import java.util.List;

public class ErrorResponse {
	
	
	
	private String message;
	private List<String> details;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getDetails() {
		return details;
	}
	public void setDetails(List<String> details) {
		this.details = details;
	}
	public ErrorResponse(String message, List<String> details) {
		super();
		this.message = message;
		this.details = details;
	}
	public ErrorResponse() {
		super();
	}
	
	
	


//	public ErrorResponse(String message) {
//		super();
//		this.message = message;
//	}












//	private String errorCode;
//	
//	 public String getErrorCode() {
//			return errorCode;
//		}
//		public void setErrorCode(String errorCode) {
//			this.errorCode = errorCode;
//		}
//	
//	
//public ErrorResponse(String message, String errorCode) {
//			super();
//			this.message = message;
//			this.errorCode = errorCode;
//		}





	//	 
//	public String getError() {
//		return error;
//	}
//	public void setError(String error) {
//		this.error = error;
//	}
//	public ErrorResponse(String message, List<String> details, String error) {
//		super();
//		this.message = message;
//		this.details = details;
//		this.error = error;
//	}
//	



//	 public ErrorResponse(String message) {
//	        this.message = message;
//	        this.errorCode = "ERR000"; // default error code
//	    }
	 
	

}
