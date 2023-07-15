package com.bokafood.tbbackend.dto.statistics;

import com.bokafood.tbbackend.entity.Dish;
import jakarta.persistence.Entity;
import lombok.*;


@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@Builder
public class QuantityDeliveredPerTypeDTO {

    private Dish.DishType currentType;
    private Long quantityDelivered;


    public QuantityDeliveredPerTypeDTO(Dish.DishType currentType, Long quantityDelivered) {
        this.currentType = currentType;
        this.quantityDelivered = quantityDelivered;
    }
    /*public QuantityDeliveredPerTypeDTO(String currentType, Long quantityDelivered) {
        this.currentType = currentType;
        this.quantityDelivered = quantityDelivered;
    }
    public QuantityDeliveredPerTypeDTO() {
        this.currentType = "";
        this.quantityDelivered = 0L;
    }*/
}
