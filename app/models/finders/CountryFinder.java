package models.finders;

import io.ebean.Finder;
import models.Country;

public class CountryFinder extends Finder<String, Country> {
	public CountryFinder() {super(Country.class);}
}
