package com.bokafood.tbbackend.dto.clientsDTO;

import lombok.*;


/**
 * DTO class used to transfer data from and to the Client entity.
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
public class ClientDTO {
    private Long id;
    private String name;
    private String addressName;
    private Long addressNumber;
    private Long zipCode;
    private String city;


}

