/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salomo.joy.SimpleRestAPI.service;

import com.salomo.joy.SimpleRestAPI.common.exception.ResourceNotFoundException;
import com.salomo.joy.SimpleRestAPI.domain.Customer;
import com.salomo.joy.SimpleRestAPI.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joy Salomo S
 */

@Service
public class CustomerServiceImp extends CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImp(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    @Override
    public Page<Customer> getAll(Pageable pageable) {

        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer add(Customer o) {

        return customerRepository.save(o);
    }

    @Override
    public Customer update(Customer o, int id) throws ResourceNotFoundException {

        Customer existCustomer = checkIfCustomerIdIsPresent(id);

        if (o.getName() != null)
            existCustomer.setName(o.getName());
        if (o.getPhone() != null)
            existCustomer.setPhone(o.getPhone());

        return customerRepository.save(existCustomer);
    }

    @Override
    public Customer getById(int id) {

        return checkIfCustomerIdIsPresent(id);
    }

    @Override
    public Customer deleteById(int id) {

        Customer existCustomer = checkIfCustomerIdIsPresent(id);
        customerRepository.deleteById(id);
        return existCustomer;
    }

    private Customer checkIfCustomerIdIsPresent(int id)
    {
        if ( !customerRepository.findById(id).isPresent() )
            throw new ResourceNotFoundException(" Customer id=" + id + " not found");
        else
            return customerRepository.findById(id).get();
    }
}
