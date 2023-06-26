package com.bokafood.tbbackend.controller;


import com.bokafood.tbbackend.entity.Delivery;
import com.bokafood.tbbackend.service.DeliveryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping
    public ResponseEntity<List<Delivery>> getDeliveries() {
        return new ResponseEntity<>(deliveryService.getDeliveries(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Delivery> getDeliveryById(@PathVariable Long id) {
        return new ResponseEntity<>(deliveryService.getDeliveryById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Delivery> addDelivery(@Valid @RequestBody Delivery delivery) {
        return new ResponseEntity<>(deliveryService.addDelivery(delivery), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Delivery updateDelivery(@PathVariable Long id, @Valid @RequestBody Delivery updatedDelivery) {
        return deliveryService.updateDelivery(id, updatedDelivery);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDelivery(@PathVariable Long id) {
        deliveryService.deleteDelivery(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
