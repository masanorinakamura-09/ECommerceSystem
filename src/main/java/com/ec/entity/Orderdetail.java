package com.ec.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name="orderDetail")
public class Orderdetail {

    public static enum Status{
        受注,出荷準備中,出荷済み,キャンセル
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="merchandise_id",referencedColumnName="id")
    @NotNull
    private Merchandise merchandise;

    @Column(nullable=false)
    @NotNull
    private Integer qty;


    @Enumerated(EnumType.STRING)
    @NotNull
    private Status status;


}
