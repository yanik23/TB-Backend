package com.bokafood.tbbackend.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private int id;
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
    @Column(name = "role", nullable = false)
    private Role role;


}
