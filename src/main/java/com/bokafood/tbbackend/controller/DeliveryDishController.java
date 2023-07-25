package com.bokafood.tbbackend.controller;

import com.bokafood.tbbackend.entity.DeliveryDish;
import com.bokafood.tbbackend.entity.DeliveryDishId;
import com.bokafood.tbbackend.service.DeliveryDishService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * Controller class used to handle HTTP requests for the DeliveryDish entity.
 * It uses the DeliveryDishService class to perform CRUD operations.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
@Controller
@RequestMapping("/deliveryDishes")
public class DeliveryDishController {

    @Autowired
    private DeliveryDishService deliveryDishService;

    /**
     * Method to handle HTTP GET requests for all delivery dishes.
     * @return ResponseEntity with a list of DeliveryDish objects and HTTP status code.
     */
    @GetMapping
    public ResponseEntity<List<DeliveryDish>> getDeliveryDishes() {
        return new ResponseEntity<>(deliveryDishService.getDeliveryDishes(), HttpStatus.OK);
    }

    /**
     * Method to handle HTTP GET requests for a delivery dish by its id.
     * @param id The id of the delivery dish to be returned.
     * @return ResponseEntity with a DeliveryDish object and HTTP status code.
     */
    @GetMapping("/{id}")
    public ResponseEntity<DeliveryDish> getDeliveryDishById(@PathVariable DeliveryDishId id) {
        return new ResponseEntity<>(deliveryDishService.getDeliveryDishById(id), HttpStatus.OK);
    }

    /**
     * Method to handle HTTP POST requests to add a new delivery dish.
     * @param deliveryDish The DeliveryDish object to be added.
     * @return ResponseEntity with a DeliveryDish object and HTTP status code.
     */
    @PostMapping
    public ResponseEntity<DeliveryDish> addDeliveryDish(@Valid @RequestBody DeliveryDish deliveryDish) {
        return new ResponseEntity<>(deliveryDishService.addDeliveryDish(deliveryDish), HttpStatus.CREATED);
    }

    /**
     * Method to handle HTTP PUT requests to update an existing delivery dish.
     * @param id The id of the delivery dish to be updated.
     * @param deliveryDish The DeliveryDish object with the updated delivery dish.
     * @return ResponseEntity with a DeliveryDish object and HTTP status code.
     */
    @PutMapping("/{id}")
    public ResponseEntity<DeliveryDish> updateDeliveryDish(@PathVariable DeliveryDishId id, @Valid @RequestBody DeliveryDish deliveryDish) {
        return new ResponseEntity<>(deliveryDishService.updateDeliveryDish(id, deliveryDish), HttpStatus.OK);
    }

    /**
     * Method to handle HTTP DELETE requests to delete an existing delivery dish.
     * @param id The id of the delivery dish to be deleted.
     * @return ResponseEntity with HTTP status code.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDeliveryDish(@PathVariable DeliveryDishId id) {
        deliveryDishService.deleteDeliveryDish(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
