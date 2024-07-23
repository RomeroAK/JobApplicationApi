package com.jobapplicationapi.jobapplicationapi.address;

import jakarta.persistence.*;

@Embeddable
public class Address {

    private String street;
    private String city;
    private String province;
    private String postalCode;
    private String country;

    public Address(){}
    public Address(String street, String country, String postalCode, String province, String city) {
        this.street = street;
        this.country = country;
        this.postalCode = postalCode;
        this.province = province;
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
