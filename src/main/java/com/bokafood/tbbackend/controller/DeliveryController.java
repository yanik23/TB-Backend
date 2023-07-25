package com.bokafood.tbbackend.controller;


import com.bokafood.tbbackend.dto.deliveriesDTO.DeliveryDTO;
import com.bokafood.tbbackend.dto.deliveriesDTO.DeliveryWithDetailsDTO;
import com.bokafood.tbbackend.service.DeliveryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * Controller class used to handle HTTP requests for the Delivery entity.
 * It uses the DeliveryService class to perform CRUD operations.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
@Controller
@RequestMapping("/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    /**
     * Method to handle HTTP GET requests for all deliveries.
     * @return ResponseEntity with a list of DeliveryDTO objects and HTTP status code.
     */
    @GetMapping
    public ResponseEntity<List<DeliveryDTO>> getDeliveries() {
        return new ResponseEntity<>(deliveryService.getDeliveries(), HttpStatus.OK);
    }

    /**
     * Method to handle HTTP GET requests for a delivery by its id.
     * @param id The id of the delivery to be returned.
     * @return ResponseEntity with a DeliveryDTO object and HTTP status code.
     */
    @GetMapping("/{id}")
    public ResponseEntity<DeliveryWithDetailsDTO> getDeliveryById(@PathVariable Long id) {
        return new ResponseEntity<>(deliveryService.getDeliveryById(id), HttpStatus.OK);
    }

    /**
     * Method to handle HTTP POST requests to add a new delivery.
     * @param deliveryWithDetailsDTO The DeliveryDTO object to be added.
     * @return ResponseEntity with a DeliveryDTO object and HTTP status code.
     */
    @PostMapping
    public ResponseEntity<DeliveryDTO> addDelivery(@Valid @RequestBody DeliveryWithDetailsDTO deliveryWithDetailsDTO) {
        return new ResponseEntity<>(deliveryService.addDelivery(deliveryWithDetailsDTO), HttpStatus.CREATED);
    }

    /**
     * Method to handle HTTP PUT requests to update an existing delivery.
     * @param id The id of the delivery to be updated.
     * @param updatedDeliveryWithDetailsDTO The DeliveryDTO object with updated fields.
     * @return ResponseEntity with a DeliveryDTO object and HTTP status code.
     */
    @PutMapping("/{id}")
    public ResponseEntity<DeliveryDTO> updateDelivery(@PathVariable Long id, @Valid @RequestBody DeliveryWithDetailsDTO updatedDeliveryWithDetailsDTO) {
        return new ResponseEntity<>(deliveryService.updateDelivery(id, updatedDeliveryWithDetailsDTO), HttpStatus.OK);
    }

    /**
     * Method to handle HTTP DELETE requests to delete an existing delivery.
     * @param id The id of the delivery to be deleted.
     * @return ResponseEntity with HTTP status code.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDelivery(@PathVariable Long id) {
        deliveryService.deleteDelivery(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

