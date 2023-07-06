package com.bokafood.tbbackend.utils;

import com.bokafood.tbbackend.dto.dishesIngredientsDTO.DishIngredientDTO;
import com.bokafood.tbbackend.dto.dishesIngredientsDTO.DishIngredientObjectDTO;
import com.bokafood.tbbackend.entity.DishIngredient;

public class DishIngredientMapper {


    public static DishIngredientDTO toDTO(DishIngredient dishIngredient) {
        com.bokafood.tbbackend.dto.dishesIngredientsDTO.DishIngredientDTO dto = new com.bokafood.tbbackend.dto.dishesIngredientsDTO.DishIngredientDTO();
        dto.setId(dishIngredient.getId());
        dto.setIdDish(dishIngredient.getId().getIdDish());
        dto.setIdIngredient(dishIngredient.getId().getIdIngredient());
        dto.setWeight(dishIngredient.getWeight());
        return dto;
    }

    public static DishIngredient toEntity(DishIngredientDTO dishIngredientDTO) {
        DishIngredient entity = new DishIngredient();
        entity.setId(dishIngredientDTO.getId());
        entity.getId().setIdDish(dishIngredientDTO.getIdDish());
        entity.getId().setIdIngredient(dishIngredientDTO.getIdIngredient());
        entity.setWeight(dishIngredientDTO.getWeight());
        return entity;
    }

    public static DishIngredient toEntity(DishIngredientObjectDTO dishIngredientDTO) {
        DishIngredient entity = new DishIngredient();
        entity.setId(dishIngredientDTO.getId());
        entity.setDish(dishIngredientDTO.getDish());
        entity.setIngredient(dishIngredientDTO.getIngredient());
        entity.setWeight(dishIngredientDTO.getWeight());
        return entity;
    }
}
