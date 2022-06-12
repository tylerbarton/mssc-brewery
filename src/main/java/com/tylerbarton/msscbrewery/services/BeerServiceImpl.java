package com.tylerbarton.msscbrewery.services;

import com.tylerbarton.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Endpoint implementation for the BeerService interface.
 */
@Service
@Slf4j // Logger
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

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        // TODO: implement
    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.debug("Deleting beer " + beerId.toString());
    }
}
