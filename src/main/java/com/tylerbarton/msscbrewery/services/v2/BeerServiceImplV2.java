package com.tylerbarton.msscbrewery.services.v2;

import com.tylerbarton.msscbrewery.web.model.v2.BeerDtoV2;
import com.tylerbarton.msscbrewery.web.model.v2.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j // Logger
public class BeerServiceImplV2 implements BeerServiceV2 {

    /**
     * GET mapping
     *
     * @param beerId the Id of the beer to create
     * @return a new beer by Id
     */
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .beerName("ph_name")
                .beerStyle(BeerStyleEnum.IPA)
                .build();
    }

    @Override
    public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {
        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {
        // TODO: implement
    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.debug("Deleting beer " + beerId.toString());
    }
}
