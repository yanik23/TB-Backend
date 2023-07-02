package com.bokafood.tbbackend;

import com.bokafood.tbbackend.entity.*;
import com.bokafood.tbbackend.repository.ClientRepository;
import com.bokafood.tbbackend.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;



@SpringBootApplication
@AllArgsConstructor
public class TbBackendApplication implements CommandLineRunner {

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	DeliveryRepository deliveryRepository;

	public static void main(String[] args) {
		SpringApplication.run(TbBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*Client client1 = new Client("Boka Fitness", "Avenue de Flon", 11, 1012, "Lausannne");
		Client client2 = new Client("Planet Fitness", "Avenue de Wallstreet", 12, 1013, "Lausannne");
		Client client3 = new Client("Pompiers de Morges", "Avenue de la Gare", 13, 1014, "Morges");

		Ingredient ingredient1 = new Ingredient("Tomate", Ingredient.IngredientType.FRUIT, "tomate grappe", "Aligro");
		Ingredient ingredient2 = new Ingredient("Pomme", Ingredient.IngredientType.FRUIT, "pomme rouge", "Aligro");
		Ingredient ingredient3 = new Ingredient("Poire", Ingredient.IngredientType.FRUIT, "poire verte", "Migros");
		Ingredient ingredient4 = new Ingredient("Banane", Ingredient.IngredientType.FRUIT, "", "");
		Ingredient ingredient5 = new Ingredient("Mozzarella", Ingredient.IngredientType.OTHER, "", "");

		Dish dish1 = new Dish("Salade de tomate", "Salade de tomate avec mozzarella",
				Dish.DishType.VEGETARIAN, Dish.DishSize.FIT, 10.0, true, 150,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

		Dish dish2 = new Dish("Salade de pomme", "Salade de pomme avec mozzarella",
				Dish.DishType.VEGETARIAN, Dish.DishSize.FIT, 12, true,
				120, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);


		// TODO Auto-generated method stub
		Client[] clients = new Client[] {
			client1,
			client2,
			client3
		};

		for(Client client: clients) {
			clientRepository.save(client);
		}

		Delivery[] deliveries = new Delivery[] {
			new Delivery(LocalDateTime.now(), "", client1),
			new Delivery(LocalDateTime.now(), "this is details of a command", client1),
			new Delivery(LocalDateTime.now(), "no details", client2)
		};

		for(Delivery delivery: deliveries) {
			deliveryRepository.save(delivery);
		}*/

	}

	/*@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}*/

}
