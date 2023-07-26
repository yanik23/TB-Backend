package com.bokafood.tbbackend.dto.dishesDTO;

import lombok.*;
import java.math.BigDecimal;


/**
 * DTO class used to transfer data from and to the Dish entity.
 * Used in the frontend to display dishes in the delivery details.
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
public class DishForDeliveryDTO {
    private Long id;
    private String name;
    private BigDecimal price;
    private int quantityRemained;
    private int quantityDelivered;
}
