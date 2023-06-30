package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.dto.DishWithIngredientListDTO;
import com.bokafood.tbbackend.entity.Dish;

import java.util.List;

public interface DishService {
    List<Dish> getDishes();
    Dish getDishById(Long id);
    Dish addDish(Dish dish);
    Dish updateDish(Long id, Dish updatedDish);
    void deleteDish(Long id);

    List<DishWithIngredientListDTO> getMinDish();
}
