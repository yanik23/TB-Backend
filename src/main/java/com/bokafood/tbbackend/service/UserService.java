package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.entity.User;

public interface UserService {
    //UserDTO getUserById(Long id);
    User getUserByUsername(String name);
}
