package com.bokafood.tbbackend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.format.annotation.NumberFormat;
import java.util.List;



/**
 * Client entity class representing the client table in the database.
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
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @NotBlank(message = "Name can't be blank")
    @Column(name = "name", nullable = false, unique = true)
    private String name;


    @NotBlank(message = "Address name can't be blank")
    @Column(name = "addressname", nullable = false)
    private String addressName;


    @Column(name = "addressnumber", nullable = false)
    private Long addressNumber;


    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @Column(name = "zipcode", nullable = false)
    private Long zipCode;


    @NotBlank(message = "City can't be blank")
    @Column(name = "city", nullable = false)
    private String city;


    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference(value = "client-delivery")
    private List<Delivery> deliveries;

}
