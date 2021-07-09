package com.cantico.profile.exception;

import javax.mail.AuthenticationFailedException;

public class MailAuthenticationException extends AuthenticationFailedException{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public MailAuthenticationException()
    {
    }

    public MailAuthenticationException(String s)
    {
        super(s);
    }

  
}