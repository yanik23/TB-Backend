package com.bokafood.tbbackend.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.format.annotation.NumberFormat;

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


    @NotBlank(message = "Name can't be blank")
    @NonNull
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @NotBlank(message = "Address name can't be blank")
    @NonNull
    @Column(name = "addressName", nullable = false)
    private String addressName;

    @NonNull
    @Column(name = "addressNumber", nullable = false)
    private int addressNumber;

    @NonNull
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @Column(name = "zipCode", nullable = false)
    private int zipCode;

    @NotBlank(message = "City can't be blank")
    @NonNull
    @Column(name = "city", nullable = false)
    private String city;


    public void update(Client client) {
        this.setName(client.getName());
        this.setAddressName(client.getAddressName());
        this.setAddressNumber(client.getAddressNumber());
        this.setZipCode(client.getZipCode());
        this.setCity(client.getCity());
    }
}
