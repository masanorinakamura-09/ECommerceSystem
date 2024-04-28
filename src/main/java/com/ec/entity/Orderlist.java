package com.ec.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Orderlist {

    @Id
    private Integer id;
    @ManyToOne
    @JoinColumn(name="customer_id",referencedColumnName="id")
    private Customer customer;

    @OneToMany
    @JoinColumn(name="order_detail",referencedColumnName="id")
    private List<Orderdetail> orderdetails;

    @ManyToOne
    @JoinColumn(name="address_id",referencedColumnName="id")
    private Address address;

    /*@Column(nullable=false)
    private String name;

    @ManyToOne
    @JoinColumn(name="address",referencedColumnName="id")
    private Address address;

    @Column(nullable=false)
    private String telephoneNumber;*/

    @Column(nullable=false)
    private LocalDate date;

}
