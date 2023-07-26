package com.bokafood.tbbackend.dto.statisticsDTO;

import com.bokafood.tbbackend.entity.Dish;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO class used to transfer statistics data to the Frontend.
 * This DTO is used to transfer the total quantity of dishes delivered per dish size.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
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
