package com.bokafood.tbbackend.dto.ingredients;

import com.bokafood.tbbackend.entity.Ingredient;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class IngredientDTO {
    private Long id;
    private String name;
    private Ingredient.IngredientType currentType;
    private String description;
    private String supplier;
}


