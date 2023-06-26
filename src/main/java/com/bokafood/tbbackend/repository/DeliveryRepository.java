package com.bokafood.tbbackend.repository;

import com.bokafood.tbbackend.entity.Delivery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends CrudRepository<Delivery, Long> {
}
