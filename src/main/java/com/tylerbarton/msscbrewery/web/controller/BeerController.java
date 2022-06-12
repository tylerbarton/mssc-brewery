package com.tylerbarton.msscbrewery.web.controller;

import com.tylerbarton.msscbrewery.services.BeerService;
import com.tylerbarton.msscbrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * POST mapping
     * @param beerDto
     * @return URL of the newly created resource
     */
    @PostMapping
   public ResponseEntity handlePost(BeerDto beerDto){ // RequestBody annotation is needed to bind to object
        BeerDto savedDto = beerService.saveNewBeer(beerDto);

        // Respond the location of the new resource
        HttpHeaders headers = new HttpHeaders();
        // Pass back the endpoint
        // TODO: Add host name to url
        headers.add("Location", "/api/v1/beer" + savedDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
   }

    /**
     * Handles PUT request
     * @param beerId Id to update
     * @param beerDto Beer information to update
     * @return Response entity with HTTP status
     */
    @PutMapping("/{beerId}") // the system has ownership of this resource - safe guard against client
   public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, BeerDto beerDto){
        beerService.updateBeer(beerId, beerDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT); // Understood request
   }
}
