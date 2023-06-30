package com.bokafood.tbbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DishWithIngredientListDTO {
    private String dishName;
    private BigDecimal price;
    private int calories;

    List<IngredientLessDTO> ingredients;

    /*public DishWithIngredientListDTO(String dishname, BigDecimal price, int calories, List<IngredientLessDTO> ingredients) {
        this.dishname = dishname;
        this.price = price;
        this.calories = calories;
        this.ingredients = ingredients;
    }*/
}
