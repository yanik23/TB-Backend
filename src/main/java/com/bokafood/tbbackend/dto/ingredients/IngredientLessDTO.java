package com.bokafood.tbbackend.dto.ingredients;


import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class IngredientLessDTO {
    Long id;
    private String name;
    private BigDecimal weight;


    /*public IngredientLessDTO(String ingredientName, BigDecimal weight) {
        this.ingredientName = ingredientName;
        this.weight = weight;
    }*/
}
