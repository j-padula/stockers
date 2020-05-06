package com.stockers.stockers.client.repository;

import com.stockers.stockers.client.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {

    Client findByClientId(Integer clientId);
}
