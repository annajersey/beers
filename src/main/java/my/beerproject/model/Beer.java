package my.beerproject.model;

import javax.persistence.*;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 *
 */
@Entity
@Table(name="beers")
public class Beer {

    @Id
    @Column(name="beer_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int beerId;

    @Column(name="beer_name")
    private String beerName;

    @Column(name="beer_subname")
    private String beerSubName;

    @Column(name="beer_since")
    private String beerSince="";

    @Column(name="beer_title")
    private String beerTitle="";

    @Column(name="beer_subtitle")
    private String beerSubTitle="";

    @Column(name="beer_description")
    private String beerDescription="";

    @Column(name="beer_article")
    private String beerArticle="";

    @Column(name="beer_tips")
    private String beerTips="";

    @Column(name="beer_collaboration")
    private String beerCollaboration="";

    private Double basics_volume=0.0;

    public Beer() {
    }

    public String getBeerSince() {
        return beerSince;
    }

    public void setBeerSince(String beerSince) {
        this.beerSince = beerSince;
    }

    public String getBeerTitle() {
        return beerTitle;
    }

    public void setBeerTitle(String beerTitle) {
        this.beerTitle = beerTitle;
    }

    public String getBeerSubTitle() {
        return beerSubTitle;
    }

    public void setBeerSubTitle(String beerSubTitle) {
        this.beerSubTitle = beerSubTitle;
    }

    public String getBeerDescription() {
        return beerDescription;
    }

    public void setBeerDescription(String beerDescription) {
        this.beerDescription = beerDescription;
    }

    public String getBeerArticle() {
        return beerArticle;
    }

    public void setBeerArticle(String beerArticle) {
        this.beerArticle = beerArticle;
    }

    public String getBeerTips() {
        return beerTips;
    }

    public void setBeerTips(String beerTips) {
        this.beerTips = beerTips;
    }

    public String getBeerCollaboration() {
        return beerCollaboration;
    }

    public void setBeerCollaboration(String beerCollaboration) {
        this.beerCollaboration = beerCollaboration;
    }

    public Double getBasics_volume() {
        return basics_volume;
    }

    public void setBasics_volume(Double basics_volume) {
        this.basics_volume = basics_volume;
    }

    public Double getBasics_boil_volume() {
        return basics_boil_volume;
    }

    public void setBasics_boil_volume(Double basics_boil_volume) {
        this.basics_boil_volume = basics_boil_volume;
    }

    public Double getBasics_abv() {
        return basics_abv;
    }

    public void setBasics_abv(Double basics_abv) {
        this.basics_abv = basics_abv;
    }

    public Double getBasics_target_fg() {
        return basics_target_fg;
    }

    public void setBasics_target_fg(Double basics_target_fg) {
        this.basics_target_fg = basics_target_fg;
    }

    public Double getBasics_target_og() {
        return basics_target_og;
    }

    public void setBasics_target_og(Double basics_target_og) {
        this.basics_target_og = basics_target_og;
    }

    public Double getBasics_ebc() {
        return basics_ebc;
    }

    public void setBasics_ebc(Double basics_ebc) {
        this.basics_ebc = basics_ebc;
    }

    public Double getBasics_srm() {
        return basics_srm;
    }

    public void setBasics_srm(Double basics_srm) {
        this.basics_srm = basics_srm;
    }

    public Double getBasics_ph() {
        return basics_ph;
    }

    public void setBasics_ph(Double basics_ph) {
        this.basics_ph = basics_ph;
    }

    public Double getBasics_attenuation_level() {
        return basics_attenuation_level;
    }

    public void setBasics_attenuation_level(Double basics_attenuation_level) {
        this.basics_attenuation_level = basics_attenuation_level;
    }

    public Double getHeading_ibu() {
        return heading_ibu;
    }

    public void setHeading_ibu(Double heading_ibu) {
        this.heading_ibu = heading_ibu;
    }

    public Double getHeading_abv() {
        return heading_abv;
    }

    public void setHeading_abv(Double heading_abv) {
        this.heading_abv = heading_abv;
    }

    public String getMethod_mash_temp() {
        return method_mash_temp;
    }

    public void setMethod_mash_temp(String method_mash_temp) {
        this.method_mash_temp = method_mash_temp;
    }

    public String getMethod_fermentation() {
        return method_fermentation;
    }

    public void setMethod_fermentation(String method_fermentation) {
        this.method_fermentation = method_fermentation;
    }

    public String getMethod_twist() {
        return method_twist;
    }

    public void setMethod_twist(String method_twist) {
        this.method_twist = method_twist;
    }

    public String getFood_parings() {
        return food_parings;
    }

    public void setFood_parings(String food_parings) {
        this.food_parings = food_parings;
    }

    private Double basics_boil_volume=0.0;
    private Double basics_abv=0.0;
    private Double basics_target_fg=0.0;
    private Double basics_target_og=0.0;
    private Double basics_ebc=0.0;
    private Double basics_srm=0.0;
    private Double basics_ph=0.0;
    private Double basics_attenuation_level=0.0;
    private Double heading_ibu=0.0;
    private Double heading_abv=0.0;
    private String method_mash_temp="";
    private String method_fermentation="";
    private String method_twist="";
    private String food_parings="";

    public int getBeerId() {
        return beerId;
    }

    public void setBeerId(int beerId) {
        this.beerId = beerId;
    }

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public String getBeerSubName() {
        return beerSubName;
    }

    public void setBeerSubName(String beerSubName) {
        this.beerSubName = beerSubName;
    }

    public List getHops() {
        return hops;
    }

    public void setHops(List hops) {
        this.hops = hops;
    }


    @ManyToMany(targetEntity=Hop.class,fetch = FetchType.EAGER)
    @JoinTable(
            name="beer_to_hop",
            joinColumns = { @JoinColumn(name = "beer_id") },
            inverseJoinColumns = { @JoinColumn(name = "hop_id") })
    private List hops;

    public List getMalts() {
        return malts;
    }
    public StringBuilder getMaltsString() {
        StringBuilder sb = new StringBuilder();

        for (Iterator<Malt> it = this.malts.iterator(); it.hasNext(); ) {
            sb.append(it.next().getMaltName());
            if (it.hasNext()) {
                sb.append(",");
            }
        }
        return sb;
    }
    public void setMalts(List malts) {
        this.malts = malts;
    }

    @ManyToMany(targetEntity = Malt.class,fetch=FetchType.EAGER)
    @JoinTable(
            name="beer_to_malt",
            joinColumns = {@JoinColumn(name="beer_id")},
            inverseJoinColumns = {@JoinColumn(name="malt_id")}
    )
    private List<Malt> malts;


    @Override
    public String toString(){
        return "id="+beerId+", beerName="+beerName+", beerSubName="+beerSubName;
    }
}