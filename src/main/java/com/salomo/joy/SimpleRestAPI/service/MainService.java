/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salomo.joy.SimpleRestAPI.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Joy Salomo S
 * @param <T>
 */

public interface MainService<T>
{
    Page<T> getAll( Pageable pageable );

    T add( T o );

    T update( T o, int id );

    T getById( int id );

    T deleteById( int id );
}
