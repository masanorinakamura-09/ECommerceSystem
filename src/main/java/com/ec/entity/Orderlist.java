package com.ec.entity;

import java.time.LocalDate;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

@Data
@Entity
public class Orderlist {

    @Id
    private Integer id;
    @ManyToOne
    @JoinColumn(name="customer_id",referencedColumnName="id")
    @NotNull
    private Customer customer;

    @OneToMany
    //@JoinColumn(name="order_detail",referencedColumnName="id")
    @NotNull
    private List<Orderdetail> orderdetails;

    @ManyToOne
    @JoinColumn(name="address_id",referencedColumnName="id")
    @NotNull
    private Address address;

    @Column(nullable=false)
    @NotNull
    @PastOrPresent
    private LocalDate date;

}
