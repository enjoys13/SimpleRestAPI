/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salomo.joy.SimpleRestAPI.common.exception;

import static com.salomo.joy.SimpleRestAPI.common.constant.ApiConstans.MESSAGE_FOR_INVALID_BODY_ERROR;
import static com.salomo.joy.SimpleRestAPI.common.constant.ApiConstans.MESSAGE_FOR_INVALID_PARAMETERS_ERROR;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

/**
 *
 * @author Joy Salomo S
 */

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> resourceEntityNotFound( ResourceNotFoundException ex )
    {
        ApiError apiError = createError( ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST, ex );
        return new ResponseEntity<>( apiError, apiError.getStatus() );
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleConstraintViolationException( ConstraintViolationException e )
    {
        ApiError apiError = createError( MESSAGE_FOR_INVALID_PARAMETERS_ERROR, HttpStatus.BAD_REQUEST, e );
        return new ResponseEntity<>( apiError, apiError.getStatus() );
    }

    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleMethodArgumentNotValid( MethodArgumentNotValidException e,
                                                                   HttpHeaders headers, HttpStatus status, WebRequest request )
    {
        ApiError apiError = createError( MESSAGE_FOR_INVALID_BODY_ERROR, HttpStatus.BAD_REQUEST, e );
        return new ResponseEntity<>( apiError, apiError.getStatus() );
    }

    private ApiError createError( String msg, HttpStatus status, Exception e )
    {
        ApiError apiError = new ApiError( status );
        apiError.setMessage( msg );
        apiError.setDebugMessage( e.getMessage() );
        return apiError;
    }

}