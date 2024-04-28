package com.ec.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Address {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="customer_id",referencedColumnName="id")
    private Customer customer;

    @Column
    private String name;

    @Column(nullable=false)
    private String prefectural;

    @Column(nullable=false)
    private String municipalities;

    @Column(nullable=false)
    private String postCode;

    @Column(nullable=false)
    private String telephoneNumber;

    private boolean priority;

    private boolean selected;
}