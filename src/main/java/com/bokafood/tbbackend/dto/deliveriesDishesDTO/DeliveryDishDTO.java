package com.bokafood.tbbackend.dto.deliveriesDishesDTO;


import com.bokafood.tbbackend.entity.Delivery;
import com.bokafood.tbbackend.entity.DeliveryDishId;
import com.bokafood.tbbackend.entity.Dish;
import lombok.*;


/**
 * DTO class used to transfer data from and to the DeliveryDish entity.
 * It contains the DeliveryDishId object that is used as the primary key.
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
public class DeliveryDishDTO {
    private DeliveryDishId id;
    private Delivery delivery;
    private Dish dish;
    private int quantityRemained;
    private int quantityDelivered;

}
