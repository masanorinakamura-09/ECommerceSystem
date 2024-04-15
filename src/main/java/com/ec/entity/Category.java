package com.ec.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name=("category"))
public class Category {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    private String categoryName;

    @Column(length=2)
    private Integer categoryId;

    @Column(nullable=false)
    private String subCategoryName;

    @Column(nullable=false,length=4)
    private Integer subCategoryId;
}
