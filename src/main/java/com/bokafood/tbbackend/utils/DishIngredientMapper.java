package com.bokafood.tbbackend.utils;

import com.bokafood.tbbackend.dto.dishesIngredientsDTO.DishIngredientDTO;
import com.bokafood.tbbackend.dto.dishesIngredientsDTO.DishIngredientObjectDTO;
import com.bokafood.tbbackend.entity.DishIngredient;


/**
 * DishIngredientMapper class used to map a DishIngredient to a DishIngredientDTO and vice versa.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
public class DishIngredientMapper {


    /**
     * Method to map a DishIngredient to a DishIngredientDTO.
     * @param dishIngredient The DishIngredient to be mapped.
     * @return The mapped DishIngredientDTO.
     */
    public static DishIngredientDTO toDTO(DishIngredient dishIngredient) {
        com.bokafood.tbbackend.dto.dishesIngredientsDTO.DishIngredientDTO dto = new com.bokafood.tbbackend.dto.dishesIngredientsDTO.DishIngredientDTO();
        dto.setId(dishIngredient.getId());
        dto.setIdDish(dishIngredient.getId().getIdDish());
        dto.setIdIngredient(dishIngredient.getId().getIdIngredient());
        dto.setWeight(dishIngredient.getWeight());
        return dto;
    }

    /**
     * Method to map a DishIngredientDTO to a DishIngredient.
     * @param dishIngredientDTO The DishIngredientDTO to be mapped.
     * @return The mapped DishIngredient.
     */
    public static DishIngredient toEntity(DishIngredientObjectDTO dishIngredientDTO) {
        DishIngredient entity = new DishIngredient();
        entity.setId(dishIngredientDTO.getId());
        entity.setDish(dishIngredientDTO.getDish());
        entity.setIngredient(dishIngredientDTO.getIngredient());
        entity.setWeight(dishIngredientDTO.getWeight());
        return entity;
    }
}
