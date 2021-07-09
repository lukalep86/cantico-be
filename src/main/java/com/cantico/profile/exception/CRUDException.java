package com.cantico.profile.exception;

public class CRUDException extends RuntimeException {

    
/**
     *
     */
    private static final long serialVersionUID = 1L;
    private int errorCode;
    private String errorMessage;
    private Exception originalException;

  public CRUDException(int errorCode, String errorMessage, Exception originalException){
        super();
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
        this.originalException=originalException;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Exception getOriginalException() {
        return originalException;
    }

    public void setOriginalException(Exception originalException) {
        this.originalException = originalException;
    }
}
