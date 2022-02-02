package com.virtusa.currencyapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyInput {

    private String country;
    private String currencySymbol;
    private int tradableFlag;
    private String description;
}
