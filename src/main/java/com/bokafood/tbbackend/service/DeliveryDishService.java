package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.entity.DeliveryDish;
import com.bokafood.tbbackend.entity.DeliveryDishId;
import java.util.List;

/**
 * DeliveryDishSercice is an interface that provides methods to manage the many-to-many table between the delivery and the dish.
 * Implementation of this interface is in DeliveryDishServiceImpl class.
 * Implements CRUD operations for deliveryDish.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 *
 */
public interface DeliveryDishService {

    /**
     * Method to get all deliveryDishes.
     * @return List<DeliveryDish> of all deliveryDishes.
     */
    List<DeliveryDish> getDeliveryDishes();

    /**
     * Method to get a deliveryDish by its id.
     * @param id The id of the deliveryDish to be found.
     * @return DeliveryDish with the deliveryDish if found.
     */
    DeliveryDish getDeliveryDishById(DeliveryDishId id);

    /**
     * Method to add a new deliveryDish.
     * @param deliveryDish The DeliveryDish object to be added.
     * @return DeliveryDish with the added deliveryDish.
     */
    DeliveryDish addDeliveryDish(DeliveryDish deliveryDish);

    /**
     * Method to update an existing deliveryDish.
     * @param id The id of the deliveryDish to be updated.
     * @param updatedDeliveryDish The DeliveryDish object with the updated deliveryDish.
     * @return DeliveryDish with the updated deliveryDish.
     */
    DeliveryDish updateDeliveryDish(DeliveryDishId id, DeliveryDish updatedDeliveryDish);

    /**
     * Method to get all deliveryDish for a given delivery id.
     * @param id The id of the delivery for which the deliveryDishes should be returned.
     */
    List<DeliveryDish> findAllByDeliveryId(Long id);

    /**
     * Method to delete a deliveryDish.
     * @param id The id of the deliveryDish to be deleted.
     */
    void deleteDeliveryDish(DeliveryDishId id);

}
