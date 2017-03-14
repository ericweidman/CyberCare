package com.entities;

import javax.persistence.*;

/**
 * Created by ericweidman on 3/14/17.
 */

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String email;

    @Column(nullable = false)
    String phone;

    @Column(nullable = false)
    String street;

    @Column(nullable = false)
    String city;

    @Column(nullable = false)
    String state;

    @Column(nullable = false)
    String zip;


    public Customer() {
    }

    public Customer(String name, String email, String phone, String street, String city, String state, String zip) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
