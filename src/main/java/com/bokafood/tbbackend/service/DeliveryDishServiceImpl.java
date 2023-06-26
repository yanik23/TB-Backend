package com.bokafood.tbbackend.service;


import com.bokafood.tbbackend.entity.DeliveryDish;
import com.bokafood.tbbackend.exception.EntityNotFoundException;
import com.bokafood.tbbackend.repository.DeliveryDishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryDishServiceImpl implements DeliveryDishService {

    @Autowired
    private DeliveryDishRepository deliveryDishRepository;

    @Override
    public List<DeliveryDish> getDeliveryDishes() {
        return (List<DeliveryDish>) deliveryDishRepository.findAll();
    }

    @Override
    public DeliveryDish getDeliveryDishById(Long id) {
        Optional<DeliveryDish> deliveryDish = deliveryDishRepository.findById(id);
        if(deliveryDish.isPresent()) {
            return deliveryDish.get();
        } else {
            throw new EntityNotFoundException(id, DeliveryDish.class);
        }
    }

    @Override
    public DeliveryDish addDeliveryDish(DeliveryDish deliveryDish) {
        return deliveryDishRepository.save(deliveryDish);
    }

    @Override
    public DeliveryDish updateDeliveryDish(Long id, DeliveryDish updatedDeliveryDish) {
        DeliveryDish deliveryDish = getDeliveryDishById(id);
        deliveryDish.update(updatedDeliveryDish);
        return deliveryDishRepository.save(deliveryDish);
    }

    @Override
    public void deleteDeliveryDish(Long id) {
        deliveryDishRepository.deleteById(id);
    }
}
