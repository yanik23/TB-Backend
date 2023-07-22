package com.bokafood.tbbackend.controller;


import com.bokafood.tbbackend.dto.clients.ClientDTO;
import com.bokafood.tbbackend.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getClients() {
        return new ResponseEntity<>(clientService.getClients(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        return new ResponseEntity<>(clientService.getClientById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> addClient(@Valid @RequestBody ClientDTO client) {
        return new ResponseEntity<>(clientService.addClient(client), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable Long id, @Valid @RequestBody ClientDTO clientDTO) {
        return new ResponseEntity<>(clientService.updateClient(id, clientDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


   /* @GetMapping("/{id}/deliveries")
    public ResponseEntity<ClientWithDeliveriesDTO> getClientWithDeliveries(@PathVariable Long id) {
        return new ResponseEntity<>(clientService.getClientWithDeliveries(id), HttpStatus.OK);
    }*/
}
