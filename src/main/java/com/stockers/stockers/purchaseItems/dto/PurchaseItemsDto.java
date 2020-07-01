package com.stockers.stockers.purchaseItems.dto;

import com.stockers.stockers.article.dto.ArticleDto;
import com.stockers.stockers.purchase.dto.PurchaseDto;
import lombok.Data;

@Data
public class PurchaseItemsDto {

    private PurchaseDto purchaseId;
    private ArticleDto articleId;
    //private Integer quantity;
    private ArticleDto price;
    private ArticleDto artCode;
}
