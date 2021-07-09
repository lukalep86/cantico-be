package com.cantico.profile.exception;


import org.springframework.http.HttpStatus;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Arrays;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class APIError {

    
    private HttpStatus status;
    private String message;
    private Exception exception;
    private List<String> errors;
    private String debugMessage;
    private String errorCode;

    public APIError(String errorCode, String message) {
        super();        
        this.setErrorCode(errorCode);
        this.message = message;
    }

  
    public APIError(String errorCode, String message, List<String> errors) {
        super();        
        this.setErrorCode(errorCode);
        this.message = message;
        this.errors = errors;
    }

    public APIError(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public APIError(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }

    public APIError(HttpStatus status) {
        super();
        this.status = status;
               
    }

    public APIError(HttpStatus status, String error, Exception ex){
        super();
        this.status = status;
        errors = Arrays.asList(error);
        this.exception =ex;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    
    public String getDebugMessage() {
		return debugMessage;
	}

	
	
	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    
    @Override
    public final String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("ApiError [status=").append(status).append(", message=").append(message).append(", developerMessage=").append("").append("]");
        return builder.toString();
    }

}
