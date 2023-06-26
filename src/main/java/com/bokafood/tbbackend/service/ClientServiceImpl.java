package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.entity.Client;
import com.bokafood.tbbackend.exception.EntityNotFoundException;
import com.bokafood.tbbackend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

        @Autowired
        private ClientRepository clientRepository;

        @Override
        public List<Client> getClients() {
            return (List<Client>) clientRepository.findAll();
        }

        @Override
        public Client getClientById(Long id) {
            Optional<Client> client = clientRepository.findById(id);
            if(client.isPresent()) {
                return client.get();
            } else {
                throw new EntityNotFoundException(id, Client.class);
            }
        }

        @Override
        public Client addClient(Client client) {
            return clientRepository.save(client);
        }

        @Override
        public Client updateClient(Long id, Client updatedClient) {
            Client client = getClientById(id);
            client.update(updatedClient);
            return clientRepository.save(client);
        }

        @Override
        public void deleteClient(Long id) {
            clientRepository.deleteById(id);
        }



}
