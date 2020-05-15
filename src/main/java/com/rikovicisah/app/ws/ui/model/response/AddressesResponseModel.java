package com.rikovicisah.app.ws.ui.model.response;

import com.rikovicisah.app.ws.shared.dto.UserDTO;

public class AddressesResponseModel {
    private String addressId;
    private String city;
    private String country;
    private String streetName;
    private String postalCode;

    public AddressesResponseModel(){}

    public AddressesResponseModel(String addressId, String city, String country, String streetName, String postalCode) {
        this.addressId = addressId;
        this.city = city;
        this.country = country;
        this.streetName = streetName;
        this.postalCode = postalCode;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
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
