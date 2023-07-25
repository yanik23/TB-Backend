package com.bokafood.tbbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;


/**
 * DeliveryDishId entity class representing the delivery_dish composed id in the database.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class DeliveryDishId implements Serializable {

    @Column(name = "delivery_id", nullable = false)
    private Long idDelivery;

    @Column(name = "dish_id", nullable = false)
    private Long idDish;
}
