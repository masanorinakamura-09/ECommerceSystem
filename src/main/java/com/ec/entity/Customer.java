package com.ec.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PreRemove;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.Data;

@Data
@Entity
@Table(name="customer")
public class Customer {

    public static enum Gender{
        男性,女性
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(length=30)
    private String name;

    @Column
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable=false)
    private String prefectural;

    @Column
    private String address;

    @Column(nullable=false)
    private Integer telephoneNumber;

    @Column(nullable=false)
    private Integer postCode;

    private String email;

    @OneToOne(mappedBy="customer")
    private Authentication authentication;

    @PreRemove
    @Transactional
    private void preRemove() {
        if(authentication!=null) {
            authentication.setCustomer(null);
        }
    }
}