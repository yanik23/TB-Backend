package com.bokafood.tbbackend.dto.deliveriesDishes;


import com.bokafood.tbbackend.entity.Delivery;
import com.bokafood.tbbackend.entity.DeliveryDishId;
import com.bokafood.tbbackend.entity.Dish;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryDishDTO {
    private DeliveryDishId id;
    private Delivery delivery;
    private Dish dish;
    private int quantityRemained;
    private int quantityDelivered;

}
