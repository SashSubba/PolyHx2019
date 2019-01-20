package models;

public class Attraction {
    private String name;
    private String address;
    private String phoneNumber;
    private String Schedule;
    private String website;
    private double price;
    private String GooglePlacesID;
    private String QRCode;
    private String restrictions;
    private String availableServices;
    private String privateInformation;

    private String typeOfAttraction;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
