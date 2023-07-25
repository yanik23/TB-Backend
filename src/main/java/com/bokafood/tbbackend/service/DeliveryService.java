package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.dto.deliveriesDTO.DeliveryDTO;
import com.bokafood.tbbackend.dto.deliveriesDTO.DeliveryWithDetailsDTO;
import java.util.List;


/**
 * DeliveryService is an interface that provides methods to manage deliveries.
 * Implementation of this interface is in DeliveryServiceImpl class.
 * Implements CRUD operations for deliveries.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 *
 */
public interface DeliveryService {

    /**
     * Method to get all deliveries.
     * @return List<DeliveryDTO> of all deliveries.
     */
    List<DeliveryDTO> getDeliveries();

    /**
     * Method to get a delivery by its id.
     * @param id The id of the delivery to be found.
     * @return DeliveryWithDetailsDTO with the delivery if found.
     */
    DeliveryWithDetailsDTO getDeliveryById(Long id);

    /**
     * Method to add a new delivery.
     * @param deliveryWithDetailsDTO The DeliveryWithDetailsDTO object to be added.
     * @return DeliveryDTO with the added delivery.
     */
    DeliveryDTO addDelivery(DeliveryWithDetailsDTO deliveryWithDetailsDTO);

    /**
     * Method to update an existing delivery.
     * @param id The id of the delivery to be updated.
     * @param updatedDeliveryWithDetailsDTO The DeliveryWithDetailsDTO object with the updated delivery.
     * @return DeliveryDTO with the updated delivery.
     */
    DeliveryDTO updateDelivery(Long id, DeliveryWithDetailsDTO updatedDeliveryWithDetailsDTO);

    /**
     * Method to delete a delivery.
     * @param id The id of the delivery to be deleted.
     */
    void deleteDelivery(Long id);

}
