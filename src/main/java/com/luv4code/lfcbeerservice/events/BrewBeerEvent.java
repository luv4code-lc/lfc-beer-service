package com.luv4code.lfcbeerservice.events;

import com.luv4code.lfcbeerservice.web.model.BeerDto;

public class BrewBeerEvent extends BeerEvent {
    public BrewBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
