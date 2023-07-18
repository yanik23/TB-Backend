package com.bokafood.tbbackend.dto.statistics;

import com.bokafood.tbbackend.entity.Dish;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AvgDeliveredPerTypeDTO {

    private Dish.DishType currentType;
    private Double quantityDelivered;


    public AvgDeliveredPerTypeDTO(Dish.DishType currentType, Double quantityDelivered) {
        this.currentType = currentType;
        this.quantityDelivered = quantityDelivered;
    }
}
