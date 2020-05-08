package com.stockers.stockers.purchase.service;

import com.stockers.stockers.purchase.domain.Purchase;

import java.util.List;

public interface PurchaseService {

    Purchase create(Purchase purchase);

    Purchase update(Purchase purchase);

    void delete(Purchase purchase);

    Purchase findById(Integer purchaseId);

    List<Purchase> findAll();
}
