package com.tylerbarton.msscbrewery.web.controller;

import com.tylerbarton.msscbrewery.services.BeerService;
import com.tylerbarton.msscbrewery.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Handles the input controlling for beer
 */
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    // Handles the service layer
    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    /**
     * GET mapping
     * @param beerId
     * @return Response body for the unique beer id
     */
    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){   // PathVariable included for clarity
        return new ResponseEntity<BeerDto>(beerService.getBeerById(beerId), HttpStatus.OK);
    }
}
