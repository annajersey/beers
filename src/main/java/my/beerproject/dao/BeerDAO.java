package my.beerproject.dao;



import my.beerproject.model.Beer;
import my.beerproject.model.Hop;

import java.util.List;

public interface BeerDAO{

    public void addBeer(Beer p);
    public void updateBeer(Beer p);
    public List<Beer> listBeers();
    public Beer getBeerById(int id);
    public void removeBeer(int id);

}