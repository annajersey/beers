package my.beerproject.dao;

import my.beerproject.model.Beer;
import my.beerproject.model.Hop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HopJpa extends JpaRepository<Hop, Integer>  {
    List<Hop> findAllByOrderByHopNameAsc();
}