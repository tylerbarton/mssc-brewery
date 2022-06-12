package com.tylerbarton.msscbrewery.services;

import com.tylerbarton.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service            // Needed to wire to controller
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .Id(customerId)
                .name("ph_name")
                .build();
    }
}
