package com.rikovicisah.app.ws.model;

import com.rikovicisah.app.ws.shared.dto.UserDTO;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="addresses")
public class AddressEntity implements Serializable {
    private static final long serialVersionUID = -556848469386838189L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 30)
    private String city;

    @Column(nullable = false, length = 30)
    private String addressId;

    @Column(nullable = false, length = 20)
    private String country;

    @Column(nullable = false, length = 100)
    private String streetName;
    @Column(nullable = false, length = 7)
    private String postalCode;

    //TODO promijeniti deklaraciju
    @ManyToOne
    @JoinColumn(name = "users_id")
    private UserEntity userDetails;


    public AddressEntity() {
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
    public String getAddressId() {
        return addressId;
    }
    public void setAddressId(String addressId) {
        this.addressId = addressId;
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
    public UserEntity getUserDetails() {
        return userDetails;
    }
    public void setUserDetails(UserEntity userDetails) {
        this.userDetails = userDetails;
    }
}
