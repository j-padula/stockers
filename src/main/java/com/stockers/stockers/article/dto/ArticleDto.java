package com.stockers.stockers.article.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ArticleDto {

    private Integer articleId;
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
