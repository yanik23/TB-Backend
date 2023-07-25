package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.dto.ingredientsDTO.IngredientDTO;
import java.util.List;

/**
 * IngredientService is an interface that provides methods to manage ingredients.
 * Implementation of this interface is in IngredientServiceImpl class.
 * Implements CRUD operations for ingredients.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 *
 */
public interface IngredientService {
    /**
     * Method to get all ingredients.
     * @return List<IngredientDTO> of all ingredients.
     */
    List<IngredientDTO> getIngredients();

    /**
     * Method to get an ingredient by its id.
     * @param id The id of the ingredient to be found.
     * @return IngredientDTO with the ingredient if found.
     */
    IngredientDTO getIngredientById(Long id);

    /**
     * Method to add a new ingredient.
     * @param ingredientDTO The IngredientDTO object to be added.
     * @return IngredientDTO with the added ingredient.
     */
    IngredientDTO addIngredient(IngredientDTO ingredientDTO);

    /**
     * Method to update an existing ingredient.
     * @param id The id of the ingredient to be updated.
     * @param updatedIngredientDTO The IngredientDTO object with the updated ingredient.
     * @return IngredientDTO with the updated ingredient.
     */
    IngredientDTO updateIngredient(Long id, IngredientDTO updatedIngredientDTO);

    /**
     * Method to delete an ingredient.
     * @param id The id of the ingredient to be deleted.
     */
    void deleteIngredient(Long id);
}
