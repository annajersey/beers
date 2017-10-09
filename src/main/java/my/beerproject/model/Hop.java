package my.beerproject.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="hops")
public class Hop {

  @Id
  @Column(name="hop_id")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long hop_id;
  private String hop_name;
  private String hop_alias;
  private Long not_hop;

 // @ManyToMany(targetEntity = Beer.class)
//  @JoinTable(
//          name="beer_to_hop",
//          joinColumns = { @JoinColumn(name = "beer_id") },
//          inverseJoinColumns = { @JoinColumn(name = "hop_id") })
 // private List beers;

 // public List getBeers() {
    //return beers;
  //}

 // public void setBeers(List beers) {
   // this.beers = beers;
 // }

  public Long getHop_id() {
    return hop_id;
  }

  public void setHop_id(Long hop_id) {
    this.hop_id = hop_id;
  }

  public String getHop_name() {
    return hop_name;
  }

  public void setHop_name(String hop_name) {
    this.hop_name = hop_name;
  }

  public String getHop_alias() {
    return hop_alias;
  }

  public void setHop_alias(String hop_alias) {
    this.hop_alias = hop_alias;
  }

  public Long getNot_hop() {
    return not_hop;
  }

  public void setNot_hop(Long not_hop) {
    this.not_hop = not_hop;
  }
}
