package com.stockers.stockers.article.mapper;

import com.stockers.stockers.article.domain.Article;
import com.stockers.stockers.article.dto.ArticleDto;

public class ArticleMapper {
    public static ArticleDto modelToDto(Article article){
        ArticleDto articleDto = new ArticleDto();
        articleDto.setName(article.getName());
        articleDto.setArtCode(article.getArtCode());
        articleDto.setModel(article.getModel());
        articleDto.setType(article.getType());
        articleDto.setLocation(article.getLocation());
        articleDto.setQuantity(article.getQuantity());
        articleDto.setManufacturingDate(article.getManufacturingDate());
        articleDto.setDescription(article.getDescription());
        articleDto.setPrice(article.getPrice());
        return articleDto;
    }
    public static Article dtoToArticle(ArticleDto articleDto){
        Article article = new Article();
        article.setArticleId(articleDto.getArticleId());
        article.setName(articleDto.getName());
        article.setArtCode(articleDto.getArtCode());
        article.setModel(articleDto.getModel());
        article.setType(articleDto.getType());
        article.setLocation(articleDto.getLocation());
        article.setQuantity(articleDto.getQuantity());
        article.setManufacturingDate(articleDto.getManufacturingDate());
        article.setDescription(articleDto.getDescription());
        article.setPrice(articleDto.getPrice());
        return article;
    }
}
