package com.bokafood.tbbackend.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;


/**
 * DeliveryDish entity class representing the delivery_dish table in the database.
 * This class is used to represent the many-to-many relationship between the delivery and the dish tables.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "delivery_dish")
public class DeliveryDish {

    @EmbeddedId
    private DeliveryDishId id;


    @ManyToOne(cascade = CascadeType.MERGE)
    @MapsId("idDelivery")
    @JsonBackReference(value="delivery-dish")
    @JoinColumn(name = "iddelivery", nullable = false)
    private Delivery delivery;

    @ManyToOne(cascade = CascadeType.MERGE)
    @MapsId("idDish")
    @JsonBackReference(value="dish-delivery")
    @JoinColumn(name = "iddish", nullable = false)
    private Dish dish;


    @Column(name = "quantityremained", nullable = false)
    private int quantityRemained;

    @Column(name = "quantitydelivered", nullable = false)
    private int quantityDelivered;

    public void update(DeliveryDish updatedDeliveryDish) {
        // TODO check if the affectation is correct
        this.delivery = updatedDeliveryDish.getDelivery();
        this.dish = updatedDeliveryDish.getDish();
        this.quantityRemained = updatedDeliveryDish.getQuantityRemained();
        this.quantityDelivered = updatedDeliveryDish.getQuantityDelivered();
    }
}
