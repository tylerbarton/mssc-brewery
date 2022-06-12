package com.tylerbarton.msscbrewery.services;

import com.tylerbarton.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Endpoint implementation for the BeerService interface.
 */
@Service
public class BeerServiceImpl implements BeerService {

    /**
     * GET mapping
     * @param beerId the Id of the beer to create
     * @return a new beer by Id
     */
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("ph_name")
                .beerStyle("ph_style")
                .build();
    }
}
