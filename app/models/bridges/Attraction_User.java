package models.bridges;

import io.ebean.Model;
import models.Attraction;
import models.User;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Attraction_User extends Model {
	@EmbeddedId
	private Attraction_User_ID bridgeID;
	@ManyToOne
	@JoinColumn(name = "attraction", insertable = false, updatable = false)
	private Attraction attraction;
	@ManyToOne
	@JoinColumn(name = "user", insertable = false, updatable = false)
	private User user;

	Attraction_User() {bridgeID = new Attraction_User_ID();}

	public Attraction getAttraction() {return attraction;}
	public void setAttraction(Attraction attraction) {
		this.attraction = attraction;
		bridgeID.attractionID = attraction.getId();
	}
	public User getUser() {return user;}
	public void setUser(User user) {
		this.user = user;
		bridgeID.userID = user.getEmail();
	}
}
