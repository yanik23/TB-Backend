package com.bokafood.tbbackend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;


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
    private int id;


    @NonNull
    @Column(name = "deliveryDate", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;


    @NonNull
    @Column(name = "details")
    private String details;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;


    public void update(Delivery delivery) {
        this.setTimestamp(delivery.getTimestamp());
        this.setDetails(delivery.getDetails());
        this.setClient(delivery.getClient());
    }
}
