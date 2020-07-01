package com.stockers.stockers.purchaseItems.controller;

import com.stockers.stockers.article.domain.Article;
import com.stockers.stockers.purchase.domain.Purchase;
import com.stockers.stockers.purchaseItems.service.PurchaseItemsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/purchaseItems")
@Api(tags = "purchase_items")
public class PurchaseItemsController {

    private PurchaseItemsService purchaseItemsService;

    @GetMapping(path = "/{purchaseId}")
    @ApiOperation(value = "Busca un pedido por su ID", notes = "Devuelve la lista de artículos")
    public ResponseEntity<List<Article>> getArticles(@PathVariable Integer purchaseId){
        return ResponseEntity.ok(purchaseItemsService.findArticleByPurchaseId(purchaseId));
    }

    /*@GetMapping()
    @ApiOperation(value = "lista articulos de compra", notes = "muestra lista de articulos de un pedido")
    public ResponseEntity<List<Article>> articles(){
        return ResponseEntity.ok(purchaseItemsService.findArticleByPurchaseId());
    }

     */

}
