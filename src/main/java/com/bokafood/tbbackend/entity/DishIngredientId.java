package com.bokafood.tbbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class DishIngredientId implements Serializable {

    @Column(name = "dish_id", nullable = false)
    private Long idDish;

    @Column(name = "ingredient_id", nullable = false)
    private Long idIngredient;
}
