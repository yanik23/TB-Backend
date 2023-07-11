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

    @ManyToOne(cascade = CascadeType.MERGE)
    @MapsId("idDish")
    @JoinColumn(name = "iddish", nullable = false)
    @JsonBackReference(value="dish-ingredient")
    private Dish dish;


    @ManyToOne(cascade = CascadeType.MERGE)
    @MapsId("idIngredient")
    @JoinColumn(name = "idingredient", nullable = false)
    @JsonBackReference(value="ingredient-dish")
    private Ingredient ingredient;

    @Column(name = "weight")
    private BigDecimal weight;

}
