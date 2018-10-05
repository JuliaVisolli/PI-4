package br.com.senac.pi4.expcetion;

import io.swagger.annotations.ApiModelProperty;

public class ErrorException extends Exception{
	
Integer status;
	
	/** application specific error code */
	int code; 
		
	/** link documenting the exception */	
	String link;
	
	/** detailed error description for developers*/
	String developerMessage;	
	
	public ErrorException(int status, int code, String message,
			String developerMessage, String link) {
		super(message);
		this.status = status;
		this.code = code;
		this.developerMessage = developerMessage;
		this.link = link;
	}

	public ErrorException() { }

	@ApiModelProperty("The status code of error (Internal FEPWeb codes).")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@ApiModelProperty("The error code.")
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@ApiModelProperty("The error message do the developer.")
	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
