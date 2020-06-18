package com.stockers.stockers.article.domain;

import com.stockers.stockers.purchase.domain.Purchase;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "Article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Integer articleId;
    private String name;
    private String artCode;
    private String model;
    private String type; //tipo de articulo, mesa, vitrina, armario, etc
    private String description;
    private Double price;



    public Article(){

    }



}