   
package com.ganga.currencyapi.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@Table(name="Currency")
@NoArgsConstructor
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Currency_Id")
    private long Id;
    @Column(name="Currency_Name", length = 50, nullable = false, unique = true)
    private String currencyName;
    @Column(name="Country_Name", length = 50, nullable = false)
    private String countryName;
    @Column(name="Currency_Symbol", length = 50, nullable = false)
    private String currencySymbol;
    @Column(name="Currency_Image", columnDefinition = "mediumblob", length=50)
    private byte[] currencyImage;

    public Currency(String currencyName, String countryName, String currencySymbol){
        this.currencyName = currencyName;
        this.countryName = countryName;
        this.currencySymbol = currencySymbol;
    }

    public Currency(String currencyName, String countryName, String currencySymbol, byte[] currencyImage){
        this.currencyName = currencyName;
        this.countryName = countryName;
        this.currencySymbol = currencySymbol;
        this.currencyImage = currencyImage;
    }


}
