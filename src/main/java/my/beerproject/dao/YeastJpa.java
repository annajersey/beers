package my.beerproject.dao;

import my.beerproject.model.Yeast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface YeastJpa extends JpaRepository<Yeast, Integer>  {
    List<Yeast> findAllByOrderByYeastNameAsc();
}