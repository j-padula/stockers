package com.stockers.stockers.purchase.controller;

import com.stockers.stockers.article.domain.Article;
import com.stockers.stockers.article.dto.ArticleDto;
import com.stockers.stockers.client.domain.Client;
import com.stockers.stockers.purchase.domain.Purchase;
import com.stockers.stockers.purchase.dto.PurchaseDto;
import com.stockers.stockers.client.service.ClientService;
import com.stockers.stockers.purchase.service.PurchaseService;
import com.stockers.stockers.user.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    public PurchaseController(PurchaseService purchaseService, ClientService clientService){
        this.purchaseService = purchaseService;
        this.clientService = clientService;
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
        Purchase purchase = new Purchase();
        Client client = new Client();
        client.setClientId(purchaseDto.getClient().getClientId());

        User user = new User();
        user.setUserId(purchaseDto.getUser().getUserId());
        List<Article> articles = new ArrayList();
        purchaseDto.getArticles().forEach((ArticleDto article) -> {
            Article art = new Article();
            art.setArticleId(article.getArticleId());
            articles.add(art);
        });
        purchase.setOrderDate(purchaseDto.getOrderDate());
        purchase.setDeliveryDate(purchaseDto.getDeliveryDate());
        purchase.setClient(client);
        purchase.setUser(user);
        purchase.setArticles(articles);
        return ResponseEntity.ok(purchaseService.create(purchase));
    }

    @PutMapping(path = "/{purchaseId}")
    @ApiOperation(value = "Actualiza un pedido", notes = "Actualiza un pedido y lo devuelve")
    public ResponseEntity<Purchase> updatePurchase(@PathVariable Integer purchaseId, @RequestBody @Valid PurchaseDto purchaseDto){
        Purchase purchase = new Purchase();
      //  Client client = this.clientService.findById(purchaseDto.getClient());
        Client client = new Client();
        client.setClientId(purchaseDto.getClient().getClientId());
        purchase.setPurchaseId(purchaseId);
        purchase.setOrderDate(purchaseDto.getOrderDate());
        purchase.setDeliveryDate(purchaseDto.getDeliveryDate());
        purchase.setClient(client);
        User user = new User();
        user.setUserId(purchaseDto.getUser().getUserId());
        List<Article> articles = null;
        purchaseDto.getArticles().forEach((ArticleDto article) -> {
            Article art = new Article();
            art.setArticleId(article.getArticleId());
            articles.add(art);
        });
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
}
