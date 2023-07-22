package com.bokafood.tbbackend.repository;

import com.bokafood.tbbackend.entity.Delivery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DeliveryRepository extends CrudRepository<Delivery, Long> {
    List<Delivery> findAllByClientId(Long id);
}
