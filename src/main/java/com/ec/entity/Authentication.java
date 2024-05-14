package com.ec.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "authentication")
public class Authentication {

    @Id
    @NotBlank
    private String LoginUser;

    @NotBlank
    private String password;

    @OneToOne
    @JoinColumn(name="customer_id",referencedColumnName="id")
    private Customer customer;
}
