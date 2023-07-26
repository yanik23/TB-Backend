package com.bokafood.tbbackend.service;

import com.bokafood.tbbackend.entity.User;

/**
 * UserService is an interface that provides methods to manage users.
 * Implementation of this interface is in UserServiceImpl class.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
public interface UserService {

    /**
     * Method to get a user by its username.
     * @param name The username of the user to be found.
     * @return User with the user if found.
     */
    User getUserByUsername(String name);
}
