package models.categories;

import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AttractionType extends Model {
    public static final Finder<Long,AttractionType> find = new Finder<>(AttractionType.class);
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long ID;
    @Column(name = "enName", nullable = false)
    private String en;
    @Column(name = "frName", nullable = false)
    private String fr;

    public String getEn() {return en;}
    public void setEn(String en) {this.en = en;}
    public String getFr() {return fr;}
    public void setFr(String fr) {this.fr = fr;}
    public Long getID() {return ID;}
    public void setID(Long ID) {this.ID = ID;}

    @Override
    public String toString() {return en;}
    public String toString(String language) {
        if (language.equalsIgnoreCase("fr")) return fr;
        return en;
    }
}