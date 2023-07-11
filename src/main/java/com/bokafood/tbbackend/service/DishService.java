package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.dto.dishes.DishWithIngredientListDTO;
import com.bokafood.tbbackend.dto.dishes.DishDTO;
import com.bokafood.tbbackend.dto.dishes.DishLightDTO;
import com.bokafood.tbbackend.entity.Dish;

import java.util.List;

public interface DishService {
    List<DishLightDTO> getDishes();
    DishWithIngredientListDTO getDishById(Long id);
    DishDTO addDish(DishWithIngredientListDTO dishDTO);
    DishDTO updateDish(Long id, DishWithIngredientListDTO updatedDishDTO);
    void deleteDish(Long id);
    List<DishWithIngredientListDTO> getDishesWithIngredients();
}
