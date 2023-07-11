package com.bokafood.tbbackend.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "delivery_dish")
public class DeliveryDish {

    @EmbeddedId
    private DeliveryDishId id;


    @NonNull
    @Column(name = "quantityremained", nullable = false)
    private int quantityRemained;
    @NonNull
    @Column(name = "quantitydelivered", nullable = false)
    private int quantityDelivered;

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


    public void update(DeliveryDish updatedDeliveryDish) {
        // TODO check if the affectation is correct
        this.delivery = updatedDeliveryDish.getDelivery();
        this.dish = updatedDeliveryDish.getDish();
        this.quantityRemained = updatedDeliveryDish.getQuantityRemained();
        this.quantityDelivered = updatedDeliveryDish.getQuantityDelivered();
    }
}
