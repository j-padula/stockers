package com.stockers.stockers.user.service.impl;

import com.stockers.stockers.user.domain.Client;
import com.stockers.stockers.user.repository.ClientRepository;
import com.stockers.stockers.user.service.ClientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    //Metodo para guardar cliente en db

    @Transactional
    @Override
    public Client create(Client client) {
        return this.clientRepository.save(client);
    }

    //Metodo para actualizar cliente

    @Transactional
    @Override
    public Client update(Client client) {
        return this.clientRepository.save(client);
    }

    //Metodo para eliminar cliente
    @Transactional
    @Override
    public void delete(Client client) {
        this.clientRepository.delete(client);
    }

    //Metodo para consultar cliente
    @Transactional
    @Override
    public Client findById(Integer clientId) {
        return this.clientRepository.findById(clientId);

    }
    @Transactional
    @Override
    public List<Client> findAll() {
        List<Client> clients = this.clientRepository.findAll();
        return clients;
    }
}
