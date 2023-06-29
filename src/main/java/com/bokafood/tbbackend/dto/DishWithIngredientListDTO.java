package com.bokafood.tbbackend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DishWithIngredientListDTO {
    private String dishname;
    private BigDecimal price;
    private int calories;

    List<IngredientDTO> ingredients;

    public DishWithIngredientListDTO(String dishname, BigDecimal price, int calories, List<IngredientDTO> ingredients) {
        this.dishname = dishname;
        this.price = price;
        this.calories = calories;
        this.ingredients = ingredients;
    }
}
