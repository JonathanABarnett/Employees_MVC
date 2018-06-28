package com.alaythiaproductions.employees.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 3, message = "Please enter address")
    private String street1;
    private String street2 = "";
    @NotNull
    @Size(min = 3, message = "Please enter your city")
    private String city;
    @NotNull
    private String stateAbb;
    @NotNull
    @Size(min = 5, max = 9, message = "Please enter your zip code")
    private String zip;

    public Address() {}

    public Address(String street1, String street2, String city, String stateAbb, String zip) {
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.stateAbb = stateAbb;
        this.zip = zip;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateAbb() {
        return stateAbb;
    }

    public void setStateAbb(String stateAbb) {
        this.stateAbb = stateAbb;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
