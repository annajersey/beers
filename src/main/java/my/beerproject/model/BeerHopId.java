package my.beerproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class BeerHopId implements Serializable {
  @JsonIgnore
  private Beer beer;
  @JsonIgnore
  private Hop hop;

  @ManyToOne
  @JsonIgnore
  public Beer getBeer() {
    return beer;
  }

  public void setBeer(Beer beer) {
    this.beer = beer;
  }

  @ManyToOne
  @JsonIgnore
  public Hop getHop() {
    return hop;
  }

  public void setHop(Hop hop) {
    this.hop = hop;
  }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    BeerHopId that = (BeerHopId) o;

    if (beer != null ? !beer.equals(that.beer) : that.beer != null) return false;
    if (hop != null ? !hop.equals(that.hop) : that.hop != null)
      return false;

    return true;
  }

  public int hashCode() {
    int result;
    result = (beer != null ? beer.hashCode() : 0);
    result = 31 * result + (hop != null ? hop.hashCode() : 0);
    return result;
  }
}
