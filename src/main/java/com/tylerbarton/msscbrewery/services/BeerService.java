package com.tylerbarton.msscbrewery.services;

import com.tylerbarton.msscbrewery.web.model.BeerDto;

import java.util.UUID;

/**
 *
 */
public interface BeerService {

    /**
     * GET mapping
     * @param beerId
     * @return
     */
    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    void updateBeer(UUID beerId, BeerDto beerDto);

    void deleteBeer(UUID beerId);
}
