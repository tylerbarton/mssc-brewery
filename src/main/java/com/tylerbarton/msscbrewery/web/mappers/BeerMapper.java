package com.tylerbarton.msscbrewery.web.mappers;

import com.tylerbarton.msscbrewery.domain.Beer;
import com.tylerbarton.msscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

/**
 * Uses MapStruct to convert BeerDto <==> Beer (Entity)
 */
@Mapper
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto dto);
}
