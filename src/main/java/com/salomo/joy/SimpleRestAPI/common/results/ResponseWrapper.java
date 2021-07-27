/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salomo.joy.SimpleRestAPI.common.results;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Joy Salomo S
 * @param <T>
 */

@SuppressWarnings("unchecked")
public class ResponseWrapper<T> extends ResponseEntity<T> {

    public ResponseWrapper( T t, HttpStatus status )
    {
        super( ( T ) new Resultset<>( t, status ), status );
    }
}
