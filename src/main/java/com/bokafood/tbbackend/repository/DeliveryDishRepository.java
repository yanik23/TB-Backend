package com.bokafood.tbbackend.repository;

import com.bokafood.tbbackend.entity.DeliveryDish;
import com.bokafood.tbbackend.entity.DeliveryDishId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryDishRepository extends CrudRepository<DeliveryDish, DeliveryDishId> {

    List<DeliveryDish> findAllByDeliveryId(Long id);
}
