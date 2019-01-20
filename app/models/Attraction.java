package models;

import io.ebean.Model;
import models.categories.AttractionType;
import models.compoundKeys.Address;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Attraction extends Model {
    @Id
    @Column(name = "id", nullable = false, columnDefinition = "identity")
    private Long id;
    @Column(name = "attractionName", nullable = false)
    private String name;
    @Embedded
    private Address address;
    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;
    @Column(name = "website", nullable = false)
    private String website;
    @Column(name = "GooglePlacesID", nullable = false)
    private String GooglePlacesID;
    private String QRCode;
    @Column(name = "restrictions", nullable = false)
    private String restrictions;
    @Column(name = "availableServices", nullable = false)
    private String availableServices;
    @Column(name = "privateInformation", nullable = false)
    private String privateInformation;
    @Column(name = "typeOfAttraction", nullable = false)
    private AttractionType typeOfAttraction;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSchedule() {
        return Schedule;
    }

    public void setSchedule(String schedule) {
        Schedule = schedule;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGooglePlacesID() {
        return GooglePlacesID;
    }

    public void setGooglePlacesID(String googlePlacesID) {
        GooglePlacesID = googlePlacesID;
    }

    public String getQRCode() {
        return QRCode;
    }

    public void setQRCode(String QRCode) {
        this.QRCode = QRCode;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    public String getAvailableServices() {
        return availableServices;
    }

    public void setAvailableServices(String availableServices) {
        this.availableServices = availableServices;
    }

    public String getPrivateInformation() {
        return privateInformation;
    }

    public void setPrivateInformation(String privateInformation) {
        this.privateInformation = privateInformation;
    }


    public String getTypeOfAttraction() {
        return typeOfAttraction;
    }

    public void setTypeOfAttraction(String typeOfAttraction) {
        this.typeOfAttraction = typeOfAttraction;
    }
}
