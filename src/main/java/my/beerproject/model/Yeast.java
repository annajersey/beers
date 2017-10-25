package my.beerproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Yeast {
  @Id
  @Column(name="yeast_id")
  @JsonProperty("id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long yeastId;
  @JsonProperty("name")
  @Column(name="yeast_name")
  private String yeastName;

  public Long getYeastId() {
    return yeastId;
  }

  public void setYeastId(Long yeastId) {
    this.yeastId = yeastId;
  }

  public String getYeastName() {
    return yeastName;
  }

  public void setYeastName(String yeastName) {
    this.yeastName = yeastName;
  }
}
