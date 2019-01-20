package models.ghosts;

import models.City;

public class CityGhost {
    public Long id;
    public String en;
    public String fr;
    public String country;

    public CityGhost() {}
    public CityGhost(City c){
        id = c.getId();
        en = c.getEn();
        fr = c.getFr();
        country = c.getCountry().getId().toString();
    }
}
