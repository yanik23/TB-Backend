package com.bokafood.tbbackend.utils;

import com.bokafood.tbbackend.dto.ingredientsDTO.IngredientLessDTO;
import com.bokafood.tbbackend.dto.dishesDTO.DishDTO;
import com.bokafood.tbbackend.dto.dishesDTO.DishLightDTO;
import com.bokafood.tbbackend.dto.dishesDTO.DishWithIngredientListDTO;
import com.bokafood.tbbackend.entity.Dish;
import java.util.stream.Collectors;


/**
 * DishMapper class used to map a Dish to a DishDTO and vice versa.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
public class DishMapper {

    /**
     * Method to map a Dish to a DishLightDTO.
     * @param dish The Dish to be mapped.
     * @return The mapped DishLightDTO.
     */
    static public DishLightDTO toLightDTO(Dish dish) {
        return DishLightDTO.builder()
                .id(dish.getId())
                .name(dish.getName())
                .price(dish.getPrice())
                .currentSize(dish.getCurrentSize())
                .currentType(dish.getCurrentType())
                .calories(dish.getCalories())
                .isAvailable(dish.isAvailable())
                .build();
    }

    /**
     * Method to map a Dish to a DishDTO.
     * @param dish The Dish to be mapped.
     * @return The mapped DishDTO.
     */
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

    /**
     * Method to map a Dish to a DishWithIngredientListDTO.
     * @param dish The Dish to be mapped.
     * @return The mapped DishWithIngredientListDTO.
     */
    static public DishWithIngredientListDTO toDishWithIngredientListDTO(Dish dish) {
       return DishWithIngredientListDTO.builder()
                .id(dish.getId())
                .name(dish.getName())
                .description(dish.getDescription())
                .currentType(dish.getCurrentType())
                .currentSize(dish.getCurrentSize())
                .price(dish.getPrice())
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

                .ingredients(dish.getDishIngredients().stream().map(ingredient -> IngredientLessDTO.builder()
                        .id(ingredient.getIngredient().getId())
                        .name(ingredient.getIngredient().getName())
                        .weight(ingredient.getWeight())
                        .build()).collect(Collectors.toList()))
                .build();
    }

    /**
     * Method to map a DishWithIngredientListDTO to a Dish.
     * @param dishDTO The DishWithIngredientListDTO to be mapped.
     * @return The mapped Dish.
     */
    static public Dish toDish(DishWithIngredientListDTO dishDTO) {
        return Dish.builder()
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

    /**
     * Method to map a DishWithIngredientListDTO to a Dish.
     * @param dishDTO The DishWithIngredientListDTO to be mapped.
     * @return The mapped Dish.
     */
    static public Dish toDishWithId(DishWithIngredientListDTO dishDTO) {
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
}
