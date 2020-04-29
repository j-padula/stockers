package com.stockers.stockers.user.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;

@Data
@Entity
@Table(name = "Article")
@NamedQuery(name = "Article.findById", query = "Select a from Article a where a.articleId=?1")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Integer articleId = null;
    private String name;
    private String artCode;
    private String model;
    private String type;
    private String location;
    private Integer quantity;
    private String manufacturingDate;
    private String description;
    private Double price;
    private ArrayList<String> articles;

}