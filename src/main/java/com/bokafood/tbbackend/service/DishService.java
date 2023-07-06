package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.dto.dishes.DishWithIngredientListDTO;
import com.bokafood.tbbackend.dto.dishes.DishDTO;
import com.bokafood.tbbackend.dto.dishes.DishLightDTO;

import java.util.List;

public interface DishService {
    List<DishLightDTO> getDishes();
    DishDTO getDishById(Long id);
    DishDTO addDish(DishWithIngredientListDTO dishDTO);
    DishDTO updateDish(Long id, DishDTO updatedDishDTO);
    void deleteDish(Long id);

    List<DishWithIngredientListDTO> getDishesWithIngredients();
}
