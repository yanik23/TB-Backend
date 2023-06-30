package com.bokafood.tbbackend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class IngredientLessDTO {
    private String ingredientName;
    private BigDecimal weight;


    /*public IngredientLessDTO(String ingredientName, BigDecimal weight) {
        this.ingredientName = ingredientName;
        this.weight = weight;
    }*/
}
