package com.bokafood.tbbackend.dto.statisticsDTO;

import com.bokafood.tbbackend.entity.Dish;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AvgDeliveredPerSizeDTO {
        private Dish.DishSize currentSize;
        private Double quantityDelivered;

        public AvgDeliveredPerSizeDTO(Dish.DishSize currentSize, Double quantityDelivered) {
            this.currentSize = currentSize;
            this.quantityDelivered = quantityDelivered;
        }
}
