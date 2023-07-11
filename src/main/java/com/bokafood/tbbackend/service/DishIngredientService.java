package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.dto.dishesIngredientsDTO.DishIngredientDTO;
import com.bokafood.tbbackend.dto.dishesIngredientsDTO.DishIngredientObjectDTO;
import com.bokafood.tbbackend.entity.DishIngredient;
import com.bokafood.tbbackend.entity.DishIngredientId;

import java.util.List;

public interface DishIngredientService {
    List<DishIngredient> getDishIngredients();
    DishIngredient getDishIngredientById(DishIngredientId id);
    DishIngredientDTO addDishIngredient(DishIngredientObjectDTO dishIngredientObjectDTO);
    DishIngredientDTO updateDishIngredient(DishIngredientId id, DishIngredientObjectDTO updatedDishIngredient);
    void deleteDishIngredient(DishIngredientId id);
    List<DishIngredient> findAllByDishId(Long id);
    void deleteAllByDishId(Long id);

}
