package com.stockers.stockers.purchaseItems.service;

import com.stockers.stockers.article.domain.Article;
import com.stockers.stockers.purchase.domain.Purchase;

import java.util.List;

public interface PurchaseItemsService {

    List<Article> findArticleByPurchaseId(Integer purchaseId);

}
