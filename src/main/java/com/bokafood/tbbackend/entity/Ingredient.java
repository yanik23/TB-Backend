package com.bokafood.tbbackend.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "ingredient")
public class Ingredient {
    public enum IngredientType {MEAT, FISH, STARCH, VEGETABLE, FRUIT, GRAIN, SPICE, SAUCE, OTHER}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @NotBlank(message = "Name can't be blank")
    @NonNull
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @NonNull
    @Column(name = "currenttype", nullable = false)
    @Enumerated(EnumType.STRING)
    private IngredientType currentType;

    //@NonNull
    @Column(name = "description")
    private String description;

    @Column(name = "supplier")
    private String supplier;


    //@JsonIgnore
    @OneToMany(mappedBy = "ingredient")
    @JsonBackReference(value = "ingredient-dish")
    private List<DishIngredient> dishIngredients;

    public void update(Ingredient ingredient) {
        this.setName(ingredient.getName());
        this.setCurrentType(ingredient.getCurrentType());
        this.setDescription(ingredient.getDescription());
        this.setSupplier(ingredient.getSupplier());
    }
}
