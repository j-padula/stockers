package com.stockers.stockers.user.service;

//Clase para definir los servicios de articulos

import com.stockers.stockers.user.domain.Article;

import java.util.List;

public interface ArticleService {


    Article create(Article article);

    Article update(Article article);

    void delete(Article article);

    Article findById(Integer articleId);

    List<Article> findAll();
}
