package com.bokafood.tbbackend.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "dish")
public class Dish {
    enum DishType {MEAT, VEGETARIAN, VEGAN}
    enum DishSize {FIT, GAIN}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @NonNull
    @Column(name = "description")
    private String description;
    @NonNull
    @Column(name = "type", nullable = false)
    private DishType currentType;
    @NonNull
    @Column(name = "size", nullable = false)
    private DishSize currentSize;
    @NonNull
    @Column(name = "price", nullable = false)
    private double price;
    @NonNull
    @Column(name = "isAvailable", nullable = false)
    private boolean isAvailable;
    @NonNull
    @Column(name = "calories")
    private double calories;
    @NonNull
    @Column(name = "fats")
    private double fats;
    @NonNull
    @Column(name = "saturatedFats")
    private double saturatedFats;
    @NonNull
    @Column(name = "sodium")
    private double sodium;
    @NonNull
    @Column(name = "carbohydrates")
    private double carbohydrates;
    @NonNull
    @Column(name = "fibers")
    private double fibers;
    @NonNull
    @Column(name = "sugars")
    private double sugars;
    @NonNull
    @Column(name = "proteins")
    private double proteins;
    @NonNull
    @Column(name = "calcium")
    private double calcium;
    @NonNull
    @Column(name = "iron")
    private double iron;
    @NonNull
    @Column(name = "potassium")
    private double potassium;


    public void update(Dish dish) {
        this.setName(dish.getName());
        this.setDescription(dish.getDescription());
        this.setCurrentType(dish.getCurrentType());
        this.setCurrentSize(dish.getCurrentSize());
        this.setPrice(dish.getPrice());
        this.setAvailable(dish.isAvailable());
        this.setCalories(dish.getCalories());
        this.setFats(dish.getFats());
        this.setSaturatedFats(dish.getSaturatedFats());
        this.setSodium(dish.getSodium());
        this.setCarbohydrates(dish.getCarbohydrates());
        this.setFibers(dish.getFibers());
        this.setSugars(dish.getSugars());
        this.setProteins(dish.getProteins());
        this.setCalcium(dish.getCalcium());
        this.setIron(dish.getIron());
        this.setPotassium(dish.getPotassium());
    }

}
