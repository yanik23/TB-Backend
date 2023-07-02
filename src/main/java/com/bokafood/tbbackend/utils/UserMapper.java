package com.bokafood.tbbackend.utils;

import com.bokafood.tbbackend.dto.users.UserDTO;
import com.bokafood.tbbackend.entity.User;

public class UserMapper {


    public static UserDTO toDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

    public static User toEntity(UserDTO userDTO) {
        return User.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .role(userDTO.getRole())
                .build();
    }
}
