package my.beerproject.service;


import my.beerproject.dao.BeerDAO;
import my.beerproject.dao.BeerJpa;
import my.beerproject.model.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BeerServiceImpl implements BeerService {
    @Autowired
    private BeerDAO beerDAO;

  @Autowired
  private BeerJpa BeerJpa;

    @Transactional
    public void addBeer(Beer p) {
        BeerJpa.saveAndFlush(p);
        //this.beerDAO.addBeer(p);
    }


    @Transactional
    public void updateBeer(Beer p) {
        this.beerDAO.updateBeer(p);
    }


    @Transactional
    public List<Beer> listBeers() {
        return this.beerDAO.listBeers();
    }


    @Transactional
    public Beer getBeerById(int id) {
        return this.beerDAO.getBeerById(id);
    }

    @Override
    @Transactional
    public void removeBeer(int id) {
        this.beerDAO.removeBeer(id);
    }

    @Transactional
    public List<Beer> getBeerByName(String beerName) {
        //System.out.println(beerName);
        //System.out.println(this.BeerJpa.findByBeerName(beerName));
        return this.BeerJpa.findByBeerName(beerName);
    }
    @Transactional
    public List<Beer> findByBeerNameIsOrBeerSubNameEquals(String beerName,String beerSubName){
        return this.BeerJpa.findByBeerNameIsOrBeerSubNameEquals(beerName,beerSubName);
    }
    @Transactional
    public List<Beer> findByBeerNameLikeOrderByBeerNameAsc(String beerName){
        return this.BeerJpa.findByBeerNameLikeIgnoreCase("%"+beerName+"%");
    }
    @Transactional
    public List<Beer> searchBeers(String malts, String hops, String yeasts,String search){
        return this.beerDAO.searchBeersSimple(malts,hops,yeasts, search);
    }


}
