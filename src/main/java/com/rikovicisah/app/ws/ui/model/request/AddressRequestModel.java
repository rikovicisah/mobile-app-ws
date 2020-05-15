package com.rikovicisah.app.ws.ui.model.request;

public class AddressRequestModel {
    private String city;
    private String country;
    private String streetName;
    private String postalCode;

    public AddressRequestModel(){}

    public AddressRequestModel(String city, String country, String streetName, String postalCode) {
        this.city = city;
        this.country = country;
        this.streetName = streetName;
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
