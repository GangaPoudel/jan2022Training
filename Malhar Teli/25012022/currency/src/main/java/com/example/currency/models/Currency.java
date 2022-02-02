package com.example.currency.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Currency")
public class Currency {
    //Currency_Code
    @Id
    @Column(name="Currency_Code", length = 3, nullable = false)
    private String currencyCode;
    //Country
    @Column(name="Country", length = 20, nullable = false)
    private String country;
    //Symbol
    @Column(name="Symbol", columnDefinition = "mediumblob")
    private byte[] symbol;
    //Tradable Flag
    @Column(name="Tradable_Flag", nullable=false)
    private long tradableFlag;
    //Description
    @Column(name = "Description", length = 50)
    private String description;
}
