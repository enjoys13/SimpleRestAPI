/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salomo.joy.SimpleRestAPI.controller;

import com.salomo.joy.SimpleRestAPI.common.results.ResponseWrapper;
import com.salomo.joy.SimpleRestAPI.domain.Customer;
import com.salomo.joy.SimpleRestAPI.service.CustomerService;
import static com.salomo.joy.SimpleRestAPI.common.constant.ApiConstans.MESSAGE_FOR_REGEX_NUMBER_MISMATCH;
import static com.salomo.joy.SimpleRestAPI.common.constant.ApiConstans.REGEX_FOR_NUMBERS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

/**
 *
 * @author Joy Salomo S
 */

@Validated
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/{id}")
    public ResponseWrapper<Customer> getCustomerById(
            @Valid @Pattern(regexp = REGEX_FOR_NUMBERS, message = MESSAGE_FOR_REGEX_NUMBER_MISMATCH) @PathVariable(value = "id") String id) {

        return new ResponseWrapper<>(customerService.getById(Integer.parseInt(id)), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseWrapper<Page<Customer>> getCustomerAll(Pageable pageable) {

        return new ResponseWrapper<>(customerService.getAll(pageable), HttpStatus.OK);
    }

    //REPLACE CUSTOMER DOMAIN WITH DTO AS PARAMETER FOR MORE COMPLEX REQUEST AND DATA
    //SAMPLE ONLY
    @PostMapping
    public ResponseWrapper<Customer> createCustomer(@Valid @RequestBody Customer customer) {

        return new ResponseWrapper<>(customerService.add(customer), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseWrapper<Customer> deleteCustomer(
            @Valid @Pattern(regexp = REGEX_FOR_NUMBERS, message = MESSAGE_FOR_REGEX_NUMBER_MISMATCH) @PathVariable(value = "id") String id) {

        return new ResponseWrapper<>(customerService.deleteById(Integer.parseInt(id)), HttpStatus.OK);
    }

    //REPLACE CUSTOMER DOMAIN WITH DTO AS PARAMETER FOR MORE COMPLEX REQUEST AND DATA
    //SAMPLE ONLY
    @PutMapping(value = "/{id}")
    public ResponseWrapper<Customer> updateCustomer( @Valid @RequestBody Customer customer,
                                               @Valid @Pattern(regexp = REGEX_FOR_NUMBERS, message = MESSAGE_FOR_REGEX_NUMBER_MISMATCH) @PathVariable(value = "id") String id) {

        return new ResponseWrapper<>(customerService.update(customer, Integer.parseInt(id)), HttpStatus.OK);
    }
}
