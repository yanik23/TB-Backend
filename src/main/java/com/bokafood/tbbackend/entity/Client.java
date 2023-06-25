package com.bokafood.tbbackend.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @NonNull
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @NonNull
    @Column(name = "addressName", nullable = false)
    private String addressName;

    @NonNull
    @Column(name = "addressNumber", nullable = false)
    private int addressNumber;

    @NonNull
    @Column(name = "zipCode", nullable = false)
    private int zipCode;

    @NonNull
    @Column(name = "city", nullable = false)
    private String city;

}
