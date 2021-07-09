package com.cantico.profile.exception;

public class InvalidOTPException extends IllegalArgumentException
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InvalidOTPException()
    {
    }

    public InvalidOTPException(String s)
    {
        super(s);
    }

    public InvalidOTPException(String message, Throwable cause)
    {
        super(message, cause);
    }
}