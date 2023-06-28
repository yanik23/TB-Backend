package com.bokafood.tbbackend.controller;

import com.bokafood.tbbackend.dto.DishWithIngredientsDTO;
import com.bokafood.tbbackend.entity.Dish;
import com.bokafood.tbbackend.service.DishService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping
    public ResponseEntity<List<Dish>> getDishes() {
        return new ResponseEntity<>(dishService.getDishes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dish> getDishById(@PathVariable Long id) {
        return new ResponseEntity<>(dishService.getDishById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Dish> addDish(@Valid @RequestBody Dish dish) {
        return new ResponseEntity<>(dishService.addDish(dish), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dish> updateDish(@PathVariable Long id, @Valid @RequestBody Dish dish) {
        return new ResponseEntity<>(dishService.updateDish(id, dish), HttpStatus.OK);
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
    public ResponseEntity<List<DishWithIngredientsDTO>> getMinimumDish() {
        return new ResponseEntity<>(dishService.getMinDish(), HttpStatus.OK);
    }
}
