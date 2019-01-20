package models.bridges;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class City_User_ID implements Serializable {
	public String userID;
	public Long cityID;

	@Override
	public int hashCode() {return (cityID + userID).hashCode();}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		City_User_ID other = (City_User_ID) obj;
		return (userID.equals(other.userID) && (cityID.equals(other.cityID)));
	}
}
