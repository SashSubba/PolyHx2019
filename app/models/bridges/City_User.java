package models.bridges;

import io.ebean.Model;
import models.City;
import models.User;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class City_User extends Model {
	@EmbeddedId
	private City_User_ID bridgeID;
	@ManyToOne
	@JoinColumn(name = "user", insertable = false, updatable = false)
	private User user;
	@ManyToOne
	@JoinColumn(name = "city", insertable = false, updatable = false)
	private City city;

	City_User(){bridgeID = new City_User_ID();}

	public User getUser() {return user;}
	public void setUser(User aUser){
		user = aUser;
		bridgeID.userID = aUser.getEmail();
	}
	public City getCity() {return city;}
	public void setCity(City aCity) {
		city = aCity;
		bridgeID.cityID = aCity.getId();
	}
}