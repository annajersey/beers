package my.beerproject.dao;

import my.beerproject.model.Hop;
import my.beerproject.model.Malt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MaltJpa extends JpaRepository<Malt, Integer>  {
    List<Malt> findAllByOrderByMaltNameAsc();
}