package com.stockers.stockers.purchaseItems.repository;

import com.stockers.stockers.article.domain.Article;
import com.stockers.stockers.purchase.domain.Purchase;

import java.util.List;

public interface PurchaseItemsRepository {

    List<Article> findByPurchaseId(Integer purchaseId);
}
