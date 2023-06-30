package com.bokafood.tbbackend.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.NumberFormat;

import java.util.List;

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
    @Column(name = "addressname", nullable = false)
    private String addressName;


    @NonNull
    @Column(name = "addressnumber", nullable = false)
    private int addressNumber;


    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @NonNull
    @Column(name = "zipcode", nullable = false)
    private int zipCode;

    @NotBlank(message = "City can't be blank")
    @NonNull
    @Column(name = "city", nullable = false)
    private String city;


    //@JsonIgnore
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    //@OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Delivery> deliveries;

   /* @JsonIgnore
    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }*/

    public void update(Client client) {
        this.setName(client.getName());
        this.setAddressName(client.getAddressName());
        this.setAddressNumber(client.getAddressNumber());
        this.setZipCode(client.getZipCode());
        this.setCity(client.getCity());
    }
}
