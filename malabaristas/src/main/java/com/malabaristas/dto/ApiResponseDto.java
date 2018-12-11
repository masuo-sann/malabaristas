package com.malabaristas.dto;

public class ApiResponseDto<T> {
	private String message;
	private String result;
	private T body;

	@Override
	public String toString() {
		return "ApiResponseDto [message=" + message + ", result=" + result + ", body=" + body + "]";
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public T getBody() {
		return body;
	}
	public void setBody(T body) {
		this.body = body;
	}
}
