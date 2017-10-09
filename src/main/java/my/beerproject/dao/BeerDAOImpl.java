package my.beerproject.dao;


import my.beerproject.model.Beer;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BeerDAOImpl implements BeerDAO {

   // private static final Logger logger = LoggerFactory.getLogger(BeerDAOImpl.class);
   @PersistenceContext
   private EntityManager entityManager;

   // private SessionFactory sessionFactory;

   // public void setSessionFactory(SessionFactory sf){
    //    this.sessionFactory = sf;
   // }


    public void addBeer(Beer p) {
        //Session session = this.sessionFactory.getCurrentSession();
        //session.persist(p);
        //logger.info("Person saved successfully, Person Details="+p);
        entityManager.persist(p);
        entityManager.flush();
    }


    public void updateBeer(Beer p) {
        //Session session = this.sessionFactory.getCurrentSession();
        //session.update(p);
        //logger.info("Person updated successfully, Person Details="+p);
        entityManager.merge(p);
        entityManager.flush();
    }

    @SuppressWarnings("unchecked")

    public List<Beer> listBeers() {
        //Session session = this.sessionFactory.getCurrentSession();
        List<Beer> beerList = entityManager.createQuery("from Beer").getResultList();
        //Hibernate.initialize(p.getHops());
        //for(Beer p : beerList){
       //     System.out.println(p);
       // }
        return beerList;
    }


    public Beer getBeerById(int id) {
        //Session session = this.sessionFactory.getCurrentSession();
        //Beer p = (Beer) session.load(Beer.class, new Integer(id));
        Beer p = entityManager.find(Beer.class, id);

        System.out.println(p.getHops());
       // System.out.println(p);
        //logger.info("Person loaded successfully, Person details="+p);
        return p;
    }

    @Transactional
    public void removeBeer(int id) {
        //Session session = this.sessionFactory.getCurrentSession();
        //Beer p = (Beer) session.load(Beer.class, new Integer(id));
        //if(null != p){
         //   session.delete(p);
        //}
       // logger.info("Person deleted successfully, person details="+p);
        Beer p = entityManager.find(Beer.class, id);

        entityManager.remove(p);
        entityManager.flush();
    }



}
