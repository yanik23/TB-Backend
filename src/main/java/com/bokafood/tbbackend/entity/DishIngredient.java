package com.bokafood.tbbackend.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "dish_ingredient")
public class DishIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "dish_id", nullable = false)
    private Dish dish;

    @ManyToOne
    @JoinColumn(name = "ingredient_id", nullable = false)
    private Ingredient ingredient;

    @NonNull
    @Column(name = "weight")
    private double weight;


    public void update(DishIngredient updatedDishIngredient) {
        // TODO check if the affectation is correct
        this.dish = updatedDishIngredient.getDish();
        this.ingredient = updatedDishIngredient.getIngredient();
        this.weight = updatedDishIngredient.getWeight();
    }
}
