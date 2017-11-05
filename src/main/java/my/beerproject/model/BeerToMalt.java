package my.beerproject.model;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="beer_to_malt")
@AssociationOverrides({
        @AssociationOverride(name = "pk.beer", joinColumns = @JoinColumn(name = "beer_id")),
        @AssociationOverride(name = "pk.malt", joinColumns = @JoinColumn(name = "malt_id")) })

public class BeerToMalt implements Serializable {
  private BeerMaltId pk = new BeerMaltId();
  private String weight;
  private long order;

  public BeerToMalt() {
  }

  @EmbeddedId
  public BeerMaltId getPk() {
    return pk;
  }

  public void setPk(BeerMaltId pk) {
    this.pk = pk;
  }

  @Transient
  public Beer getBeer() {
    return getPk().getBeer();
  }

  public void setBeer(Beer beer) {
    getPk().setBeer(beer);
  }

  @Transient
  public Malt getMalt() {
    return getPk().getMalt();
  }

  public void setMalt(Malt malt) {
    getPk().setMalt(malt);
  }


  @Column(name = "weight", nullable = false, length = 128, updatable = false)
  public String getWeight() {
    return this.weight;
  }

  public void setWeight(String weight) {
    this.weight = weight;
  }

  @Column(name = "order", nullable = false, length = 10, updatable = false)
  public long getOrder() {
    return this.order;
  }

  public void setOrder(long createdBy) {
    this.order = order;
  }

  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    BeerToMalt that = (BeerToMalt) o;

    if (getPk() != null ? !getPk().equals(that.getPk())
            : that.getPk() != null)
      return false;

    return true;
  }

  public int hashCode() {
    return (getPk() != null ? getPk().hashCode() : 0);
  }
}
