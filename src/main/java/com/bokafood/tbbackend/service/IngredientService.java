package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.entity.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> getIngredients();
    Ingredient getIngredientById(Long id);
    Ingredient addIngredient(Ingredient ingredient);
    Ingredient updateIngredient(Long id, Ingredient updatedIngredient);
    void deleteIngredient(Long id);
}
