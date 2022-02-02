package com.example.customer.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Embeddable
@Entity
@Table(name="Desk")
public class Desk {
    //Desk_Code
    @Id
    @Column(name = "Desk_Code", length = 15, unique = true, nullable = false)
    private String deskCode;
    //Micr_Code
    @Column(name="Micr_Code", length=10,nullable = false)
    private long micrCode;
    //Bank
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(foreignKey = @ForeignKey(name="Bank_Id"), name = "Bank_Id")
//    private Bank bank;
    //Bank
}
