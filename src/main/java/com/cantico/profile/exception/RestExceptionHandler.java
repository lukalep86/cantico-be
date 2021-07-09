package com.cantico.profile.exception;



import org.springframework.http.HttpStatus;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	//protected Logger _logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex, 
      HttpHeaders headers, 
      HttpStatus status, 
      WebRequest request) {
        List<String> errors = new ArrayList<String>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }
        
        APIError apiError = 
          new APIError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
        return handleExceptionInternal(
          ex, apiError, headers, apiError.getStatus(), request);
    }

@Override
protected ResponseEntity<Object> handleMissingServletRequestParameter(
  MissingServletRequestParameterException ex, HttpHeaders headers, 
  HttpStatus status, WebRequest request) {
    String error = ex.getParameterName() + " parameter is missing";
    
    APIError apiError = 
      new APIError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
    return new ResponseEntity<Object>(
      apiError, new HttpHeaders(), apiError.getStatus());
}

@ExceptionHandler({ ConstraintViolationException.class })
public ResponseEntity<Object> handleConstraintViolation(  ConstraintViolationException ex, WebRequest request) {
    List<String> errors = new ArrayList<String>();
    for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
        errors.add(violation.getRootBeanClass().getName() + " " + 
          violation.getPropertyPath() + ": " + violation.getMessage());
    }

    APIError apiError = 
      new APIError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
    return new ResponseEntity<Object>(
      apiError, new HttpHeaders(), apiError.getStatus());
}

@Override
protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    String error = "Malformed JSON request";
     APIError apiError =   new APIError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
    return buildResponseEntity(apiError);
}




@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
public ResponseEntity<Object> handleMethodArgumentTypeMismatch(
  MethodArgumentTypeMismatchException ex, WebRequest request) {
    String error = 
      ex.getName() + " should be of type " + ex.getRequiredType().getName();

      APIError apiError =    new APIError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
    return new ResponseEntity<Object>( apiError, new HttpHeaders(), apiError.getStatus());
}




@Override
protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    String error = "Error writing JSON output";    
    APIError apiError =     new APIError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), error);
  return new ResponseEntity<Object>(  apiError, new HttpHeaders(), apiError.getStatus());
 
}



@ExceptionHandler(EntityNotFoundException.class)
protected ResponseEntity<Object> handleEntityNotFoundException(RuntimeException ex) {
  APIError apiError = new APIError(HttpStatus.NOT_FOUND);
  apiError.setMessage(ex.getMessage());
 // apiError.setDebugMessage(ExceptionUtils.getRootCauseMessage(ex));
  return buildResponseEntity(apiError);
    
}

    //Exception custom per sollevata dalla get by id quando l'id non esiste. 404 NOT FOUND
    @ExceptionHandler(java.util.NoSuchElementException.class)
    protected ResponseEntity<Object> handleNoSuchElementException(RuntimeException ex) {
    	APIError apiError = new APIError(HttpStatus.NOT_FOUND);
    	apiError.setMessage(ex.getLocalizedMessage());
        return buildResponseEntity(apiError,ex);
    }


   
  @ExceptionHandler(ExpiredOTPException.class)
  protected ResponseEntity<Object> handleExpiredTokenException(RuntimeException ex) {
    APIError apiError = new APIError(HttpStatus.UNAUTHORIZED);
    apiError.setMessage(ex.getMessage());
  //  apiError.setDebugMessage(ExceptionUtils.getRootCauseMessage(ex));
    return buildResponseEntity(apiError);
  }

     
     @ExceptionHandler(InvalidOTPException.class)
     protected ResponseEntity<Object> handleInvalidOTPException(RuntimeException ex) {
       APIError apiError = new APIError(HttpStatus.UNAUTHORIZED);
       apiError.setMessage(ex.getMessage());
     //  apiError.setDebugMessage(ExceptionUtils.getRootCauseMessage(ex));
       return buildResponseEntity(apiError);
     }

      
  @ExceptionHandler(InvalidPSWException.class)
  protected ResponseEntity<Object> handleInvalidPSWException(RuntimeException ex) {
    APIError apiError = new APIError(HttpStatus.UNAUTHORIZED);
    apiError.setMessage(ex.getMessage());
   // apiError.setDebugMessage(ExceptionUtils.getRootCauseMessage(ex));
    return buildResponseEntity(apiError);
  }


  @ExceptionHandler(MailAuthenticationException.class)
  protected ResponseEntity<Object> handleMailAuthenticationException(RuntimeException ex) {
    APIError apiError = new APIError(HttpStatus.INTERNAL_SERVER_ERROR);
    apiError.setMessage(ex.getMessage());
    //apiError.setDebugMessage(ExceptionUtils.getRootCauseMessage(ex));
    return buildResponseEntity(apiError);
  }

  @ExceptionHandler(FieldNotNullException.class)
  protected ResponseEntity<Object> handleFieldNotNullException(IllegalArgumentException ex) {
    APIError apiError = new APIError(HttpStatus.BAD_REQUEST);
    apiError.setMessage(ex.getMessage());
   // apiError.setDebugMessage(ExceptionUtils.getRootCauseMessage(ex));
    return buildResponseEntity(apiError);
  }

  @ExceptionHandler(InvalidTokenException.class)
  protected ResponseEntity<Object> handleInvalidTokenException(IllegalArgumentException ex) {
    APIError apiError = new APIError(HttpStatus.BAD_REQUEST);
    apiError.setMessage(ex.getMessage());
   // apiError.setDebugMessage(ExceptionUtils.getRootCauseMessage(ex));
    return buildResponseEntity(apiError);
  }

private ResponseEntity<Object> buildResponseEntity(APIError apiError) {
  return new ResponseEntity<>(apiError, apiError.getStatus());
 
}

private ResponseEntity<Object> buildResponseEntity(APIError apiError , Exception ex) {
    
      return new ResponseEntity<>(apiError, apiError.getStatus());
  }


}