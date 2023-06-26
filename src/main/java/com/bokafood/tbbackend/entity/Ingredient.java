package com.bokafood.tbbackend.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "ingredient")
public class Ingredient {
    private enum IngredientType {MEAT, STARCH, VEGETABLE, FRUIT, GRAIN, SPICE, SAUCE, OTHER}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @NonNull
    @Column(name = "type", nullable = false)
    private IngredientType currentType;
    @NonNull
    @Column(name = "description")
    private String description;
    @NonNull
    @Column(name = "supplier")
    private String supplier;


    public void update(Ingredient ingredient) {
        this.setName(ingredient.getName());
        this.setCurrentType(ingredient.getCurrentType());
        this.setDescription(ingredient.getDescription());
        this.setSupplier(ingredient.getSupplier());
    }
}
