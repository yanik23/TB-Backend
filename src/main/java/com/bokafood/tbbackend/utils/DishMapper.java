package com.bokafood.tbbackend.utils;

import com.bokafood.tbbackend.dto.ingredients.IngredientLessDTO;
import com.bokafood.tbbackend.dto.dishes.DishDTO;
import com.bokafood.tbbackend.dto.dishes.DishLightDTO;
import com.bokafood.tbbackend.dto.dishes.DishWithIngredientListDTO;
import com.bokafood.tbbackend.entity.Dish;

import java.util.stream.Collectors;

public class DishMapper {

    static public DishLightDTO toLightDTO(Dish dish) {
        return DishLightDTO.builder()
                .id(dish.getId())
                .dishName(dish.getName())
                .price(dish.getPrice())
                .dishSize(dish.getCurrentSize())
                .dishType(dish.getCurrentType())
                .calories(dish.getCalories())
                .isAvailable(dish.isAvailable())
                .build();
    }

    static public Dish toDish(DishLightDTO dishLightDTO) {
        return Dish.builder()
                .name(dishLightDTO.getDishName())
                .price(dishLightDTO.getPrice())
                .currentSize(dishLightDTO.getDishSize())
                .currentType(dishLightDTO.getDishType())
                .calories(dishLightDTO.getCalories())
                .isAvailable(dishLightDTO.isAvailable())
                .build();
    }

    static public DishDTO toDTO(Dish dish) {
        return DishDTO.builder()
                .id(dish.getId())
                .name(dish.getName())
                .description(dish.getDescription())
                .price(dish.getPrice())
                .currentSize(dish.getCurrentSize())
                .currentType(dish.getCurrentType())
                .isAvailable(dish.isAvailable())
                .calories(dish.getCalories())
                .fats(dish.getFats())
                .saturatedFats(dish.getSaturatedFats())
                .sodium(dish.getSodium())
                .carbohydrates(dish.getCarbohydrates())
                .fibers(dish.getFibers())
                .sugars(dish.getSugars())
                .proteins(dish.getProteins())
                .calcium(dish.getCalcium())
                .iron(dish.getIron())
                .potassium(dish.getPotassium())
                .build();
    }

    static public Dish toDish(DishDTO dishDTO) {
        return Dish.builder()
                .id(dishDTO.getId())
                .name(dishDTO.getName())
                .description(dishDTO.getDescription())
                .price(dishDTO.getPrice())
                .currentSize(dishDTO.getCurrentSize())
                .currentType(dishDTO.getCurrentType())
                .isAvailable(dishDTO.isAvailable())
                .calories(dishDTO.getCalories())
                .fats(dishDTO.getFats())
                .saturatedFats(dishDTO.getSaturatedFats())
                .sodium(dishDTO.getSodium())
                .carbohydrates(dishDTO.getCarbohydrates())
                .fibers(dishDTO.getFibers())
                .sugars(dishDTO.getSugars())
                .proteins(dishDTO.getProteins())
                .calcium(dishDTO.getCalcium())
                .iron(dishDTO.getIron())
                .potassium(dishDTO.getPotassium())
                .build();
    }

    static public DishWithIngredientListDTO toDishWithIngredientListDTO(Dish dish) {
       return DishWithIngredientListDTO.builder()
                .dishName(dish.getName())
                .price(dish.getPrice())
                .calories(dish.getCalories())
                .ingredients(dish.getDishIngredients().stream().map(ingredient -> IngredientLessDTO.builder()
                        .ingredientName(ingredient.getIngredient().getName())
                        .weight(ingredient.getWeight())
                        .build()).collect(Collectors.toList()))
                .build();
    }
}