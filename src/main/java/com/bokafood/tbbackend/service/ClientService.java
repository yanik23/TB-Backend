package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.dto.clients.ClientDTO;

import java.util.List;

public interface ClientService {
    List<ClientDTO> getClients();
    ClientDTO getClientById(Long id);
    ClientDTO addClient(ClientDTO clientDTO);
    ClientDTO updateClient(Long id, ClientDTO updatedClientDTO);
    void deleteClient(Long id);

    //ClientWithDeliveriesDTO getClientWithDeliveries(Long id);
}
