package com.bokafood.tbbackend.utils;

import com.bokafood.tbbackend.dto.clients.ClientDTO;
import com.bokafood.tbbackend.entity.Client;

public class ClientMapper {
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
