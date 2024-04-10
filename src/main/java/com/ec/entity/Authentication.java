package com.ec.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "authentication")
public class Authentication {

    @Id
    private String LoginUser;

    private String password;

    @OneToOne
    @JoinColumn(name="customer_id",referencedColumnName="id")
    private Customer customer;
}
