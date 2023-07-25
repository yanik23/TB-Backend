package com.bokafood.tbbackend.dto.statisticsDTO;

import com.bokafood.tbbackend.entity.Dish;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TotalDeliveredPerSizeDTO {
        private Dish.DishSize currentSize;
        private Long quantityDelivered;

        public TotalDeliveredPerSizeDTO(Dish.DishSize currentSize, Long quantityDelivered) {
            this.currentSize = currentSize;
            this.quantityDelivered = quantityDelivered;
        }
}
