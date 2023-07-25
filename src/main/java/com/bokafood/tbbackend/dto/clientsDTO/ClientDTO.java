package com.bokafood.tbbackend.dto.clientsDTO;

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
    private Long addressNumber;
    private Long zipCode;
    private String city;


}

