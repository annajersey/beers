package my.beerproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="hops")
public class Hop {

  @Id
  @Column(name="hop_id")
  @JsonProperty("id")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long hop_id;
  @JsonProperty("name")
  @Column(name="hop_name")
  private String hopName;
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

  public String getHopName() {
    return hopName;
  }

  public void setHopName(String hopName) {
    this.hopName = hopName;
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
