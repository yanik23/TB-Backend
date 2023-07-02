package com.bokafood.tbbackend.dto.users;


import com.bokafood.tbbackend.entity.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private User.Role role;

}
