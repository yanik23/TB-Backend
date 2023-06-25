package com.bokafood.tbbackend;

import com.bokafood.tbbackend.entity.Client;
import com.bokafood.tbbackend.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@AllArgsConstructor
@SpringBootApplication
public class TbBackendApplication implements CommandLineRunner {

	ClientRepository clientRepository;

	public static void main(String[] args) {
		SpringApplication.run(TbBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Client[] clients = new Client[] {
			new Client("Boka Food", "Avenue de la Gombe", 11, 1012, "Lausannne")
		};

		for(Client client: clients) {
			clientRepository.save(client);
		}
	}

}
