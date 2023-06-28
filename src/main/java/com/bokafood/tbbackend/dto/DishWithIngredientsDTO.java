package com.bokafood.tbbackend.dto;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor


public class DishWithIngredientsDTO {
    private String dishname;
    private BigDecimal price;
    private int calories;
    private String name;
    private BigDecimal weight;
    //d.calories, i.name, di.weight


    public DishWithIngredientsDTO(String dishname, BigDecimal price, int calories, String name, BigDecimal weight) {
        this.dishname = dishname;
        this.price = price;
        this.calories = calories;
        this.name = name;
        this.weight = weight;
    }
}
