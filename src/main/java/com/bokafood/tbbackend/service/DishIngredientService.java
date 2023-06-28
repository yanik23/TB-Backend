package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.entity.DishIngredient;
import java.util.List;

public interface DishIngredientService {
    List<DishIngredient> getDishIngredients();
    DishIngredient getDishIngredientById(Long id);
    DishIngredient addDishIngredient(DishIngredient dishIngredient);
    DishIngredient updateDishIngredient(Long id, DishIngredient updatedDishIngredient);
    void deleteDishIngredient(Long id);

}