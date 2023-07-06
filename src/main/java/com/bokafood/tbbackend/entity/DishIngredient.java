package com.bokafood.tbbackend.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "dish_ingredient")
public class DishIngredient {

    @EmbeddedId
    private DishIngredientId id;

    @ManyToOne
    @MapsId("idDish")
    @JoinColumn(name = "iddish", nullable = false)
    @JsonBackReference
    private Dish dish;


    @ManyToOne
    @MapsId("idIngredient")
    @JoinColumn(name = "idingredient", nullable = false)
    @JsonBackReference
    private Ingredient ingredient;

    @Column(name = "weight")
    private BigDecimal weight;


    public void update(DishIngredient updatedDishIngredient) {
        // TODO check if the affectation is correct
        this.dish = updatedDishIngredient.getDish();
        this.ingredient = updatedDishIngredient.getIngredient();
        this.weight = updatedDishIngredient.getWeight();
    }
}
