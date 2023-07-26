package com.bokafood.tbbackend.utils;

import com.bokafood.tbbackend.dto.ingredientsDTO.IngredientDTO;
import com.bokafood.tbbackend.entity.Ingredient;


/**
 * IngredientMapper class used to map a Ingredient to a IngredientDTO and vice versa.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
public class IngredientMapper {

    /**
     * Method to map a Ingredient to a IngredientDTO.
     * @param ingredient The Ingredient to be mapped.
     * @return The mapped IngredientDTO.
     */
    public static IngredientDTO toDTO(Ingredient ingredient) {
        return IngredientDTO.builder()
                .id(ingredient.getId())
                .name(ingredient.getName())
                .currentType(ingredient.getCurrentType())
                .description(ingredient.getDescription())
                .supplier(ingredient.getSupplier())
                .build();
    }

    /**
     * Method to map a IngredientDTO to a Ingredient.
     * @param ingredientDTO The IngredientDTO to be mapped.
     * @return The mapped Ingredient.
     */
    public static Ingredient toIngredient(IngredientDTO ingredientDTO) {
        return Ingredient.builder()
                .id(ingredientDTO.getId())
                .name(ingredientDTO.getName())
                .currentType(ingredientDTO.getCurrentType())
                .description(ingredientDTO.getDescription())
                .supplier(ingredientDTO.getSupplier())
                .build();
    }

    /**
     * Method to map a IngredientDTO to a Ingredient.
     * @param ingredientDTO The IngredientDTO to be mapped.
     * @return The mapped Ingredient.
     */
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
