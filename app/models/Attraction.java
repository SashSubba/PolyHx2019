package models;

import io.ebean.Finder;
import io.ebean.Model;
import models.bridges.Attraction_User;
import models.categories.AttractionType;
import models.compoundKeys.Address;

import javax.persistence.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Attraction extends Model {
    public static final Finder<Long, Attraction> find = new Finder<>(Attraction.class);
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
    @Column(name = "isClosed", nullable = false)
    private boolean isClosed;
    @OneToMany(mappedBy = "attraction")
    private List<Attraction_User> managers = new LinkedList<>();


    public Long getId(){return id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    public String getWebsite() {return website;}
    public void setWebsite(String website) {this.website = website;}
    public String getGooglePlacesID() {return GooglePlacesID;}
    public void setGooglePlacesID(String googlePlacesID) {GooglePlacesID = googlePlacesID;}
    public String getQRCode() {return QRCode;}
    public void setQRCode(String QRCode) {this.QRCode = QRCode;}
    public String getRestrictions() {return restrictions;}
    public void setRestrictions(String restrictions) {this.restrictions = restrictions;}
    public String getAvailableServices() {return availableServices;}
    public void setAvailableServices(String availableServices) {this.availableServices = availableServices;}
    public String getPrivateInformation() {return privateInformation;}
    public void setPrivateInformation(String privateInformation) {this.privateInformation = privateInformation;}
    public AttractionType getTypeOfAttraction() {return typeOfAttraction;}
    public void setTypeOfAttraction(AttractionType typeOfAttraction) {this.typeOfAttraction = typeOfAttraction;}
    public Address getAddress() {return address;}
    public void setAddress(Address address) {this.address = address;}
    public boolean isClosed() {return isClosed;}
    public void setClosed(boolean closed) {isClosed = closed;}
    public Iterator<Attraction_User> getManagers(){return managers.iterator();}
}
