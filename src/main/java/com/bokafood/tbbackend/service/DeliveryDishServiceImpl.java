package com.bokafood.tbbackend.service;


import com.bokafood.tbbackend.entity.DeliveryDish;
import com.bokafood.tbbackend.entity.DeliveryDishId;
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
    public DeliveryDish getDeliveryDishById(DeliveryDishId id) {
        Optional<DeliveryDish> deliveryDish = deliveryDishRepository.findById(id);
        if(deliveryDish.isPresent()) {
            return deliveryDish.get();
        } else {
            throw new EntityNotFoundException(id.getIdDish(), id.getIdDelivery(), DeliveryDish.class);
        }
    }

    @Override
    public DeliveryDish addDeliveryDish(DeliveryDish deliveryDish) {
        return deliveryDishRepository.save(deliveryDish);
    }

    @Override
    public DeliveryDish updateDeliveryDish(DeliveryDishId id, DeliveryDish updatedDeliveryDish) {
        DeliveryDish deliveryDish = getDeliveryDishById(id);
        deliveryDish.update(updatedDeliveryDish);
        return deliveryDishRepository.save(deliveryDish);
    }

    @Override
    public void deleteDeliveryDish(DeliveryDishId id) {
        deliveryDishRepository.deleteById(id);
    }

    @Override
    public List<DeliveryDish> findAllByDeliveryId(Long id) {
        return deliveryDishRepository.findAllByDeliveryId(id);
    }
}
