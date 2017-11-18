package my.beerproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="beer_to_hop")
@AssociationOverrides({
        @AssociationOverride(name = "pk.beer", joinColumns = @JoinColumn(name = "beer_id")),
        @AssociationOverride(name = "pk.hop", joinColumns = @JoinColumn(name = "hop_id")) })

public class BeerToHop implements Serializable {
  @JsonIgnore
  private BeerHopId pk = new BeerHopId();
  private Double g;

  @Column(name = "g")
  public Double getG() {
    return g;
  }

  public void setG(Double g) {
    this.g = g;
  }
  @Column(name = "add")
  public String getAdd() {
    return add;
  }

  public void setAdd(String add) {
    this.add = add;
  }

  public String getAttribute() {
    return attribute;
  }

  public void setAttribute(String attribute) {
    this.attribute = attribute;
  }

  private String add;
  private String attribute;
  private long order;

  public BeerToHop() {
  }

  @EmbeddedId
  @JsonIgnore
  public BeerHopId getPk() {
    return pk;
  }

  public void setPk(BeerHopId pk) {
    this.pk = pk;
  }

  @Transient
  @JsonIgnore

  public Beer getBeer() {
    return getPk().getBeer();
  }

  public void setBeer(Beer beer) {
    getPk().setBeer(beer);
  }

  @Transient

  public Hop getHop() {
    return getPk().getHop();
  }

  public void setHop(Hop hop) {
    getPk().setHop(hop);
  }

  @Column(name = "order", nullable = false, length = 10, updatable = false)
  public long getOrder() {
    return this.order;
  }

  public void setOrder(long order) {
    this.order = order;
  }

  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    BeerToHop that = (BeerToHop) o;

    if (getPk() != null ? !getPk().equals(that.getPk())
            : that.getPk() != null)
      return false;

    return true;
  }

  public int hashCode() {
    return (getPk() != null ? getPk().hashCode() : 0);
  }
}
