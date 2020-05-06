package com.stockers.stockers.article.service;

//Clase para definir los servicios de articulos

import com.stockers.stockers.article.domain.Article;

import java.util.List;

public interface ArticleService {


    Article create(Article article);

    Article update(Article article);

    void delete(Article article);

    Article findById(Integer articleId);

    List<Article> findAll();
}
