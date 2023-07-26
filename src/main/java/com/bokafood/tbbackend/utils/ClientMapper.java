package com.bokafood.tbbackend.utils;

import com.bokafood.tbbackend.dto.clientsDTO.ClientDTO;
import com.bokafood.tbbackend.entity.Client;

/**
 * ClientMapper class used to map a Client to a ClientDTO and vice versa.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
public class ClientMapper {

    /**
     * Method to map a Client to a ClientDTO.
     * @param client The Client to be mapped.
     * @return The mapped ClientDTO.
     */
    static public ClientDTO toDTO(Client client) {
        return ClientDTO.builder()
            .id(client.getId())
            .name(client.getName())
            .addressName(client.getAddressName())
            .addressNumber(client.getAddressNumber())
            .zipCode(client.getZipCode())
            .city(client.getCity())
            .build();
    }

    /**
     * Method to map a ClientDTO to a Client.
     * @param clientDTO The ClientDTO to be mapped.
     * @return The mapped Client.
     */
    static public Client toClient(ClientDTO clientDTO) {
        return Client.builder()
            .id(clientDTO.getId())
            .name(clientDTO.getName())
            .addressName(clientDTO.getAddressName())
            .addressNumber(clientDTO.getAddressNumber())
            .zipCode(clientDTO.getZipCode())
            .city(clientDTO.getCity())
            .build();
    }
}
