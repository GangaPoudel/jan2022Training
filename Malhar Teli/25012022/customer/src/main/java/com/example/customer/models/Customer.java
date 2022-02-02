package com.example.customer.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Customer")
public class Customer {
    //CustomerId
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Customer_Id")
    private long customerId;
    //Name
    @Embedded
    private FullName fullName;
    //Address
    @Embedded
    private Address address;
    //Email
    @Column(name="Customer_Email", length = 50, nullable = false, unique = true)
    private String email;
    //Phone
    @Column(name="Customer_Phone", length = 10, nullable = false)
    private String phone;
    //CustomerStatus
    @Column(name="Customer_Status")
    private boolean status;
    //Desk Code
    @OneToOne(cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name="Desk_Id"), name="Desk_Id")
    private Desk desk;
}
