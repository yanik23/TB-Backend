package com.bokafood.tbbackend.repository;

import com.bokafood.tbbackend.entity.Delivery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Delivery repository class used for CRUD operations on the Delivery entity.
 * Uses hibernate to access the database.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
@Repository
public interface DeliveryRepository extends CrudRepository<Delivery, Long> {
    //List<Delivery> findAllByClientId(Long id);
}
