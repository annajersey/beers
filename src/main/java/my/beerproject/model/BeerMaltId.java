package my.beerproject.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BeerMaltId implements Serializable {
  private Beer beer;
  private Malt malt;

  @ManyToOne
  public Beer getBeer() {
    return beer;
  }

  public void setBeer(Beer beer) {
    this.beer = beer;
  }

  @ManyToOne
  public Malt getMalt() {
    return malt;
  }

  public void setMalt(Malt malt) {
    this.malt = malt;
  }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    BeerMaltId that = (BeerMaltId) o;

    if (beer != null ? !beer.equals(that.beer) : that.beer != null) return false;
    if (malt != null ? !malt.equals(that.malt) : that.malt != null)
      return false;

    return true;
  }

  public int hashCode() {
    int result;
    result = (beer != null ? beer.hashCode() : 0);
    result = 31 * result + (malt != null ? malt.hashCode() : 0);
    return result;
  }
}
