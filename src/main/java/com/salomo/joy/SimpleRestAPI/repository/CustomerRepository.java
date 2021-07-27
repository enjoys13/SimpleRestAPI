/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salomo.joy.SimpleRestAPI.repository;

import com.salomo.joy.SimpleRestAPI.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Joy Salomo S
 */

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
