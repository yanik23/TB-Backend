package com.bokafood.tbbackend;


import com.bokafood.tbbackend.entity.Client;
import com.bokafood.tbbackend.repository.ClientRepository;
import com.bokafood.tbbackend.service.ClientService;
import com.bokafood.tbbackend.service.ClientServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ClientIntegrationTest {

   /* @Mock
    private MockMvc mockMvc;

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;


    private final List<Client> clients = Arrays.asList(
            new Client("Boka Fitness", "Avenue de Flon", 11, 1012, "Lausannne"),
            new Client("Planet Fitness", "Avenue de Wallstreet", 12, 1013, "Lausannne"),
            new Client("Pompiers de Morges", "Avenue de la Gare", 13, 1014, "Morges")
    );

    @BeforeEach
    void setup() {
        System.out.println("Setting up DB");
        clientRepository.save(new Client("Boka Fitness", "Avenue de Flon", 11, 1012, "Lausannne"));
    }

    @AfterEach
    void clear() {
        System.out.println("Clearing DB");
        clientRepository.deleteAll();
    }

    @Test
    public void GetAllClientsTest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/clients");

        // Set up mock behavior
        when(clientService.getClients()).thenReturn(clients);

        System.out.println("Before request");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].name").value("Boka Fitness"));
    }


    /*@Test
    public void successfulClientSubmissionTest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/addClient")
                .param("name", "Harry")
                .param("subject", "Math")
                .param("score", "A");

        mockMvc.perform(request)
                .andExpect(status().i)
                .andExpect(redirectedUrl("/grades"));
    }*/

}
