package com.stockers.stockers.purchase.repository;

import com.stockers.stockers.purchase.domain.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, String> {

    Purchase findByPurchaseId (Integer purchaseId);

}
