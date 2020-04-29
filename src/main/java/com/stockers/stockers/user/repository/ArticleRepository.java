package com.stockers.stockers.user.repository;

//Interfaz de operaciones de articulos en la base de datos

import com.stockers.stockers.user.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, String> {

    Article findById(Integer articleId);
}
