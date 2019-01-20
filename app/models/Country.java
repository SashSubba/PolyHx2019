package models;

import io.ebean.Finder;
import io.ebean.Model;
import models.bridges.City_Country;

import javax.persistence.*;
import java.util.List;

@Entity
public class Country extends Model {
	public static final Finder<Long, Country> find = new Finder<>(Country.class);
	@Id
	@Column(name = "id", nullable = false, columnDefinition = "identity")
	private Long id;
	@Column(name = "enName", nullable = false)
	private String en;
	@Column(name = "frName", nullable = false)
	private String fr;
	@OneToMany(mappedBy = "country")
	List<City_Country> cities;

	public Long getId() {return id;}
	//public void setId(Long id) {this.id = id;}
	public String getEn() {return en;}
	public void setEn(String en) {this.en = en;}
	public String getFr() {return fr;}
	public void setFr(String fr) {this.fr = fr;}

	@Override
	public String toString() {return en;}
	public String toString(String language) {
		if (language.equalsIgnoreCase("fr")) return fr;
		return en;
	}
}