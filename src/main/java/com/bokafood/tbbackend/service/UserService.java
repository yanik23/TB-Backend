package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.dto.users.UserDTO;
import com.bokafood.tbbackend.entity.User;

public interface UserService {
    UserDTO getUserById(Long id);
    User getUserByName(String name);
}
