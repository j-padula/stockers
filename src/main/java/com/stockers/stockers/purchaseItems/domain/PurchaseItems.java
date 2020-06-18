package com.stockers.stockers.purchaseItems.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Purchase Items")
public class PurchaseItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String articleId;
    private String purchaseId;
    private Integer quantity;
    private Double price;
    private String artCode;

    public PurchaseItems(){

    }
}
