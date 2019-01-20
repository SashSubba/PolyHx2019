package models.bridges;

import io.ebean.Model;
import models.City;
import models.Country;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class City_Country extends Model {
	@EmbeddedId
	private City_Country_ID bridgeID;
	@ManyToOne
	@JoinColumn(name = "country", insertable = false, updatable = false)
	private Country country;
	@ManyToOne
	@JoinColumn(name = "city", insertable = false, updatable = false)
	private City city;

	City_Country(){bridgeID = new City_Country_ID();}

	public Country getCountry(){return country;}
	public void setCountry(Country aCountry) {
		country = aCountry;
		bridgeID.countryID = aCountry.getId();
	}
	public City getCity() {return city;}
	public void setCity(City aCity) {
		city = aCity;
		bridgeID.cityID = aCity.getId();
	}
}