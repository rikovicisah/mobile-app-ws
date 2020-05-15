package com.rikovicisah.app.ws.shared.dto;

public class AddressDTO {
    private long id;
    private String addressId;
    private String city;
    private String country;
    private String streetName;
    private String postalCode;
    private UserDTO userDetails;

    public AddressDTO(){}
    public AddressDTO(long id, String addressId, String city, String country, String streetName, String postalCode, UserDTO userDetails) {
        this.id = id;
        this.city = city;
        this.addressId = addressId;
        this.country = country;
        this.streetName = streetName;
        this.postalCode = postalCode;
        this.userDetails = userDetails;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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
    public UserDTO getUserDetails() {
        return userDetails;
    }
    public void setUserDetails(UserDTO userDetails) {
        this.userDetails = userDetails;
    }
    public String getAddressId() {
        return addressId;
    }
    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }
}
