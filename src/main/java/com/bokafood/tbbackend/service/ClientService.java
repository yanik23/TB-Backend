package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.entity.Client;

import java.util.List;

public interface ClientService {
    List<Client> getClients();
    Client getClientById(Long id);
    Client addClient(Client client);
    Client updateClient(Long id, Client updatedClient);
    void deleteClient(Long id);
}
