package com.virtusa.currencyapi.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

@Data
@Entity
@Table(name = "Currency")
@AllArgsConstructor
@NoArgsConstructor
public class Currency implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    @Column(name = "Currency_Id")
    private long currencyId;
    @Column(name="Country",length=50,nullable = false)
    private String country;
    //CURRENCY SYMBOL?
    @Column(name = "Symbol")
    private String currencySymbol;
    @Column(name="Tradable_Flag",nullable = false)
    private int tradableFlag;
    @Column(name = "Description")
    private String description;

    public Currency(String country, String currencySymbol, int tradableFlag, String description) {
        this.country = country;
        this.currencySymbol = currencySymbol;
        this.tradableFlag = tradableFlag;
        this.description = description;
    }
}
