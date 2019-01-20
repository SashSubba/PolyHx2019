package models;

import io.ebean.Finder;
import io.ebean.Model;
import models.bridges.City_Country;
import models.bridges.City_User;

import javax.persistence.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "cities")
public class City extends Model {
    public static final Finder<Long, City> find = new Finder<>(City.class);
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "enName", nullable = false)
    private String en;
    @Column(name = "frName", nullable = false)
    private String fr;
    @ManyToOne(optional = false)
    @Column(name = "country", nullable = false)
    private Country country;
    @OneToMany(mappedBy = "city")
    private List<City_User> managers = new LinkedList<>();

    public Long getId() {return id;}
    //public void setId(Long id) {this.id = id;}
    public String getEn() {return en;}
    public void setEn(String en) {this.en = en;}
    public String getFr() {return fr;}
    public void setFr(String fr) {this.fr = fr;}
    public Country getCountry() {return country;}
    public void setCountry(Country country) {this.country = country;}
    @Override
    public String toString(){return en;}
    public String toString(String language){
        if(language.equalsIgnoreCase("fr")) return fr;
        return en;
    }
    public Iterator<City_User> getManagers(){return managers.iterator();}
}
