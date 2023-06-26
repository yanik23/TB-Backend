package com.bokafood.tbbackend.controller;


import com.bokafood.tbbackend.entity.Client;
import com.bokafood.tbbackend.service.ClientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/clients")
@Validated
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getClients() {
        return new ResponseEntity<>(clientService.getClients(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        return new ResponseEntity<>(clientService.getClientById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Client> addClient(@Valid @RequestBody Client client) {
        return new ResponseEntity<>(clientService.addClient(client), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @Valid @RequestBody Client client) {
        return new ResponseEntity<>(clientService.updateClient(id, client), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
