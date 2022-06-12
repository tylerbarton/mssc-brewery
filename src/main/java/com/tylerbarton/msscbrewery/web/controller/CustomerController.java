package com.tylerbarton.msscbrewery.web.controller;

import com.tylerbarton.msscbrewery.services.CustomerService;
import com.tylerbarton.msscbrewery.web.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Input mapping for customer
 */
@RequestMapping("/api/v1/customer")       // API endpoint exposure
@RestController                             // Indicates controller
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    /**
     * Called from the Customer Service for mapping access
     * @param customerService
     */
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    /**
     * GET mapping
     * @param customerId Id of the customer
     * @return Response body populated by getCustomerById
     */
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customerId){
        return new ResponseEntity<CustomerDto>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }



}
