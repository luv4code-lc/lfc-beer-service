package com.luv4code.lfcbeerservice.services;

import com.luv4code.lfcbeerservice.web.model.BeerDto;
import com.luv4code.lfcbeerservice.web.model.BeerPagedList;
import com.luv4code.lfcbeerservice.web.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest);
}
