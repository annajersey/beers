package my.beerproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

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


}
