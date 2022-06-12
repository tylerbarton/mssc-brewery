package com.tylerbarton.msscbrewery.services;

import com.tylerbarton.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

/**
 * View for API
 */
public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);
}
