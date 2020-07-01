package com.stockers.stockers.purchaseItems.domain;

import com.stockers.stockers.article.domain.Article;

import com.stockers.stockers.client.domain.Client;
import com.stockers.stockers.purchase.domain.Purchase;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PurchaseItems")
public class PurchaseItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer purchaseItemId;

    @ManyToOne
    @JoinColumn(name = "purchaseId")
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "articleId")
    private Article article;

    private Integer quantity;

    private Double price;


    public PurchaseItems(){

    }
}
