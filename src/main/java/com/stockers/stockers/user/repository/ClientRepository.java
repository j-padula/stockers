package com.stockers.stockers.user.repository;

import com.stockers.stockers.user.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;

public interface ClientRepository extends JpaRepository<Client, String> {

    Client findById(Integer clientId);
}
