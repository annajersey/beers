package my.beerproject.service;


import my.beerproject.model.Beer;

import java.util.List;

public interface BeerService {

    public void addBeer(Beer p);
    public void updateBeer(Beer p);
    public List<Beer> listBeers();
    public Beer getBeerById(int id);
    public void removeBeer(int id);

    List<Beer> getBeerByName(String s);

    List<Beer> findByBeerNameIsOrBeerSubNameEquals(String name, String subName);
    List<Beer>  findByBeerNameLikeOrderByBeerNameAsc(String s);
}