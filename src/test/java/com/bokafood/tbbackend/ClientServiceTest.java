package com.bokafood.tbbackend;


import com.bokafood.tbbackend.entity.Client;
import com.bokafood.tbbackend.exception.EntityNotFoundException;
import com.bokafood.tbbackend.repository.ClientRepository;
import com.bokafood.tbbackend.service.ClientService;
import com.bokafood.tbbackend.service.ClientServiceImpl;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

   /* @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;


    @Test
    public void getClientsFromRepoTest() {
        when(clientRepository.findAll()).thenReturn(Arrays.asList(
                new Client("Boka Fitness", "Avenue de Flon", 11, 1012, "Lausannne"),
                new Client("Planet Fitness", "Avenue de Wallstreet", 12, 1013, "Lausannne"),
                new Client("Pompiers de Morges", "Avenue de la Gare", 13, 1014, "Morges")
        ));

        List<Client> result = clientService.getClients();

        assertEquals(3, result.size());
        assertEquals("Boka Fitness", result.get(0).getName());
        assertEquals("Avenue de Wallstreet", result.get(1).getAddressName());
        assertEquals("Morges", result.get(2).getCity());

    }

    @Test
    public void getClientIndexFromValidIdTest() {
        Client client = new Client("Boka Fitness", "Avenue de Flon", 11, 1012, "Lausannne");
        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));

        Client validClient = clientService.getClientById(1L);

        assertEquals(client, validClient);
    }

    @Test
    public void getClientIndexFromInvalidIdTest() {
        when(clientRepository.findById(42L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            clientService.getClientById(42L);
        });
    }


    @Test
    public void addClientWithCorrectPayloadTest() {
        Client client = new Client("Boka Fitness", "Avenue de Flon", 11, 1012, "Lausannne");
        when(clientRepository.save(client)).thenReturn(client);

        Client validClient = clientService.addClient(client);

        assertEquals(client, validClient);
    }

    @Test
    public void addClientAlreadyExistingTest() {
        Client client = new Client("Boka Fitness", "Avenue de Flon", 11, 1012, "Lausannne");
        when(clientRepository.save(client)).thenReturn(client);

        Client validClient = clientService.addClient(client);

        assertEquals(client, validClient);
    }

    @Test
    public void addClientWithBlankNameTest() {
        Client client = new Client("", "Avenue de Flon", 11, 1012, "Lausannne");
        when(clientRepository.save(client)).thenReturn(client);

        Client testClient = clientService.addClient(client);

        System.out.println(testClient.getName());
        System.out.println(testClient.getAddressName());
        assertThrows(IllegalArgumentException.class, () -> {
            clientService.addClient(client);
        });
    }

    @Test
    public void addClienjjjjjtTest() {
        Client client = new Client("Boka Fitness", "Avenue de Flon", 11, 1012, "Lausannne");
        when(clientRepository.save(client)).thenThrow(new DataIntegrityViolationException("Duplicate entry for name field."));

        assertThrows(DataIntegrityViolationException.class, () -> {
            clientService.addClient(client);
        });
    }

  */
}
