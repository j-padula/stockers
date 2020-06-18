package com.stockers.stockers.purchase.controller;

import com.stockers.stockers.article.domain.Article;
import com.stockers.stockers.article.dto.ArticleDto;
import com.stockers.stockers.article.service.ArticleService;
import com.stockers.stockers.client.domain.Client;
import com.stockers.stockers.purchase.domain.Purchase;
import com.stockers.stockers.purchase.dto.PurchaseDto;
import com.stockers.stockers.client.service.ClientService;
import com.stockers.stockers.purchase.mapper.PurchaseMapper;
import com.stockers.stockers.purchase.service.PurchaseService;
import com.stockers.stockers.user.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/purchases")
@Api(tags="purchases")
public class PurchaseController {

    private PurchaseService purchaseService;
    private ClientService clientService;
    private Purchase purchase;
    private ArticleService articleService;

    public PurchaseController(PurchaseService purchaseService, ClientService clientService, ArticleService articleService){
        this.purchaseService = purchaseService;
        this.clientService = clientService;
        this.articleService = articleService;
    }

    @GetMapping()
    @ApiOperation(value = "Listado de pedidos", notes = "Devuelve un listado de pedidos")
    public ResponseEntity<List<Purchase>> purchases(){
        return ResponseEntity.ok(purchaseService.findAll());
    }

    @GetMapping(path = "/{purchaseId}")
    @ApiOperation(value = "Busca un pedido", notes = "Devuelve un pedido según su ID")
    public ResponseEntity<Purchase> getPurchase(@PathVariable Integer purchaseId){
        return ResponseEntity.ok(purchaseService.findById(purchaseId));
    }

    @PostMapping()
    @ApiOperation(value = "Crea un pedido", notes = "Crea un pedido y lo devuelve")
    public ResponseEntity<Purchase>  createPurchase(@RequestBody @Valid PurchaseDto purchaseDto){
        Purchase purchase = PurchaseMapper.dtoToModel(purchaseDto);
        return ResponseEntity.ok(purchaseService.create(purchase));
    }

    @PutMapping(path = "/{purchaseId}")
    @ApiOperation(value = "Actualiza un pedido", notes = "Actualiza un pedido y lo devuelve")
    public ResponseEntity<Purchase> updatePurchase(@PathVariable Integer purchaseId, @RequestBody @Valid PurchaseDto purchaseDto){
        Purchase purchase = PurchaseMapper.dtoToModel(purchaseDto);
        return ResponseEntity.ok(purchaseService.update(purchase));
    }

    @DeleteMapping("/{purchaseId}")
    @ApiOperation(value = "Eliminar un pedido", notes = "Elimina un pedido")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Pedido eliminado correctamente"),
            @ApiResponse(code = 404, message = "Pedido no encontrado") })
    public void removePurchase (@PathVariable("purchaseId") Integer purchaseId) {
        Purchase purchase = this.purchaseService.findById(purchaseId);
        if (purchase != null) {
            this.purchaseService.delete(purchase);
        }
    }
    /*@GetMapping(path = "/{purchaseId}/{articleId]")
    @ApiOperation(value = "Busca un pedido y un articulo por ID", notes = "Devuelve un pedido y un articulo según su ID")
    public ResponseEntity>(@PathVariable Integer purchaseId, Integer articleId){
        Purchase purchase = this.purchaseService.findById(purchaseId);
       // Article article = this.articleService.findById(articleId);
        if  (purchase != null) {
            this.articleService.findById(articleId);
        }
            return ResponseEntity.ok(purchaseService.findById(purchaseId));
            return ResponseEntity.ok(articleService.findById(articleId));


    }

     */


    /*public ResponseEntity<Purchase>getPurchaseAndArticle(@PathVariable Integer purchaseId) {
        return ResponseEntity.ok(purchaseService.findById(purchaseId));
    }
    public ResponseEntity<Article>getPurchaseAndArticle2(@PathVariable Integer articleId){
        return ResponseEntity.ok(articleService.findById(articleId));
    }*/
}
