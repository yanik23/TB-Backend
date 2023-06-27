package com.bokafood.tbbackend.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "dish")
public class Dish {
    public enum DishType {MEAT, VEGETARIAN, VEGAN}
    public enum DishSize {FIT, GAIN}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @NonNull
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @NonNull
    @Column(name = "description")
    private String description;
    @NonNull
    @Column(name = "currenttype", nullable = false)
    @Enumerated(EnumType.STRING)
    private DishType currentType;
    @NonNull
    @Column(name = "currentsize", nullable = false)
    @Enumerated(EnumType.STRING)
    private DishSize currentSize;
    @NonNull
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @NonNull
    @Column(name = "isavailable", nullable = false)
    private boolean isAvailable;
    @NonNull
    @Column(name = "calories")
    private int calories;
    @NonNull
    @Column(name = "fats", precision = 10, scale = 2)
    private BigDecimal fats;
    @NonNull
    @Column(name = "saturatedfats", precision = 10, scale = 2)
    private BigDecimal saturatedFats;
    @NonNull
    @Column(name = "sodium", precision = 10, scale = 2)
    private BigDecimal sodium;
    @NonNull
    @Column(name = "carbohydrates", precision = 10, scale = 2)
    private BigDecimal carbohydrates;
    @NonNull
    @Column(name = "fibers", precision = 10, scale = 2)
    private BigDecimal fibers;
    @NonNull
    @Column(name = "sugars", precision = 10, scale = 2)
    private BigDecimal sugars;
    @NonNull
    @Column(name = "proteins", precision = 10, scale = 2)
    private BigDecimal proteins;
    @NonNull
    @Column(name = "calcium", precision = 10, scale = 2)
    private BigDecimal calcium;
    @NonNull
    @Column(name = "iron", precision = 10, scale = 2)
    private BigDecimal iron;
    @NonNull
    @Column(name = "potassium", precision = 10, scale = 2)
    private BigDecimal potassium;


    //@OneToMany(mappedBy = "dish", cascade = CascadeType.ALL)
    //private List<DeliveryDish> deliveryDishes;
    @OneToMany(mappedBy = "dish")
    private List<DeliveryDish> deliveryDishes;

    @OneToMany(mappedBy = "dish")
    private List<DishIngredient> dishIngredients;

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
