package com.example.calendar.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Country {
    @Id
    @Column(name = "Country_Code", nullable = false)
    private String countryCode;
}
