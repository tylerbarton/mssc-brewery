package com.tylerbarton.msscbrewery.web.controller;

import com.tylerbarton.msscbrewery.services.CustomerService;
import com.tylerbarton.msscbrewery.web.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
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

    /**
     * Handles the POST verb
     * inserts a new customer
     * @param customerDto Customer information
     * @return
     */
    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDto customerDto){
        CustomerDto savedDto = customerService.saveNewCustomer(customerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer" + savedDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDto customerDto){
        customerService.updateCustomer(customerId, customerDto);
    }

    /**
     * Handles the DELETE verb
     * @param customerId the UUID of the customer to delete
     */
    @DeleteMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable("customerId") UUID customerId){
        customerService.deleteCustomer(customerId);
    }
}
