package my.beerproject.dao;



import my.beerproject.model.Beer;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
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
        //System.out.println("qqq");
       // Beer p=new Beer();
        Beer p = entityManager.find(Beer.class, id);
       // List<Beer> beerList = this.listBeers();
       // for (Beer beer:beerList
       //      ) {
       //     if(beer.getBeerId()==id){
       //          p =beer;
       //         break;
       //     }
       // }
       // System.out.println(p.getBeerToMalt());
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
    public List<Beer> searchBeersSimple(String malts,String hops,String yeasts,String search) {
        System.out.println(search);
        StringBuilder filters = new StringBuilder();
        if(search != null && !search.isEmpty()) filters.append(" AND (b.beer_name LIKE :search OR "+
        "b.beer_subname LIKE :search OR "+
        "b.beer_title LIKE :search OR "+
        "b.beer_subtitle LIKE :search OR "+
        "b.beer_description LIKE :search OR "+
        "b.food_parings LIKE :search OR "+
        "b.beer_tips LIKE :search)");

        if(malts != null && !malts.isEmpty()) filters.append("AND b2m.malt_id IN (:malts) ");
        if(hops != null && !hops.isEmpty()) filters.append("AND b2h.hop_id IN (:hops) ");
        if(yeasts != null && !yeasts.isEmpty()) filters.append("AND b2y.yeast_id IN (:yeasts) ");

        String query = "SELECT b.beer_id, (100*(COUNT(DISTINCT b2m.malt_id) + COUNT(DISTINCT b2h.hop_id))/ " +
                "(COUNT(DISTINCT b2h2.hop_id) + COUNT(DISTINCT b2m2.malt_id))" +
                ") points FROM beers as b " +
                "LEFT JOIN beer_to_hop b2h ON b.beer_id=b2h.beer_id " +
                "LEFT JOIN beer_to_malt b2m ON b.beer_id=b2m.beer_id " +
                "LEFT JOIN beer_to_hop b2h2 ON b.beer_id=b2h2.beer_id " +
                "LEFT JOIN beer_to_malt b2m2 ON b.beer_id=b2m2.beer_id " +
                "LEFT JOIN beer_to_yeast b2y ON b.beer_id=b2y.beer_id " +
                "WHERE 1=1  "+filters+
        " GROUP BY b.beer_id ORDER BY points DESC, b.brand_id ASC ";
        Query q = entityManager.createNativeQuery(query);
        if(malts != null && !malts.isEmpty()) q.setParameter("malts", malts);
        if(hops != null && !hops.isEmpty())  q.setParameter("hops",hops);
        if(yeasts != null && !yeasts.isEmpty())  q.setParameter("yeasts", yeasts);
        if(search != null && !search.isEmpty())  q.setParameter("search", '%'+search+'%');

        List<Object[]> result = q.getResultList();
        List<Beer> beers = new ArrayList<Beer>();
        for (Object[] a : result) {
           beers.add(this.getBeerById((Integer) a[0]));
        }
        return beers;
    }



}
