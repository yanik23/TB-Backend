package com.bokafood.tbbackend.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "delivery_dish")
public class DeliveryDish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "delivery_id", nullable = false)
    private Delivery delivery;

    @ManyToOne
    @JoinColumn(name = "dish_id", nullable = false)
    private Dish dish;


    @NonNull
    @Column(name = "quantityRemained", nullable = false)
    private int quantityRemained;
    @NonNull
    @Column(name = "quantityDelivered", nullable = false)
    private int quantityDelivered;


    public void update(DeliveryDish updatedDeliveryDish) {
        // TODO check if the affectation is correct
        this.delivery = updatedDeliveryDish.getDelivery();
        this.dish = updatedDeliveryDish.getDish();
        this.quantityRemained = updatedDeliveryDish.getQuantityRemained();
        this.quantityDelivered = updatedDeliveryDish.getQuantityDelivered();
    }
}
