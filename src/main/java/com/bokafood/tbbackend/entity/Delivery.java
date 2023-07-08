package com.bokafood.tbbackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

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

    //@JsonIgnore
    @NonNull
    @ManyToOne
    @JsonBackReference(value = "client-delivery")
    @JoinColumn(name = "idclient", referencedColumnName = "id")
    private Client client;


    //@JsonIgnore
    @OneToMany(mappedBy = "delivery", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference(value = "delivery-dish")
    private List<DeliveryDish> deliveryDish;


    @ManyToOne
    @JsonBackReference(value = "user-delivery")
    @JoinColumn(name = "iduser", referencedColumnName = "id")
    private User user;



    /*public void update(Delivery delivery) {
        this.setDeliveryDate(delivery.getDeliveryDate());
        this.setDetails(delivery.getDetails());
        this.setClient(delivery.getClient());
    }*/
}
