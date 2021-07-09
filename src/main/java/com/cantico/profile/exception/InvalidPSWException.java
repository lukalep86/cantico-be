package com.cantico.profile.exception;

public class InvalidPSWException extends IllegalArgumentException
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InvalidPSWException()
    {
    }

    public InvalidPSWException(String s)
    {
        super(s);
    }

    public InvalidPSWException(String message, Throwable cause)
    {
        super(message, cause);
    }
}