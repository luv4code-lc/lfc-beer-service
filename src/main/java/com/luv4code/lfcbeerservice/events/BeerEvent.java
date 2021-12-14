package com.luv4code.lfcbeerservice.events;

import com.luv4code.lfcbeerservice.web.model.BeerDto;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@RequiredArgsConstructor
public class BeerEvent implements Serializable {
    private final long serialVersionUID = -895956677169828371L;
    private final BeerDto beerDto;

}
