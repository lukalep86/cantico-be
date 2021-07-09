package com.cantico.profile.exception;

public class FieldNotNullException extends IllegalArgumentException
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public FieldNotNullException()
    {
    }

    public FieldNotNullException(String s)
    {
        super(s);
    }

    public FieldNotNullException(String message, Throwable cause)
    {
        super(message, cause);
    }
}