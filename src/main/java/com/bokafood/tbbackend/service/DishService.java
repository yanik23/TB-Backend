package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.dto.dishesDTO.DishWithIngredientListDTO;
import com.bokafood.tbbackend.dto.dishesDTO.DishDTO;
import com.bokafood.tbbackend.dto.dishesDTO.DishLightDTO;
import java.util.List;


/**
 * DishService is an interface that provides methods to manage dishes.
 * Implementation of this interface is in DishServiceImpl class.
 * Implements CRUD operations for dishes.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
public interface DishService {

    /**
     * Method to get all dishes.
     * @return List<DishDTO> of all dishes.
     */
    List<DishLightDTO> getDishes();

    /**
     * Method to get a dish by its id.
     * @param id The id of the dish to be found.
     * @return DishWithIngredientListDTO with the dish if found.
     */
    DishWithIngredientListDTO getDishById(Long id);

    /**
     * Method to add a new dish.
     * @param dishDTO The DishDTO object to be added.
     * @return DishDTO with the added dish.
     */
    DishDTO addDish(DishWithIngredientListDTO dishDTO);

    /**
     * Method to update an existing dish.
     * @param id The id of the dish to be updated.
     * @param updatedDishDTO The DishDTO object with the updated dish.
     * @return DishDTO with the updated dish.
     */
    DishDTO updateDish(Long id, DishWithIngredientListDTO updatedDishDTO);

    /**
     * Method to delete a dish.
     * @param id The id of the dish to be deleted.
     */
    void deleteDish(Long id);

    /**
     * Method to get all dishes with ingredients.
     * @return a list of dishes with the ingredients.
     */
    List<DishWithIngredientListDTO> getDishesWithIngredients();
}
