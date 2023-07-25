package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.dto.dishesDTO.DishWithIngredientListDTO;
import com.bokafood.tbbackend.dto.dishesDTO.DishDTO;
import com.bokafood.tbbackend.dto.dishesDTO.DishLightDTO;
import java.util.List;

public interface DishService {
    List<DishLightDTO> getDishes();
    DishWithIngredientListDTO getDishById(Long id);
    DishDTO addDish(DishWithIngredientListDTO dishDTO);
    DishDTO updateDish(Long id, DishWithIngredientListDTO updatedDishDTO);
    void deleteDish(Long id);
    List<DishWithIngredientListDTO> getDishesWithIngredients();
}
