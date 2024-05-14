package com.ec.entity;

import java.util.List;

import org.hibernate.validator.constraints.Range;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PreRemove;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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

    @NotBlank
    @Column(length=30,nullable=false)
    private String name;

    @Range(min=0,max=150)
    @NotNull
    @Column(length=3,nullable=false)
    private Integer age;


    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotBlank
    @Pattern(regexp="[0-9]{10,11}",message = "{phoneerr}")
    @Column(nullable=false)
    private String telephoneNumber;

    @NotBlank
    @Email
    @Column(nullable=false)
    private String email;


    @Column(nullable=false)
    private Integer cash;

    @OneToMany(mappedBy="customer", cascade = CascadeType.ALL)
    private List<Orderlist> orderlists;

    @OneToOne(mappedBy="customer",cascade = CascadeType.ALL)
    @Valid
    private Authentication authentication;

    @PreRemove
    @Transactional
    private void preRemove() {
        if(authentication!=null) {
            authentication.setCustomer(null);
        }
    }
}