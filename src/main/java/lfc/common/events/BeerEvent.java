package lfc.common.events;

import com.luv4code.lfcbeerservice.web.model.BeerDto;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BeerEvent implements Serializable {
    private final long serialVersionUID = -895956677169828371L;
    private BeerDto beerDto;

}
