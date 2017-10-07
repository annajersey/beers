package my.beerproject.dao;



import my.beerproject.model.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BeerDAO{

    public void addBeer(Beer p);
    public void updateBeer(Beer p);
    public List<Beer> listBeers();
    public Beer getBeerById(int id);
    public void removeBeer(int id);

}