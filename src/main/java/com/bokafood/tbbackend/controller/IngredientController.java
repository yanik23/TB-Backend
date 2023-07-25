package com.bokafood.tbbackend.controller;


import com.bokafood.tbbackend.dto.ingredientsDTO.IngredientDTO;
import com.bokafood.tbbackend.service.IngredientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Controller class used to handle HTTP requests for the Ingredient entity.
 * It uses the IngredientService class to perform CRUD operations.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
@Controller
@RequestMapping("/ingredients")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    /**
     * Method to handle HTTP GET requests for all ingredients.
     * @return ResponseEntity with a list of IngredientDTO objects and HTTP status code.
     */
    @GetMapping
    public ResponseEntity<List<IngredientDTO>> getIngredients() {
        return new ResponseEntity<>(ingredientService.getIngredients(), HttpStatus.OK);
    }

    /**
     * Method to handle HTTP GET requests for an ingredient by its id.
     * @param id The id of the ingredient to be returned.
     * @return ResponseEntity with an IngredientDTO object and HTTP status code.
     */
    @GetMapping("/{id}")
    public ResponseEntity<IngredientDTO> getIngredientById(@PathVariable Long id) {
        return new ResponseEntity<>(ingredientService.getIngredientById(id), HttpStatus.OK);
    }

    /**
     * Method to handle HTTP POST requests to add a new ingredient.
     * @param ingredientDTO The IngredientDTO object to be added.
     * @return ResponseEntity with an IngredientDTO object and HTTP status code.
     */
    @PostMapping
    public ResponseEntity<IngredientDTO> addIngredient(@Valid @RequestBody IngredientDTO ingredientDTO) {
        return new ResponseEntity<>(ingredientService.addIngredient(ingredientDTO), HttpStatus.CREATED);
    }

    /**
     * Method to handle HTTP PUT requests to update an existing ingredient.
     * @param id The id of the ingredient to be updated.
     * @param ingredientDTO The IngredientDTO object to be updated.
     * @return ResponseEntity with an IngredientDTO object and HTTP status code.
     */
    @PutMapping("/{id}")
    public ResponseEntity<IngredientDTO> updateIngredient(@PathVariable Long id, @Valid @RequestBody IngredientDTO ingredientDTO) {
        return new ResponseEntity<>(ingredientService.updateIngredient(id, ingredientDTO), HttpStatus.OK);
    }

    /**
     * Method to handle HTTP DELETE requests to delete an existing ingredient.
     * @param id The id of the ingredient to be deleted.
     * @return ResponseEntity with HTTP status code.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteIngredient(@PathVariable Long id) {
        ingredientService.deleteIngredient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
