package my.beerproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Malt {

  @Id
  @Column(name="malt_id")
  @JsonProperty("id")
 @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long maltId;

    @JsonProperty("name")
    @Column(name="malt_name")
  private String maltName;
    @Column(name="not_malt")
  private long notMalt;

  public long getMaltId() {
    return maltId;
  }

  public void setMaltId(long maltId) {
    this.maltId = maltId;
  }


  public String getMaltName() {
    return maltName;
  }

  public void setMaltName(String maltName) {
    this.maltName = maltName;
  }


  public long getNotMalt() {
    return notMalt;
  }

  public void setNotMalt(long notMalt) {
    this.notMalt = notMalt;
  }




    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "pk.malt", cascade=CascadeType.ALL)

    @JsonBackReference
    private Set<BeerToMalt> beerToMalt = new HashSet<BeerToMalt>(0);

    public Set<BeerToMalt> getBeerToMalt() {
        return this.beerToMalt;
    }

}
