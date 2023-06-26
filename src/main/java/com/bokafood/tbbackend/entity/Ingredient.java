package com.bokafood.tbbackend.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Ingredient {
    private enum IngredientType {MEAT, STARCH, VEGETABLE, FRUIT, GRAIN, SPICE, SAUCE, OTHER}

    private int id;
    private String name;
    private IngredientType currentType;
    private String description;
    private String supplier;

    public Ingredient() {
    }

    public Ingredient(int id, String name, IngredientType currentType, String description, String supplier) {
        this.id = id;
        this.name = name;
        this.currentType = currentType;
        this.description = description;
        this.supplier = supplier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IngredientType getCurrentType() {
        return currentType;
    }

    public String getCurrentTypeString() {
        return currentType.toString();
    }

    public void setCurrentType(IngredientType currentType) {
        this.currentType = currentType;
    }

    public void setCurrentTypeString(String currentType) {
        this.currentType = IngredientType.valueOf(currentType);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
