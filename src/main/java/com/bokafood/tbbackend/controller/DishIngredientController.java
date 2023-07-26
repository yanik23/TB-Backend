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


/**
 * Controller class used to handle HTTP requests for the DishIngredient entity.
 * It uses the DishIngredientService class to perform CRUD operations.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
@Controller
@RequestMapping("/dishIngredients")
public class DishIngredientController {

    @Autowired
    private DishIngredientService dishIngredientService;

    /**
     * Method to handle HTTP GET requests for all dishIngredients.
     * @return ResponseEntity with a list of DishIngredient objects and HTTP status code.
     */
    @GetMapping
    public ResponseEntity<List<DishIngredient>> getDishIngredients() {
        return new ResponseEntity<>(dishIngredientService.getDishIngredients(), org.springframework.http.HttpStatus.OK) ;
    }

    /**
     * Method to handle HTTP GET requests for a dishIngredient by its id.
     * @param id The id of the dishIngredient to be returned.
     * @return ResponseEntity with a DishIngredient object and HTTP status code.
     */
    @GetMapping("/{id}")
    public ResponseEntity<DishIngredient> getDishIngredientById(@PathVariable DishIngredientId id) {
        return new ResponseEntity<>(dishIngredientService.getDishIngredientById(id), org.springframework.http.HttpStatus.OK) ;
    }

    /**
     * Method to handle HTTP POST requests to add a new dishIngredient.
     * @param dishIngredientObjectDTO the DishIngredientObjectDTO object to be added.
     * @return ResponseEntity with a DishIngredientDTO object created and HTTP status code.
     */
    @PostMapping
    public ResponseEntity<DishIngredientDTO> addDishIngredient(@Valid @RequestBody DishIngredientObjectDTO dishIngredientObjectDTO) {
        return new ResponseEntity<>(dishIngredientService.addDishIngredient(dishIngredientObjectDTO), org.springframework.http.HttpStatus.CREATED) ;
    }

    /**
     * Method to handle HTTP PUT requests to update an existing dishIngredient.
     * @param id The id of the dishIngredient to be updated.
     * @param dishIngredient the DishIngredientDTO object used to update the existing dishIngredient.
     * @return
     */
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
