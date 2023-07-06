package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.dto.dishesIngredientsDTO.DishIngredientDTO;
import com.bokafood.tbbackend.dto.dishesIngredientsDTO.DishIngredientObjectDTO;
import com.bokafood.tbbackend.entity.DishIngredient;
import java.util.List;

public interface DishIngredientService {
    List<DishIngredient> getDishIngredients();
    DishIngredient getDishIngredientById(Long id);
    DishIngredientDTO addDishIngredient(DishIngredientObjectDTO dishIngredientObjectDTO);
    DishIngredient updateDishIngredient(Long id, DishIngredient updatedDishIngredient);
    void deleteDishIngredient(Long id);

}
