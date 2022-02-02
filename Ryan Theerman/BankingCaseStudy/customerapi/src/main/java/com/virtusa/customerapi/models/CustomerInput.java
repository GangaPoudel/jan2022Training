package com.virtusa.customerapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInput {

    private FullName customerName;
    private String customerAddress;
    private String customerCountry;
    private String customerZip;
    private String customerState;
    private String customerPhone;
    private String customerEmail;
    private String dob;
}
