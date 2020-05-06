package com.stockers.stockers.article.service.impl;

import com.stockers.stockers.article.domain.Article;
import com.stockers.stockers.article.repository.ArticleRepository;
import com.stockers.stockers.article.service.ArticleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    //Metodo para guardar articulo en db

    @Transactional
    @Override
    public Article create(Article article) {
        return this.articleRepository.save(article);
    }

    //Metodo para actualizar articulo

    @Transactional
    @Override
    public Article update(Article article) {
        return this.articleRepository.save(article);
    }

    //Metodo para eliminar articulo
    @Transactional
    @Override
    public void delete(Article article) {
        this.articleRepository.delete(article);
    }

    //Metodo para consultar articulo
    @Transactional
    @Override
    public Article findById(Integer articleId) {
        return this.articleRepository.findByArticleId(articleId);

    }
    @Transactional
    @Override
    public List<Article> findAll() {
        List<Article> articles = this.articleRepository.findAll();
        return articles;
    }
}
