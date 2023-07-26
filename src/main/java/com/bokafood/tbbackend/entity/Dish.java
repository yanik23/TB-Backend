package com.bokafood.tbbackend.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * Dish entity class representing the dish table in the database.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "dish")
public class Dish {
    public enum DishType {MEAT, VEGETARIAN, VEGAN}
    public enum DishSize {FIT, GAIN}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;


    @Column(name = "name", nullable = false, unique = true)
    private String name;


    @Column(name = "description")
    private String description;


    @Column(name = "currenttype", nullable = false)
    @Enumerated(EnumType.STRING)
    private DishType currentType;


    @Column(name = "currentsize", nullable = false)
    @Enumerated(EnumType.STRING)
    private DishSize currentSize;


    @Column(name = "price", nullable = false)
    private BigDecimal price;


    @Column(name = "isavailable", nullable = false)
    private boolean isAvailable;


    @Column(name = "calories")
    private int calories;


    @Column(name = "fats", precision = 10, scale = 2)
    private BigDecimal fats;


    @Column(name = "saturatedfats", precision = 10, scale = 2)
    private BigDecimal saturatedFats;


    @Column(name = "sodium", precision = 10, scale = 2)
    private BigDecimal sodium;


    @Column(name = "carbohydrates", precision = 10, scale = 2)
    private BigDecimal carbohydrates;


    @Column(name = "fibers", precision = 10, scale = 2)
    private BigDecimal fibers;


    @Column(name = "sugars", precision = 10, scale = 2)
    private BigDecimal sugars;


    @Column(name = "proteins", precision = 10, scale = 2)
    private BigDecimal proteins;


    @Column(name = "calcium", precision = 10, scale = 2)
    private BigDecimal calcium;


    @Column(name = "iron", precision = 10, scale = 2)
    private BigDecimal iron;


    @Column(name = "potassium", precision = 10, scale = 2)
    private BigDecimal potassium;


    @OneToMany(mappedBy = "dish")
    @JsonManagedReference("dish-delivery")
    private List<DeliveryDish> deliveryDishes;


    @OneToMany(mappedBy = "dish", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference("dish-ingredient")
    private List<DishIngredient> dishIngredients;

}
