package com.stockers.stockers.article.repository;

//Interfaz de operaciones de articulos en la base de datos

import com.stockers.stockers.article.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, String> {

    Article findByArticleId(Integer articleId);
}
