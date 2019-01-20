package models.compoundKeys;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Address implements Serializable {
	public String number;
	public String unit;
	public String street;
	public String postalCode;
	public String province;
	public String city;
	public String country;

	@Override
	public String toString(){
		String answer = "";
		if(unit != null && !unit.equals("")){answer = unit + "-";}
		return answer + number + " " + street + ", " + city + ", " + province + " " + postalCode + ", " + country;
	}
	@Override
	public int hashCode(){return toString().hashCode();}
	@Override
	public boolean equals(Object obj){
		if(this==obj) return true;
		if(obj==null) return false;
		Address other = (Address)obj;
		return (number.equals(other.number) && unit.equals(other.unit) && street.equals(other.street)
				&& postalCode.equals(other.postalCode) && province.equals(other.province)
				&& city.equals(other.city) && country.equals(other.country));
	}
}