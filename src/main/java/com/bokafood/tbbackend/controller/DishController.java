package com.bokafood.tbbackend.controller;

import com.bokafood.tbbackend.dto.dishes.DishWithIngredientListDTO;
import com.bokafood.tbbackend.dto.dishes.DishDTO;
import com.bokafood.tbbackend.dto.dishes.DishLightDTO;
import com.bokafood.tbbackend.service.DishService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping
    public ResponseEntity<List<DishLightDTO>> getDishes() {
        return new ResponseEntity<>(dishService.getDishes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DishDTO> getDishById(@PathVariable Long id) {
        return new ResponseEntity<>(dishService.getDishById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DishDTO> addDish(@Valid @RequestBody DishDTO dishDTO) {
        return new ResponseEntity<>(dishService.addDish(dishDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DishDTO> updateDish(@PathVariable Long id, @Valid @RequestBody DishDTO dishDTO) {
        return new ResponseEntity<>(dishService.updateDish(id, dishDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDish(@PathVariable Long id) {
        dishService.deleteDish(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*@GetMapping("/{id}/ingredients")
    public ResponseEntity<List<DishWithIngredientsDTO>> getDishByIdWithIngredients(@PathVariable Long id) {
        return new ResponseEntity<>(dishService.getDishByIdWithIngredients(id), HttpStatus.OK);
    }*/

    @GetMapping("/min")
    public ResponseEntity<List<DishWithIngredientListDTO>> getMinimumDish() {
        return new ResponseEntity<>(dishService.getDishesWithIngredients(), HttpStatus.OK);
    }

}
