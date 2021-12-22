package com.luv4code.lfcbeerservice.web.controller;

import com.luv4code.lfcbeerservice.services.BeerService;
import com.luv4code.brewery.model.BeerDto;
import com.luv4code.brewery.model.BeerPagedList;
import com.luv4code.brewery.model.BeerStyleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class BeerController {

    private final BeerService beerService;

    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;


    @GetMapping(produces = {"application/json"}, path = "beer")
    private ResponseEntity<BeerPagedList> listBeers(
            @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @RequestParam(value = "beerName", required = false) String beerName,
            @RequestParam(value = "beerStyle", required = false) BeerStyleEnum beerStyle,
            @RequestParam(value = "showInventoryOnHand", required = false) Boolean showInventoryOnHand) {

        if (showInventoryOnHand == null) {
            showInventoryOnHand = false;
        }

        if (pageNumber == null || pageNumber < 0)
            pageNumber = DEFAULT_PAGE_NUMBER;

        if (pageSize == null || pageSize < 0)
            pageSize = DEFAULT_PAGE_SIZE;

        BeerPagedList beerList = beerService.listBeers(beerName, beerStyle, PageRequest.of(pageNumber, pageSize), showInventoryOnHand);
        return new ResponseEntity<>(beerList, HttpStatus.OK);

    }


    @GetMapping("beer/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@Validated @PathVariable UUID beerId,
                                               @RequestParam(value = "showInventoryOnHand", required = false) Boolean showInventoryOnHand) {
        if (showInventoryOnHand == null) {
            showInventoryOnHand = false;
        }
        return new ResponseEntity<>(beerService.getBeerById(beerId, showInventoryOnHand), HttpStatus.OK);
    }

    @GetMapping("beerUpc/{upc}")
    public ResponseEntity<BeerDto> getBeerByUpc( @PathVariable("upc") String upc) {
        return new ResponseEntity(beerService.getByUpc(upc), HttpStatus.OK);
    }


    @PostMapping(path = "beer")
    public ResponseEntity saveNewBear(@RequestBody BeerDto beerDto) {
        return new ResponseEntity(beerService.saveNewBeer(beerDto), HttpStatus.CREATED);
    }

    @PutMapping(path = "beer/{beerId}")
    public ResponseEntity updateBeerById(@PathVariable UUID beerId, @Validated @RequestBody BeerDto beerDto) {
        return new ResponseEntity(beerService.updateBeer(beerId, beerDto), HttpStatus.NO_CONTENT);
    }
}
