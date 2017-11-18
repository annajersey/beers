package my.beerproject.dao;

import my.beerproject.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BeerJpa extends JpaRepository<Beer, Integer>  {
    List<Beer> findByBeerName(String beerName);
    List<Beer> findByBeerNameIsOrBeerSubNameEquals(String value, String value2);
    List<Beer> findByBeerNameLikeIgnoreCase(String beerName);
    Beer findByBeerId(int id);
}