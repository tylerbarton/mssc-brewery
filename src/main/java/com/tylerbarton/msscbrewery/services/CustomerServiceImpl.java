package com.tylerbarton.msscbrewery.services;

import com.tylerbarton.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service            // Need to declare spring component to wire to controller
@Slf4j              // Logging utility
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .Id(customerId)
                .name("ph_name")
                .build();
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        log.debug("Successfully deleted customer " + customerId.toString());
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        UUID uid = UUID.randomUUID();
        log.debug("Successfully saved customer " + uid.toString());
        return CustomerDto.builder()
                .Id(uid)
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        log.debug("Successfully saved customer " + customerId.toString());
    }
}
