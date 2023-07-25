package com.bokafood.tbbackend.controller;


import com.bokafood.tbbackend.dto.clientsDTO.ClientDTO;
import com.bokafood.tbbackend.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * Controller class used to handle HTTP requests for the Client entity.
 * It uses the ClientService class to perform CRUD operations.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 *
 */
@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    /**
     * Method to handle HTTP GET requests for all clients.
     * @return ResponseEntity with a list of ClientDTO objects and HTTP status code.
     */
    @GetMapping
    public ResponseEntity<List<ClientDTO>> getClients() {
        return new ResponseEntity<>(clientService.getClients(), HttpStatus.OK);
    }

    /**
     * Method to handle HTTP GET requests for a client by its id.
     * @param id The id of the client to be returned.
     * @return ResponseEntity with a ClientDTO object and HTTP status code.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        return new ResponseEntity<>(clientService.getClientById(id), HttpStatus.OK);
    }

    /**
     * Method to handle HTTP POST requests to add a new client.
     * @param client The ClientDTO object to be added.
     * @return ResponseEntity with a ClientDTO object and HTTP status code.
     */
    @PostMapping
    public ResponseEntity<ClientDTO> addClient(@Valid @RequestBody ClientDTO client) {
        return new ResponseEntity<>(clientService.addClient(client), HttpStatus.CREATED);
    }

    /**
     * Method to handle HTTP PUT requests to update an existing client.
     * @param id The id of the client to be updated.
     * @param clientDTO The ClientDTO object with the updated data.
     * @return ResponseEntity with a ClientDTO object and HTTP status code.
     */
    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable Long id, @Valid @RequestBody ClientDTO clientDTO) {
        return new ResponseEntity<>(clientService.updateClient(id, clientDTO), HttpStatus.OK);
    }

    /**
     * Method to handle HTTP DELETE requests to delete an existing client.
     * @param id The id of the client to be deleted.
     * @return ResponseEntity with HTTP status code.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
