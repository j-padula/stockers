package com.stockers.stockers.client.controller;

import com.stockers.stockers.client.domain.Client;
import com.stockers.stockers.client.dto.ClientDto;
import com.stockers.stockers.client.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
@Api(tags = "clients")
public class ClientController {
    private ClientService clientService;
    private Client client;


    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping()
    @ApiOperation(value = "Listado de clientes", notes = "Devuelve un listado de clientes")
    public ResponseEntity<List<Client>> clients(){
        return ResponseEntity.ok(clientService.findAll());

    }
    @GetMapping(path = "/{clientId}")
    @ApiOperation(value = "Busca un cliente", notes = "Devuelve un cliente segun ID")
    public ResponseEntity<Client> getClient(@PathVariable Integer clientId){
        return ResponseEntity.ok(clientService.findById(clientId));
    }

    @PostMapping()
    @ApiOperation(value = "Crea un cliente", notes = "Crea un cliente y lo devuelve")
    public ResponseEntity<Client> createClient(@RequestBody @Valid ClientDto clientDto){
        Client client = new Client();
        client.setName(clientDto.getName());
        client.setBusinessName(clientDto.getBusinessName());
        client.setVatDeparture(clientDto.getVatDeparture());
        client.setAddress(clientDto.getAddress());
        client.setTelephoneNumber(clientDto.getTelephoneNumber());
        client.setContactName(clientDto.getContactName());
        client.setEmail(clientDto.getEmail());
        client.setCountry(clientDto.getCountry());
        return ResponseEntity.ok((clientService.create(client)));
    }
    @PutMapping(path = "/{clientId}")
    @ApiOperation(value = "Actualiza un cliente", notes = "Actualiza un cliente y lo devuelve")
    public ResponseEntity<Client> updateClient(@PathVariable Integer clientId, @RequestBody @Valid ClientDto clientDto){
        Client client = new Client();
        client.setClientId(clientId);
        client.setName(clientDto.getName());
        client.setBusinessName(clientDto.getBusinessName());
        client.setVatDeparture(clientDto.getVatDeparture());
        client.setAddress(clientDto.getAddress());
        client.setTelephoneNumber(clientDto.getTelephoneNumber());
        client.setContactName(clientDto.getContactName());
        client.setEmail(clientDto.getEmail());
        client.setCountry(clientDto.getCountry());
        return ResponseEntity.ok((clientService.update(client)));

    }

    @DeleteMapping("/{ID de cliente}")
    @ApiOperation(value = "Eliminar cliente", notes = "Servicio para eliminar un cliente")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "cliente eliminado correctamente"),
            @ApiResponse(code = 404, message = "cliente no encontrado") })
    public void removeClient (@PathVariable("ID de cliente") Integer clientId) {
        Client client = this.clientService.findById(clientId);
        if (client != null){
            this.clientService.delete(client);

        }
    }

}