package com.stockers.stockers.purchase.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.stockers.stockers.article.domain.Article;
import com.stockers.stockers.client.domain.Client;
import com.stockers.stockers.client.dto.ClientDto;
import com.stockers.stockers.user.domain.User;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer purchaseId;

    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @Temporal(TemporalType.DATE)
    private Date deliveryDate;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;


    /*@ManyToMany(targetEntity = Article.class)
    @JoinColumn(name = "articleId")
    private List<Article> articles;

     */

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    private String state;


    public Purchase(){

    }
}
