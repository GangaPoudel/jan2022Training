package com.virtusa.traderapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TraderInput implements Serializable {

    private long traderId;
    private FullName name;
    private long tradingLimit;
    private String email;
    private String dob;
    private BankTraderInput bank;
}
