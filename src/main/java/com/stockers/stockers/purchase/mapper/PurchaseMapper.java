package com.stockers.stockers.purchase.mapper;

import com.stockers.stockers.article.domain.Article;
import com.stockers.stockers.article.dto.ArticleDto;
import com.stockers.stockers.client.domain.Client;
import com.stockers.stockers.client.dto.ClientDto;
import com.stockers.stockers.purchase.domain.Purchase;
import com.stockers.stockers.purchase.dto.PurchaseDto;
import com.stockers.stockers.user.domain.User;
import com.stockers.stockers.user.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public class PurchaseMapper {
    public static PurchaseDto modelToDto(Purchase purchase){
        PurchaseDto purchaseDto = new PurchaseDto();
        ClientDto clientDto = new ClientDto();
        clientDto.setClientId(purchaseDto.getClient().getClientId());

        UserDto userDto = new UserDto();
        userDto.setUserId(purchaseDto.getUser().getUserId());
        List<ArticleDto> articles = new ArrayList();
       /* purchase.getArticles().forEach((Article article) -> {
            ArticleDto art = new ArticleDto();
            art.setArticleId(article.getArticleId());
            articles.add(art);
        });

        */
        purchaseDto.setOrderDate(purchaseDto.getOrderDate());
        purchaseDto.setDeliveryDate(purchaseDto.getDeliveryDate());
        purchaseDto.setClient(clientDto);
        purchaseDto.setUser(userDto);
        //purchaseDto.setArticles(articles);
        return purchaseDto;
    }
    public static Purchase dtoToModel(PurchaseDto purchaseDto){
        Purchase purchase = new Purchase();
        Client client = new Client();
        client.setClientId(purchaseDto.getClient().getClientId());

        User user = new User();
        user.setUserId(purchaseDto.getUser().getUserId());
        List<Article> articles = new ArrayList();
       /* purchaseDto.getArticles().forEach((ArticleDto article) -> {
            Article art = new Article();
            art.setArticleId(article.getArticleId());
            articles.add(art);
        });

        */
        purchase.setOrderDate(purchaseDto.getOrderDate());
        purchase.setDeliveryDate(purchaseDto.getDeliveryDate());
        purchase.setClient(client);
        purchase.setUser(user);
       // purchase.setArticles(articles);
        return purchase;
    }
}
