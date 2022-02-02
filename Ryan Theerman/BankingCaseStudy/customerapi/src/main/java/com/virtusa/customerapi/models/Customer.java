package com.virtusa.customerapi.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Customer")
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    @Column(name="Customer_Id")
    private long customerId;
    @Embedded
    private FullName customerName;
    @Column(name="Customer_Address")
    private String customerAddress;
    @Column(name="Customer_Country")
    private String customerCountry;
    @Column(name="Customer_Zip")
    private String customerZip;
    @Column(name="Customer_State")
    private String customerState;
    @Column(name="Customer_Phone")
    private String customerPhone;
    @Column(name="Customer_Email")
    private String customerEmail;
    @Column(name="DOB")
    private String dob;

    public Customer(FullName customerName,
                    String customerAddress,
                    String customerCountry,
                    String customerZip,
                    String customerState,
                    String customerPhone,
                    String customerEmail,
                    String dob) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerCountry = customerCountry;
        this.customerZip = customerZip;
        this.customerState = customerState;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.dob = dob;
    }
}
