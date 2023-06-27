package com.bokafood.tbbackend.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "dish_ingredient")
public class DishIngredient {

    /*@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name ="id")
    private Long id;*/

    @EmbeddedId
    private DishIngredientId id;

    @ManyToOne
    @MapsId("idDish")
    @JoinColumn(name = "iddish", nullable = false)
    private Dish dish;


    @ManyToOne
    @MapsId("idIngredient")
    @JoinColumn(name = "idingredient", nullable = false)
    private Ingredient ingredient;

    @NonNull
    @Column(name = "weight")
    private BigDecimal weight;


    public void update(DishIngredient updatedDishIngredient) {
        // TODO check if the affectation is correct
        this.dish = updatedDishIngredient.getDish();
        this.ingredient = updatedDishIngredient.getIngredient();
        this.weight = updatedDishIngredient.getWeight();
    }
}
