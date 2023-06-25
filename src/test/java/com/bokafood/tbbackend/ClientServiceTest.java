package com.bokafood.tbbackend;


import com.bokafood.tbbackend.repository.ClientRepository;
import com.bokafood.tbbackend.service.ClientService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {
    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;



}
