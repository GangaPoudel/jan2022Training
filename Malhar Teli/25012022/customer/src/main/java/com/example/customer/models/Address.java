package com.example.customer.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Address {
    //Street Address
    @Column(name="Street_Address", nullable = false)
    private String streetAddress;
    //City
    @Column(name="Address_City", nullable = false)
    private String city;
    //State
    @Column(name="Address_State", nullable = false)
    private String state;
    //Country
    @Column(name="Address_Country", nullable = false)
    private String country;
    //Zip
    @Column(name="Address_Zip", nullable = false)
    private Integer zip;
}
