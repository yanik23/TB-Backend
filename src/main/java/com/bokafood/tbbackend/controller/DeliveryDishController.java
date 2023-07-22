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


@Controller
@RequestMapping("/deliveryDishes")
public class DeliveryDishController {

    @Autowired
    private DeliveryDishService deliveryDishService;

    @GetMapping
    public ResponseEntity<List<DeliveryDish>> getDeliveryDishes() {
        return new ResponseEntity<>(deliveryDishService.getDeliveryDishes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryDish> getDeliveryDishById(@PathVariable DeliveryDishId id) {
        return new ResponseEntity<>(deliveryDishService.getDeliveryDishById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DeliveryDish> addDeliveryDish(@Valid @RequestBody DeliveryDish deliveryDish) {
        return new ResponseEntity<>(deliveryDishService.addDeliveryDish(deliveryDish), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeliveryDish> updateDeliveryDish(@PathVariable DeliveryDishId id, @Valid @RequestBody DeliveryDish deliveryDish) {
        return new ResponseEntity<>(deliveryDishService.updateDeliveryDish(id, deliveryDish), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDeliveryDish(@PathVariable DeliveryDishId id) {
        deliveryDishService.deleteDeliveryDish(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
