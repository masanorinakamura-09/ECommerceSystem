package com.ec.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="merchandise")
public class merchandise {

    public static enum Category{
        食品,薬剤,お酒,文房具,家電
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(length=30,nullable=false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    private Integer price;

    private Integer stock;
}
//