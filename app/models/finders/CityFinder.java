package models.finders;

import io.ebean.Finder;
import models.City;

public class CityFinder extends Finder<Long, City> {
	public CityFinder(){super(City.class);}
}
