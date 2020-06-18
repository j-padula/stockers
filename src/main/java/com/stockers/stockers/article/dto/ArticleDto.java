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
    private String description;
    private Double price;

}
