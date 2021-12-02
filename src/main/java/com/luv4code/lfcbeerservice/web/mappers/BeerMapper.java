package com.luv4code.lfcbeerservice.web.mappers;

import com.luv4code.lfcbeerservice.domain.Beer;
import com.luv4code.lfcbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);

    Beer BeerDtoToBeer(BeerDto beerDto);
}
