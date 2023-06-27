package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.entity.Delivery;
import com.bokafood.tbbackend.exception.EntityNotFoundException;
import com.bokafood.tbbackend.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryServiceImpl implements DeliveryService {


    @Autowired
    DeliveryRepository deliveryRepository;

    @Override
    public List<Delivery> getDeliveries() {
        return (List<Delivery>) deliveryRepository.findAll();
    }

    @Override
    public Delivery getDeliveryById(Long id) {
        Optional<Delivery> delivery = deliveryRepository.findById(id);
        if(delivery.isPresent()) {
            return delivery.get();
        } else {
            throw new EntityNotFoundException(id, Delivery.class);
        }
    }

    @Override
    public Delivery addDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    @Override
    public Delivery updateDelivery(Long id, Delivery updatedDelivery) {
        Delivery delivery = getDeliveryById(id);
        delivery.update(updatedDelivery);
        return deliveryRepository.save(delivery);
    }

    @Override
    public void deleteDelivery(Long id) {
        deliveryRepository.deleteById(id);
    }

    @Override
    public List<Delivery> getDeliveriesByClientId(Long id) {
        return deliveryRepository.findAllByClientId(id);
    }
}
