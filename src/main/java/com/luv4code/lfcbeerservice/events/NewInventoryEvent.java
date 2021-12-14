package com.luv4code.lfcbeerservice.events;

import com.luv4code.lfcbeerservice.web.model.BeerDto;

public class NewInventoryEvent extends BeerEvent {
    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
