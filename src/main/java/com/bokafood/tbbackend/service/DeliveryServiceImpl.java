package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.dto.deliveries.DeliveryDTO;
import com.bokafood.tbbackend.dto.deliveries.DeliveryWithDetailsDTO;
import com.bokafood.tbbackend.entity.Delivery;
import com.bokafood.tbbackend.exception.EntityNotFoundException;
import com.bokafood.tbbackend.repository.DeliveryRepository;
import com.bokafood.tbbackend.utils.DeliveryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryServiceImpl implements DeliveryService {


    @Autowired
    DeliveryRepository deliveryRepository;

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
        //return deliveryRepository.save(delivery);
        return null;
    }

    @Override
    public DeliveryDTO updateDelivery(Long id, DeliveryDTO updatedDeliveryDTO) {
       /* Delivery delivery = getDeliveryById(id);
        delivery.update(updatedDelivery);
        return deliveryRepository.save(delivery);*/
        return null;
    }

    @Override
    public void deleteDelivery(Long id) {
        deliveryRepository.deleteById(id);
    }

   /* @Override
    public List<Delivery> getDeliveriesByClientId(Long id) {
        return deliveryRepository.findAllByClientId(id);
    }*/
}
