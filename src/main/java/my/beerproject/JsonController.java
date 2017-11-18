package my.beerproject;

import my.beerproject.dao.BeerJpa;
import my.beerproject.dao.HopJpa;
import my.beerproject.dao.MaltJpa;
import my.beerproject.dao.YeastJpa;
import my.beerproject.model.Beer;
import my.beerproject.model.Hop;
import my.beerproject.model.Malt;
import my.beerproject.model.Yeast;
import my.beerproject.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("json")
@RestController
@CrossOrigin
public class JsonController {
    @Autowired
    private BeerService beerService;
   // @Autowired(required = true)
   // @Qualifier(value = "beerService")
   // public void setBeerService(BeerService ps) {
        //this.beerService = ps;
    //}
    @Autowired
    private HopJpa hopJpa;
    @Autowired
    private MaltJpa maltJpa;
    @Autowired
    private YeastJpa yeastJpa;
    @Autowired
    private BeerJpa beerJpa;
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
    @CrossOrigin
    public @ResponseBody List<Beer> searchBeers(
            @RequestParam(required = false) String malts,
            @RequestParam( required = false) String hops,
            @RequestParam( required = false) String yeasts,
            @RequestParam( required = false) String search){
        List<Beer> beers = this.beerService.searchBeers(malts,hops,yeasts,search);
        return beers;
    }

    @RequestMapping(value="hops", method = RequestMethod.GET)
    public @ResponseBody List<Hop> getAllHops() {
        List<Hop> hops =  this.hopJpa.findAllByOrderByHopNameAsc();
        return hops;
    }

    @RequestMapping(value="malts", method = RequestMethod.GET)
    public @ResponseBody List<Malt> getAllMalts() {
        List<Malt> malts=  this.maltJpa.findAllByOrderByMaltNameAsc();
        return malts;
    }

    @RequestMapping(value="yeasts", method = RequestMethod.GET)
    public @ResponseBody List<Yeast> getAllYeasts() {
        List<Yeast> yeasts=  this.yeastJpa.findAllByOrderByYeastNameAsc();
        return yeasts;
    }

    @RequestMapping(value="beer/{beerId}", method = RequestMethod.GET)
    public @ResponseBody Beer getBeer(@PathVariable int beerId) {
        Beer beer=  this.beerService.getBeerById(beerId);
        //Beer beer = this.beerJpa.findByBeerId(beerId);
        return beer;
    }
}
