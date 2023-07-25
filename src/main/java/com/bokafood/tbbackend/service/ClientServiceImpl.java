package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.dto.clientsDTO.ClientDTO;
import com.bokafood.tbbackend.entity.Client;
import com.bokafood.tbbackend.exception.EntityNotFoundException;
import com.bokafood.tbbackend.repository.ClientRepository;
import com.bokafood.tbbackend.utils.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

        @Autowired
        private ClientRepository clientRepository;

        @Override
        public List<ClientDTO> getClients() {
            List<Client> clients = (List<Client>) clientRepository.findAll();
            return clients.stream().map(ClientMapper::toDTO).toList();
        }

        @Override
        public ClientDTO getClientById(Long id) {
            Optional<Client> client = clientRepository.findById(id);
            if(client.isPresent()) {
                return ClientMapper.toDTO(client.get());
            } else {
                throw new EntityNotFoundException(id, Client.class);
            }
        }

        @Override
        public ClientDTO addClient(ClientDTO clientDTO) {
           Client client = ClientMapper.toClient(clientDTO);
           Client savedClient = clientRepository.save(client);
           return ClientMapper.toDTO(savedClient);
        }

        @Override
        public ClientDTO updateClient(Long id, ClientDTO updatedClientDTO) {
            Client client = ClientMapper.toClient(getClientById(id));
            update(client, updatedClientDTO);
            Client savedClient = clientRepository.save(client);
            return ClientMapper.toDTO(savedClient);
        }

        @Override
        public void deleteClient(Long id) {
            clientRepository.deleteById(id);
        }


        @Override
        public ClientDTO getClientByName(String name) {
            Optional<Client> client = clientRepository.findByName(name);
            if(client.isPresent()) {
                return ClientMapper.toDTO(client.get());
            } else {
                throw new EntityNotFoundException(name, Client.class);
            }
        }


        /**
         * Updates the client with the values from the updatedClient
         * @param updatedClient the client to be updated
         * @param clientDTO the client with the new values
         */
        private void update(Client updatedClient, ClientDTO clientDTO) {
            updatedClient.setName(clientDTO.getName());
            updatedClient.setAddressName(clientDTO.getAddressName());
            updatedClient.setAddressNumber(clientDTO.getAddressNumber());
            updatedClient.setZipCode(clientDTO.getZipCode());
            updatedClient.setCity(clientDTO.getCity());
        }

}
