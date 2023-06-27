package com.bokafood.tbbackend.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "user")
public class User {

    private enum Role {ADMIN, USER}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @NonNull
    @Column(name = "password", nullable = false, unique = true)
    private String password;
    @NonNull
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @NonNull
    @Column(name = "currentrole", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;


}
