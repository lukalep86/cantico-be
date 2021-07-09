package com.cantico.profile.exception;

public class ExpiredTokenException extends InvalidTokenException
{
    public ExpiredTokenException()
    {
    }

    public ExpiredTokenException(String s)
    {
        super(s);
    }

    public ExpiredTokenException(String message, Throwable cause)
    {
        super(message, cause);
    }
}