package com.stockers.stockers.user.service;

//Definicion de los servicios de cliente

import com.stockers.stockers.user.domain.Client;
import com.stockers.stockers.user.repository.ClientRepository;

import java.util.List;


public interface ClientService {


    Client create(Client client);

    Client update(Client client);

    void delete(Client client);

    Client findById(Integer clientId);

    List<Client> findAll();

}
