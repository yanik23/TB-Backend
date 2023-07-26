package com.bokafood.tbbackend.dto.statisticsDTO;

import com.bokafood.tbbackend.entity.Dish;
import lombok.*;

/**
 * DTO class used to transfer statistics data to the Frontend.
 * This DTO is used to transfer the total quantity of dishes delivered per dish type.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
@Getter
@Setter
@Builder
public class TotalDeliveredPerTypeDTO {

    private Dish.DishType currentType;
    private Long quantityDelivered;


    public TotalDeliveredPerTypeDTO(Dish.DishType currentType, Long quantityDelivered) {
        this.currentType = currentType;
        this.quantityDelivered = quantityDelivered;
    }

}
