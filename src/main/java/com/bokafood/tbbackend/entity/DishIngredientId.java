package com.bokafood.tbbackend.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

/**
 * DishIngredientId entity class representing the dish_ingredient composed id in the database.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
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
