package com.bokafood.tbbackend.controller;

import com.bokafood.tbbackend.dto.dishesDTO.DishWithIngredientListDTO;
import com.bokafood.tbbackend.dto.dishesDTO.DishDTO;
import com.bokafood.tbbackend.dto.dishesDTO.DishLightDTO;
import com.bokafood.tbbackend.service.DishService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * Controller class used to handle HTTP requests for the Dish entity.
 * It uses the DishService class to perform CRUD operations.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
@Controller
@RequestMapping("/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    /**
     * Method to handle HTTP GET requests for all dishes.
     * @return ResponseEntity with a list of DishDTO objects and HTTP status code.
     */
    @GetMapping
    public ResponseEntity<List<DishLightDTO>> getDishes() {
        return new ResponseEntity<>(dishService.getDishes(), HttpStatus.OK);
    }

    /**
     * Method to handle HTTP GET requests for a dish by its id.
     * @param id The id of the dish to be returned.
     * @return ResponseEntity with a DishDTO object and HTTP status code.
     */
    @GetMapping("/{id}")
    public ResponseEntity<DishWithIngredientListDTO> getDishById(@PathVariable Long id) {
        return new ResponseEntity<>(dishService.getDishById(id), HttpStatus.OK);
    }

    /**
     * Method to handle HTTP POST requests to add a new dish.
     * @param dishDTO The DishDTO object to be added.
     * @return ResponseEntity with a DishDTO object and HTTP status code.
     */
    @PostMapping
    public ResponseEntity<DishDTO> addDish(@Valid @RequestBody DishWithIngredientListDTO dishDTO) {
        return new ResponseEntity<>(dishService.addDish(dishDTO), HttpStatus.CREATED);
    }

    /**
     * Method to handle HTTP PUT requests to update an existing dish.
     * @param id The id of the dish to be updated.
     * @param dishDTO The DishDTO object used to update the existing Dish.
     * @return ResponseEntity with a DishDTO object and HTTP status code.
     */
    @PutMapping("/{id}")
    public ResponseEntity<DishDTO> updateDish(@PathVariable Long id, @Valid @RequestBody DishWithIngredientListDTO dishDTO) {
        return new ResponseEntity<>(dishService.updateDish(id, dishDTO), HttpStatus.OK);
    }

    /**
     * Method to handle HTTP DELETE requests to delete an existing dish.
     * @param id The id of the dish to be deleted.
     * @return ResponseEntity with HTTP status code.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDish(@PathVariable Long id) {
        dishService.deleteDish(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Method to handle HTTP GET requests for all dishes with their ingredients.
     * @return ResponseEntity with a list of DishWithIngredientListDTO objects and HTTP status code.
     */
    @GetMapping("/ingredients")
    public ResponseEntity<List<DishWithIngredientListDTO>> getDishesWithIngredients() {
        return new ResponseEntity<>(dishService.getDishesWithIngredients(), HttpStatus.OK);
    }

}
