package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.dto.DishWithIngredientsDTO;
import com.bokafood.tbbackend.entity.Dish;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DishService {
    List<Dish> getDishes();
    Dish getDishById(Long id);
    Dish addDish(Dish dish);
    Dish updateDish(Long id, Dish updatedDish);
    void deleteDish(Long id);

   // List<DishWithIngredientsDTO> getDishByIdWithIngredients(Long id);
    List<DishWithIngredientsDTO> getMinDish();
}
