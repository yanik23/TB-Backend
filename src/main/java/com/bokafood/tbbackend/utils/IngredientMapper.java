package com.bokafood.tbbackend.utils;

import com.bokafood.tbbackend.dto.ingredients.IngredientDTO;
import com.bokafood.tbbackend.dto.ingredients.IngredientLessDTO;
import com.bokafood.tbbackend.entity.Ingredient;

public class IngredientMapper {

    public static IngredientDTO toDTO(Ingredient ingredient) {
        return IngredientDTO.builder()
                .id(ingredient.getId())
                .name(ingredient.getName())
                .currentType(ingredient.getCurrentType())
                .description(ingredient.getDescription())
                .supplier(ingredient.getSupplier())
                .build();
    }

    public static Ingredient toIngredient(IngredientDTO ingredientDTO) {
        return Ingredient.builder()
                .id(ingredientDTO.getId())
                .name(ingredientDTO.getName())
                .currentType(ingredientDTO.getCurrentType())
                .description(ingredientDTO.getDescription())
                .supplier(ingredientDTO.getSupplier())
                .build();
    }

    public static IngredientLessDTO toLessDTO(Ingredient ingredient) {
        return IngredientLessDTO.builder()
                .id(ingredient.getId())
                .name(ingredient.getName())
                .build();
    }


    public static Ingredient toEntity(IngredientLessDTO ingredientLessDTO) {
        return Ingredient.builder()
                .name(ingredientLessDTO.getName())
                .build();
    }

    public static Ingredient toEntity(IngredientDTO ingredientDTO) {
        return Ingredient.builder()
                .id(ingredientDTO.getId())
                .name(ingredientDTO.getName())
                .currentType(ingredientDTO.getCurrentType())
                .description(ingredientDTO.getDescription())
                .supplier(ingredientDTO.getSupplier())
                .build();
    }


}
