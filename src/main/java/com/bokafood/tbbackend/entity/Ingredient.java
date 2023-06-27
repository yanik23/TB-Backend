package com.bokafood.tbbackend.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "ingredient")
public class Ingredient {
    public enum IngredientType {MEAT, STARCH, VEGETABLE, FRUIT, GRAIN, SPICE, SAUCE, OTHER}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @NonNull
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @NonNull
    @Column(name = "currenttype", nullable = false)
    @Enumerated(EnumType.STRING)
    private IngredientType currentType;
    @NonNull
    @Column(name = "description")
    private String description;
    @NonNull
    @Column(name = "supplier")
    private String supplier;


    @OneToMany(mappedBy = "ingredient")
    private List<DishIngredient> dishIngredients;

    public void update(Ingredient ingredient) {
        this.setName(ingredient.getName());
        this.setCurrentType(ingredient.getCurrentType());
        this.setDescription(ingredient.getDescription());
        this.setSupplier(ingredient.getSupplier());
    }
}
