package my.beerproject;

import my.beerproject.dao.BeerDAO;
import my.beerproject.model.Beer;
import my.beerproject.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.List;

@Controller

public class BeerController {

    private BeerService beerService;


    @Autowired(required = true)
    @Qualifier(value = "beerService")
    public void setBeerService(BeerService ps) {
        this.beerService = ps;
    }

//    @RequestMapping("/")
//    public String Home(Model model){
//        List<Beer> beers = this.beerService.getBeerByName("PUNK IPA");
//        model.addAttribute("beer", new Beer());
//        model.addAttribute("listBeers", beers);
//        return "beers";
//    }

    @RequestMapping(value="jsontest/{name}", method = RequestMethod.GET)
    public @ResponseBody List<Beer> getBeerInJSON(@PathVariable String name) {
        List<Beer> beers = this.beerService.getBeerByName(name);
        return beers;
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listBeers(Model model) {
        System.out.println("test");

        model.addAttribute("beer", new Beer());
        model.addAttribute("listBeers", this.beerService.listBeers());
        for(Beer p : this.beerService.listBeers()){
            System.out.println(p);
        }
        return "beers";
    }

    //For add and update person both
    @RequestMapping(value = "/beers/add", method = RequestMethod.POST)
    public String addBeer(@ModelAttribute("beer") Beer p) {

        if (p.getBeerId() == 0) {
            //new person, add it
            this.beerService.addBeer(p);
        } else {
            //existing person, call update
            this.beerService.updateBeer(p);
        }

        return "redirect:/";

    }

    @RequestMapping("/remove/{id}")
    public String removeBeer(@PathVariable("id") int id) {

        this.beerService.removeBeer(id);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public String editBeer(@PathVariable("id") int id, Model model) {
        model.addAttribute("beer", this.beerService.getBeerById(id));

        model.addAttribute("listBeers", this.beerService.listBeers());
        return "beers";
    }
}