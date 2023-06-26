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
			new Client("Boka Fitness", "Avenue de Flon", 11, 1012, "Lausannne"),
			new Client("Planet Fitness", "Avenue de Wallstreet", 12, 1013, "Lausannne"),
			new Client("Pompiers de Morges", "Avenue de la Gare", 13, 1014, "Morges")
		};

		for(Client client: clients) {
			clientRepository.save(client);
		}
	}

}
