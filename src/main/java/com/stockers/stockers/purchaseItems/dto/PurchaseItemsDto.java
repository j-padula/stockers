package com.stockers.stockers.purchaseItems.dto;

import lombok.Data;

@Data
public class PurchaseItemsDto {

    private String articleId;
    private String purchaseId;
    private Integer quantity;
    private Double price;
    private String artCode;
}
