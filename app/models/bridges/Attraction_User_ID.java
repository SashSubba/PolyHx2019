package models.bridges;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Attraction_User_ID implements Serializable {
	public Long attractionID;
	public String userID;

	@Override
	public int hashCode() {
		return (attractionID + userID).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		City_Country_ID other = (City_Country_ID) obj;
		return (attractionID.equals(other.cityID) && userID.equals(other.countryID));
	}
}
