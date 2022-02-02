package com.example.currency.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="Currency")
@AllArgsConstructor
@NoArgsConstructor
public class Currency {
    //Currency_Code
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Currency_Id")
    private long currencyId;
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
