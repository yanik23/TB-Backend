package com.bokafood.tbbackend.entity;

import jakarta.persistence.Column;

import java.io.Serializable;

public class DishIngredientId implements Serializable {

    @Column(name = "dish_id", nullable = false)
    private Long idDish;

    @Column(name = "ingredient_id", nullable = false)
    private Long idIngredient;
}
