/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salomo.joy.SimpleRestAPI.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Joy Salomo S
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException( String exception )
    {
        super( exception );
    }

    public ResourceNotFoundException()
    {
        super();
    }

    public ResourceNotFoundException( String message, Throwable cause )
    {
        super( message, cause );
    }

}
