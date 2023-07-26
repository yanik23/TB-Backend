package com.bokafood.tbbackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;


/**
 * Delivery entity class representing the delivery table in the database.
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

@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "deliverydate", nullable = false, columnDefinition = "DATE")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime deliveryDate;


    @Column(name = "details")
    private String details;


    @ManyToOne
    @JsonBackReference(value = "client-delivery")
    @JoinColumn(name = "idclient", referencedColumnName = "id")
    private Client client;


    @OneToMany(mappedBy = "delivery", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference(value = "delivery-dish")
    private List<DeliveryDish> deliveryDishes;


    @ManyToOne
    @JsonBackReference(value = "user-delivery")
    @JoinColumn(name = "iduser", referencedColumnName = "id")
    private User user;

}
