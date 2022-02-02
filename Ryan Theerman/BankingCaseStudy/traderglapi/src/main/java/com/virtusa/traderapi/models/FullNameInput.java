package com.virtusa.traderapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullNameInput implements Serializable {

    private String firstName;
    private String lastName;
    private String middleName;
}
