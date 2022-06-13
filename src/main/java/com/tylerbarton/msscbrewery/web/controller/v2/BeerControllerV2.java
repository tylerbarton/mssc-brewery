package com.tylerbarton.msscbrewery.web.controller.v2;

import com.tylerbarton.msscbrewery.services.v2.BeerServiceV2;
import com.tylerbarton.msscbrewery.web.model.v2.BeerDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Validated                          // Method Validation
@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

    // Handles the service layer
    private final BeerServiceV2 beerService;

    public BeerControllerV2(BeerServiceV2 beerService) {
        this.beerService = beerService;
    }

    /**
     * GET mapping
     * @param beerId
     * @return Response body for the unique beer id
     */
    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDtoV2> getBeer(@NotNull @PathVariable("beerId") UUID beerId){   // PathVariable included for clarity
        return new ResponseEntity<BeerDtoV2>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    /**
     * POST mapping
     * @param beerDto
     * @return URL of the newly created resource
     */
    @PostMapping
    public ResponseEntity handlePost(@Valid @RequestBody BeerDtoV2 beerDto){ // RequestBody annotation is needed to bind to object
        BeerDtoV2 savedDto = beerService.saveNewBeer(beerDto);

        // Respond the location of the new resource
        HttpHeaders headers = new HttpHeaders();
        // Pass back the endpoint
        // TODO: Add host name to url
        headers.add("Location", "/api/v2/beer/" + savedDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    /**
     * Handles PUT request
     * @param beerId Id to update
     * @param beerDto Beer information to update
     * @return Response entity with HTTP status
     */
    @PutMapping("/{beerId}") // the system has ownership of this resource - safe guard against client
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDtoV2 beerDto){
        beerService.updateBeer(beerId, beerDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT); // Understood request
    }

    /**
     * Handles DELETE method for a specific UUID
     */
    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT) // To return a status without body
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        beerService.deleteBeer(beerId);
    }

}
