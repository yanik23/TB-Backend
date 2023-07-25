package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.dto.deliveriesDTO.DeliveryDTO;
import com.bokafood.tbbackend.dto.deliveriesDTO.DeliveryWithDetailsDTO;
import com.bokafood.tbbackend.dto.dishesDTO.DishForDeliveryDTO;
import com.bokafood.tbbackend.dto.dishesDTO.DishWithIngredientListDTO;
import com.bokafood.tbbackend.entity.*;
import com.bokafood.tbbackend.exception.EntityNotFoundException;
import com.bokafood.tbbackend.repository.DeliveryRepository;
import com.bokafood.tbbackend.repository.UserRepository;
import com.bokafood.tbbackend.utils.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryServiceImpl implements DeliveryService {


    @Autowired
    DeliveryRepository deliveryRepository;

    @Autowired
    DishService dishService;

    @Autowired
    DeliveryDishService deliveryDishService;

    @Autowired
    ClientService clientService;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<DeliveryDTO> getDeliveries() {
        List<Delivery> deliveries = (List<Delivery>) deliveryRepository.findAll();
        return deliveries.stream().map(DeliveryMapper::toDTO).toList();
    }

    @Override
    public DeliveryWithDetailsDTO getDeliveryById(Long id) {
        Optional<Delivery> delivery = deliveryRepository.findById(id);
        if(delivery.isPresent()) {
            DeliveryWithDetailsDTO deliveryWithDetailsDTO = DeliveryMapper.toDTOWithDetails(delivery.get());
            return deliveryWithDetailsDTO;
        } else {
            throw new EntityNotFoundException(id, Delivery.class);
        }
    }

    @Override
    public DeliveryDTO addDelivery(DeliveryWithDetailsDTO deliveryWithDetailsDTO) {

        Delivery delivery = DeliveryMapper.toDelivery(deliveryWithDetailsDTO);

        Client client = ClientMapper.toClient(clientService.getClientByName(deliveryWithDetailsDTO.getClientName()));
        delivery.setClient(client);

        Optional<User> user = userRepository.findByUsername(deliveryWithDetailsDTO.getUserName());

        if(user.isPresent()) {
        	delivery.setUser(user.get());
        } else {
        	throw new EntityNotFoundException(deliveryWithDetailsDTO.getUserName(), User.class);
        }

        Delivery savedDelivery = deliveryRepository.save(delivery);
        List<DishForDeliveryDTO> dishes = deliveryWithDetailsDTO.getDishes();

        if(dishes != null) {
            for (DishForDeliveryDTO dish : dishes) {
                Dish dishEntity = DishMapper.toDishWithId(dishService.getDishById(dish.getId()));
                DeliveryDishId deliveryDishId = new DeliveryDishId(savedDelivery.getId(), dish.getId());
                DeliveryDish deliveryDish = new DeliveryDish(deliveryDishId, savedDelivery, dishEntity, dish.getQuantityRemained(), dish.getQuantityDelivered());
                deliveryDishService.addDeliveryDish(deliveryDish);
            }
        }
        return DeliveryMapper.toDTO(savedDelivery);

    }

    @Transactional
    @Override
    public DeliveryDTO updateDelivery(Long id, DeliveryWithDetailsDTO updatedDeliveryDTO) {
        Delivery delivery = DeliveryMapper.toDelivery(getDeliveryById(id));
        update(delivery, updatedDeliveryDTO);
        Delivery savedDelivery = deliveryRepository.save(delivery);
        return DeliveryMapper.toDTO(savedDelivery);
    }

    @Override
    public void deleteDelivery(Long id) {
        deliveryRepository.deleteById(id);
    }


    private void update(Delivery delivery, DeliveryWithDetailsDTO updatedDeliveryWithDetailsDTO) {
        delivery.setClient(ClientMapper.toClient(clientService.getClientByName(updatedDeliveryWithDetailsDTO.getClientName())));
        delivery.setUser(userRepository.findByUsername(updatedDeliveryWithDetailsDTO.getUserName()).get());
        delivery.setDeliveryDate(updatedDeliveryWithDetailsDTO.getDeliveryDate());


        List<DishForDeliveryDTO> updatedDishes = updatedDeliveryWithDetailsDTO.getDishes();
        List<DeliveryDish> deliveryDishes = new ArrayList<>();

        if (updatedDishes != null) {
            List<DeliveryDish> existingDishes = deliveryDishService.findAllByDeliveryId(delivery.getId());

            for (DeliveryDish existingDish : existingDishes) {
                DeliveryDishId existingDishId = existingDish.getId();
                boolean dishExists = updatedDishes.stream()
                        .anyMatch(dish -> dish.getId().equals(existingDishId.getIdDish()));

                if (!dishExists) {
                    deliveryDishService.deleteDeliveryDish(existingDishId);
                }
            }
            for (DishForDeliveryDTO dish : updatedDishes) {
                DishWithIngredientListDTO dishDTO = dishService.getDishById(dish.getId());
                Dish dishEntity = DishMapper.toDishWithId(dishDTO);
                DeliveryDishId deliveryDishId = new DeliveryDishId(delivery.getId(), dish.getId());
                // Check if the ingredient already exists
                DeliveryDish existingDish = findExistingDish(existingDishes, deliveryDishId);
                if (existingDish != null) {
                    // If the ingredient exists, add it to the new dishIngredients list
                    deliveryDishes.add(existingDish);
                } else {
                    // If the ingredient is new, create a new DishIngredient entity
                    DeliveryDish deliveryDish = new DeliveryDish(deliveryDishId, delivery, dishEntity, dish.getQuantityRemained(), dish.getQuantityDelivered());
                    deliveryDishes.add(deliveryDish);
                }
            }
        }
        delivery.setDeliveryDishes(deliveryDishes);
    }

    private DeliveryDish findExistingDish(List<DeliveryDish> existingDishes, DeliveryDishId deliveryDishId) {
        for (DeliveryDish existingDish : existingDishes) {
            if (existingDish.getId().equals(deliveryDishId)) {
                return existingDish;
            }
        }
        return null;
    }
}
