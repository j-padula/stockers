package com.stockers.stockers.purchase.dto;

import com.stockers.stockers.article.dto.ArticleDto;
import com.stockers.stockers.client.dto.ClientDto;
import com.stockers.stockers.user.dto.UserDto;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PurchaseDto {
    private Integer purchaseId ;
    private Date orderDate;
    private Date deliveryDate;
    private ClientDto client;
    //private List<ArticleDto> articles;
    private UserDto user;
    private String state;


}