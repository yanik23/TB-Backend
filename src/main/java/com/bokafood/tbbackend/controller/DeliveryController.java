package com.bokafood.tbbackend.controller;


import com.bokafood.tbbackend.dto.deliveries.DeliveryDTO;
import com.bokafood.tbbackend.dto.deliveries.DeliveryWithDetailsDTO;
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
    public ResponseEntity<List<DeliveryDTO>> getDeliveries() {
        return new ResponseEntity<>(deliveryService.getDeliveries(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryWithDetailsDTO> getDeliveryById(@PathVariable Long id) {
        return new ResponseEntity<>(deliveryService.getDeliveryById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DeliveryDTO> addDelivery(@Valid @RequestBody DeliveryWithDetailsDTO deliveryWithDetailsDTO) {
        return new ResponseEntity<>(deliveryService.addDelivery(deliveryWithDetailsDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeliveryDTO> updateDelivery(@PathVariable Long id, @Valid @RequestBody DeliveryDTO updatedDeliveryWithDetailsDTO) {
        return new ResponseEntity<>(deliveryService.updateDelivery(id, updatedDeliveryWithDetailsDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDelivery(@PathVariable Long id) {
        deliveryService.deleteDelivery(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*@GetMapping("/client/{id}")
    public ResponseEntity<List<Delivery>> getDeliveriesByClientId(@PathVariable Long id) {
        return new ResponseEntity<>(deliveryService.getDeliveriesByClientId(id), HttpStatus.OK);
    }*/
}

