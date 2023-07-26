package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.dto.dishesIngredientsDTO.DishIngredientDTO;
import com.bokafood.tbbackend.dto.dishesIngredientsDTO.DishIngredientObjectDTO;
import com.bokafood.tbbackend.entity.DishIngredient;
import com.bokafood.tbbackend.entity.DishIngredientId;
import java.util.List;

/**
 * DishIngredientService is an interface that provides methods to manage dish ingredients.
 * Implementation of this interface is in DishIngredientServiceImpl class.
 * Implements CRUD operations for dish ingredients.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
public interface DishIngredientService {

    /**
     * Method to get all dish ingredients.
     * @return List<DishIngredient> of all dish ingredients.
     */
    List<DishIngredient> getDishIngredients();

    /**
     * Method to get a dish ingredient by its id.
     * @param id The id of the dish ingredient to be found.
     * @return DishIngredient with the dish ingredient if found.
     */
    DishIngredient getDishIngredientById(DishIngredientId id);

    /**
     * Method to add a new dish ingredient.
     * @param dishIngredientObjectDTO The DishIngredientObjectDTO object to be added.
     * @return DishIngredientDTO with the added dish ingredient.
     */
    DishIngredientDTO addDishIngredient(DishIngredientObjectDTO dishIngredientObjectDTO);

    /**
     * Method to update an existing dish ingredient.
     * @param id The id of the dish ingredient to be updated.
     * @param updatedDishIngredient The DishIngredientObjectDTO object with the updated dish ingredient.
     * @return DishIngredientDTO with the updated dish ingredient.
     */
    DishIngredientDTO updateDishIngredient(DishIngredientId id, DishIngredientObjectDTO updatedDishIngredient);

    /**
     * Method to delete a dish ingredient.
     * @param id The id of the dish ingredient to be deleted.
     */
    void deleteDishIngredient(DishIngredientId id);

    /**
     * Method to get all dish ingredients for a given dish id.
     * @param id The id of the dish for which the dish ingredients should be returned.
     */
    List<DishIngredient> findAllByDishId(Long id);


}
