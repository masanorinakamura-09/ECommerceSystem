package com.ec.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="basketDetail")
public class Basketdetail {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="basket_id",referencedColumnName="id",nullable=false)
    private Basket basket;

    @OneToOne
    @JoinColumn(name="merchandise_id",referencedColumnName="id",nullable=false)
    private Merchandise merchandise;

    @Column(nullable=false)
    private Integer qty;
}
