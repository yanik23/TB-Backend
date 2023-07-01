package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.dto.ingredients.IngredientDTO;
import com.bokafood.tbbackend.entity.Ingredient;

import java.util.List;

public interface IngredientService {
    List<IngredientDTO> getIngredients();
    IngredientDTO getIngredientById(Long id);
    IngredientDTO addIngredient(IngredientDTO ingredientDTO);
    IngredientDTO updateIngredient(Long id, IngredientDTO updatedIngredientDTO);
    void deleteIngredient(Long id);
}
