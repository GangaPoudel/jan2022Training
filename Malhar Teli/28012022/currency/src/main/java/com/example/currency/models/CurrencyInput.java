package com.example.currency.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyInput {
    private String currencyCode;
    private String country;
    private String symbol;
    private Integer tradableFlag;
    private String description;
}
