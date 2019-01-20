package models.bridges;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class City_Country_ID implements Serializable {
	public Long cityID;
	public Long countryID;

	@Override
	public int hashCode(){return (cityID.hashCode() + countryID.hashCode());}
	@Override
	public boolean equals(Object obj){
		if (this == obj) return true;
		if (obj == null) return false;
		City_Country_ID other = (City_Country_ID) obj;
		return (cityID.equals(other.cityID) && countryID.equals(other.countryID));
	}
}
