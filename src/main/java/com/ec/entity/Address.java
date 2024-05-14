package com.ec.entity;


import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    @NotBlank
    private String name;

    @Column(nullable=false)
    @NotBlank
    private String prefectural;

    @Column(nullable=false)
    @NotBlank
    private String municipalities;

    @Column(nullable=false)
    @NotBlank
    @Length(min=7,max=7,message= "{posterr}")
    private String postCode;

    @Column(nullable=false)
    @NotBlank
    @Pattern(regexp="[0-9]{10,11}",message = "{phoneerr}")
    private String telephoneNumber;

    @NotNull
    private boolean priority;
}