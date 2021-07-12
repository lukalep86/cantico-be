package com.cantico.profile.exception;

public class MessageResponse  extends RuntimeException {
 
  private static final long serialVersionUID = 1L;

  public MessageResponse(String message) {
        super(message);
  }
}

