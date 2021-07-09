package com.cantico.profile.exception;

public class ExpiredOTPException extends IllegalArgumentException
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ExpiredOTPException()
    {
    }

    public ExpiredOTPException(String s)
    {
        super(s);
    }

    public ExpiredOTPException(String message, Throwable cause)
    {
        super(message, cause);
    }
}