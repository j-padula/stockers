package com.stockers.stockers.purchaseItems.service.impl;

import com.stockers.stockers.article.domain.Article;
import com.stockers.stockers.article.dto.ArticleDto;
import com.stockers.stockers.purchase.domain.Purchase;
import com.stockers.stockers.purchaseItems.repository.PurchaseItemsRepository;
import com.stockers.stockers.purchaseItems.service.PurchaseItemsService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class PurchaseItemsServiceImpl implements PurchaseItemsService {
    private final PurchaseItemsRepository purchaseItemsRepository;

    public PurchaseItemsServiceImpl(PurchaseItemsRepository purchaseItemsRepository){
        this.purchaseItemsRepository = purchaseItemsRepository;
    }

    @Transactional
    @Override
    public List<Article> findArticleByPurchaseId(Integer purchaseId){
        List<Article> articles = this.purchaseItemsRepository.findByPurchaseId(purchaseId);
        return articles;
    }

    /*@Override
    public Article findArticleById(Integer articleId) {
        return this.purchaseItemsRepository.findArticleById(articleId);
    }*/
}
