package com.bokafood.tbbackend.entity;

public class Dish {
    enum DishType {MEAT, VEGETARIAN, VEGAN}
    enum DishSize {FIT, GAIN}

    private int id;
    private String name;
    private String description;
    private DishType currentType;
    private DishSize currentSize;
    private double price;
    private double isAvailable;
    private double calories;
    private double fats;
    private double saturatedFats;
    private double sodium;
    private double carbohydrates;
    private double fibers;
    private double sugars;
    private double proteins;
    private double calcium;
    private double iron;
    private double potassium;

    public Dish() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DishType getCurrentType() {
        return currentType;
    }

    public void setCurrentType(DishType currentType) {
        this.currentType = currentType;
    }

    public DishSize getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(DishSize currentSize) {
        this.currentSize = currentSize;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(double isAvailable) {
        this.isAvailable = isAvailable;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getSaturatedFats() {
        return saturatedFats;
    }

    public void setSaturatedFats(double saturatedFats) {
        this.saturatedFats = saturatedFats;
    }

    public double getSodium() {
        return sodium;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getFibers() {
        return fibers;
    }

    public void setFibers(double fibers) {
        this.fibers = fibers;
    }

    public double getSugars() {
        return sugars;
    }

    public void setSugars(double sugars) {
        this.sugars = sugars;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getCalcium() {
        return calcium;
    }

    public void setCalcium(double calcium) {
        this.calcium = calcium;
    }

    public double getIron() {
        return iron;
    }

    public void setIron(double iron) {
        this.iron = iron;
    }

    public double getPotassium() {
        return potassium;
    }

    public void setPotassium(double potassium) {
        this.potassium = potassium;
    }
}
