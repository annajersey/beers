package my.beerproject;

import my.beerproject.model.Beer;
import my.beerproject.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("json")
public class JsonController {
    private BeerService beerService;
    @Autowired(required = true)
    @Qualifier(value = "beerService")
    public void setBeerService(BeerService ps) {
        this.beerService = ps;
    }
    @RequestMapping(value="nameorsubname/{name}", method = RequestMethod.GET)
    public @ResponseBody
    List<Beer> findByBeerNameIsOrbeerSubNameEquals(@PathVariable String name) {
        List<Beer> beers = this.beerService.findByBeerNameIsOrBeerSubNameEquals(name,name);
        return beers;
    }
    @RequestMapping(value="name/{name}", method = RequestMethod.GET)
    public @ResponseBody List<Beer> getBeerByName(@PathVariable String name) {
        List<Beer> beers = this.beerService.getBeerByName(name);
        return beers;
    }
    @RequestMapping(value="namelike/{name}", method = RequestMethod.GET)
    public @ResponseBody List<Beer> findByBeerNameLikeOrderByBeerNameAsc(@PathVariable String name) {
        List<Beer> beers = this.beerService.findByBeerNameLikeOrderByBeerNameAsc(name);
        return beers;
    }

    @RequestMapping(value="search")
    public @ResponseBody List<Beer> searchBeers(
            @RequestParam(required = false) String malts,
            @RequestParam( required = false) String hops,
            @RequestParam( required = false) String yeasts,
            @RequestParam( required = false) String search){
        List<Beer> beers = this.beerService.searchBeers(malts,hops,yeasts,search);
        return beers;
    }
}
