package com.bokafood.tbbackend.repository;

import com.bokafood.tbbackend.entity.DeliveryDish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryDishRepository extends CrudRepository<DeliveryDish, Long> {
}
