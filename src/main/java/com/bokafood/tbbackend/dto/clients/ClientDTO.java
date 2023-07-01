package com.bokafood.tbbackend.dto.clients;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ClientDTO {
    private Long id;
    private String name;
    private String addressName;
    private int addressNumber;
    private int zipCode;
    private String city;


}

