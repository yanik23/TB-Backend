package com.bokafood.tbbackend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @NonNull
    @Column(name = "deliverydate", nullable = false, columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime deliveryDate;


    @NonNull
    @Column(name = "details")
    private String details;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "idclient", referencedColumnName = "id")
    private Client client;


    @JsonIgnore
    @OneToMany(mappedBy = "delivery")
    private List<DeliveryDish> deliveryDish;
    /*@JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "delivery_dish",
            joinColumns = @JoinColumn(name = "iddelivery"),
            inverseJoinColumns = @JoinColumn(name = "iddish")
    )*/



    public void update(Delivery delivery) {
        this.setDeliveryDate(delivery.getDeliveryDate());
        this.setDetails(delivery.getDetails());
        this.setClient(delivery.getClient());
    }
}
