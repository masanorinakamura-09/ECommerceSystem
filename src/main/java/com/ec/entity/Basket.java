package com.ec.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="basket")
public class Basket {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name="customer_id",referencedColumnName="id",nullable=false)
    private Customer customer;

    @OneToMany
    @JoinColumn(name="basketdetail_id",referencedColumnName="id",nullable=false)
    private List<Basketdetail> basketdetail;
}
