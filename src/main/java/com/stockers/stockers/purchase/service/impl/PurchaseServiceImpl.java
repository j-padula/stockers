package com.stockers.stockers.purchase.service.impl;

import com.stockers.stockers.purchase.domain.Purchase;
import com.stockers.stockers.purchase.repository.PurchaseRepository;
import com.stockers.stockers.purchase.service.PurchaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PurchaseServiceImpl implements PurchaseService {
    private final PurchaseRepository purchaseRepository;

    public PurchaseServiceImpl(PurchaseRepository purchaseRepository){
        this.purchaseRepository = purchaseRepository;
    }

    //Método para crear un pedido
    @Transactional
    @Override
    public Purchase create(Purchase purchase){
        return this.purchaseRepository.save(purchase);
    }

    //Metodo para actualizar pedido

    @Transactional
    @Override
    public Purchase update(Purchase purchase){
        return this.purchaseRepository.save(purchase);
    }

    //Método para eliminar un pedido

    @Transactional
    @Override
    public void delete(Purchase purchase){
        this.purchaseRepository.delete(purchase);
    }

    //Método para consultar un pedido

    @Transactional
    @Override
    public Purchase findById(Integer purchaseId){
        return this.purchaseRepository.findByPurchaseId(purchaseId);
    }

    @Transactional
    @Override
    public List<Purchase> findAll() {
        List<Purchase> purchases = this.purchaseRepository.findAll();
        return purchases;
    }
}
