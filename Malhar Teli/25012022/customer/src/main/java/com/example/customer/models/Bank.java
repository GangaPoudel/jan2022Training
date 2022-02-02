package com.example.customer.models;

import lombok.Data;

import javax.persistence.*;
import io.swagger.annotations.ApiModelProperty;


@Data
@Entity
@Table(name="Bank")
public class Bank {
    //Bank_Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden=true)
    @Column(name="Bank_Id")
    private long bankId;

    //Nostro_Account
    @Column(name="Nostro_Account", nullable = false)
    private long  nostroAccount;
    //Bank_Name
    @Column(name="Bank_Name", length = 50, nullable = false)
    private String bankName;
    //Bank_Legal_Entity
    @Column(name="Bank_Legal_Entity", length=50, nullable = false)
    private String bankLegalEntity;
    //Address
    @Embedded
    private Address address;

}
