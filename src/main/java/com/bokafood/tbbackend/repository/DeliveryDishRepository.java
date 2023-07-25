package com.bokafood.tbbackend.repository;

import com.bokafood.tbbackend.entity.DeliveryDish;
import com.bokafood.tbbackend.entity.DeliveryDishId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * DeliveryDish repository class used for CRUD operations on the DeliveryDish entity.
 * Uses hibernate to access the database.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
@Repository
public interface DeliveryDishRepository extends CrudRepository<DeliveryDish, DeliveryDishId> {

    /**
     * Method to find all delivery dishes by delivery id.
     * @param id The id of the delivery.
     * @return List of delivery dishes.
     */
    List<DeliveryDish> findAllByDeliveryId(Long id);
}
