package com.virtusa.traderapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankInput implements Serializable {
	private String bankName;
	private String address;

}
