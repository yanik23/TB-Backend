package com.bokafood.tbbackend.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor

public class IngredientDTO {
    private String ingredientName;
    private BigDecimal weight;


    public IngredientDTO(String ingredientName, BigDecimal weight) {
        this.ingredientName = ingredientName;
        this.weight = weight;
    }
}
