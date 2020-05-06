package com.stockers.stockers.client.service;

//Definicion de los servicios de cliente

import com.stockers.stockers.client.domain.Client;

import java.util.List;


public interface ClientService {


    Client create(Client client);

    Client update(Client client);

    void delete(Client client);

    Client findById(Integer clientId);

    List<Client> findAll();

}
