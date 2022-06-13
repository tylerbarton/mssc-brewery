package com.tylerbarton.msscbrewery.web.mappers;

import com.tylerbarton.msscbrewery.domain.Customer;
import com.tylerbarton.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

/**
 * CustomerDto <=> Customer (Entity)
 */
@Mapper
public interface CustomerMapper {
    CustomerDto customerToCustomerDto(Customer customer);
    Customer customerDtoToCustomer(CustomerDto dto);
}
