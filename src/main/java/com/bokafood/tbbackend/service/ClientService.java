package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.dto.clientsDTO.ClientDTO;
import java.util.List;


/**
 * ClientService is an interface that provides methods to manage clients.
 * Implementation of this interface is in ClientServiceImpl class.
 * Implements CRUD operations for clients.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 *
 */
public interface ClientService {
    /**
     * Method to get all clients.
     * @return List<ClientDTO> of all clients.
     */
    List<ClientDTO> getClients();

    /**
     * Method to get a client by its id.
     * @param id The id of the client to be found.
     * @return ClientDTO with the client if found.
     */
    ClientDTO getClientById(Long id);

    /**
     * Method to add a new client.
     * @param clientDTO The ClientDTO object to be added.
     * @return ClientDTO with the added client.
     */
    ClientDTO addClient(ClientDTO clientDTO);

    /**
     * Method to update an existing client.
     * @param id The id of the client to be updated.
     * @param updatedClientDTO The ClientDTO object with the updated client.
     * @return ClientDTO with the updated client.
     */
    ClientDTO updateClient(Long id, ClientDTO updatedClientDTO);

    /**
     * Method to delete a client.
     * @param id The id of the client to be deleted.
     */
    void deleteClient(Long id);

    /**
     * Method to get a client by its name.
     * @param name The name of the client to be found.
     * @return ClientDTO with the client if found.
     */
    ClientDTO getClientByName(String name);
}
