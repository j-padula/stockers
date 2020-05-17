package com.stockers.stockers.client.mapper;

import com.stockers.stockers.client.domain.Client;
import com.stockers.stockers.client.dto.ClientDto;

public class ClientMapper {
    public static ClientDto modelToDto(Client client){
        ClientDto clientDto = new ClientDto();
        clientDto.setName(client.getName());
        clientDto.setBusinessName(client.getBusinessName());
        clientDto.setVatDeparture(client.getVatDeparture());
        clientDto.setAddress(client.getAddress());
        clientDto.setTelephoneNumber(client.getTelephoneNumber());
        clientDto.setContactName(client.getContactName());
        clientDto.setEmail(client.getEmail());
        clientDto.setCountry(client.getCountry());
        return clientDto;
    }
    public static Client dtoToClient(ClientDto clientDto){
        Client client = new Client();
        client.setName(clientDto.getName());
        client.setBusinessName(clientDto.getBusinessName());
        client.setVatDeparture(clientDto.getVatDeparture());
        client.setAddress(clientDto.getAddress());
        client.setTelephoneNumber(clientDto.getTelephoneNumber());
        client.setContactName(clientDto.getContactName());
        client.setEmail(clientDto.getEmail());
        client.setCountry(clientDto.getCountry());
        return client;
    }
}
