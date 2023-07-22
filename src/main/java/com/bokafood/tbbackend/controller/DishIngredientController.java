package com.bokafood.tbbackend.controller;

import com.bokafood.tbbackend.dto.dishesIngredientsDTO.DishIngredientDTO;
import com.bokafood.tbbackend.dto.dishesIngredientsDTO.DishIngredientObjectDTO;
import com.bokafood.tbbackend.entity.DishIngredient;
import com.bokafood.tbbackend.entity.DishIngredientId;
import com.bokafood.tbbackend.service.DishIngredientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dishIngredients")
public class DishIngredientController {

    @Autowired
    private DishIngredientService dishIngredientService;

    @GetMapping
    public ResponseEntity<List<DishIngredient>> getDishIngredients() {
        return new ResponseEntity<>(dishIngredientService.getDishIngredients(), org.springframework.http.HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DishIngredient> getDishIngredientById(@PathVariable DishIngredientId id) {
        return new ResponseEntity<>(dishIngredientService.getDishIngredientById(id), org.springframework.http.HttpStatus.OK) ;
    }

    @PostMapping
    public ResponseEntity<DishIngredientDTO> addDishIngredient(@Valid @RequestBody DishIngredientObjectDTO dishIngredientObjectDTO) {
        return new ResponseEntity<>(dishIngredientService.addDishIngredient(dishIngredientObjectDTO), org.springframework.http.HttpStatus.CREATED) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<DishIngredientDTO> updateDishIngredient(@PathVariable DishIngredientId id, @Valid @RequestBody DishIngredientObjectDTO dishIngredient) {
        return new ResponseEntity<>(dishIngredientService.updateDishIngredient(id, dishIngredient), org.springframework.http.HttpStatus.OK) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<org.springframework.http.HttpStatus> deleteDishIngredient(@PathVariable DishIngredientId id) {
        dishIngredientService.deleteDishIngredient(id);
        return new ResponseEntity<>(org.springframework.http.HttpStatus.NO_CONTENT) ;
    }

}
